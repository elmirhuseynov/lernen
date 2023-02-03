package challenges.ff;

import java.util.HashSet;
import java.util.Set;

public class BoxTest {

    static Box box = new Box();
    static int counter = 0;

    public static void main(String[] args) {
        //add 30 item to box
        //for (int i = 0; i < 30; i++) {
            box.add(new ModItem());
        //}
        box.done();
    }

    static class ModItem extends Item {

        @Override
        public int hashCode() {
            if (++counter < 30) {
                box.add(new ModItem());
            }
            return super.hashCode();
        }
    }

}

class Box {

    private static final int CAPACITY = 5;
    private Set<Item> items = new HashSet<>();

    public synchronized void add(Item item) {
        if (items.size() >= CAPACITY) {
            throw new IllegalStateException("full");
        } else {
            items.add(item);
        }
    }

    public synchronized void done() {
        if (items.size() == 30) {
            System.out.println("box with 30 items!");
        }
    }
}

class Item {
}
