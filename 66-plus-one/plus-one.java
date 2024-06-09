class Solution {
    public int[] plusOne(int[] digits) {
        int n= digits.length;
        for(int i=0 ; i<n ;i++){
            if(digits[n-1-i]<9){
                digits[n-i-1]++;
                return digits;
            }
            digits[n-i-1]=0;
        }
        digits= new int[n+1];
        digits[0]=1;
        return digits;
    }
}