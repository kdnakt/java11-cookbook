package com.kdnakt.java11;

import java.util.Arrays;
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

        System.out.println(Objects.hash((Object[]) null)); // prints: 0
        System.out.println(Objects.hash("abc"));
        // prints: 96385
        String[] arr = { "abc" };
        System.out.println(Objects.hash((Object[]) arr));
        Object[] objs = { "a", 42, "c" };
        System.out.println(Objects.hash(objs));
        // prints: 124409
        System.out.println(Objects.hash("a", 42, "c"));
        // prints: 124409

        obj = null;
        System.out.println(obj == null); // prints: true
        System.out.println(Objects.isNull(obj));
        // prints: true
        obj = "";
        System.out.println(obj == null); // prints: false
        System.out.println(Objects.isNull(obj));
        // prints: false

        obj = null;
        System.out.println(obj != null); // prints: false
        System.out.println(Objects.nonNull(obj));
        // prints: false
        obj = "";
        System.out.println(obj != null); // prints: true
        System.out.println(Objects.nonNull(obj));
        // prints: true

        String o1 = "o";
        String o2 = "o";
        System.out.println(Objects.equals(o1, o2));
        // prints: true
        System.out.println(Objects.equals(null, null));
        // prints: true
        Integer[] ints1 = { 1, 2, 3 };
        Integer[] ints2 = { 1, 2, 3 };
        System.out.println(Objects.equals(ints1, ints2));
        // prints: false
        Integer[] ints3 = ints1;
        System.out.println(Objects.equals(ints1, ints3));
        // prints: true

        System.out.println(Objects.deepEquals(o1, o2));
        // prints: true
        System.out.println(Objects.deepEquals(null, null));
        // prints: true

        System.out.println(Objects.deepEquals(ints1, ints2));
        // prints: true

        Integer[][] iints1 = { { 1, 2, 3 }, { 1, 2, 3 } };
        Integer[][] iints2 = { { 1, 2, 3 }, { 1, 2, 3 } };
        System.out.println(Objects.deepEquals(iints1, iints2)); // prints: true
        Integer[][] iints11 = { { 1, 2, 3 }, { 1, 2, 3 } };
        Integer[][] iints12 = { { 1, 2, 3 }, { 1, 3, 2 } };
        System.out.println(Objects.deepEquals(iints11, iints12)); // prints: false

        System.out.println(Arrays.equals(ints1, ints2));
        // prints: true
        System.out.println(Arrays.deepEquals(ints1, ints2));
        // prints: true
        System.out.println(Arrays.equals(iints1, iints2));
        // prints: false
        System.out.println(Arrays.deepEquals(iints1, iints2));
        // prints: true
    }
}