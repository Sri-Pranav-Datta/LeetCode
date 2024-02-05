class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int n = nums.size();
        vector<int> temp(n);
        int j=0;
        while(k>n){
            k-=n;
        }
        for (int i = n - k; i < 2 * n - k; i++) {
            temp[j++] = nums[i%n];
        }
        nums=temp;
    }
};