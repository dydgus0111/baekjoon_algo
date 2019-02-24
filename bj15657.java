package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class bj15657 {
	static int n;
	static int m;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		int []arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		Arrays.sort(arr);
		recur(arr,0, "",0);
	}
	static void recur(int[]arr,int cnt,String str,int sel) {
		if(cnt==m) {
			System.out.println(str);
			return;
		}
		
		for(int i=sel;i<n;i++) {
			recur(arr,cnt+1,str+arr[i]+" ",i);
		}
	}
}
