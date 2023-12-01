import java.util.Scanner;

public class CodeVita1 {
    static int counter_a = 0, counter_b = 0;

    static void bubble_in_desc(int[] array, int length) {
        for (int step = 0; step < length - 1; ++step) {
            for (int i = 0; i < length - step - 1; ++i) {
                if (array[i] < array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    counter_a++;
                }
            }
        }
    }

    static void bubble_in_Asc(int[] array, int length) {
        for (int step = 0; step < length - 1; ++step) {
            for (int i = 0; i < length - step - 1; ++i) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    counter_b++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inp_size = scanner.nextInt();
        int[] array1 = new int[inp_size];
        int[] array2 = new int[inp_size];

        for (int i = 0; i < inp_size; i++) {
            array1[i] = scanner.nextInt();
            array2[i] = array1[i];
        }

        bubble_in_desc(array1, inp_size);
        bubble_in_Asc(array2, inp_size);

        if (counter_a > counter_b)
            System.out.println(counter_b);
        else
            System.out.println(counter_a);

        scanner.close();
    }
}
