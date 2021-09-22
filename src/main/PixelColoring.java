package main;

public class PixelColoring {
    int[][] img = new int[][]{
            {1, 0, 0, 0, 1},
            {0, 0, 1, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 1, 0, 0},
            {1, 0, 1, 0, 1}
    };
    final int rowLen = 5;
    final int colLen = 5;


    public static void main(String[] args) {
        final int oldValue = 1;
        final int newValue = 5;
        final int row = 1;
        final int col = 2;

        PixelColoring pixelColoring = new PixelColoring();
        pixelColoring.applyColor(row, col, oldValue, newValue);
        pixelColoring.print();
    }

    private void applyColor(int row, int col, int oldValue, int newValue) {
        if(row < 0 || col < 0 || row >= rowLen || col >=colLen || img[row][col] != oldValue){
            return;
        }
        img[row][col] = newValue;
        applyColor(row-1, col, oldValue, newValue);
        applyColor(row-1, col-1, oldValue, newValue);
        applyColor(row-1, col+1, oldValue, newValue);
        applyColor(row, col-1, oldValue, newValue);
        applyColor(row, col+1, oldValue, newValue);
        applyColor(row+1, col, oldValue, newValue);
        applyColor(row+1, col-1, oldValue, newValue);
        applyColor(row+1, col+1, oldValue, newValue);
    }

    private void print() {
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                System.out.print(img[i][j] + " ");
            }
            System.out.println();
        }
    }

}
