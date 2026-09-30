/*74. Search a 2D Matrix
level:medium 
Runtime:0 ms ||Beats:100.00%
Memory:42.2 MB ||Beats:5.00%

problem:
Givem a 2D matrix and a target value, return true if the target is found in the matrix,
otherwise return false.

Approach:
We use Binary Search
Although the matrix is 2d, we can treat it like a sorted 1D array.
instead of actually converting the 2D matrix into a 1D array,we can use the row and column .
int row=mid/cols;
int col=mid.cols;

Ex:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false

Ex2:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
 */
//code:
class Search2DMatrix{
    public boolean search2Dmatrix(int[][] matrix,int target){
        int rows=matrix.length;
        int cols=matrix[0].length;

        int low=0;
        int high=rows*cols-1;

        while(low <= high){

            int mid=low+(high-low)/2;
        int row=mid/cols;
        int col=mid%cols;

        if(matrix[row][col]==target){
            return true;
        }else if(matrix[row][col] < target){
            low=mid+1;
        }else{
            high=mid-1;
        }
        }
        return false;
    }
    public static void main(String[] args){
        Search2DMatrix s= new Search2DMatrix();
        int[][] matrix={
            {1,3,5,7},
            {10,11,16,20},
            {23,30,34,60}
        };
        int target=3;
        boolean ans=s.search2Dmatrix(matrix, target);
        System.out.println(ans);
    }
}
/* Algorithm:
Algorithm
Find the number of rows.
Find the number of columns.
Set low = 0.
Set high = rows * cols - 1.
Calculate mid.
Convert mid into a 2D position.
Compare the matrix value with the target.
If equal → return true.
If matrix value is smaller → move low to the right.
Otherwise → move high to the left.
If the target is not found → return false.

#Time COmplexity:
0(Log(m*n))

#Space Complexity:
0(1)
 */
