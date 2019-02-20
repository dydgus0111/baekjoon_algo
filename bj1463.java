package test;

import java.util.Scanner;

public class bj1463 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ans=Integer.MAX_VALUE;
		int N=sc.nextInt();
		recur(N, 0);
		System.out.println(ans);
	}
	static int []d=new int[1000001];
	static int ans=Integer.MAX_VALUE;
	static void recur(int N,int cnt) {
		if(N==1) {
			if(d[cnt]<ans)
				ans=d[cnt];
			return;
		}
		if(N%3!=0&&N%2!=0){
			int temp=N-1;
			d[cnt]=d[temp]+1;
			recur(N-1,cnt+1);
		}
		if(N%3==0) {
			int temp=N/3;
			d[cnt]=d[temp]+1;
			recur(N/3,cnt+1);
		}
		if(N%2==0) {
			int temp=N/2;
			d[cnt]=d[temp]+1;
			recur(N/2,cnt+1);
		}
	}
}