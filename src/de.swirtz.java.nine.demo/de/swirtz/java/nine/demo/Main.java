package de.swirtz.java.nine.demo;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> j9Style = List.of("hello", "twitter", "folks");
        String txt = String.join(" ", j9Style);
        System.out.println(txt);
    }
}
