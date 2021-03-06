/*
 *    Copyright 2017-2018 Frederic Thevenet
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package eu.fthevenet.util.text;

/**
 * An implementation of {@link PrefixFormatter} for binary prefixes
 *
 * @author Frederic Thevenet
 */
public class BinaryPrefixFormatter extends PrefixFormatter {
    /**
     * Initializes a new instance of the {@link BinaryPrefixFormatter} class
     */
    public BinaryPrefixFormatter() {
        super(1024, new String[]{"ki", "Mi", "Gi", "Ti", "Pi", "Ei"});
    }
}
