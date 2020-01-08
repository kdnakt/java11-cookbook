package com.kdnakt.java11;

import java.util.function.Supplier;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class App {
    public static void main(String... arg) {
        int res = Objects.compare("a", "c", Comparator.naturalOrder());
        System.out.println(res); // prints: -2
        res = Objects.compare("a", "a", Comparator.naturalOrder());
        System.out.println(res); // prints: 0
        res = Objects.compare("c", "a", Comparator.naturalOrder());
        System.out.println(res); // prints: 2
        res = Objects.compare("c", "a", Comparator.reverseOrder());
        System.out.println(res); // prints: -2

        res = Objects.compare(3, 5, Comparator.naturalOrder());
        System.out.println(res); // prints: -1
        res = Objects.compare(3, 3, Comparator.naturalOrder());
        System.out.println(res); // prints: 0
        res = Objects.compare(5, 3, Comparator.naturalOrder());
        System.out.println(res); // prints: 1
        res = Objects.compare(5, 3, Comparator.reverseOrder());
        System.out.println(res); // prints: -1
        res = Objects.compare("5", "3", Comparator.reverseOrder());
        System.out.println(res); // prints: -2

        res = Objects.compare(null, null, Comparator.naturalOrder());
        System.out.println(res); // prints: 0

        // throws NullPointerException
        // Objects.compare(null, "c", Comparator.naturalOrder());

        System.out.println(Objects.toString("a")); // prints: a
        System.out.println(Objects.toString(null)); // prints: null
        System.out.println(Objects.toString("a", "b")); // prints: a
        System.out.println(Objects.toString(null, "b"));// prints: b

        List<Integer> list = List.of(1, 2);
        try {
            Objects.checkIndex(3, list.size());
        } catch (IndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
            // prints: Index 3 out-of-bounds for length 2
        }

        try {
            Objects.checkFromIndexSize(1, 3, list.size());
        } catch (IndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
            // prints:Range [1, 1 + 3) out-of-bounds for length 2
        }

        try {
            Objects.checkFromToIndex(1, 3, list.size());
        } catch (IndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
            // prints:Range [1, 3) out-of-bounds for length 2
        }

        String obj = null;
        try {
            Objects.requireNonNull(obj);
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());// prints: null
        }

        try {
            Objects.requireNonNull(obj, "Parameter 'obj' is null");
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
            // prints: Parameter 'obj' is null
        }

        Supplier<String> supplier = () -> "Message";
        try {
            Objects.requireNonNull(obj, supplier);
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
            // prints: Message
        }

        System.out.println(Objects.requireNonNullElse(obj, "Default value"));
        // prints: Default value

        Integer intObj = null;
        Supplier<Integer> intSupplier = () -> 42;
        try {
            System.out.println(Objects.requireNonNullElseGet(intObj, intSupplier));
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage()); // prints: 42
        }

        System.out.println(Objects.hashCode(null));
        // prints: 0
        System.out.println(Objects.hashCode("abc"));
        // prints: 96354

        System.out.println(Objects.hash((Object[])null)); // prints: 0
        System.out.println(Objects.hash("abc"));
        // prints: 96385
        String[] arr = { "abc" };
        System.out.println(Objects.hash((Object[])arr));
        Object[] objs = { "a", 42, "c" };
        System.out.println(Objects.hash(objs));
        // prints: 124409
        System.out.println(Objects.hash("a", 42, "c"));
        // prints: 124409
    }
}