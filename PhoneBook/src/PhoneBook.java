import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        Map<String, List<String>> phoneBook = new HashMap<>();

        addContact(phoneBook, "Иванов", "123-456-789");
        addContact(phoneBook, "Петров", "987-654-321");
        addContact(phoneBook, "Иванов", "111-222-333");
        addContact(phoneBook, "Сидоров", "555-666-777");
        addContact(phoneBook, "Иванов", "999-888-777");
        addContact(phoneBook, "Григорьев", "111-222-333");
        addContact(phoneBook, "Петров", "111-232-333");

        printPhoneBook(phoneBook);
    }

    private static void addContact(Map<String, List<String>> phoneBook, String name, String phoneNumber) {
        phoneBook.computeIfAbsent(name, k -> new ArrayList<>()).add(phoneNumber);
    }

    private static void printPhoneBook(Map<String, List<String>> phoneBook) {

        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(phoneBook.entrySet());

        entries.sort(Comparator.comparingInt(entry -> entry.getValue().size()));

        for (int i = entries.size() - 1; i >= 0; i--) {
            Map.Entry<String, List<String>> entry = entries.get(i);
            String name = entry.getKey();
            List<String> phoneNumbers = entry.getValue();

            System.out.println(name + ": " + phoneNumbers);
        }
    }
}
