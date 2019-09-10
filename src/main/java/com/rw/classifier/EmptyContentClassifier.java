package com.rw.classifier;

import com.rw.ContentClassification;

public class EmptyContentClassifier implements ContentClassifier {
    public ContentClassification classify(String content) {
        return new ContentClassification("");
    }
}
