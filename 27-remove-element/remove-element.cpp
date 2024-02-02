class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int count =0;
        vector<int> newarr;
        for(int i=0;i<nums.size();i++){
            if(nums[i]==val){
                
            }else{
                newarr.push_back(nums[i]);
                count++;
            }
        }
        
        nums=newarr;
        return count;
    }
};