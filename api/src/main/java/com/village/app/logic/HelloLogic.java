package com.village.app.logic;

public class HelloLogic {
    public static String hello(String what) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            s.append("Hello ").append(what).append("\n");
        }
        return s.toString();
    }

    public static String hello2(String what) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            s.append("Hello ").append(what).append("\n");
        }
        return s.toString();
    }

    public static String helloJSON(String what) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            s.append("Hello ").append(what).append("\n");
        }
        return s.toString();
    }
}
