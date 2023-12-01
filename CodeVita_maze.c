#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

#define MAX_SIZE 15

typedef struct {
    int row, col, dist;
} Cell;

bool is_valid(int row, int col, int rows, int cols) {
    return row >= 0 && row < rows && col >= 0 && col < cols;
}

int maze_runner(int maze[MAX_SIZE][MAX_SIZE], int rows, int cols, Cell start, Cell target) {
    int directions[4][2] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    bool visited[MAX_SIZE][MAX_SIZE];
    memset(visited, false, sizeof(visited));

    Cell queue[MAX_SIZE * MAX_SIZE];
    int front = 0, rear = 0;
    queue[rear++] = start;
    visited[start.row][start.col] = true;

    while (front != rear) {
        Cell current = queue[front++];
        
        if (current.row == target.row && current.col == target.col) {
            return current.dist;
        }

        for (int i = 0; i < 4; ++i) {
            int new_row = current.row + directions[i][0];
            int new_col = current.col + directions[i][1];

            if (is_valid(new_row, new_col, rows, cols) && !visited[new_row][new_col]) {
                visited[new_row][new_col] = true;

                if (maze[new_row][new_col] == 0 || maze[new_row][new_col] == 2) {
                    Cell next = {new_row, new_col, current.dist + 1};
                    queue[rear++] = next;
                } else if (maze[new_row][new_col] == 3) {
                    continue; // Skip dangerous path
                } else if (new_row == target.row && new_col == target.col) {
                    Cell next = {new_row, new_col, current.dist + 1};
                    queue[rear++] = next;
                }
            }
        }
    }

    return -1; // STUCK
}

int main() {
    int rows, cols;
    scanf("%d %d", &rows, &cols);

    int maze[MAX_SIZE][MAX_SIZE];
    for (int i = 0; i < rows; ++i) {
        for (int j = 0; j < cols; ++j) {
            scanf("%d", &maze[i][j]);
        }
    }

    Cell start, target;
    scanf("%d %d", &start.row, &start.col);
    scanf("%d %d", &target.row, &target.col);

    int result = maze_runner(maze, rows, cols, start, target);
    printf("%d\n", result);

    return 0;
}