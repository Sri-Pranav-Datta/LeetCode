class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) {
            List<String> ans = new ArrayList<>();
            return ans;
        }
        return padRet("",digits);
    }

    static ArrayList<String> padRet(String p, String up) {
         if(up.isEmpty()) {
            ArrayList<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
         }
         int digit = up.charAt(0) - '0';
         ArrayList<String> ans = new ArrayList<>();
         if(digit < 7) {
            for(int i = (digit - 2)*3; i < (digit - 1)*3; i++) {
                char ch = (char) ('a' + i);
                ans.addAll(padRet(p+ch, up.substring(1)));
            }
         }
         else if(digit == 7) {
            for(int i = 1; i <= 4; i++) {
                char ch = (char) ('o' + i);
                ans.addAll(padRet(p+ch, up.substring(1)));
            }
         }
         else if(digit == 8) {
            for(int i = 1; i <= 3; i++) {
                char ch = (char) ('s' + i);
                ans.addAll(padRet(p+ch, up.substring(1)));
            }
         }
         else {
            for(int i = 1; i <= 4; i++) {
                char ch = (char) ('v' + i);
                ans.addAll(padRet(p+ch, up.substring(1)));
            }
         }
         return ans;
    }
}