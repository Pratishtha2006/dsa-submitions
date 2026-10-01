class Solution {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int count = 0;

        // Sum 0 exists before starting
        map.put(0, 1);

        for (int a : nums) {

            sum += a;

            // Look for previous sum
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            // Store current sum
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}