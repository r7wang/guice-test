package com.rw;

import com.google.inject.ConfigurationException;
import com.google.inject.CreationException;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.rw.classifier.ContentClassifier;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuiceTest
{
    @Test(expected = ConfigurationException.class)
    public void testNoModuleInjector()
    {
        Injector injector = Guice.createInjector();
        injector.getInstance(ContentClassifier.class);
    }

    @Test
    public void testInjectorFromModule()
    {
        Injector injector = Guice.createInjector(new DefaultModule());
        ContentClassifier classifier = injector.getInstance(ContentClassifier.class);
        ContentClassification result = classifier.classify("test string");
        assertEquals("test string", result.toString());
    }

    @Test
    public void testModuleInstall()
    {
        Injector injector = Guice.createInjector(new ParentModule());
        ContentClassifier classifier = injector.getInstance(ContentClassifier.class);
        ContentClassification result = classifier.classify("test string");
        assertEquals("test string", result.toString());
    }

    @Test(expected = CreationException.class)
    public void testDuplicateBinding()
    {
        Guice.createInjector(new DuplicateBindModule());
    }

    @Test
    public void testRepeatedBinding()
    {
        Injector injector = Guice.createInjector(new RepeatedBindModule());
        ContentClassifier classifier = injector.getInstance(ContentClassifier.class);
        ContentClassification result = classifier.classify("test string");
        assertEquals("test string", result.toString());
    }

    @Test(expected = CreationException.class)
    public void testDuplicatedBindingInSeparateModules()
    {
        Guice.createInjector(new DuplicateBindInstallModule());
    }

    @Test
    public void testRepeatedBindingInSeparateModules()
    {
        Injector injector = Guice.createInjector(new RepeatedBindInstallModule());
        ContentClassifier classifier = injector.getInstance(ContentClassifier.class);
        ContentClassification result = classifier.classify("test string");
        assertEquals("test string", result.toString());
    }

    @Test(expected = StackOverflowError.class)
    public void testReinstallCurrentModule()
    {
        Guice.createInjector(new ReinstallModule());
    }
}
