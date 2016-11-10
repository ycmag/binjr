package eu.fthevenet.binjr.viewer;

import eu.fthevenet.binjr.commons.charts.ChartCrossHairManager;
import eu.fthevenet.binjr.commons.logging.Profiler;
import eu.fthevenet.binjr.data.JRDSDataProvider;
import eu.fthevenet.binjr.data.TimeSeriesBuilder;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import jfxtras.scene.control.CalendarTextField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.gillius.jfxutils.chart.XYChartInfo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class MainViewController implements Initializable {
    private static final Logger logger = LogManager.getLogger(MainViewController.class);

    @FXML
    public VBox root;
    @FXML
    public TextField RDPEpsilon;

    @FXML
    public AnchorPane chartParent;

    @FXML
    public CalendarTextField beginDateTime;
    @FXML
    public CalendarTextField endDateTime;
    @FXML
    private AreaChart<Date, Number> chart;
    @FXML
    private Menu editMenu;
    @FXML
    private MenuItem editRefresh;

    @FXML
    private CheckBox chkBoxEnableRDP;

    @FXML
    private CheckBox showChartSymbols;
//

    XYChartInfo chartInfo;
    private boolean dragging;
    private boolean wasYAnimated;
    private ObjectProperty<Integer> reductionTarget = new SimpleObjectProperty<>(2000);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        assert chart != null : "fx:id\"chart\" was not injected!";
        assert editMenu != null : "fx:id\"editMenu\" was not injected!";
        assert beginDateTime != null : "fx:id\"beginDateTime\" was not injected!";
        assert endDateTime != null : "fx:id\"endDateTime\" was not injected!";
        assert chartParent != null : "fx:id\"chartParent\" was not injected!";
        assert root != null : "fx:id\"root\" was not injected!";
        assert RDPEpsilon != null : "fx:id\"RDPEpsilon\" was not injected!";
        assert showChartSymbols != null : "fx:id\"showChartSymbols\" was not injected!";


        chart.createSymbolsProperty().bindBidirectional(showChartSymbols.selectedProperty());

        final TextFormatter<Integer> formatter = new TextFormatter<>(new IntegerStringConverter());
        // reductionTarget.bindBidirectional(DoubleProperty.doubleProperty(formatter.valueProperty()));
        formatter.valueProperty().bindBidirectional(reductionTarget);
        formatter.valueProperty().addListener((observable, oldValue, newValue) -> refreshChart());
        RDPEpsilon.setTextFormatter(formatter);

        Instant end = Instant.now();// Instant.parse("2016-10-25T22:00:00Z");
        Instant begin = end.minus(12 * 60, ChronoUnit.MINUTES);
        beginDateTime.setCalendar(Calendar.getInstance());
        beginDateTime.getCalendar().setTime(Date.from(begin));
        endDateTime.setCalendar(Calendar.getInstance());
        endDateTime.getCalendar().setTime(Date.from(end));
        editRefresh.setOnAction(a -> refreshChart());


        beginDateTime.textProperty().addListener((observable, oldValue, newValue) -> refreshChart());
        endDateTime.textProperty().addListener((observable, oldValue, newValue) -> refreshChart());
        chkBoxEnableRDP.selectedProperty().addListener((o, oldval, newVal) -> refreshChart());

//        chart.getYAxis().setAutoRanging(false);
//        ((ValueAxis<Number>) chart.getYAxis()).setLowerBound(134700000);
//        ((ValueAxis<Number>) chart.getYAxis()).setUpperBound(135200000);

        chart.getYAxis().setAutoRanging(true);
        logger.debug(chart.getYAxis().getScaleY());

        this.refreshChart();
        ChartCrossHairManager<Date, Number> crossHair = new ChartCrossHairManager<>(chart, chartParent, Date::toString, Object::toString);


    }

    private void refreshChart() {
        try (Profiler p = Profiler.start("Refreshing chart view")) {
            chart.getData().clear();
            Map<String, XYChart.Series<Date, Number>> series = getRawData();
//            chart.getData().addAll(
////                    series.get("InterruptTime"),
//                    series.get("DPCTime"),
//                    series.get("PrivilegedTime"),
//                    series.get("UserTime"),
//                    series.get("IdleTime"));
            //  chart.getData().add(series.get("InterruptTime"));
            //  chart.getData().add(series.get("DPCTime"));
//            chart.getData().add(series.get("PrivilegedTime"));
//            chart.getData().add(series.get("ProcessorTime"));
//            chart.getData().add(series.get("FreeVirtualMemory"));
//            chart.getData().add(series.get("TotalVirtualMemory"));
            chart.getData().addAll(series.values());
        } catch (IOException e) {
            logger.error(() -> "Error getting data", e);
            throw new RuntimeException(e);
        }
    }

    private Map<String, XYChart.Series<Date, Number>> getRawData() throws IOException {

        String jrdsHost = "ngwps006:31001";
        String target = "ngwps006.mshome.net";
        String probe = "memprocPdh";
        Instant end = endDateTime.getCalendar().getTime().toInstant();
        Instant begin = beginDateTime.getCalendar().getTime().toInstant();

        JRDSDataProvider dp = new JRDSDataProvider(jrdsHost);

        String[] counters = new String[]{
                "UserTime",
                "AvailableBytes",
                "IdleTime",
                "DPCTime",
                "PrivilegedTime",
                "PagesOutputPerSec",
                "LoadPercentage",
                "PagesInputPerSec",
                "ProcessorTime",
                "TotalPhysicalMemory",
                "FreeVirtualMemory",
                "TotalVirtualMemory",
                "InterruptTime"
        };

        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            if (dp.getData(target, probe, begin, end, out)) {
                InputStream in = new ByteArrayInputStream(out.toByteArray());
                return TimeSeriesBuilder.fromCSV(in, reductionTarget.get(), chkBoxEnableRDP.selectedProperty().get(), counters);
            }
            else {
                throw new IOException(String.format("Failed to retrieve data from JRDS for %s %s %s %s", target, probe, begin.toString(), end.toString()));
            }
        }
    }
}
