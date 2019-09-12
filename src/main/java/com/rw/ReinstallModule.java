package com.rw;

import com.google.inject.AbstractModule;
import com.rw.classifier.ContentClassifier;
import com.rw.classifier.DefaultContentClassifier;

public class ReinstallModule extends AbstractModule {
    @Override
    protected void configure()
    {
        bind(ContentClassifier.class).to(DefaultContentClassifier.class);
        install(new ReinstallModule());
    }
}
