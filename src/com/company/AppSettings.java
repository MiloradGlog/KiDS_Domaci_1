package com.company;

public class AppSettings {

    private static final String CORPUS_PREFIX = "corpus_";

    private static AppSettings instance;

    private AppSettings(){

    }

    public static AppSettings getInstance() {
        if (instance == null){
            instance = new AppSettings();
        }
        return instance;
    }

    public String getCORPUS_PREFIX() {
        return CORPUS_PREFIX;
    }
}
