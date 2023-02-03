package challenges.ff;

import java.util.stream.IntStream;

public class FTest {

    public static void main(String[] args) {
        IntStream.range(0, 5)
                .parallel()
                .sequential()
                //.forEachOrdered(System.out::println);
                .forEachOrdered(System.out::println);
    }
}
