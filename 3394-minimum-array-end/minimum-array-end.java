class Solution {
    public long minEnd(int n, int x) {
        long result = x;
        long position = 1;
        int remaining = n-1;
        while(remaining != 0) {
            if((x&position)==0) {
                result |= (remaining & 1) * position;
                remaining >>=1;
            }
            position<<=1;
        }
        return result;
    }
    
}