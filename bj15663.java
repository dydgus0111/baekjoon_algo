package backjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class bj15663 {
	static int[] arr;
	static boolean[] check;
	static int[] sel;
	static HashSet<String> hs=new HashSet<String>();
	static int m;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		m=sc.nextInt();
		arr=new int[n];
		sel=new int[m];
		check=new boolean[n];
		for(int i=0;i<n;i++) {
			int input=sc.nextInt();
			arr[i]=input;
		}
		Arrays.sort(arr);
		recur(0,0);
	}
	static void recur(int n,int cnt) {
		if(cnt==m) {
			StringBuilder sb=new StringBuilder();
			for(int i=0;i<cnt;i++) {
				sb.append(sel[i]+" ");
			}
			if(hs.contains(sb.toString()))
				return;
			hs.add(sb.toString());
			System.out.println(sb.toString());
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
