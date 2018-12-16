/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package eu.playperium.spongecore.configuration

import ninja.leaping.configurate.commented.CommentedConfigurationNode
import ninja.leaping.configurate.loader.ConfigurationLoader
import java.io.File
import java.util.*

class ConfigurationManager(configurationFile: File, configurationLoader: ConfigurationLoader<CommentedConfigurationNode>) {

    private val configurationFile: File = configurationFile
    private val configurationLoader: ConfigurationLoader<CommentedConfigurationNode> = configurationLoader
    private val configurationNode: CommentedConfigurationNode = configurationLoader.load()
    private val configOptions: ArrayList<ConfigOption> = ArrayList()

    fun registerConfigOption(option: ConfigOption) {
        if (!configOptions.contains(option)) {
            configOptions.add(option)
        }
    }

    fun setConfigOptions() {
        if (!configurationFile.exists()) {
            configurationFile.createNewFile()

            for (option: ConfigOption in configOptions) {
                configurationNode.getNode(*option.path).value = option.defaultValue
            }

            configurationLoader.save(this.configurationNode)
        }
    }

    fun setValue(option: ConfigOption, value: Any) {
        this.configurationNode.getNode(*option.path).value = value
        configurationLoader.save(this.configurationNode)
    }

    fun getString (option: ConfigOption): String {
        return this.configurationNode.getNode(*option.path).string
    }

    fun getFloat(option: ConfigOption): Float {
        return this.configurationNode.getNode(*option.path).float
    }

    fun getDouble(option: ConfigOption): Double {
        return this.configurationNode.getNode(*option.path).double
    }

    fun getInt(option: ConfigOption): Int {
        return this.configurationNode.getNode(*option.path).int
    }

    fun getLong(option: ConfigOption): Long {
        return this.configurationNode.getNode(*option.path).long
    }

    fun getBoolean(option: ConfigOption): Boolean {
        return this.configurationNode.getNode(*option.path).boolean
    }
}
