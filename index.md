*binjr* is an open source time series visualization tool. It can plot time series data from multiple sources as a set of charts, which end users can navigate or zoom in and out.

Its focus is on enabling end users to constitute their own custom sets of views for the data exposed by various sources, generally in ways that are not proposed by the front-ends these sources might already propose, and then let them navigate these views dynamically, by zooming or panning to a chosen time interval or value range.

As such, *binjr* aims to become a valuable tool in forensic analysis when working with data sources that do not provide such flexible visualization natively.

It is a Java based client application, packaged as a single executable JAR file and has no other requirement than a compatible Java Runtime Environment, and runs on multiple Desktop environnements (Windows, MacOS and Linux).

<div id="PhotoGallery" class="photo-gallery">
  <figure class="photo-gallery--image">
    <a href="/assets/images/screenshot01.png" class="photo">
      <img src="/assets/images/screenshot01.png" alt="binjr screenshot 01">
    </a>
  </figure>
  <figure class="photo-gallery--image">
    <a href="/assets/images/screenshot02.png" class="photo">
      <img  src="/assets/images/screenshot02.png" alt="binjr screenshot  02">
    </a>
  </figure> 
  <figure class="photo-gallery--image">
    <a href="/assets/images/screenshot03.png" class="photo" >
      <img  src="/assets/images/screenshot03.png" alt="binjr screenshot  03">
    </a>
  </figure> 
  <figure class="photo-gallery--image">
    <a href="/assets/images/screenshot04.png" class="photo" >
      <img  src="/assets/images/screenshot04.png" alt="binjr screenshot  04">
    </a>
  </figure> 
</div>

## Getting started


_binjr_ is Java application, built on top of JavaFX, and requires a Java Runtime Environment version 1.8 with JavaFX version 8u40 or later.

The latest release can be found [here](https://github.com/fthevenet/binjr/releases/latest), and is available in different forms:
* _As a JAR file_

  All dependencies are packaged inside a single, executable JAR file; to start the application simply run `java -jar binjr.jar` (or double-click the jar file, provided your environment is configured adequately).
  
  You must have a copy of a Java Runtime Environment version 1.8 installed on your computer for this to work.

* _As a native application bundle_

  Plateform specific bundles are available, in the form of an MSI installer for Windows, RPM and DEB packages for Linux and DMG image for MacOS.
  
  Those bundles contain the application and all of its dependencies, as well as a minimal copy of the Oracle JRE for the target platform. 
  If using the bundle for your operating system, it doesn't matter what other version of Java, if any, is installed on your computer.

* _As source code_
  
  The source code repository for *binjr* is hosted on [Github](https://www.github.com) and can be found [here]({{ site.github.repository_url }}).
  
  Clone the [git repo]({{ site.github.clone_url }}) or download a [zip]({{ site.github.zip_url }}) or [tar.gz]({{{ site.github.tar_url }}}) archive that contains the source code, and build it with Maven 3 and a 1.8 Java Development Kit.

## Getting help

The user guide can be found [here](/user_manual).

If you encounter any problem starting the application, please check the [troubleshooting page](troubleshooting) for a list of common issues and solutions.

If all else failes, or if you would like to suggest an enhancement or a new feature, please open a ticket [here](https://github.com/fthevenet/binjr/issues).

Finally, if you've got some burning questions on the how or why behind *binjr*, try your luck with the [FAQ](MTMUFAQ). 

## How is it licensed?

*binjr* is released under the [Apache License version 2.0](http://www.apache.org/licenses/LICENSE-2.0).

