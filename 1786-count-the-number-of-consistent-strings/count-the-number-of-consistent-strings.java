class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int m= allowed.length();
        HashSet<Character> hs = new HashSet<Character>();
        for(int i=0;i<m;i++){
            hs.add(allowed.charAt(i));
        }
        int count =0;
        int n = words.length;
        for(int i=0;i<n;i++){
            boolean b = true;
            for(int j=0;j<words[i].length();j++){
                if(!hs.contains(words[i].charAt(j))){
                    b = false;
                }
            }
            if(b==true){
                count++;
            }
        }
        return count;
    }
}