class Solution {
    int maxSubarraySum(int[] arr) {
        int sum=0,max=arr[0];
        int dp[] = new int[arr.length];
        dp[0] = arr[0];
        for(int i=1;i<arr.length;i++){
            dp[i] = Math.max(arr[i] + dp[i-1],arr[i]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
