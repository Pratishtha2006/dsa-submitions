class Solution {
    public int lengthOfLIS(int[] nums) {

        ArrayList<Integer> tmp = new ArrayList<>();

        for (int a : nums) {

            // If tmp is empty OR a is greater than last element
            if (tmp.size() == 0 || a > tmp.get(tmp.size() - 1)) {
                tmp.add(a);
            }

            else {
                // Find first element >= a
                for (int j = 0; j < tmp.size(); j++) {

                    if (tmp.get(j) >= a) {
                        tmp.set(j, a);
                        break;
                    }
                }
            }
        }

        return tmp.size();
    }
}