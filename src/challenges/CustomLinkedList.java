package challenges;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

public class CustomLinkedList<T> implements List<T> {

    public CustomLinkedList() {

    }

    private CustomLinkedList(Node head, Node tail, int size) {
        this.head = head;
        this.tail = tail;
        this.size = size;
    }

    private class Node {
        private T val;
        private Node next;
        private Node previous;

        public Node(T val, Node previous, Node next) {
            this.val = val;
            this.next = next;
            this.previous = previous;
        }

        boolean isHead() {
            return this.previous == null;
        }

        boolean isTail() {
            return this.next == null && this.previous != null;
        }

        public String toString() {
            return (isHead() ? "head" : isTail() ? "tail" : "middle") + "  " + super.toString();
        }
    }

    private Node head;
    private Node tail;
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean contains(Object o) {
        Node node = head;
        while (node != null) {
            if (Objects.equals(node.val, o)) {
                return true;
            }

            node = node.next;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node savepoint = CustomLinkedList.this.head;

            @Override
            public boolean hasNext() {
                return savepoint != null;
            }

            @Override
            public T next() {
                if (savepoint == null) {
                    throw new NoSuchElementException();
                } else {
                    Node refer = savepoint;
                    savepoint = savepoint.next;
                    return refer.val;
                }

            }
        };
    }

    @Override
    public Object[] toArray() {
        return this.stream().toArray();
    }

    @Override
    public <G> G[] toArray(G[] a) {
        if (a.length < size) {
            return (G[]) this.stream().toArray();
        } else {
            int index = 0;
            Iterator<T> iterator = CustomLinkedList.this.iterator();
            while (iterator.hasNext()) {
                a[index] = (G) iterator.next();
                index++;
            }
            return a;
        }
    }

    @Override
    public boolean add(T e) {
        addLast(e);
        size++;
        return true;
    }

    private void addLast(T e) {
        if (head == null) {
            head = new Node(e, null, null);
        } else {
            if (tail == null) {
                tail = new Node(e, head, null);
                head.next = tail;
            } else {
                Node referOldTail = tail;
                tail = new Node(e, referOldTail, null);
                referOldTail.next = tail;
            }
        }
    }

    private void addFirst(T e) {
        if (head == null) {
            head = new Node(e, null, null);
        } else {
            Node first = head;
            head = new Node(e, null, first);
            first.previous = head;
            if (tail == null) {
                tail = first;
            }
        }
    }

