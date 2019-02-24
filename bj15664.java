package backjoon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class bj15664 {
	static int[] arr;
	static int[] sel;
	static int m;
	static HashSet<String> hs=new HashSet<String>();
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		m=sc.nextInt();
		arr=new int[n];
		sel=new int[m];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		Arrays.sort(arr);
		combi(arr,sel,0,0);
	}
	static void combi(int[] arr, int[] sel, int n, int r) {
		if(sel.length==r) {
			StringBuilder sb=new StringBuilder();
			for(int i=0;i<sel.length;i++) {
				sb.append(sel[i]+" ");
			}
			if(hs.contains(sb.toString()))
				return;
			hs.add(sb.toString());
			System.out.println(sb.toString());
			return;
		}
		if(arr.length==n) {
			return;			
		}
		sel[r]=arr[n];
		combi(arr, sel, n+1, r+1);
		combi(arr,sel,n+1,r);
	}
	
}
