class Solution {
    public long pairAndSum(int[] arr) {
        long count=0,pairs=0,ans=0;
        for(int i=0;i<31;i++){
            count=0;
            for(int j=0;j<arr.length;j++){
                if((arr[j] & (1 << i)) != 0){
                    count++;
                }
            }
            pairs = (count * (count-1))/2;
            ans += pairs * (1 << i);
        }
        return ans;
    }
}
