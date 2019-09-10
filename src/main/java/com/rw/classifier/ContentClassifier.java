package com.rw.classifier;

import com.rw.ContentClassification;

public interface ContentClassifier {
    ContentClassification classify(String content);
}
