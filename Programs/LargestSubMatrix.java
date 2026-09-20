class Solution {
    public int largestSubsquare(char mat[][]) {
        boolean check = false;
        int max = Math.max(mat.length,mat[0].length);
        for(int count=max-1;count >=0;count--){
            for(int i=0;i<mat.length-count;i++){
              for(int j=0;j<mat[0].length-count;j++){
                 check = checkMatrix(i,j,i+count,j+count,mat);
                 if(check){
                     return count+1;
                 }
              }
           }
        }
        return 0;
    }
    public static boolean checkMatrix(int s1,int s2,int e1,int e2,char[][] mat){
        for(int i=s1;i<=e1;i++){
            for(int j=s2;j<=e2;j++){
                if(i == s1 || i==e1){
                    if(mat[i][j] != 'X'){
                        return false;
                    }
                }
                else{
                    if(j==s2 || j==e2){
                        if(mat[i][j] != 'X'){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
};
