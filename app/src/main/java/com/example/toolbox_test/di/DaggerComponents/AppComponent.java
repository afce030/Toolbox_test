package com.example.toolbox_test.di.DaggerComponents;

import android.app.Application;

import com.example.toolbox_test.di.Others.ActivityBuilder;
import com.example.toolbox_test.di.DaggerModules.AppModule;
import com.example.toolbox_test.MyApp;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = { AndroidSupportInjectionModule.class, AppModule.class, ActivityBuilder.class })
public interface AppComponent extends AndroidInjector<MyApp> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);
        AppComponent build();

    }

    void inject(MyApp application);

}
