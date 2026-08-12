/*
5. Longest Palindromic Substring

String | Medium
Runtime: 14ms|Beats |89.76%
Memory:43.34MB|Beats|89.43%

Problem
Given a string s, return the longest palindromic substring in s.
A palindrome is a string that reads the same forward and backward.

Example 1
Input:s = "babad"
Output:
"bab"
Explanation:"aba" is also a valid answer.

Example 2
Input:s = "cbbd"
Output:
"bb"

Constraints
1 <= s.length <= 1000
s consists of only English letters and digits./* */
*/
class LongestPalidrone{
    public String LongestPalindrone(String s){
        if(s.length()  < 2){
            return s;
        }

        int start=0;
        int maxlength=1;

        for(int i=0;i<s.length();i++){
            int len1=expand(s,i,i);

            int len2=expand(s,i,i+1);

            int len=Math.max(len1,len2);

            if(len > maxlength){
                maxlength=len;
                start=i-(len-1)/2;
            }
        }
        return s.substring(start,start+maxlength);
    }
    private int expand(String s,int left,int right){
        while(left >=0 &&
            right<s.length() &&
            s.charAt(left)==s.charAt(right)){
            left--;
            right++;
            }
        return right-left-1;
    }
    public static void main(String[] args){
        LongestPalidrone L=new LongestPalidrone();
        String s="babad";
        String ans=L.LongestPalindrone(s);
        System.out.println(ans);
    }
}
/*
Explanation:

The longestPalindrome() method finds the longest palindromic substring using the Expand Around Center approach.
The main idea is to consider every character as a possible center of a palindrome.

There are two types of palindromes:
Odd length:
aba
 ↑
Center = b

Even length:
abba
 ↑↑
Center = between b and b
1. Check Small Strings
if (s.length() < 2) {
    return s;
}

If the string has only one character, it is already a palindrome.
Example:
"a" → "a"

2. Initialize Variables
int start = 0;
int maxLength = 1;
start stores the starting index of the longest palindrome,maxLength stores the length of the longest palindrome found so far.

3. Traverse Every Character
for (int i = 0; i < s.length(); i++)
Each character is considered as a possible center of a palindrome.

4. Check Odd Length Palindrome
int len1 = expand(s, i, i);
Here, both left and right start at the same index.

Example:
b a b
  ↑
Center = a

This checks palindromes such as:"aba","bab","racecar"

5. Check Even Length Palindrome
int len2 = expand(s, i, i + 1);
Here, the center is between two characters.
Example:
a b b a
  ↑ ↑
Center between b and b

This checks palindromes such as:"bb","abba","noon"

6. Find the Maximum Length
int len = Math.max(len1, len2);
Choose the longer palindrome between the odd-length and even-length results.

7. Update Starting Position
if (len > maxLength) {
    maxLength = len;
    start = i - (len - 1) / 2;
}
If a longer palindrome is found,Update maxLength.
Calculate its starting index using:
i - (len - 1) / 2

8. Expand Around Center
while (left >= 0 &&
       right < s.length() &&
       s.charAt(left) == s.charAt(right))

The method keeps expanding outward while,left is inside the string,right is inside the string,Characters at left and right are equal.

Example:
b a b a d
  ↑
  Center

Expand:
a == a
b == b
When the characters are different or the boundary is reached, expansion stops.

9. Return Palindrome Length
return right - left - 1;
Because the loop moves left and right one position beyond the valid palindrome, we use:

right - left - 1
to calculate the actual palindrome length.

10. Return the Answer
return s.substring(start, start + maxLength);
This extracts the longest palindromic substring from the original string.

TIme complexity:
0(n^2)

Space Complexity
0(1)
*/