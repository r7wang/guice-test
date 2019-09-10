package com.rw.classifier;

import com.rw.ContentClassification;

public class DefaultContentClassifier implements ContentClassifier {
    public ContentClassification classify(String content) {
        return new ContentClassification(content);
    }
}
