package me.filizes.prison.di.module

import dagger.Module
import dagger.Provides
import me.filizes.prison.api.container.ContainerAPI
import org.bukkit.plugin.java.JavaPlugin
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideContainerApi(plugin: JavaPlugin) =
        ContainerAPI(plugin)

}