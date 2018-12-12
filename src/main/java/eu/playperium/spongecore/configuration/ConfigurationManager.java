/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package eu.playperium.spongecore.configuration;

import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ConfigurationManager {

    private File configurationFile;

    private ConfigurationLoader<CommentedConfigurationNode> configurationLoader;
    private CommentedConfigurationNode configurationNode = null;

    private ArrayList<ConfigOption> configOptions = new ArrayList<>();

    public ConfigurationManager(File configurationFile, ConfigurationLoader<CommentedConfigurationNode> configurationLoader) {
        this.configurationFile = configurationFile;
        this.configurationLoader = configurationLoader;

        try {
            this.configurationNode = configurationLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registerConfigOption(ConfigOption option) {
        configOptions.add(option);
    }

    public void setConfigOptions() {
        if (!configurationFile.exists()) {
            try {
                configurationFile.createNewFile();

                for (ConfigOption option: configOptions) {
                    if (option.getDefaultValue() != null) {
                        configurationNode.getNode(option.getPath()).setValue(option.getDefaultValue());
                        configurationNode.getNode();
                    }
                }

                configurationLoader.save(this.configurationNode);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String getString(ConfigOption option) {
        return configurationNode.getNode(option.getPath()).getString();
    }

    public float getFloat(ConfigOption option) {
        return configurationNode.getNode(option.getPath()).getFloat();
    }

    public double getDouble(ConfigOption option) {
        return configurationNode.getNode(option.getPath()).getDouble();
    }

    public int getInt(ConfigOption option) {
        return configurationNode.getNode(option.getPath()).getInt();
    }

    public long getLong(ConfigOption option) {
        return configurationNode.getNode(option.getPath()).getLong();
    }

    public boolean getBoolean(ConfigOption option) {
        return configurationNode.getNode(option.getPath()).getBoolean();
    }

    public void setValue(ConfigOption option, Object value) {
        configurationNode.getNode(option.getPath()).setValue(value);

        try {
            configurationLoader.save(this.configurationNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
