package com.parabank.pom.util;

public class General {

    public static void waitForDomStable() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
