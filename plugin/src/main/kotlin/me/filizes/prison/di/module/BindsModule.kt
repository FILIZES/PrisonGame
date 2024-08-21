package me.filizes.prison.di.module

import dagger.Binds
import dagger.Module
import me.filizes.prison.acceptor.PlayerAcceptorImpl
import me.filizes.prison.api.acceptor.PlayerAcceptor
import me.filizes.prison.api.data.player.PlayerManager
import me.filizes.prison.api.data.world.LocationManager
import me.filizes.prison.data.player.MongoPlayerManager
import me.filizes.prison.data.world.MongoLocationManager
import javax.inject.Singleton

@Module
abstract class BindsModule {

    @Binds
    @Singleton
    abstract fun providePlayerManager(mongoPlayerManager: MongoPlayerManager): PlayerManager

    @Binds
    @Singleton
    abstract fun providePlayerAcceptor(playerAcceptorImpl: PlayerAcceptorImpl): PlayerAcceptor

    @Binds
    @Singleton
    abstract fun provideLocationManager(mongoLocationManager: MongoLocationManager): LocationManager

}
