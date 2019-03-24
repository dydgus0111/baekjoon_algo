package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14501_dfs {
	static Pair[] list;
	static int N;
	static int max;
	static boolean check[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		list=new Pair[N];
		max=Integer.MIN_VALUE;
		check=new boolean[N];
		for(int i=0;i<N;i++) {
			StringTokenizer token=new StringTokenizer(br.readLine());
			int t=Integer.parseInt(token.nextToken());
			int p=Integer.parseInt(token.nextToken());
			list[i]=new Pair(t, p);
		}
		dfs(0);
		System.out.println(max);
	}
	static void dfs(int idx) {
		if(idx>=list.length) {
			int sum=0;
			for(int i=0;i<check.length;i++) {
				if(check[i]) {
					sum+=list[i].p;
				}
			}
			if(sum>max)
				max=sum;
			return;
		}
		for(int i=idx;i<N;i++) {
			if(!check[i]) {
				if(i+list[i].t<=N)
					check[i]=true;
				int tmpidx=i;
				i+=list[i].t;
				dfs(i);
				i=tmpidx;
				check[i]=false;
			}
		}
	}
	static class Pair{
		int t;	//상담에 소요되는 날짜
		int p;	//완료시 받는 금액
		public Pair(int t, int p) {
			this.t=t;
			this.p=p;
		}
	}
}
