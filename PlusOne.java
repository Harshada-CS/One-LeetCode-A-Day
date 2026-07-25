/*
 * 66.Plus One

 * Array
 * Level: Easy
 * Runtime: 0 ms | Beats: 100% (May vary)
 * Memory: 42 MB | Beats: 79.87%(May vary)
 *
 * You are given a large integer represented as an integer array digits,where each digits[i] is the ith digit of the integer.
 *
 * The digits are ordered from most significant to least significant in left-to-right order.
 *
 * Increment the large integer by one and return the resulting array.
 *
 * Example 1:
 *
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 *
 * Explanation:
 * The array represents the integer 123,Incrementing by one gives 124.
 *
 * Example 2:
 *
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 *
 * Explanation:
 * The array represents the integer 4321. Incrementing by one gives 4322.
 *
 * Example 3:
 *
 * Input: digits = [9]
 * Output: [1,0]
 *
 * Explanation:
 * The array represents the integer 9,Incrementing by one gives 10.
 *
 * Constraints:
 *
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * digits does not contain leading zeros.
 */

import java.util.Arrays;
class PlusOne{
    public int[] PlusOne(int[] digits){

        for(int i=digits.length-1;i>=0;i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }

            digits[i]=0;
        }

        int[] result=new int[digits.length+1];
        result[0]=1;
        return result;
    }
    public static void main(String[] args){
        PlusOne p=new PlusOne();
        int[] digits={1,2,3};

        int[] ans=p.PlusOne(digits);
        System.out.println(Arrays.toString(ans));
    }
}
// EXPLANATION

/*
 * The PlusOne() method increments the number represented by the array by one.
 *
 * The solution starts checking from the last digit,
 * because adding one always affects the least significant digit first.
 *
 * for(int i = digits.length - 1; i >= 0; i--)
 * - Traverse the array from right to left.
 *
 * if(digits[i] < 9)
 * - If the current digit is less than 9, simply increase it by one.
 *
 * digits[i]++;
 * - Return the updated array immediately because no carry is generated.
 *
 * digits[i] = 0;
 * - If the current digit is 9, adding one produces a carry.
 * 
 * int[] result = new int[digits.length + 1];
 * - Create a new array with one extra position.
 *
 * result[0] = 1;
 * - Place 1 at the beginning.
 *
 * Remaining elements are already 0.
 * 
 * TIme Complexity:
 * 0(n)
 * 
 * Space Complexity
 * 0(1)
 * 
 * */