package me.filizes.prison.command

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CommandManager @Inject constructor(
    private val testCommand: TestCommand,
    private val levelCommand: LevelCommand,
    private val locationCommand: LocationCommand,
    private val mineCommand: MineCommand,
)
