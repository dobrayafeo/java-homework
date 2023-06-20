import java.util.*;

public class PhoneBook {
    private HashMap<String, List<String>> contacts;

    public PhoneBook() {
        contacts = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        List<String> phoneNumbers = contacts.get(name);
        if (phoneNumbers == null) {
            phoneNumbers = new ArrayList<>();
            contacts.put(name, phoneNumbers);
        }
        phoneNumbers.add(phoneNumber);
    }

    public void printPhoneBook() {
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(contacts.entrySet());

        Collections.sort(entries, new Comparator<Map.Entry<String, List<String>>>() {
            public int compare(Map.Entry<String, List<String>> entry1, Map.Entry<String, List<String>> entry2) {
                return entry2.getValue().size() - entry1.getValue().size();
            }
        });

        for (Map.Entry<String, List<String>> entry : entries) {
            String name = entry.getKey();
            List<String> phoneNumbers = entry.getValue();
            System.out.println("Имя: " + name);
            System.out.println("Телефоны: " + phoneNumbers);
            System.out.println("--------------------");
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.addContact("Иванов", "123456789");
        phoneBook.addContact("Петров", "987654321");
        phoneBook.addContact("Сидоров", "555555555");
        phoneBook.addContact("Иванов", "111111111");
        phoneBook.addContact("Петров", "222222222");

        System.out.println("Телефонная книга:");
        phoneBook.printPhoneBook();
    }
}

