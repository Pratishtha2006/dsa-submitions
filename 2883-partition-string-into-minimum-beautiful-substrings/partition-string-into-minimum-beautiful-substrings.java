
class Solution {

    boolean check(int l, int r, String s) {

        if (s.charAt(l) == '0')
            return false;

        StringBuilder tmp = new StringBuilder();

        for (int i = l; i <= r; i++) {
            tmp.append(s.charAt(i));
        }

        // 101

        tmp.reverse();

        int i = 0;
        int num = 0;

        for (int k = 0; k < tmp.length(); k++) {

            char a = tmp.charAt(k);

            if (a == '0') {
                i++;
                continue;
            }

            num = num + (int)Math.pow(2, i);
            i++;
        }

        for (int j = 0; j <= 10; j++) {

            int kk = (int)Math.pow(5, j);

            if (num == kk)
                return true;
        }

        return false;
    }


    int fun(int p, int i, String s) {

        if (i == s.length() - 1) {

            if (check(p, i, s))
                return 0;

            return 1000000000;
        }

        int m = 1000000000;

        // Cut here
        if (check(p, i, s)) {

            int a = 1 + fun(i + 1, i + 1, s);

            m = Math.min(m, a);
        }

        // Don't cut here
        int a = fun(p, i + 1, s);

        m = Math.min(m, a);

        return m;
    }


    public int minimumBeautifulSubstrings(String s) {

        int ans = fun(0, 0, s);

        return ans == 1000000000 ? -1 : ans + 1;
    }
}

