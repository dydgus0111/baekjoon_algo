package backjoon;

import java.util.Scanner;

public class bj2231 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String N=sc.next();
		ans=Integer.MAX_VALUE;
		dfs(new int[N.length()], N, 0);
		if(ans==Integer.MAX_VALUE)
			ans=0;
		System.out.println(ans);
	}
	static int ans;
	static void dfs(int[] sel,String N,int idx) {
		if(N.length()==idx) {
			int sum=0;
			StringBuilder sb=new StringBuilder();
			for(int i=0;i<sel.length;i++) {
				sum+=sel[i];
				sb.append(sel[i]);
			}
			if(Integer.parseInt(N)-sum==Integer.parseInt(sb.toString())) {
				if(ans>Integer.parseInt(sb.toString()))
					ans=Integer.parseInt(sb.toString());
			}
			return;
		}
		for(int i=0;i<10;i++) {
			sel[idx]=i;
			dfs(sel, N, idx+1);
		}
	}
}
