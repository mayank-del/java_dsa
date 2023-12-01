import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int f1(int n, int m, List<Pair> dealer1, List<Pair> x) {
        Collections.sort(dealer1, Collections.reverseOrder());
        Collections.sort(x, Collections.reverseOrder());

        int b = 0;
        int i = 0;

        for (Pair c : dealer1) {
            while (i < m && x.get(i).second > c.second) {
                i++;
            }

            if (i < m && x.get(i).first >= c.first) {
                b++;
                i++;
            }
        }

        return b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<Pair> dealer1 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int first = scanner.nextInt();
            int second = scanner.nextInt();
            dealer1.add(new Pair(first, second));
        }

        List<Pair> x = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int first = scanner.nextInt();
            int second = scanner.nextInt();
            x.add(new Pair(first, second));
        }

        int ans = f1(n, m, dealer1, x);
        System.out.println(ans);

        scanner.close();
    }

    static class Pair implements Comparable<Pair> {
        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.first, o.first);
        }
    }
}
