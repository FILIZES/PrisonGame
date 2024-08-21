package me.filizes.prison.api.acceptor

import me.filizes.prison.api.data.player.PrisonPlayer
import org.bukkit.entity.Player

interface PlayerAcceptor {

    fun accept(player: Player, prisonPlayer: PrisonPlayer)

}
