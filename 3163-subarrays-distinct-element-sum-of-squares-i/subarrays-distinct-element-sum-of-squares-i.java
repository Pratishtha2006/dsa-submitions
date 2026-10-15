
import java.util.*;

class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                boolean[] seen = new boolean[101];
                int count = 0;

                for (int k = i; k <= j; k++) {
                    int num = nums.get(k);

                    if (!seen[num]) {
                        seen[num] = true;
                        count++;
                    }
                }

                ans += count * count;
            }
        }

        return ans;
    }
}
