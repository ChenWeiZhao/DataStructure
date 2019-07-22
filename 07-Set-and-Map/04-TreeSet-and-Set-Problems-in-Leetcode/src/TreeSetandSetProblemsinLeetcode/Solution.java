package TreeSetandSetProblemsinLeetcode;// Leetcode 804. Unique Morse Code Words
// https://leetcode.com/problems/unique-morse-code-words/description/
//使用集合，不会重复计算
import java.util.TreeSet;

public class Solution {

    public int uniqueMorseRepresentations(String[] words) {

        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        TreeSet<String> set = new TreeSet<>();
        for(String word: words){
            StringBuilder res = new StringBuilder();
            for(int i = 0 ; i < word.length() ; i ++) {
                //'a'充当偏移，'a'-'a' = 0 ； 'b' - 'a' = 1
                res.append(codes[word.charAt(i) - 'a']);
            }
            set.add(res.toString());
        }

        return set.size();
    }
}
