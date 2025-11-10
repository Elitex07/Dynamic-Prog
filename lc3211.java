import java.util.ArrayList;
import java.util.List;

public class lc3211 {
        void helper(String str, int index, String curr, List<String> res) {
        if(index == str.length()) {
            if(!curr.contains("00")) res.add(curr);
            return;
        }
        
        String temp = curr + "0";
        if(!temp.contains("00")) helper(str, index + 1, curr + "0", res);
        helper(str, index + 1, curr + "1", res);
    }
    public List<String> validStrings(int n) {
        List<String> res = new ArrayList<>();

        int dec = (int) Math.pow(2, n) - 1;
        helper(Integer.toBinaryString(dec), 0, "", res);
        
        return res;
    }
}