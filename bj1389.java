package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1389 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int map[][]=new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			Arrays.fill(map[i], 987654321);
		}
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			map[a][b]=1;
			map[b][a]=1;
		}
		for(int k=1;k<=N;k++) {
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					map[i][j]=Math.min(map[i][j], map[i][k]+map[k][j]);
				}
			}
		}
		int arr[]=new int[N+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(i==j) continue;
				arr[i]+=map[i][j];
			}
		}
		int min=Integer.MAX_VALUE;
		int minidx=0;
		for(int i=1;i<=N;i++) {
			if(min>arr[i]) {
				min=arr[i];
				minidx=i;
			}
		}
		System.out.println(minidx);
	}
}
