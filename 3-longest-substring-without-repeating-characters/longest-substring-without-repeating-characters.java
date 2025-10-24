class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(s == null ||n == 0) return 0;
        if(n == 1) return 1;
        int maxi = 0;
        int l = 0;
        int r = 0;
        int cur = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while( r < n) {
            if(map.containsKey(s.charAt(r)) && map.get(s.charAt(r)) >= l) {
                l = map.get(s.charAt(r)) + 1;
            }
            map.put(s.charAt(r), r);
            cur = r-l+1;
            maxi = Math.max(maxi, cur);
            r++;
        }
        return maxi;
    }
}