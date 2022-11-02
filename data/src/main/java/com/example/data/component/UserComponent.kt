package com.example.data.component

import com.example.data.scope.UserScope
import com.example.domain.model.User
import dagger.BindsInstance
import dagger.hilt.DefineComponent
import dagger.hilt.components.SingletonComponent
import dagger.hilt.internal.GeneratedComponentManager
import javax.inject.Inject
import javax.inject.Singleton

@UserScope
@DefineComponent(parent = SingletonComponent::class)
interface UserComponent {

    @DefineComponent.Builder
    interface Builder {
        fun provideUser(@BindsInstance user: User?): Builder
        fun build(): UserComponent
    }
}

@Singleton
class UserComponentManager @Inject constructor(
    private val builder: UserComponent.Builder
) : GeneratedComponentManager<UserComponent> {

    private var userComponent = builder
        .provideUser(null)
        .build()

    fun onLogin(user: User) {
        userComponent = builder
            .provideUser(user)
            .build()
    }

    fun onLogout() {
        userComponent = builder
            .provideUser(null)
            .build()
    }

    override fun generatedComponent(): UserComponent {
        return userComponent
    }

}