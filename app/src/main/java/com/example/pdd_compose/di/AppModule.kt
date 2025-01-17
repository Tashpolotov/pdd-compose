package com.example.pdd_compose.di

import android.app.Application
import com.example.pdd_compose.data.remote.ApiServices
import com.example.pdd_compose.data.remote.ProfileApiService
import com.example.pdd_compose.data.remote.RankApiService
import com.example.pdd_compose.data.remote.RegisterApiService
import com.example.pdd_compose.data.remote.main.MainLevelApiService
import com.example.pdd_compose.data.repository.MainLevelRepositoryImpl
import com.example.pdd_compose.data.repository.register.RegisterRepoImpl
import com.example.pdd_compose.data.repository.manager.LocalUserManagerImpl
import com.example.pdd_compose.data.repository.profile.ProfileRepoImpl
import com.example.pdd_compose.data.repository.rank.RankRepositoryImpl
import com.example.pdd_compose.domain.repository.RepositoryDomain
import com.example.pdd_compose.domain.repository.auth.AuthRepository
import com.example.pdd_compose.domain.repository.localmanager.LocalUserManager
import com.example.pdd_compose.domain.repository.main.level.MainLevelRepository
import com.example.pdd_compose.domain.repository.profile.ProfileRepository
import com.example.pdd_compose.domain.repository.rank.RankRepository
import com.example.pdd_compose.domain.usecase.rank.GetAllUsersUseCase
import com.example.pdd_compose.domain.usecase.UsaCases
import com.example.pdd_compose.domain.usecase.app_entry.AppEntryUseCase
import com.example.pdd_compose.domain.usecase.app_entry.ReadAppEntry
import com.example.pdd_compose.domain.usecase.app_entry.SaveAppEntry
import com.example.pdd_compose.domain.usecase.level.MainLevelUseCase
import com.example.pdd_compose.domain.usecase.profileusecase.ProfileUseCase
import com.example.pdd_compose.domain.usecase.registerusecase.RegisterUseCase
import com.example.pdd_compose.util.SharedPref
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(application: Application): LocalUserManager {
        return LocalUserManagerImpl(application)
    }

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCase(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

    @Provides
    @Singleton
    fun provideApiServices(retrofit: Retrofit): ApiServices {
        return ApiServices(
            profileApiService = retrofit.create(ProfileApiService::class.java),
            registerApiService = retrofit.create(RegisterApiService::class.java)
        )
    }

    @Provides
    @Singleton
    fun provideRegisterRepositoryImpl(apiService: ApiServices, sharedPref: SharedPref): AuthRepository {
        return RegisterRepoImpl(apiService.registerApiService, sharedPref)
    }

    @Provides
    @Singleton
    fun provideProfileRepositoryImpl(apiService: ApiServices, sharedPref: SharedPref): ProfileRepository {
        return ProfileRepoImpl(apiService.profileApiService, sharedPref)
    }

    @Provides
    fun provideRankApiService(retrofit: Retrofit) =
        retrofit.create(RankApiService::class.java)

    @Provides
    fun provideRankRepository(apiService: RankApiService, sharedPref: SharedPref): RankRepository {
        return RankRepositoryImpl(apiService, sharedPref)
    }

    @Provides
    fun provideMainLevelApiService(retrofit: Retrofit): MainLevelApiService {
        return retrofit.create(MainLevelApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideMainLevelRepository(apiService: MainLevelApiService, sharedPref: SharedPref)
            : MainLevelRepository {
        return MainLevelRepositoryImpl(apiService, sharedPref)
    }

    @Provides
    @Singleton
    fun provideUseCase(repository: RepositoryDomain): UsaCases {
        return UsaCases(
            profileUseCase = ProfileUseCase(repository.profileRepository),
            registerUseCase = RegisterUseCase(repository.authRepository),
            rankUseCase = GetAllUsersUseCase(repository.rankRepository),
            levelUseCase = MainLevelUseCase(repository.levelRepository)
        )
    }

}