    @Override
    public boolean remove(Object o) {
        if (head == null) {
            return false;
        }

        if (Objects.equals(head.val, o)) {
            head = head.next;
            head.previous = null;
            size--;
            return true;
        }
        Node node = head;
        while (node != null) {
            if (Objects.equals(node.val, o)) {
                //burada 3 case var:
                //node head,tail,ve middle olar biler
                Node previous = node.previous;
                Node next = node.next;
                size--;
                if (node == head) {
                    if (next == null) {
                        head = null;
                        return true;
                    } else {
                        next.previous = null;
                        head = next;
                        return true;
                    }
                } else if (node == tail) {
                    if (previous == head) {
                        tail = null;
                    }
                    previous.next = null;
                    return true;
                } else {
                    previous.next = next;
                    next.previous = previous;
                    return true;
                }
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return c.stream().allMatch(obj -> this.contains(obj));
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        Iterator<? extends T> iterator = c.iterator();
        if (iterator.hasNext()) {
            T val = iterator.next();
            if (head == null) {
                head = new Node(val, null, null);
            } else {
                Node previous = tail != null ? tail : head;
                Node newNode = new Node(val, previous, null);
                previous.next = newNode;
                tail = newNode;
            }
            size++;
        } else
            return false;

        //artiq head var
        while (iterator.hasNext()) {
            T val = iterator.next();
            Node previous = tail != null ? tail : head;
            Node newNode = new Node(val, previous, null);
            previous.next = newNode;
            tail = newNode;
            size++;
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Iterator<? extends T> iterator = c.iterator();

        Node node = null;
        if (iterator.hasNext()) {
            T val = iterator.next();
            if (head == null) {
                head = new Node(val, null, null);
            } else {
                //hemishe head var
                node = head;
                for (int i = 0; i < index; i++) {
                    node = node.next;
                }
                if (node == null) {//index=size()

                    Node previous = tail != null ? tail : head;
                    Node newTail = new Node(val, previous, null);
                    previous.next = newTail;
                    tail = newTail;
                } else {//index<size();
                    Node previous = node.previous;
                    Node newNode = new Node(val, previous, node);
                    if (node == head) {
                        node.previous = newNode;
                        head = newNode;
                        if (tail == null) {
                            tail = node;
                        }
                    } else if (node == tail) {//minimum list size==2
                        node.previous = newNode;
                        previous.next = newNode;//::)
                    } else {
                        node.previous = newNode;
                        previous.next = newNode;//::)
                    }
                }
            }
            size++;
        } else return false;

        while (iterator.hasNext()) {
            T val = iterator.next();

            if (node == null) {//index=size()
                Node previous = tail != null ? tail : head;
                Node newTail = new Node(val, previous, null);
                previous.next = newTail;
                tail = newTail;
            } else {//index<size();
                Node previous = node.previous;
                Node newNode = new Node(val, previous, node);
                if (node == head) {
                    node.previous = newNode;
                    head = newNode;
                    if (tail == null) {
                        tail = node;
                    }
                } else if (node == tail) {//minimum list size==2
                    node.previous = newNode;
                    previous.next = newNode;//::)
                } else {
                    node.previous = newNode;
                    previous.next = newNode;
                }
            }
            size++;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (head == null) {
            return false;
        } else if (tail == null) {
            if (c.contains(head.val)) {
                head = null;
                size--;
                return true;
            }
            return false;
        } else {
            Node node = head;
            while (node != null) {
                if (c.contains(node.val)) {
                    Node previous = node.previous;
                    Node next = node.next;

                    if (node == head) {
                        if (next == tail) {
                            tail = null;
                        }
                        next.previous = null;
                        head = next;

                    } else if (node == tail) {
                        if (previous == head) {
                            tail = null;
                        } else {
                            previous.next = null;
                            tail = previous;
                        }
                    } else {
                        previous.next = next;
                        next.previous = previous;
                    }
                    size--;
                }
                node = node.next;
            }
            return false;
        }
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        Node node = head;
        boolean f = false;
        while (node != null) {
            if (!c.contains(node.val)) {
                if (removeNode(node)) {
                    f = true;
                }
            }
            node = node.next;
        }
        return f;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public T get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.val;
    }

    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        T oldVal = node.val;
        node.val = element;
        return oldVal;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        //when list is empty case
        if (head == null) {
            head = new Node(element, null, null);
            size++;
            return;
        }

        //list is not empty case en azi list-de 1 element vardir
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        //index==size()-1 case
        if (node == null) {
            Node previous = null;
            if (tail != null) {
                previous = tail;
            } else {
                previous = head;
            }
            Node newTail = new Node(element, previous, null);
            previous.next = newTail;
            tail = newTail;
            size++;
            return;
        }

        //case: eger index sonuncu olsa tail deyishir

        Node previous = node.previous;
        Node newNode = new Node(element, previous, node);
        node.previous = newNode;
        if (previous != null)
            previous.next = newNode;
        else
            head = newNode;

        //setup tail start
        //eger verilmish index 0-dirsa
        if (node.previous == head) {
            tail = node;
        } else
            //burada node hec vaxt null ola bilmez ama tail null olar biler [eger list-in size -i 2-den kicik olarsa]
            if (node.previous == tail) {
                tail = node;
            }
        //setup tail end
        size++;

    }

    private T removeFirst() {
        Node first = head;
        if (first == null) {
            throw new NoSuchElementException();
        }
        Node next = first.next;
        if (next != null) {
            if (next == tail) {
                tail = null;
            }
            next.previous = null;
            head = next;
        } else {
            head = null;
        }
        return first.val;

    }

    private T removeLast() {
        if (tail != null) {
            Node buff = tail;
            Node previous = tail.previous;
            previous.next = null;
            tail = previous;
            return buff.val;
        } else {
            return removeFirst();
        }
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        if (node == head) {
            return removeFirst();
        } else if (node == tail) {
            return removeLast();
        } else {

            Node previous = node.previous;
            Node next = node.next;
            previous.next = next;
            next.previous = previous;
            return node.val;
        }
    }

    @Override
    public int indexOf(Object o) {
        Node node = head;
        int index = 0;
        while (node != null) {
            if (Objects.equals(node.val, o)) {
                return index;
            }
            node = node.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {

        Node last = tail != null ? tail : head;
        int index = size() - 1;
        while (last != null) {
            if (Objects.equals(last.val, o)) {
                return index;
            }
            last = last.previous;
            index--;
        }
        return -1;
    }

    //TODO add size check to methods index<0 || index>size()
    private Node node(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        int k = 0;
        Node node = head;
        while (index != k) {
            node = node.next;
            k++;
        }
        return node;
    }

    private class MyListIterator implements ListIterator<T> {

        public MyListIterator(final int index) {
            this.index = index;
            this.savepoint = node(index);
            this.oldSavePoint = savepoint != null ? savepoint.previous : null;
            // TODO implement calculation savepoint and oldsavePoint
        }

        private int index;
        private Node savepoint = CustomLinkedList.this.head; //ya head ,yada queu-nin sonu olduqda null olur
        private Node oldSavePoint = null; //yalniz head null olduqda olur

        @Override
        public boolean hasNext() {
            return savepoint != null;
        }

        @Override
        public T next() {
            if (savepoint == null) {
                throw new NoSuchElementException();
            } else {
                oldSavePoint = savepoint;
                savepoint = savepoint.next;
                index++;
                return oldSavePoint.val;
            }

        }

        @Override
        public boolean hasPrevious() {

            if (savepoint != null) {
                if (savepoint.previous != null) {
                    return true;
                } else {
                    return false;
                }
            } else {
                //iki case var:
                //1)savepoint=head==null,
                //2)savepoint =null-> oldSavePoint!=null
                if (head == null) {
                    return false;
                }
                if (oldSavePoint != null) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public T previous() {
            if (head == null) {
                throw new NoSuchElementException();
            }
            if (savepoint == null) {//sona direnib

                Node refer = oldSavePoint;
                savepoint = oldSavePoint;
                oldSavePoint = oldSavePoint.previous;
                index--;
                return refer.val;
            } else {
                if (oldSavePoint == null) {
                    throw new NoSuchElementException();
                } else {
                    Node refer = oldSavePoint;
                    savepoint = oldSavePoint;
                    oldSavePoint = oldSavePoint.previous;
                    index--;
                    return refer.val;
                }
            }
        }

        @Override
        public int nextIndex() {
            return index + 1;
        }

        @Override
        public int previousIndex() {
            // TODO Auto-generated method stub
            return index - 1;
        }

        @Override
        public void remove() {
            //savepoint node-unu remove etmek lazimdir
            if (oldSavePoint == null) {
                throw new NoSuchElementException();
            }
            Node previous = oldSavePoint.previous;
            Node next = oldSavePoint.next;
            removeNode(oldSavePoint);
            savepoint = next;
            oldSavePoint = previous;
        }

        @Override
        public void set(T e) {
            if (oldSavePoint == null) {
                throw new UnsupportedOperationException();
            } else {
                oldSavePoint.val = e;
            }

        }

        @Override
        public void add(T val) {
            if (savepoint == null) {
                if (head == null) {
                    head = new Node(val, null, null);
                    oldSavePoint = head;
                    savepoint = null; //for simplicity
                } else {//queue-nin sonu
                    Node newTail = new Node(val, oldSavePoint, null);//a.k.a new tail
                    if (tail == null) {
                        tail = newTail;
                        head.next = tail;
                    } else {
                        tail.next = newTail;//old tail
                        tail = newTail;
                    }
                }
            } else {
                Node previous = savepoint.previous;
                if (savepoint == head) {
                    Node oldHead = head;
                    Node newHead = new Node(val, null, head);
                    head = newHead;
                    oldHead.previous = head;
                    if (tail == null) {
                        tail = oldHead;
                    }
                } else if (savepoint == tail) {
                    Node newNode = new Node(val, previous, tail);
                    tail.previous = newNode;
                    previous.next = newNode;
                } else {//middle node
                    Node newNode = new Node(val, previous, savepoint);
                    previous.next = newNode;
                    savepoint.previous = newNode;
                }

            }
        }

    }

    @Override
    public ListIterator<T> listIterator() {
        return new MyListIterator(0);
    }

    private boolean removeNode(Node node) {
        //burada 3 case var:
        //node head,tail,ve middle olar biler
        Node previous = node.previous;
        Node next = node.next;
        if (head == null) {
            return false;
        }
        if (node == head) {
            if (next == null) {
                head = null;
            } else {
                next.previous = null;
                head = next;
            }
        } else if (node == tail) {
            if (previous == head) {
                tail = null;
            }
            previous.next = null;
        } else {
            previous.next = next;
            next.previous = previous;
        }
        return true;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return new MyListIterator(index);
    }

    //inclusive
    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return new CustomLinkedList<>(node(fromIndex), node(toIndex), toIndex - fromIndex + 1);
    }

    public String toString() {
        return stream()
                .map(Object::toString)
                .collect(Collectors.joining(",", "[", "]"));
    }
}
