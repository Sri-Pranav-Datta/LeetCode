class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n = s.length;
        int m = g.length;
        int result = 0;
        for(int i = 0; i < n; i++) {
            if( result >= m) {
                return result;
            }
            if(s[i] >= g[result]) {
                result++;
            }
        }
        return result;
    }
}