//package ocp.codingchallenges;
//
//import book.chapter3.collection.CustomLinkedListFagan;
//import org.junit.Ignore;
//import org.junit.Test;
//
//import java.util.Arrays;
//import java.util.Iterator;
//import java.util.List;
//import java.util.ListIterator;
//
//public class CustomLinkedListTest {
//
//    private CustomLinkedListFagan<Integer> list = new CustomLinkedListFagan<>();
//
//    @Test
//    public void size() {
//        assert list.size() == 0;
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        assert list.size() == 3;
//        list.clear();
//        assert list.size() == 0;
//    }
//
//    @Test
//    public void isEmpty() {
//        assert list.isEmpty();
//        list.add(1);
//        assert !list.isEmpty();
//    }
//
//    public void contains(Object o) {
//        assert !list.contains(new Object());
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        assert list.contains(3);
//        assert list.contains(1);
//
//    }
//
//    @Test
//    public void iterator() {
//        //case 1 empty list
//        Iterator<Integer> iterator = list.iterator();
//        assert !iterator.hasNext();
//
//        //case2 non empty list
//        list.add(1);
//        list.add(2);
//        list.add(3);
//
//        iterator = list.iterator();
//
//        assert iterator.hasNext() && iterator.next() == 1;
//        assert iterator.hasNext() && iterator.next() == 2;
//        assert iterator.hasNext() && iterator.next() == 3;
//        assert !iterator.hasNext();
//    }
//
//    @Test
//    public void add() {
//        //case 1 add to empty list
//        assert list.add(1);
//        assert list.contains(1);
//        assert list.size() == 1;
//
//        //case 2 add to non empty list
//        list.add(2);
//        list.add(3);
//        Iterator<Integer> iterator = list.iterator();
//        //to make sure list preserve insertion order of elements
//        assert iterator.next() == 1;
//        assert iterator.next() == 2;
//        assert iterator.next() == 3;
//        assert list.size() == 3;
//
//    }
//
//    @Test
//    public void removeObject() {
//        //case 1;//remove element from empty list
//        assert !list.remove(new Object());
//
//        //case 2; remove first element
//        list.add(1);
//        list.add(2);
//        list.add(3);
//
//        assert list.remove(Integer.valueOf(1));
//        assert !list.contains(1);
//
//        //case 2; remove last element
//        assert list.remove(Integer.valueOf(3));
//        assert !list.contains(3);
//        assert list.contains(2);
//        assert list.size() == 1;
//
//        list.add(100);
//        list.add(101);
//        assert list.get(0) == 2;
//        assert list.get(1) == 100;
//        assert list.get(2) == 101;
//    }
//
//    @Test
//    public void addAll() {
//        //case 1:empty list +collection
//        list.addAll(Arrays.asList(1, 2, 3));
//        assert list.size() == 3;
//        Iterator<Integer> iterator = list.iterator();
//        assert iterator.next() == 1;
//        assert iterator.next() == 2;
//        assert iterator.next() == 3;
//
//        //case 2;non empty list+collection
//        list.clear();
//        list.add(1);
//        list.addAll(Arrays.asList(2, 3, 4));
//        assert list.size() == 4;
//        iterator = list.iterator();
//        assert iterator.next() == 1;
//        assert iterator.next() == 2;
//        assert iterator.next() == 3;
//        assert iterator.next() == 4;
//        assert !iterator.hasNext();
//
//    }
//
//    @Test
//    public void addAllWithIndex() {
//
//        //case 1 insert to 0 index to empty list;
//        list.addAll(0, Arrays.asList(1, 2, 3));
//        assert list.size() == 3;
//        Iterator<Integer> iterator = list.iterator();
//        assert iterator.next() == 1;
//        assert iterator.next() == 2;
//        assert iterator.next() == 3;
//        assert !iterator.hasNext();
//
//        //case 2 insert to 0 index to non empty list;
//        list.clear();
//        list.add(1);
//        list.addAll(0, Arrays.asList(1, 2, 3));
//        iterator = list.iterator();
//        assert iterator.next() == 1;
//        assert iterator.next() == 2;
//        assert iterator.next() == 3;
//        assert iterator.next() == 1;
//        assert !iterator.hasNext();
//
//        //case 3 insert to  middle index;
//        list.clear();
//        list.add(1);
//        list.add(5);
//        list.add(7);
//        list.addAll(1, Arrays.asList(2, 3));
//        iterator = list.iterator();
//        assert iterator.next() == 1;
//        assert iterator.next() == 2;
//        assert iterator.next() == 3;
//        assert iterator.next() == 5;
//        assert iterator.next() == 7;
//
//        //case 4 insert to last index;
//        list.clear();
//        list.add(1);
//        list.addAll(1, Arrays.asList(2, 3));
//        iterator = list.iterator();
//        assert iterator.next() == 1;
//        assert iterator.next() == 2;
//        assert iterator.next() == 3;
//
//    }
//
//    @Test
//    public void clear() {
//        list.add(1);
//        list.clear();
//        assert list.size() == 0;
//        assert list.isEmpty();
//
//    }
//
//    @Test
//    public void get() {
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        assert list.get(0) == 1;
//        assert list.get(1) == 2;
//        assert list.get(2) == 3;
//    }
//
//    @Test
//    public void set() {
//        list.add(1);
//        assert list.set(0, 2) == 1;
//        assert list.get(0) == 2;
//    }
//
//    @Test
////	@Ignore
//    public void addWithIndex() {
//
//        //case 1 insert to 0 index to empty list;
//        list.add(0, 1);
//        assert list.contains(1);
//
//        //case 2 insert to 0 index to non empty list;
//        list.add(0, 2);
//        assert list.get(0) == 2;
//
//        //case 3 insert middle index;
//        list.add(1, 3);
//        assert list.get(0) == 2;
//        assert list.get(1) == 3;
//        assert list.get(2) == 1;
//
//        //case 4 insert last index;
//        list.add(3, 4);
//        assert list.get(3) == 4;
//
//    }
//
//    @Test
//    public void remove() {
//        list.add(1);
//
//        assert list.remove(0) == 1;
//
//        list.add(1);
//        list.add(2);
//        list.add(3);
//
//        assert list.remove(2) == 3;
//        Iterator<Integer> iterator = list.iterator();
//        assert iterator.next() == 1;
//        assert iterator.next() == 2;
//        assert !iterator.hasNext();
//
//    }
//
//    @Test
//    public void removeAll() {
//
//        list.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
//
//        list.removeAll(Arrays.asList(1, 2, 3));
//        assert !list.contains(1);
//        assert !list.contains(2);
//        assert !list.contains(3);
//    }
//
//    @Test
//    public void retainAll() {
//        list.addAll(Arrays.asList(1, 2, 3, 4));
//        assert list.retainAll(Arrays.asList(2, 3));
//        assert !list.contains(1);
//        assert list.get(0) == 2;
//        assert list.get(1) == 3;
//        assert !list.contains(4);
//
//        assert list.retainAll(Arrays.asList());
//        assert list.isEmpty();
//
//    }
//
//    @Test
//    public void containsAll() {
//
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//
//        assert list.containsAll(Arrays.asList(2, 3, 4));
//        assert list.containsAll(Arrays.asList(1, 2));
//    }
//
//    @Test
//    public void toArray() {
//        list.addAll(Arrays.asList(1, 2, 3));
//        Object[] arr = list.toArray();
//
//        assert arr[0] == Integer.valueOf(1);
//        assert arr[1] == Integer.valueOf(2);
//        assert arr[2] == Integer.valueOf(3);
//    }
//
//    @Test
//    public void toArray2() {
//        list.addAll(Arrays.asList(1, 2, 3));
//        Integer[] b = new Integer[3];
//        Integer[] arr = list.toArray(b);
//
//        assert arr[0] == Integer.valueOf(1);
//        assert arr[1] == Integer.valueOf(2);
//        assert arr[2] == Integer.valueOf(3);
//    }
//
//    @Test
//    public void indexOf() {
//        list.addAll(Arrays.asList(1, 2, 2, 2));
//        assert list.indexOf(2) == 1;
//    }
//
//    @Test
//    public void lastIndexOf() {
//        list.addAll(Arrays.asList(1, 2, 2, 2));
//        assert list.lastIndexOf(2) == 3;
//        assert list.lastIndexOf(1) == 0;
//    }
//
//    @Test
//    public void listIterator() {
//        list.addAll(Arrays.asList(1, 2, 3));
//        ListIterator<Integer> listIterator = list.listIterator();
//
//        assert !listIterator.hasPrevious();
//        assert listIterator.hasNext();
//        assert listIterator.next() == 1;
//        assert listIterator.hasNext();
//        assert listIterator.next() == 2;
//        assert listIterator.hasNext();
//        assert listIterator.next() == 3;
//        assert !listIterator.hasNext();
//        assert listIterator.hasPrevious();
//        assert listIterator.previous() == 3;
//        assert listIterator.hasPrevious();
//        assert listIterator.previous() == 2;
//        assert listIterator.hasPrevious();
//        assert listIterator.previous() == 1;
//        assert !listIterator.hasPrevious();
//
////		List<Integer> list =new ArrayList<>(Arrays.asList(1,2,3,4));
////		ListIterator<Integer> listIterator2 = list.listIterator();
//        assert listIterator.next() == 1;
//        listIterator.remove();
//        assert listIterator.next() == 2;
//        listIterator.next();
//        listIterator.remove();
////		System.out.println(list);
////		assert listIterator.next()==4;
//
//    }
//
//    @Test
//    public void listiterator12() {
//        list.addAll(Arrays.asList(1, 2, 3));
//        ListIterator<Integer> listIterator = list.listIterator();
//        System.out.println(list);
//        listIterator.next();
//        listIterator.set(-1);
//        assert list.get(0) == -1;
//    }
//
//    @Test
//    public void listIteratorWithIndex() {
//        list.addAll(Arrays.asList(1, 2, 3, 4));
//        ListIterator<Integer> listIterator = list.listIterator(1);
//        assert listIterator.next() == 2;
//        assert listIterator.next() == 3;
//        assert listIterator.next() == 4;
//        assert !listIterator.hasNext();
//
//        assert listIterator.previous() == 4;
//        assert listIterator.previous() == 3;
//        assert listIterator.previous() == 2;
//        assert listIterator.previous() == 1;
//        assert !listIterator.hasPrevious();
//
//    }
//
//    @Test
//    public void subList() {
//        list.addAll(Arrays.asList(1, 2, 3, 4));
//
//        List<Integer> sublist = list.subList(1, 3);
//        assert sublist.size() == 3;
//    }
//
//    @Test
//    @Ignore
//    public void tostring() {
//        assert list.toString().equals("[]");
//        list.add(1);
//        list.add(2);
//        assert list.toString().equals("[1,2]");
//    }
//
//    public static void checkTail(List<Integer> list) {
//        list.add(1);
//        assert list.get(list.size() - 1) == 1;
//    }
//
//}
