package com.simonfea.lovewhereyouwork.model;

/**
 * Created by simonfea on 18/10/2016.
 */
public class AppModel {
    private static AppModel ourInstance = new AppModel();

    private AppModel() {
    }

    public static AppModel getInstance() {
        return ourInstance;
    }
}
