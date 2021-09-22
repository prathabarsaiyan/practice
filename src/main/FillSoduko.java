package main;

/**
 * fill 9*9 soduko
 */
public class FillSoduko {
    static int[][] fillSoduko(int[][] grid){
        int n = grid.length;
        int value = 1;
        for(int i =0; i< n;){
            for(int j=0; j<n;j++){
                if(value> 9){
                    value = value%9;
                }
                grid[i][j] = value;
                value++;
            }
            i++;
            if(i%3 == 0){
                value = grid[i-3][0]+1;
            } else {
                value = grid[i-1][0]+3;
            }
        }
        return grid;
    }


    public static void main(String[] args) {
        int[][] grid = new int[9][9];
        fillSoduko(grid);
        for(int i =0; i< 9;i++){
            for(int j=0; j<9;j++){
                System.out.print("\t"+grid[i][j]);
            }
            System.out.println("");
        }
    }
}
