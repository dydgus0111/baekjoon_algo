package backjoon;

import java.util.Scanner;

public class bj9461 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		long d[]=new long[101];
		d[0]=0;
		d[1]=1;
		d[2]=1;
		d[3]=1;
		for(int i=4;i<=100;i++) {
			d[i]=d[i-2]+d[i-3];
		}
		for(int i=0;i<T;i++) {
			int N=sc.nextInt();
			System.out.println(d[N]);
		}
	}
}
