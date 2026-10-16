
class Solution {
    static final int MOD = 1_000_000_007;

    int[] sum, sq, lazy;
    int n;

    public int sumCounts(int[] nums) {
        n = nums.length;

        sum = new int[4 * n];
        sq = new int[4 * n];
        lazy = new int[4 * n];

        int[] last = new int[100001];
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int x = nums[i];

            // Update distinct counts for subarrays
            // ending at index i
            int left = last[x];
            update(1, 0, n - 1, left, i, 1);

            last[x] = i + 1;

            // Sum of squares for all subarrays
            // ending at index i
            ans = (ans + sq[1]) % MOD;
        }

        return (int) ans;
    }

    void update(int node, int start, int end,
                int l, int r, int val) {

        if (r < start || end < l) {
            return;
        }

        if (l <= start && end <= r) {
            apply(node, start, end, val);
            return;
        }

        push(node, start, end);

        int mid = (start + end) / 2;

        update(node * 2, start, mid, l, r, val);
        update(node * 2 + 1, mid + 1, end, l, r, val);

        sum[node] = (sum[node * 2] + sum[node * 2 + 1])
                    % MOD;

        sq[node] = (int) (
            ((long) sq[node * 2] + sq[node * 2 + 1]) % MOD
        );
    }

    void apply(int node, int start, int end, int val) {
        long len = end - start + 1L;

        long s = sum[node];
        long v = val;

        sq[node] = (int) (
            (sq[node] + 2L * v % MOD * s
             + v * v % MOD * len) % MOD
        );

        sum[node] = (int) ((s + v * len) % MOD);

        lazy[node] = (int) ((lazy[node] + val) % MOD);
    }

    void push(int node, int start, int end) {
        if (lazy[node] == 0 || start == end) {
            return;
        }

        int mid = (start + end) / 2;
        int val = lazy[node];

        apply(node * 2, start, mid, val);
        apply(node * 2 + 1, mid + 1, end, val);

        lazy[node] = 0;
    }
}
