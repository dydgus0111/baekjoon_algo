package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class bj15652 {
	static int n;
	static int m;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		recur(0, "",1);
	}
	static void recur(int cnt,String str,int num) {
		if(cnt==m) {
			System.out.println(str);
			return;
		}
		
		for(int i=num;i<=n;i++) {
			recur(cnt+1,str+i+" ",i);
		}
	}
}
