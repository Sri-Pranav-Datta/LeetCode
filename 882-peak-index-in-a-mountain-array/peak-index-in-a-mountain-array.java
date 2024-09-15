class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        return peak(arr,0,n-1);
    }

    public int peak(int[] arr, int l, int r){
        if(l>=r){
            return l;
        }
        int mid = l+ (r-l)/2;
        if(arr[mid]< arr[mid+1]){
            return peak(arr,mid+1,r);
        }
        return peak(arr,l,mid);
    }

}