import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(8);
        numbers.add(5);
        numbers.add(2);
        numbers.add(7);
        numbers.add(1);
        numbers.add(6);
        numbers.add(4);

        // Удаление чётных чисел
        numbers.removeIf(n -> n % 2 == 0);
        System.out.println("Список после удаления чётных чисел: " + numbers);

        // Поиск минимального значения
        int min = numbers.stream().min(Integer::compareTo).orElse(0);
        System.out.println("Минимальное значение: " + min);

        // Поиск максимального значения
        int max = numbers.stream().max(Integer::compareTo).orElse(0);
        System.out.println("Максимальное значение: " + max);

        // Вычисление среднего значения
        double average = numbers.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        System.out.println("Среднее значение: " + average);
    }
}
