class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char x : s.toCharArray()){
            map.put(x, map.getOrDefault(x,0)+1);
        }
        for(char x: t.toCharArray()){
            map.put(x, map.getOrDefault(x,0)-1);
        }
        for(Map.Entry<Character, Integer> e : map.entrySet()){
            if(e.getValue() != 0){
                return false;
            }
        }
        return true;
    }
}