package igrulka;

public class GameBoard {
    private char[][] board;
    private boolean[][] occupied;
    private int size;

    public GameBoard(int size) {
        this.size = size;
        this.board = new char[size][size];
        this.occupied = new boolean[size][size];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = ' ';
                occupied[i][j] = false;
            }
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isCellOccupied(int row, int col) {
        return occupied[row][col];
    }

    public void placeMark(int row, int col, char playerSymbol) {
        board[row][col] = playerSymbol;
        occupied[row][col] = true;
    }

    public boolean checkWin(int row, int col, char playerSymbol) {
        if (checkLine(row, 0, 0, 1, playerSymbol)) return true;
        if (checkLine(0, col, 1, 0, playerSymbol)) return true;
        if (row == col && checkLine(0, 0, 1, 1, playerSymbol)) return true;
        if (row + col == size - 1 && checkLine(0, size - 1, 1, -1, playerSymbol)) return true;

        return false;
    }

    private boolean checkLine(int startRow, int startCol, int deltaRow, int deltaCol, char playerSymbol) {
        for (int i = 0; i < size; i++) {
            int r = startRow + i * deltaRow;
            int c = startCol + i * deltaCol;
            if (r < 0 || r >= size || c < 0 || c >= size || board[r][c] != playerSymbol) {
                return false;
            }
        }
        return true;
    }

    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!occupied[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void printBoard() {
        System.out.println();
        System.out.print("  ");
        for (int j = 0; j < size; j++) {
            System.out.print(" " + (j + 1) + "    ");
        }
        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < size; j++) {
                System.out.print("| " + board[i][j] + " ");
            }
            System.out.println("|");
            if (i < size - 1) {
                System.out.print("  ");
                for (int j = 0; j < size; j++) {
                    System.out.print("----");
                }
                System.out.println("-");
            }
        }
    }
}