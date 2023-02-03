package digitalocean.innerclass;

public class Test {

    public static void main(String[] args) {
        test();
    }

    static void test() {
        User user = new User();
        User.City city = user.new City();
        city.setName("Baku");
        user.setCity(city);

        User.Address address = new User.Address();
        address.setName("Address");
        user.setAddress(address);

        System.out.println(user);
    }

    static {
        class Foo {

        }

        Foo f = new Foo();
    }

    public void bar() {
        if(1 < 2) {
            class Bar {

            }
            Bar bar = new Bar();
        }
        // Below will throw error because of the scope of the class
        //Bar t = new Bar();
        //zxlFoo f = new Foo();
    }

    //////////////////
    private String s_main_class;

    public void print() {
        String s_print_method = "";

        // local inner class inside the method
        class Logger {
            // able to access enclosing class variables
            String name = s_main_class;

            // able to access non-final method variables
            String name1 = s_print_method;

            @Override
            public String toString() {
                return "Test";
            }

            public void foo() {
                String name1 = s_print_method;
                // Below code will throw compile time error:
                // Local variable s_print_method defined in an enclosing scope must be final or effectively final
                //s_print_method= ":";
            }
        }

        // instantiate local inner class in the method to use
        Logger logger = new Logger();

    }

}
