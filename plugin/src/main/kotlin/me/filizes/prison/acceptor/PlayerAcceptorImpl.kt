package me.filizes.prison.acceptor

import me.filizes.prison.api.acceptor.PlayerAcceptor
import me.filizes.prison.api.data.player.PrisonPlayer
import me.filizes.prison.message.MessageConfig
import me.filizes.prison.message.MessageType
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlayerAcceptorImpl @Inject constructor(
    private val messageConfig: MessageConfig
): PlayerAcceptor {

    override fun accept(player: Player, prisonPlayer: PrisonPlayer) {
        player.sendTitle(
            messageConfig.getMessage(MessageType.FIRST_JOIN_TITLE),
            messageConfig.getMessage(MessageType.FIRST_JOIN_SUBTITLE)
        )

        val item = ItemStack(
            Material.matchMaterial("WOOD_PICKAXE") ?: Material.WOODEN_PICKAXE
        ).apply {
            itemMeta!!.isUnbreakable = true
            itemMeta = itemMeta
        }

        player.inventory.addItem(item)
    }

}