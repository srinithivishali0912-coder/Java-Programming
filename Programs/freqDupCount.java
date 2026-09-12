import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean flag=true;
        int digits[] = new int[n];
        int freq[] = new int[10];
        for(int i=0;i<n;i++){
            digits[i] = sc.nextInt();
        }
        for(int digit : digits){
            freq[digit]++;
        }
        for(int i=0;i<10;i++){
            if(freq[i] == 0){
                continue;
            }
            System.out.println(i+":"+freq[i]);
        }
        outer: for(int i=0;i<freq.length;i++){
                   if(freq[i] == 0){
                       continue;
                   }
                  int val = freq[i];
                  for(int j=i+1;j<freq.length;j++){
                     if(freq[j] != 0 && freq[j] == val) {
                         flag = false;
                         break outer;
                     }
                  }
        }
        if(!flag){
            System.out.println("Duplicate Occurrences");
        }
        else{
            System.out.println("No duplicate Occurrences");
        }
    }
}
