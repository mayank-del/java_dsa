import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Cell {
    int row, col, dist;

    public Cell(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

public class MazeRunner {
    static final int MAX_SIZE = 15;

    static boolean isValid(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    static int mazeRunner(int[][] maze, int rows, int cols, Cell start, Cell target) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited = new boolean[MAX_SIZE][MAX_SIZE];

        Queue<Cell> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.row][start.col] = true;

        while (!queue.isEmpty()) {
            Cell current = queue.poll();

            if (current.row == target.row && current.col == target.col) {
                return current.dist;
            }

            for (int i = 0; i < 4; ++i) {
                int newRow = current.row + directions[i][0];
                int newCol = current.col + directions[i][1];

                if (isValid(newRow, newCol, rows, cols) && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;

                    if (maze[newRow][newCol] == 0 || maze[newRow][newCol] == 2) {
                        Cell next = new Cell(newRow, newCol, current.dist + 1);
                        queue.offer(next);
                    } else if (maze[newRow][newCol] == 3) {
                        continue; // Skip dangerous path
                    } else if (newRow == target.row && newCol == target.col) {
                        Cell next = new Cell(newRow, newCol, current.dist + 1);
                        queue.offer(next);
                    }
                }
            }
        }

        return -1; // STUCK
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        int[][] maze = new int[MAX_SIZE][MAX_SIZE];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                maze[i][j] = scanner.nextInt();
            }
        }

        Cell start = new Cell(scanner.nextInt(), scanner.nextInt(), 0);
        Cell target = new Cell(scanner.nextInt(), scanner.nextInt(), 0);

        int result = mazeRunner(maze, rows, cols, start, target);
        System.out.println(result);

        scanner.close();
    }
}
