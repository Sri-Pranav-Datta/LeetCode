class Solution {
public:
    int strStr(string haystack, string needle) {
        int h = haystack.size();
        int n = needle.size();
        for (int i = 0; i < h - n + 1; i++) {
            int k = 0;
            for (int j = i; j < i + n; j++) {
                if (haystack[j] == needle[k]) {
                    k++;
                } else {
                    break;
                }
            }
            if (k == n) {
                return i;
            }
        }
        return -1;
    }
};