class Solution {
    public int minBitFlips(int start, int goal) {
        int x = start^goal;
        int count= 0;
        String s = Integer.toBinaryString(x);
        char[] c = s.toCharArray();
        for(char i : c){
            if(i == '1'){
                count++;
            }
        }
        return count;
    }
}