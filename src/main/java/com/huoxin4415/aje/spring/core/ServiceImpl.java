package com.huoxin4415.aje.spring.core;

public class ServiceImpl implements Service {

    private static final Service instance = new ServiceImpl("Spring Code Instance!");

    private String name;

    private User user;

    public ServiceImpl() {
        this.name = "Spring Code!";
    }

    public ServiceImpl(String name) {
        this.name = name;
    }

    public static Service createInstance() {
        return instance;
    }

    @Override
    public void hello() {
        System.out.println("Hello!" + name);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}