package baeldung.threadsafety.stateless_1;

import java.math.BigInteger;

//Stateless implementations
public class Test {

    public static void main(String[] args) {
        System.out.println(factorial(3));
    }

    // Thread safety: It is stateless method, because it returns always same result given specific input
    public static BigInteger factorial(int number) {
        BigInteger f = new BigInteger("1");

        for (int i = 2; i <= number; i++) {
            f = f.multiply(BigInteger.valueOf(i));
        }

        return f;
    }

}
