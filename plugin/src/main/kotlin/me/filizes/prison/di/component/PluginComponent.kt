package me.filizes.prison.di.component

import dagger.BindsInstance
import dagger.Component
import me.filizes.prison.PrisonPlugin
import me.filizes.prison.di.module.ApiModule
import me.filizes.prison.di.module.BindsModule
import me.filizes.prison.di.module.MongoModule
import me.filizes.prison.di.module.PluginModule
import org.bukkit.plugin.java.JavaPlugin
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        PluginModule::class,
        MongoModule::class,
        BindsModule::class,
        ApiModule::class
    ]
)
interface PluginComponent {
    fun inject(plugin: PrisonPlugin)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance plugin: JavaPlugin): PluginComponent
    }
}
