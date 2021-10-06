package main.pratha;
// /* Problem Name is &&& Optimal Path &&& PLEASE DO NOT REMOVE THIS LINE. */
// //  Personal Meeting ID : 9060553195
// //  Meeting Password : 850868

// //Please start the meeting. Its started

// /*
// ** Instructions to candidate.
// **  1) You are an avid rock collector who lives in southern California. Some rare
// **     and desirable rocks just became available in New York, so you are planning
// **     a cross-country road trip. There are several other rare rocks that you could
// **     pick up along the way.
// **
// **     You have been given a grid filled with numbers, representing the number of
// **     rare rocks available in various cities across the country.  Your objective
// **     is to find the optimal path from So_Cal to New_York that would allow you to
// **     accumulate the most rocks along the way.
// **
// **     Note: You can only travel either north (up) or east (right).
// **  2) Consider adding some additional tests in doTestsPass().
// **  3) Implement optimalPath() correctly.
// **  4) Here is an example:
// **                                                           ^
// **                 {{0,0,0,0,5}, New_York (finish)           N
// **                  {0,1,1,1,0},                         < W   E >
// **   So_Cal (start) {2,0,0,0,0}}                             S
// **                                                           v
// **   The total for this example would be 10 (2+0+1+1+1+0+5).
// */

 class OptimalPathProblem
 {
   /*
   **  Find the optimal path.
   */
   public static Integer optimalPath(Integer[][] grid)
   {
     int m = grid.length;
     int n = grid[0].length;

     int[][] maxGrid = new int[m][n];
     int max = 0;
     max = findOptimalPath(grid, max, m-1, 0,  n,maxGrid);
     return max;
   }


   static int findOptimalPath(Integer[][] grid,
                          int max, int i , int j, int n,int[][] maxGrid) {
     if(j >= n || i < 0){
       return max;
     }

     max +=  grid[i][j];

     maxGrid[i][j] = Math.max(findOptimalPath(grid,max, i-1, j, n,maxGrid),
           findOptimalPath(grid, max, i, j+1, n,maxGrid));

     return maxGrid[i][j];
   }


   /*
   **  Returns true if the tests pass. Otherwise, returns false;
   */
   public static boolean doTestsPass()
   {
       boolean result = true;
       // Base test case
       result &= optimalPath(new Integer[][]{{0,0,0,0,5},
                           {0,1,1,1,0},
                           {2,0,0,0,0}}) == 10;
       return result;
   }

   /*
   **  Execution entry point.
   */
   public static void main(String[] args)
   {
       if(doTestsPass())
       {
         System.out.println("All tests pass");
       }
       else
       {
         System.out.println("Tests fail.");
       }
   }
 }





