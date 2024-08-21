package me.filizes.prison

import com.mongodb.kotlin.client.coroutine.MongoClient
import me.filizes.prison.api.container.ContainerAPI
import me.filizes.prison.command.CommandManager
import me.filizes.prison.di.component.DaggerPluginComponent
import me.filizes.prison.listener.ListenerManager
import me.filizes.prison.message.MessageConfig
import me.filizes.prison.service.AllowBreakLocationBlocks
import me.filizes.prison.service.AutomaticRenew
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PrisonPlugin: JavaPlugin() {

    @Inject lateinit var commandManager: CommandManager
    @Inject lateinit var listenerManager: ListenerManager

    @Inject lateinit var messageConfig: MessageConfig

    @Inject lateinit var mongoClient: MongoClient

    @Inject lateinit var automaticRenew: AutomaticRenew
    @Inject lateinit var allowBreakLocationBlocks: AllowBreakLocationBlocks

    @Inject lateinit var containerApi: ContainerAPI

    override fun onEnable() {
        saveDefaultConfig()

        DaggerPluginComponent.factory()
            .create(this)
            .inject(this)

        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, automaticRenew, 20L * 10, 20L * 600)
        allowBreakLocationBlocks.load()
    }

    override fun onDisable() {
        mongoClient.close()
    }

}