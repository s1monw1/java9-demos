package de.swirtz.java.nine.demo;

import java.util.List;

public class StreamExtensions {

    public static void main(String[] args) {
        List<String> list = List.of("a", "b", "c", "d", "e");

        //print String until first time predicate fails
        list.stream().takeWhile(s -> s.compareTo("d") < 0).forEach(System.out::println);

        System.out.println("Next:");
        //print String as soon as predicate succeeds
        list.stream().dropWhile(s -> s.compareTo("d") < 0).forEach(System.out::println);

    }
}
