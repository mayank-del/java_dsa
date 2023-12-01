import java.util.Scanner;

public class BouncingBalls {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int M = scanner.nextInt();
        int N = scanner.nextInt();

        int[] p1 = { scanner.nextInt(), scanner.nextInt() };
        int[] dir_1 = { scanner.nextInt(), scanner.nextInt() };

        int[] p2 = { scanner.nextInt(), scanner.nextInt() };
        int[] dir_2 = { scanner.nextInt(), scanner.nextInt() };

        int steps = helper__function_f(M, N, p1, dir_1, p2, dir_2);
        System.out.println(steps);

        scanner.close();
    }

    static int helper__function_f(int M, int N, int[] p1, int[] dir_1, int[] p2, int[] dir_2) {
        for (int i = 0; i < 10000; i++) {
            p1[0] += dir_1[0];
            p1[1] += dir_1[1];

            p2[0] += dir_2[0];
            p2[1] += dir_2[1];

            if (p1[0] == p2[0] && p1[1] == p2[1]) {
                return i + 1;
            }

            if (p1[0] <= 0 || p1[0] >= M || p1[1] <= 0 || p1[1] >= N) {
                dir_1[0] = -dir_1[0];
                dir_1[1] = -dir_1[1];
            }

            if (p2[0] <= 0 || p2[0] >= M || p2[1] <= 0 || p2[1] >= N) {
                dir_2[0] = -dir_2[0];
                dir_2[1] = -dir_2[1];
            }
        }

        return -1; // If they never overlap
    }
}
