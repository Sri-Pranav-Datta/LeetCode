class Solution {
    public boolean isAnagram(String s, String t) {
        char[] s1 = sortString(s);
        char[] t1 = sortString(t);
        if(s1.length != t1.length){
            return false;
        }
        for(int i=0;i<s1.length;i++){
            if(s1[i]!=t1[i]){
                return false;
            }
        }
        return true;
        
    }

    char[] sortString(String in){
        char[] arr = in.toCharArray();
        Arrays.sort(arr);
        return arr;
    }
}