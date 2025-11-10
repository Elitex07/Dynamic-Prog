import java.util.*;

class Solution {
    private HashMap<String, Boolean> memo;
    private int[] stones;
    
    public boolean canCross(int[] stones) {
        if (stones[1] != 1) {
            return false;
        }
        
        this.stones = stones;
        this.memo = new HashMap<>();
        return helper(0, 0);
    }
    
    private boolean helper(int pos, int k) {
        String key = pos + "," + k;
        
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        for (int i = pos + 1; i < stones.length; i++) {
            int gap = stones[i] - stones[pos];
            
            if (gap >= k - 1 && gap <= k + 1) {
                if (pos == 0 && gap != 1) {
                    continue;
                }
                
                if (helper(i, gap)) {
                    memo.put(key, true);
                    return true;
                }
            } else if (gap > k + 1) {
                break;
            }
        }
        
        if (pos == stones.length - 1) {
            memo.put(key, true);
            return true;
        }
        
        memo.put(key, false);
        return false;
    }
}