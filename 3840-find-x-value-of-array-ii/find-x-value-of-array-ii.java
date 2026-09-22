class Solution {

    int n, k;
    int[][] cnt;
    int[] prod;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.n = nums.length;
        this.k = k;

        cnt = new int[4 * n][k];
        prod = new int[4 * n];

        build(nums, 1, 0, n - 1);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int idx = queries[i][0];
            int val = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            update(1, 0, n - 1, idx, val);

            Node res = query(1, 0, n - 1, start, n - 1);

            ans[i] = res.cnt[x];
        }

        return ans;
    }

    class Node {
        int p;
        int[] cnt;

        Node() {
            p = 1 % k;
            cnt = new int[k];
        }
    }

    void build(int[] a, int node, int l, int r) {
        if (l == r) {
            int x = a[l] % k;
            prod[node] = x;
            cnt[node][x] = 1;
            return;
        }

        int mid = (l + r) / 2;

        build(a, node * 2, l, mid);
        build(a, node * 2 + 1, mid + 1, r);

        merge(node);
    }

    void merge(int node) {
        int L = node * 2;
        int R = node * 2 + 1;

        prod[node] = (prod[L] * prod[R]) % k;

        for (int i = 0; i < k; i++)
            cnt[node][i] = cnt[L][i];

        for (int i = 0; i < k; i++) {
            int r = (prod[L] * i) % k;
            cnt[node][r] += cnt[R][i];
        }
    }

    void update(int node, int l, int r, int idx, int val) {
        if (l == r) {
            int x = val % k;
            prod[node] = x;

            for (int i = 0; i < k; i++)
                cnt[node][i] = 0;

            cnt[node][x] = 1;
            return;
        }

        int mid = (l + r) / 2;

        if (idx <= mid)
            update(node * 2, l, mid, idx, val);
        else
            update(node * 2 + 1, mid + 1, r, idx, val);

        merge(node);
    }

    Node query(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            Node res = new Node();
            res.p = prod[node];

            for (int i = 0; i < k; i++)
                res.cnt[i] = cnt[node][i];

            return res;
        }

        int mid = (l + r) / 2;

        if (qr <= mid)
            return query(node * 2, l, mid, ql, qr);

        if (ql > mid)
            return query(node * 2 + 1, mid + 1, r, ql, qr);

        Node A = query(node * 2, l, mid, ql, qr);
        Node B = query(node * 2 + 1, mid + 1, r, ql, qr);

        return combine(A, B);
    }

    Node combine(Node A, Node B) {
        Node C = new Node();

        C.p = (A.p * B.p) % k;

        for (int i = 0; i < k; i++)
            C.cnt[i] = A.cnt[i];

        for (int i = 0; i < k; i++) {
            int r = (A.p * i) % k;
            C.cnt[r] += B.cnt[i];
        }

        return C;
    }
}