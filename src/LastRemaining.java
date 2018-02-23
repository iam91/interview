public class LastRemaining {
    public int LastRemaining_Solution(int n, int m) {
        if(n == 0 || m == 0) return -1;
        int[] children = new int[n];
        int cnt = n;
        for(int i = 0; i < n; i++) children[i] = 0;

        int start = 0;
        while(cnt > 1) {
            int idx = start;
            for(int i = 0; i < m; i++) {
                idx = nextUnvisited(children, idx, n);
                idx = (idx + 1) % n;
            }
            cnt--;
            children[(n + idx - 1) % n] = 1;
            idx = nextUnvisited(children, idx, n);
            start = idx;
        }

        return start;
    }

    public int nextUnvisited(int[] children, int idx, int n) {
        while(children[idx] == 1) {
            idx = (idx + 1) % n;
        }
        return idx;
    }

    public static void main(String[] args) {
        LastRemaining c = new LastRemaining();
        System.out.println(c.LastRemaining_Solution(0, 0));
    }
}
