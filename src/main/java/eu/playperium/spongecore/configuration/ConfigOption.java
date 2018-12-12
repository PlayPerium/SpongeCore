/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package eu.playperium.spongecore.configuration;

public class ConfigOption {

    private Object[] path;
    private String defaultValue;

    public ConfigOption(String defaultValue, Object... path) {
        this.defaultValue = defaultValue;
        this.path = path;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public Object[] getPath() {
        return path;
    }
}
