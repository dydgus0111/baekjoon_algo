package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class bj14889 {
	static int map[][];
	static int N;
	static int arr[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		StringTokenizer token;
		map=new int[N+1][N+1];
		arr=new int[N+1];
		hs=new HashSet<String>();
		for(int i=1;i<=N;i++) {
			arr[i]=i;
		}
		for(int i=1;i<=N;i++) {
			token=new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				map[i][j]=Integer.parseInt(token.nextToken());
			}
		}
		combi(new int[N/2],arr, 1, 0);
		System.out.println(ans);
	}
	static int A=0;
	static int B=0;
	static int ans=Integer.MAX_VALUE;
	static HashSet<String> hs;
	static void combi(int[] sel,int[] a,int n, int r) {
		if(r==sel.length) {
			boolean check[]=new boolean[N+1];
			StringBuilder sb=new StringBuilder();
			for(int i=0;i<sel.length;i++) {
				check[sel[i]]=true;
				sb.append(sel[i]+" ");
			}
			if(hs.contains(sb.toString()))
				return;
			else
				hs.add(sb.toString());
			int arr[]=new int[N/2];
			sb=new StringBuilder();
			for(int i=1,cnt=0;i<=N;i++) {
				if(!check[i]) {
					arr[cnt]=i;
					cnt++;
					sb.append(i+" ");
				}
			}
			if(hs.contains(sb.toString()))
				return;
			combi2(new int[2], sel, 0, 0);
			combi3(new int[2], arr, 0, 0);
			if(Math.abs(A-B)<ans)
				ans=Math.abs(A-B);
			A=0;
			B=0;
			return;
		}
		if(n==N+1)
			return;
		sel[r]=a[n];
		combi(sel,a, n+1, r+1);
		combi(sel,a, n+1, r);
	}
	static void combi2(int[] sel,int[] a,int n, int r) {
		if(r==sel.length) {
			A+=map[sel[0]][sel[1]]+map[sel[1]][sel[0]];
			return;
		}
		if(n==N/2)
			return;
		sel[r]=a[n];
		combi2(sel,a, n+1, r+1);
		combi2(sel,a, n+1, r);
	}
	static void combi3(int[] sel,int[] a,int n, int r) {
		if(r==sel.length) {
			B+=map[sel[0]][sel[1]]+map[sel[1]][sel[0]];
			return;
		}
		if(n==N/2)
			return;
		sel[r]=a[n];
		combi3(sel,a, n+1, r+1);
		combi3(sel,a, n+1, r);
	}
}
