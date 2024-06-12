class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0 ; i<numRows ; i++){
            result.add(new ArrayList<>());
        }
        result.get(0).add(1);
        if(numRows == 1){
            return result;
        }
        result.get(1).add(1);
        result.get(1).add(1);
        if(numRows == 2){
            return result;
        }
        for(int i=2; i<numRows; i++){
            result.get(i).add(1);
            for(int j=1 ; j<i; j++){
                result.get(i).add(result.get(i-1).get(j-1)+ result.get(i-1).get(j));
            }
            result.get(i).add(1);
        }
        return result;
    }
}