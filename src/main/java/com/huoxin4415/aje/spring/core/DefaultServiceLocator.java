package com.huoxin4415.aje.spring.core;

public class DefaultServiceLocator {
    private static Service instance = new ServiceImpl("Spring Code Instance By Bean!");

    public Service createInstance() {
        return instance;
    }
}