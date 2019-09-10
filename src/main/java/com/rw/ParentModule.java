package com.rw;

import com.google.inject.AbstractModule;

public class ParentModule extends AbstractModule {
    @Override
    protected void configure()
    {
        install(new DefaultModule());
    }
}
