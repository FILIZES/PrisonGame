package me.filizes.prison.listener

import me.filizes.prison.settings.BreakListener
import me.filizes.prison.settings.DropListener
import me.filizes.prison.settings.JoinListener
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ListenerManager @Inject constructor(
    private val firstJoinListener: FirstJoinListener,

    private val joinListener: JoinListener,
    private val dropListener: DropListener,
    private val breakListener: BreakListener,
)
