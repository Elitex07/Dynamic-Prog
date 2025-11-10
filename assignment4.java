import java.util.ArrayList;
import java.util.List;

public class assignment4 {
        void helper(int ind, List<Integer> curr, int k, int n, List<List<Integer>> res) {
        if(curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }

        int t = ind;
        while(t <= n) {
            curr.add(t);
            helper(t + 1, curr, k, n, res);
            curr.remove(curr.size() - 1);
            t++;
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(1, new ArrayList<>(), k, n, res);

        return res;
    }
}
