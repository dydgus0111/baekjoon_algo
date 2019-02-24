package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class bj15654 {
	static int[] arr;
	static boolean[] check;
	static int[] sel;
	static int m;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		m=sc.nextInt();
		arr=new int[n];
		sel=new int[m];
		check=new boolean[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		Arrays.sort(arr);
		recur(0,0);
		
	}
	static void recur(int n,int cnt) {
		if(cnt==m) {
			for(int i=0;i<cnt;i++) {
				System.out.print(sel[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=0;i<arr.length;i++) {
			if(check[i]==false) {
				sel[n]=arr[i];
				check[i]=true;
				recur(n+1,cnt+1);
				check[i]=false;
			}
		}
	}
	
}
