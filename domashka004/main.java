import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class User {
    private String fullName;
    private int age;
    private String gender;

    public User(String fullName, int age, String gender) {
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getFormattedInfo() {
        String[] nameParts = fullName.split(" ");
        String formattedName = nameParts[1] + " " + nameParts[0].charAt(0) + ".";
        return formattedName + " " + age + " " + gender;
    }
}

public class UserManagement {
    private List<User> users;

    public UserManagement() {
        users = new ArrayList<>();
    }

    public void addUser(String fullName, int age, String gender) {
        User user = new User(fullName, age, gender);
        users.add(user);
    }

    public void printUsers() {
        for (User user : users) {
            System.out.println(user.getFormattedInfo());
        }
    }

    public void sortByAge() {
        Collections.sort(users, Comparator.comparingInt(User::getAge));
    }

    public void sortByAgeAndGender() {
        Collections.sort(users, Comparator.comparingInt(User::getAge).thenComparing(User::getGender));
    }

    public static void main(String[] args) {
        UserManagement userManagement = new UserManagement();
        userManagement.addUser("Иванов Иван", 25, "Мужской");
        userManagement.addUser("Сидорова Екатерина", 30, "Женский");
        userManagement.addUser("Петров Алексей", 20, "Мужской");

        System.out.println("Пользователи:");
        userManagement.printUsers();

        System.out.println("\nПользователи, отсортированные по возрасту:");
        userManagement.sortByAge();
        userManagement.printUsers();

        System.out.println("\nПользователи, отсортированные по возрасту и полу:");
        userManagement.sortByAgeAndGender();
        userManagement.printUsers();
    }
}
