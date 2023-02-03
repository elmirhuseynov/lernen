package challenges.tt;

import java.util.IntSummaryStatistics;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(3, 4, 5, 6, 7);
        /*
            Basqa Stream yaratmadan yuxaridaki stream-den min, max, avg tapilmasi teleb olunur.
        */

//        var min = stream.min(Integer::compareTo)
//                .orElseThrow();
//        System.out.println("Min: " + min);

//        var max = stream.max(Integer::compareTo)
//                        .orElseThrow();
//        System.out.println("Max: " + max);

//        var avg = stream.mapToInt(Integer::intValue)
//                .average()
//                .orElseThrow();
//
//        System.out.println("Average: " + avg);

        get();

        test();
    }

    public static void get() {
        // first
        IntSummaryStatistics firstWay = Stream.of(3, 4, 5, 6, 7)
                .mapToInt(Integer::intValue)
                .summaryStatistics();

        System.out.println(firstWay.getMax());
        System.out.println(firstWay.getMin());
        System.out.println(firstWay.getAverage());

        // second
        IntSummaryStatistics secondWay = Stream.of(3, 4, 5, 6, 7)
                .collect(Collectors.summarizingInt(Integer::intValue));

        System.out.println(secondWay.getMax());
        System.out.println(secondWay.getMin());
        System.out.println(secondWay.getAverage());
    }

    static void test() {
        // reusable stream - don't try this at home
        Supplier<Stream<Integer>> reusableStream = new Supplier<Stream<Integer>>() {
            @Override
            public Stream<Integer> get() {
                return Stream.of(3, 4, 5, 6, 7);
            }
        };

        reusableStream.get().forEach(System.out::println);
        reusableStream.get().forEach(System.out::println);
        reusableStream.get().forEach(System.out::println);
    }
}
