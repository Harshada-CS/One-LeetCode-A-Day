/*739.Daily Temperatures
level:medium
Runtime:63ms || Beats:44.71%
Memory:107.49MB || Beats:47.36%

Problem :
Given an array of daily temperatures, return an array where:

1.answer[i] tells us how many days we have to wait after day i to get a warmer temperature.
2.If there is no future day with a warmer temperature, answer[i] = 0.

Example
Input:
[73, 74, 75, 71, 69, 72, 76, 73]
Output:
[1, 1, 4, 2, 1, 1, 0, 0]

Approach:
1.Create a stack to keep track of the indices of the temperatures.
2.Iterate through the temperatures array.
3.for each temperature,check if the current temperature is greater than the temperature at the index stored at the top of the stack.
4.If it is,pop the index from the stack and calculate the number of days to wait for a warmer temperature.
5.if the current temperature is not greater,push the current index onto the stack.
6.Continue the process until all temperature have been processed.
7.the stack will contain the indices of the temperatures for which there is no warmer temperature in the future,and the corresponding values in the answer array will be 0.
8.finally return the answer array.
*/

import java.util.*;
public class DailyTemperature {
    public int[] dailyTemperatures(int[] temperatures){
        int n=temperatures.length;
        int[] answer=new int[n];

        Stack<Integer> stack=new Stack<>();

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                int index=stack.pop();
                answer[index]=i-index;
            }
            stack.push(i);
        }
        return answer;
    }
    public static void main(String[] args){
        DailyTemperature D=new DailyTemperature();
        int[] temperatures={73,74,75,71,69,72,76,73};
        int[] answer=D.dailyTemperatures(temperatures);
        for(int i=0;i<temperatures.length;i++){
            System.out.print(temperatures[i]+" ");
        }
        System.out.println();
        for(int i=0;i<answer.length;i++){
            System.out.print(answer[i]+" ");
        }
        System.out.println();
    }
}
/*
time Complexity:0(n)
Space Compexity:0(n)
 */
