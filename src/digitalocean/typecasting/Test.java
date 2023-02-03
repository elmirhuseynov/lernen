package digitalocean.typecasting;

public class Test {

    public static void main(String[] args) {
        //upcasting
        Parent parent = new Child();
        parent.name = "Noname";
        parent.print();

        // Performing Down casting Implicitly
        //Child child = new Parent(); // it gives compile-time error

        // Performing Downcasting Explicitly
        Child child = (Child) parent;

        child.age = 18;
        System.out.println(child.name);
        System.out.println(child.age);
        child.print();
    }

}
