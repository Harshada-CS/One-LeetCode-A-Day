/*
 * 224.Valid Anagram
 * String, Sorting
 * Level: Easy
 * Approach: Sorting
 * Runtime: O(n log n)
 * Memory: O(n)
 *
 * Given two strings s and t, return true if t is an anagram of s, otherwise return false.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of another word, using all the original letters exactly once.
 *
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 *
 * Constraints:
 * 1 <= s.length, t.length <= 5 * 10^4
 * s and t consist of lowercase English letters.
 */
//Code:Brute Force
import java.util.*;
class ValidAnagram{
    public boolean isAnagram(String s,String t){
        if(s.length()!=t.length()){
            return false;
        }
        
        char[] a=s.toCharArray();
        char[] b=t.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a,b);
    }
    public static void main(String[] args){
        ValidAnagram V=new ValidAnagram();
        boolean result=V.isAnagram("listen","silent" );
        System.out.println(result);
    }
}
/*
 * The isAnagram() method checks whether two strings are anagrams using sorting.
 *
 * if(s.length() != t.length())
 *
 * - If the lengths of the two strings are different, they cannot be anagrams.
 * - Return false immediately.
 *
 * char[] a = s.toCharArray();
 * char[] b = t.toCharArray();
 *
 * - Convert both strings into character arrays.
 *
 * Arrays.sort(a);
 * Arrays.sort(b);
 *
 * - Sort both character arrays in ascending order.
 *
 * return Arrays.equals(a, b);
 * - Compare both sorted arrays.
 *
 * - If they are exactly equal, return true.
 *
 * - Otherwise, return false. 
 * 
 * Time Complexity:
 * 0(n log n)
 * 
 * SPace Complexity:
 * 0(n)
 * */

//Code:Optimal Approach
class ValidAnagram{
    public boolean isAnagram(String s,String t){
        if(s.length()!=t.length()){
            return false;
        }
        int[] count=new int[26];

        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }
        for(int num:count){
            if(num!=0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        ValidAnagram V=new ValidAnagram();
        boolean result=V.isAnagram("listen","silent");
        System.out.println(result);
    }
}
/*
 * The isAnagram() method checks whether two strings are anagrams using a frequency array.
 *
 * if(s.length() != t.length())
 *
 * - If the lengths of both strings are different, they cannot be anagrams.
 * - Return false immediately.
 *
 * int[] count = new int[26];
 * - Create an integer array of size 26.
 * - Each index represents one lowercase English letter.
 *
 * Index 0 -> 'a'
 * Index 1 -> 'b'
 * ...
 * Index 25 -> 'z'
 *
 * for(int i = 0; i < s.length(); i++)
 * - Traverse both strings together.
 *
 * count[s.charAt(i) - 'a']++;
 * - Increase the frequency of the current character from string s.
 *
 * count[t.charAt(i) - 'a']--;
 * - Decrease the frequency of the current character from string t.
 *
 * If both strings contain exactly the same characters with the same frequency, every value in the count array will
 * become zero.
 *
 * for(int num : count)
 * - Traverse the frequency array.
 *
 * if(num != 0)
 * - If any frequency is not zero, the strings are not anagrams.
 * - Return false.
 *
 * If every value is zero,
 * return true.
 *
 * Time Complexity:
 * 0(n)
 * 
 * Space Complexity:
 * 0(n)
 .*/