import java.util.*;

class assignment3 {
    void helper(String digits, int index, String curr, List<String> res) {
        if(index == digits.length()) {
            res.add(curr);
            return;
        }

        String option = map(digits.charAt(index));
        for(char i : option.toCharArray()) {
            curr = curr.concat(String.valueOf(i));
            helper(digits, index + 1, curr, res);
            curr = curr.substring(0, curr.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        helper(digits, 0, "", res);

        return res;
    }
    private static String map(char c){
        switch(c){
            case '2': return "abc";
            case '3': return "def";
            case '4': return "ghi";
            case '5': return "jkl";
            case '6': return "mno";
            case '7': return "pqrs";
            case '8': return "tuv";
            case '9': return "wxyz";
        }
        return "";
    }
}