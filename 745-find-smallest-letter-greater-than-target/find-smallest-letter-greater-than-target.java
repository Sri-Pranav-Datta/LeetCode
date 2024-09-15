class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n= letters.length;
        if(letters[0]>target){
            return letters[0];
        }else if(letters[n-1]<=target){
            return letters[0];
        }
        int l=0;
        int r =n;
        int mid;
        char ans = letters[0];
        while(l<=r){
            mid = l + (r-l)/2;
            if(letters[mid] <= target){
                l = mid+1;
            }
            else{
                ans = letters[mid];
                r = mid-1;
            }
        }
        return ans;
    }
}