import java.util.Random;

public class FirstJavaSeminar {

    public static void main(String[] args) {
        int i = new Random().nextInt(2001);
        int n = findHighestBit(i);
        int[] m1 = findMultiplesOfN(i, Short.MAX_VALUE, n);
        int[] m2 = findNonMultiplesOfN(Short.MIN_VALUE, i, n);

        System.out.println("Случайное число i: " + i);
        System.out.println("Номер старшего значащего бита числа i: " + n);
        System.out.println("Кратные n числа в диапазоне от i до Short.MAX_VALUE:");
        printArray(m1);
        System.out.println("Некратные n числа в диапазоне от Short.MIN_VALUE до i:");
        printArray(m2);
    }

    // Метод для нахождения номера старшего значащего бита числа
    public static int findHighestBit(int num) {
        int highestBit = 0;
        while (num > 0) {
            num >>= 1;
            highestBit++;
        }
        return highestBit;
    }

    // Метод для нахождения кратных n чисел в заданном диапазоне
    public static int[] findMultiplesOfN(int start, int end, int n) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (i % n == 0) {
                count++;
            }
        }

        int[] multiples = new int[count];
        int index = 0;
        for (int i = start; i <= end; i++) {
            if (i % n == 0) {
                multiples[index++] = i;
            }
        }

        return multiples;
    }

    // Метод для нахождения некратных n чисел в заданном диапазоне
    public static int[] findNonMultiplesOfN(int start, int end, int n) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (i % n != 0) {
                count++;
            }
        }

        int[] nonMultiples = new int[count];
        int index = 0;
        for (int i = start; i <= end; i++) {
            if (i % n != 0) {
                nonMultiples[index++] = i;
            }
        }

        return nonMultiples;
    }

    // Метод для печати массива
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
