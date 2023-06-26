import java.util.ArrayList;
import java.util.List;

public class MyHashSet {
    private List<Integer> elements;

    public MyHashSet() {
        elements = new ArrayList<>();
    }

    public void add(int element) {
        if (!contains(element)) {
            elements.add(element);
        }
    }

    public boolean contains(int element) {
        return elements.contains(element);
    }

    public int size() {
        return elements.size();
    }

    public void remove(int element) {
        elements.remove(Integer.valueOf(element));
    }

    public String toString() {
        return elements.toString();
    }

    public Integer get(int index) {
        if (index >= 0 && index < size()) {
            return elements.get(index);
        }
        return null;
    }

    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();
        set.add(5);
        set.add(3);
        set.add(8);
        set.add(3); // duplicate, should not be added

        System.out.println("HashSet: " + set);
        System.out.println("Size: " + set.size());
        System.out.println("Element at index 1: " + set.get(1));
    }
}
