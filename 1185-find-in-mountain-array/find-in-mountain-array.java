/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        //find peak element in mountain array.
        int l =0;
        int n = mountainArr.length();
        int r = n-1;
        int mid;
        while(l<r){
            mid = l + (r-l)/2;
            if(mountainArr.get(mid+1)<mountainArr.get(mid)){
                r = mid;
            }
            else{
                l = mid+1;
            }
        }
        // l is the peak element
        if(mountainArr.get(l)==target){
            return l;
        }
        //search left subarray
        int lt =0;
        int rt =l-1;
        int e;
        while(lt<rt){
            mid = lt + (rt-lt)/2;
            e = mountainArr.get(mid);
            if(e==target){
                return mid;
            }
            else if(target<e){
                rt=mid-1;
            }
            else{
                lt = mid+1;
            }
        }
        if(mountainArr.get(lt)==target){
            return lt;
        }
        // search right subarray
        lt=l+1;
        rt=n-1;
        while(lt<rt){
            mid = lt+(rt-lt)/2;
            e = mountainArr.get(mid);
            if(e==target){
                return mid;
            }
            else if(e<target){
                rt=mid-1;
            }
            else{
                lt=mid+1;
            }
        }
        if(mountainArr.get(lt)==target){
            return lt;
        }
        return -1;
    }
}