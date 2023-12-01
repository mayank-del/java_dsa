import java.util.Scanner;

public class CodeVita2 {
    static int f(String row_parameter) {
        int cnt_m = 0;
        int cnt_l = 0;
        int i = 0;

        while (i < row_parameter.length()) {
            if (row_parameter.charAt(i) == 'M') {
                cnt_m++;
                while (i < row_parameter.length() && row_parameter.charAt(i) == 'M') {
                    i++;
                }
            } else if (row_parameter.charAt(i) == 'L') {
                cnt_l++;
                while (i < row_parameter.length() && row_parameter.charAt(i) == 'L') {
                    i++;
                }
            } else {
                return -1;
            }
        }

        int sm = (cnt_m * (cnt_m - 1) * (cnt_m - 2)) / 6;
        int sl = (cnt_l * (cnt_l - 1) * (cnt_l - 2)) / 6;

        return sm + sl;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String r1 = scanner.nextLine().trim();
        String r2 = scanner.nextLine().trim();

        if (r1.matches(".*[^ML].*") || r2.matches(".*[^ML].*")) {
            System.out.println("Invalid input");
            return;
        }

        int cr1 = f(r1);
        int cr2 = f(r2);

        if (cr1 == -1 || cr2 == -1) {
            System.out.println("Invalid input");
        } else if (cr1 > cr2) {
            System.out.println((r1.chars().filter(c -> c == 'M' || c == 'L').count() > 0) ? "Ashok" : "Draw");
        } else if (cr2 > cr1) {
            System.out.println((r2.chars().filter(c -> c == 'M' || c == 'L').count() > 0) ? "Anand" : "Draw");
        } else {
            System.out.println("Draw");
        }

        scanner.close();
    }
}
