class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> prev = null;
        
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> li = new ArrayList<>();    
            li.add(1);
            for (int j=1; j <= i; j++) {
                if (j < i) li.add(prev.get(j-1) + prev.get(j));
                else li.add(1);
            }
            list.add(li);
            prev = li;
        }
        return list;
    }
}