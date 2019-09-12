package com.rw;

import com.google.inject.AbstractModule;
import com.rw.classifier.ContentClassifier;
import com.rw.classifier.EmptyContentClassifier;

public class EmptyClassifierModule extends AbstractModule {
    @Override
    protected void configure()
    {
        bind(ContentClassifier.class).to(EmptyContentClassifier.class);
    }
}
