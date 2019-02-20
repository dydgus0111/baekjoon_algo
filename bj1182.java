package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj1182 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer token=new StringTokenizer(br.readLine());
		N=Integer.parseInt(token.nextToken());
		S=Integer.parseInt(token.nextToken());
		ans=0;
		int[] arr=new int[N];
		boolean[] ps=new boolean[N];
		token=new StringTokenizer( br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(token.nextToken());
		}
		powerset(arr, ps, 0);
		System.out.println(ans);
	}
	static int N=0;
	static int S=0;
	static int ans=0;
	static void powerset(int[] arr,boolean[] ps, int cnt ) {
		if(ps.length==cnt) {
			int sum=0;
			int fcnt=0;
			for(int i=0;i<ps.length;i++) {
				if(ps[i]==true) {
					sum+=arr[i];
				}else if(ps[i]==false)
					fcnt++;
			}
			if(fcnt==ps.length)
				return;
			if(sum==S)
				ans++;
			return;
		}
		
		ps[cnt]=true;
		powerset(arr,ps,cnt+1);
		ps[cnt]=false;
		powerset(arr, ps,cnt+1);
	}
}