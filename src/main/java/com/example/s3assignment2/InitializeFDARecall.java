package com.example.s3assignment2;

import java.io.IOException;

public interface InitializeFDARecall {
    void loadFDARecallDetails(String recallNumber) throws IOException, InterruptedException;
}
