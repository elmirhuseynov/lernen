package challenges.ee;

import java.util.function.Predicate;

public class PredicateChallenge {

    private static final String primis = "elmir";
    private static final String secundus = "elmir";

    public static void main(String... args) {
        Predicate<String> pugna = (new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return primis == new String(s).intern();
            }
        }) // -> true
                .and(new Pugna()) // true and false = false
                .or(s -> s.equals(secundus)) // false || true = true
                .negate(); // false

        System.out.println(pugna.test(primis));
    }

    static class Pugna implements Predicate<String> {

        @Override
        public boolean test(String s) {
            return s.equals("!elmir");
        }
    }
}
   
