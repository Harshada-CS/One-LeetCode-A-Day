/*49. Group Anagrams

Array / 
String /
HashMap | Medium

Runtime: May vary
Memory: May vary

Problem:
Given an array of strings strs, group the anagrams together.
You can return the answer in any order.
Two strings are anagrams if they contain the same characters with the same frequencies, but in a different order.

Example 1
Input:
strs = ["eat","tea","tan","ate","nat","bat"]
Output:
[["bat"],["nat","tan"],["eat","tea","ate"]]

Explanation:

"eat", "tea" and "ate" are anagrams.
"tan" and "nat" are anagrams.
"bat" has no other anagram.

Example 2
Input:strs = [""]
Output:
[[""]]

Example 3
Input:strs = ["a"]
Output:[["a"]]

Constraints
1 <= strs.length <= 10^4
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters. */
import java.util.*;

class GroupAnagrams {

    public List<List<String>> GroupAnagram(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            String key = new String(chars);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

        GroupAnagrams G = new GroupAnagrams();

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> ans = G.GroupAnagram(strs);

        System.out.println(ans);
    }
}
/*Explanation

The GroupAnagram() method groups all anagrams together using a HashMap.
1. Create a HashMap
HashMap<String, List<String>> map = new HashMap<>();

The HashMap stores:
Sorted String → List of Anagrams

2. Traverse Every String
for (String str : strs)
We process every string one by one.

3. Convert String to Character Array
char[] chars = str.toCharArray();

Arrays.sort(chars);

All anagrams produce the same sorted string.
Therefore, the sorted string can be used as the key.

5. Create the Key
String key = new String(chars);

6. Add a New List if Key Doesn't Exist
if (!map.containsKey(key)) {
    map.put(key, new ArrayList<>());
}
If the key is not present in the HashMap, create a new ArrayList.

7. Add the Original String
map.get(key).add(str);
The original string is added to the list associated with its sorted key.

8. Return All Groups
return new ArrayList<>(map.values());

map.values() contains all the grouped anagrams. 

Time COmplexity:
0(n*k log k)

Space COmplexity:
0(n*k)
*/