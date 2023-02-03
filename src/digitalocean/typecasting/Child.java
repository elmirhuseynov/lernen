package digitalocean.typecasting;

public class Child extends Parent {

    int age;

    @Override
    public void print() {
        System.out.println("Child and age: " + age);
    }

}
