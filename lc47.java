/*
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class lc47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums); // Sort
        
        backtrack(nums, res, new ArrayList<>(), visited);
        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> curr, boolean[] visited) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }

            visited[i] = true;
            curr.add(nums[i]); 

            backtrack(nums, res, curr, visited);

            curr.remove(curr.size() - 1);
            visited[i] = false;
        }
    }
}