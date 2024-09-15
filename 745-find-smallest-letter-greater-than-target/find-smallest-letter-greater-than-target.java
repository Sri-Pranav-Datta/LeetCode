class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n= letters.length;
        if(letters[0]>target || letters[n-1]<=target){
            return letters[0];
        }
        return binarySearch(letters,target,0,n-1);
    }
    public char binarySearch(char[] letters, char target, int l, int r){
        if(l>r){
            return letters[l];
        }
        int mid = l+ (r-l)/2;
        if(letters[mid]>target){
            return binarySearch(letters,target,l,mid-1);
        }
        return binarySearch(letters,target,mid+1,r);
    }
}