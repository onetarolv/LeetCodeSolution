package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by engry on 2017/9/20.
 * 438 Find All Anagrams in a String
 */
public class JavaFindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        int i = 0;
        ArrayList<Character> str = new ArrayList<Character>();
        for(int j = 0; j < p.length(); j++){
            str.add(p.charAt(j));
        }
        // a b c d 3         1 1+3-1 3-1
        //   b c d 3 -3 +1
        ArrayList<Character> tmp = str;
        ArrayList<Integer> res = new ArrayList<Integer>();
        while(i < s.length()){
            if(p.contains(String.valueOf(s.charAt(i)))){
                String anagram = s.substring(i, i+p.length() -1);
                if(anagram.hashCode() == p.hashCode()){
                    for(int j = 0; j < p.length(); j++){
                        str.add(p.charAt(j));
                    }

                }
                tmp.remove(new Character(s.charAt(i)));
                if(tmp.isEmpty()){
                    res.add(i - p.length() + 1);
                    tmp = str;
                }
            }
                i ++;
        }
        return res;
    }

    // solutions by other coder
    public List<Integer> findAnagrams_1(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
        int[] hash = new int[256]; //character hash
        //record each character in p to hash
        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        //two points, initialize count to p's length; first p.length: left is in;
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            //move right everytime, if the character exists in p's hash, decrease the count
            //current hash value >= 1 means the character is existing in p
            if (hash[s.charAt(right++)]-- >= 1) count--;

            //when the count is down to 0, means we found the right anagram
            //then add window's left to result list
            if (count == 0) list.add(left);

            //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            //++ to reset the hash because we kicked out the left
            //only increase the count if the character is in p
            //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
        }
        return list;
    }
}

class JavaFindALLANagramsTest {
    public static void main(String args[]){
        ArrayList<Character> str = new ArrayList<Character>();
        str.add('a');
        str.add('b');
        str.add('a');
        ArrayList<Character> tmp = str;
        StringBuffer buffer = new StringBuffer("aba");
        tmp.remove(new Character('a'));
        for(int i = 0; i< str.size();i ++){
            System.out.println(str.get(i));
        }
    }
}
