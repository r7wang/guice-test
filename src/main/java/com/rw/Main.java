package com.rw;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main
{
    public static void main(String[] args)
    {
        Logger logger = new Logger();
        Injector injector = Guice.createInjector(new DefaultModule());
        ContentClassifier classifier = injector.getInstance(ContentClassifier.class);
        ContentClassification result = classifier.classify("test string");
        logger.log(result.toString());
    }
}
