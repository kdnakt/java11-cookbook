package com.kdnakt.java11;

import java.util.function.Function;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String... arg) {
        Optional<Integer> prize1 = Optional.empty();
        System.out.println(prize1.isPresent()); // prints: false
        System.out.println(prize1); // prints: Optional.empty
        Optional<Integer> prize2 = Optional.of(1000000);
        System.out.println(prize2.isPresent()); // prints: true
        System.out.println(prize2); // prints: Optional[1000000]

        System.out.println(prize1.equals(prize2)); // prints: false

        // Optional<Integer> prize = Optional.of(null);
        // NullPointerException
        Optional<Integer> prize3 = Optional.ofNullable(null);
        System.out.println(prize3.isPresent()); // prints: false
        System.out.println(prize3); // prints: Optional.empty

        System.out.println(prize1.equals(prize3)); // prints: true

        Optional<Integer> prize4 = Optional.of(1000000);
        System.out.println(prize2.equals(prize4)); // prints: true
        System.out.println(prize2 == prize4); // prints: false

        Optional<Integer> prize5 = Optional.of(10);
        System.out.println(prize2.equals(prize5)); // prints: false

        Optional<String> congrats1 = Optional.empty();
        System.out.println(prize1.equals(congrats1));// prints: true
        Optional<String> congrats2 = Optional.of("Happy for you!");
        System.out.println(prize1.equals(congrats2));// prints: false

        List<Optional<Integer>> list = List.of(Optional.empty(), Optional.ofNullable(null), Optional.of(100000));
        useFlatMap(list);
    }

    private static void useFlatMap(List<Optional<Integer>> list) {
        Function<Optional<Integer>, Stream<Optional<Integer>>> tryUntilWin = opt -> {
            List<Optional<Integer>> opts = new ArrayList<>();
            if (opt.isPresent()) {
                opts.add(opt);
            } else {
                int prize = 0;
                while (prize == 0) {
                    double d = Math.random() - 0.8;
                    prize = d > 0 ? (int) (1000000 * d) : 0;
                    opts.add(Optional.of(prize));
                }
            }
            return opts.stream();
        };
        list.stream().flatMap(tryUntilWin).forEach(opt -> checkResultAndShare(opt.get()));
    }

    private static void checkResultAndShare(int prize) {
        if (prize <= 0) {
            System.out.println("We've lost again...");
        } else {
            System.out.println("We've won! Your half is " + Math.round(((double) prize) / 2) + "!");
        }
    }
}