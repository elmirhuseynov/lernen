package effectivejava.item7;

public class Test {

    @Override
    protected void finalize() throws Throwable {
        try {
            // cleanup subclass state
            System.out.println("finalize");
        } finally {
            super.finalize();
        }
    }

    public static void main(String[] args) {
        while (true) {
            Test test = new Test();

            //System.out.println("if block");
        }

    }

}
