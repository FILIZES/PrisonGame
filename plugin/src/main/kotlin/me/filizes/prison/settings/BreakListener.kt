package me.filizes.prison.settings

import me.filizes.prison.api.listener.AutoRegisterListener
import me.filizes.prison.message.MessageConfig
import me.filizes.prison.message.MessageType
import org.bukkit.event.EventHandler
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.plugin.java.JavaPlugin
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BreakListener @Inject constructor(
    private val plugin: JavaPlugin,
    private val messageConfig: MessageConfig
): AutoRegisterListener(plugin) {

    @EventHandler
    fun onBreak(event: BlockBreakEvent) {
        val block = event.block
        val player = event.player

        if (!block.hasMetadata("location")) {
            messageConfig.sendMessage(player, MessageType.NOT_ALLOW_TO_BREAK)
            event.isCancelled = true
        }
    }

}