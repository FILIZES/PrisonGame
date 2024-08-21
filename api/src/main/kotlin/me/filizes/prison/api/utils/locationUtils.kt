package me.filizes.prison.api.utils

import me.filizes.prison.api.data.world.Position
import org.bukkit.Location

fun Location.toPosition() =
    Position(
        world = this.world!!.name,
        x = this.blockX,
        y = this.blockY,
        z = this.blockZ,
    )