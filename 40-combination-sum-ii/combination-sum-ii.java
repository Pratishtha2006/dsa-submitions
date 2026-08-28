class Solution {

    List<List<Integer>> ans = new ArrayList<>();
    Map<List<Integer>, Integer> map = new HashMap<>();

    void fun(int sum, List<Integer> nums, List<Integer> tmp, int target) {

        if (sum > target)
            return;

        if (sum == target) {
            if (!map.containsKey(tmp)) {
                ans.add(new ArrayList<>(tmp));
                map.put(new ArrayList<>(tmp), 1);
            }
            return;
        }

        for (int i = 0; i < nums.size(); i++) {

            if (i > 0 && nums.get(i).equals(nums.get(i - 1)))
                continue;

            List<Integer> ip = new ArrayList<>(nums);

            for (int j = 0; j <= i; j++)
                ip.remove(0);

            tmp.add(nums.get(i));

            fun(sum + nums.get(i), ip, tmp, target);

            tmp.remove(tmp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] nums, int target) {

        Arrays.sort(nums);

        List<Integer> list = new ArrayList<>();

        for (int x : nums)
            list.add(x);

        fun(0, list, new ArrayList<>(), target);

        return ans;
    }
}