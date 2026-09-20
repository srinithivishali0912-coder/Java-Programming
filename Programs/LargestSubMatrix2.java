class Solution {
    public int largestSubsquare(char mat[][]) {
        int r = mat.length,c=mat[0].length;
        int right[][] = new int[r][c];
        int down[][] = new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=c-1;j>=0;j--){
                if(j < c-1 && mat[i][j] == 'X'){
                    right[i][j] = 1 + right[i][j+1];
                }
                else{
                    if(mat[i][j] == 'X'){
                        right[i][j] = 1;
                    }
                    else{
                        right[i][j] = 0;
                    }
                }
            }
        }
        for(int i=r-1;i>=0;i--){
            for(int j=0;j<c;j++){
                if(i < r-1 && mat[i][j] == 'X'){
                    down[i][j] = 1 + down[i+1][j];
                }
                else{
                    if(mat[i][j] == 'X'){
                        down[i][j] = 1;
                    }
                    else{
                        down[i][j] = 0;
                    }
                }
            }
        }
        int max = Math.min(r,c);
        for(int count=max;count >=1;count--){
            for(int i=0;i<=r-count;i++){
                for(int j=0;j<=c-count;j++){
                    if(right[i][j] >= count && right[i+count-1][j] >= count && down[i][j] >= count && down[i][j+count-1] >= count){
                        return count;
                    }
                }
            }
        }
        return 0;
    }
};
