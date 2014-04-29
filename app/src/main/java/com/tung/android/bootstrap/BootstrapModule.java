package com.tung.android.bootstrap;

import android.accounts.AccountManager;
import android.content.Context;

import com.tung.android.bootstrap.authenticator.BootstrapAuthenticatorActivity;
import com.tung.android.bootstrap.authenticator.LogoutService;
import com.tung.android.bootstrap.core.TimerService;
import com.tung.android.bootstrap.ui.BootstrapTimerActivity;
import com.tung.android.bootstrap.ui.MainActivity;
import com.tung.android.bootstrap.ui.CheckInsListFragment;
import com.tung.android.bootstrap.ui.NavigationDrawerFragment;
import com.tung.android.bootstrap.ui.NewsActivity;
import com.tung.android.bootstrap.ui.NewsListFragment;
import com.tung.android.bootstrap.ui.UserActivity;
import com.tung.android.bootstrap.ui.UserListFragment;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module for setting up provides statements.
 * Register all of your entry points below.
 */
@Module(
        complete = false,

        injects = {
                BootstrapApplication.class,
                BootstrapAuthenticatorActivity.class,
                MainActivity.class,
                BootstrapTimerActivity.class,
                CheckInsListFragment.class,
                NavigationDrawerFragment.class,
                NewsActivity.class,
                NewsListFragment.class,
                UserActivity.class,
                UserListFragment.class,
                TimerService.class
        }
)
public class BootstrapModule {

    @Singleton
    @Provides
    Bus provideOttoBus() {
        return new Bus();
    }

    @Provides
    @Singleton
    LogoutService provideLogoutService(final Context context, final AccountManager accountManager) {
        return new LogoutService(context, accountManager);
    }

}
