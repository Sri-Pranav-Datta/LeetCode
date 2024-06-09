class Solution {
    public int[] plusOne(int[] digits) {
        int n= digits.length;
        for(int i=0 ; i<n ;i++){
            if(digits[n-1-i]==9){
                digits[n-i-1]=0;
                if(i==n-1){
                    int[] newarr = new int[n+1];
                    newarr[0]=1;
                    for(int j=0;j<n;j++){
                        newarr[j+1]=digits[j];
                    }
                    digits=newarr;
                }
            }
            else{
                digits[n-1-i]++;
                return digits;
            }
        }
        return digits;
    }
}