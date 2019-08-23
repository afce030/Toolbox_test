package com.example.toolbox_test.di.Others;

import com.example.toolbox_test.View.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();
}
