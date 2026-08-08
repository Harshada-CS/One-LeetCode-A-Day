/*
 * 14.Longest Common Prefix
 * Array, String
 * Level: Easy
 * Approach: Horizontal Scanning
 * Time Complexity: O(S)
 * Space Complexity: O(1)
 *
 * Given an array of strings strs, find the longest common prefix string amongst all the strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 *
 * Explanation:
 * There is no common prefix among the input strings.
 *
 * Constraints:
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters.
 */

class LongestPrefix {
    public String LongestStringPrefix(String[] strs){
        String prefix=strs[0];

        for(int i=1;i<strs.length;i++){
            while(!strs[i].startsWith(prefix)){
                prefix=prefix.substring(0,prefix.length()-1);

                if(prefix.length()==0){
                    return "";
                }
            }
        }
        return prefix;
    }
    public static void main(String[] args){
        LongestPrefix L=new LongestPrefix();
        String[] strs={"flower","flow","flight"};
        String ans=L.LongestStringPrefix(strs);
        System.out.println(ans);
    }
    
}
/*
 *Explanation:
 * String prefix = strs[0];
 * - Initially assume that the first string is the common prefix.
 *
 * Example:
 *
 * ["flower", "flow", "flight"]
 * prefix = "flower"
 *
 * for(int i = 1; i < strs.length; i++)
 * - Compare the current prefix with every remaining string.
 *
 * while(!strs[i].startsWith(prefix))
 *
 * - Check whether the current string starts with the prefix.
 * - If it does not, reduce the prefix.
 *
 * Example:
 *
 * prefix = "flower"
 * current string = "flow"
 *
 * "flow".startsWith("flower")
 *
 * false
 *
 * prefix = prefix.substring(0, prefix.length() - 1);
 * - Remove the last character from prefix.
 *
 * "flower"
 * ↓
 * "flowe"
 * ↓
 * "flow"
 *
 * Now:
 * "flow".startsWith("flow")
 * true
 * So prefix becomes "flow".
 *
 * Next string:
 * "flight"
 * Current prefix:
 * "flow"
 * "flight".startsWith("flow"
 * false
 * Reduce:
 *
 * "flow" → "flo"
 * "flo"  → "fl"
 *
 * Now:
 *
 * "flight".startsWith("fl")
 * true
 * Therefore:
 * prefix = "fl"
 *
 * Return prefix.
 * Final Answer:
 *
 * "fl"
 *
 * Time Complexity:
 *O(S)
 *
 * Space Complexity:
 * 0(1)
 */
