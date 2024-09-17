class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> h1 = new HashMap<>();
        HashMap<String, Integer> h2 = new HashMap<>();
        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");
        for(String s: words1){
            h1.put(s, h1.getOrDefault(s,0)+1);
        }
        for(String s:words2){
            h2.put(s,h2.getOrDefault(s,0)+1);
        }
        for(String s: words2){
            if(h1.containsKey(s)){
                h1.remove(s);
                h2.remove(s);
            }
        }
        List<String> result = new ArrayList<>();
        int count=0;
        for(Map.Entry<String, Integer> e : h1.entrySet()){
            if(e.getValue()==1){
                result.add(e.getKey());
        }
        }
        for(Map.Entry<String, Integer> e : h2.entrySet()){
            if(e.getValue()==1){
                result.add(e.getKey());
        }
        }
        
        return result.toArray(new String[0]);
    }
}