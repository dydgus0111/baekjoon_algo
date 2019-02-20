package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj9095 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T=Integer.parseInt(br.readLine());
		for(int test_case=0;test_case<T;test_case++) {
			N=Integer.parseInt(br.readLine());
			StringBuilder sb=new StringBuilder();
			int[] arr=new int[N];
			ans=0;
			sumcnt(1,0,arr,0);
			System.out.println(ans);
		}
	}
	static int N=0;
	static int ans=0;
	static void sumcnt(int num,int sum,int[] arr,int cnt) {
		if(sum==N) {	//지금까지 sum의 합이 N과 같다면 ans+1
			ans+=1;
			return;
		}
		if(cnt==arr.length)
			return;
		for(int i=1;i<=3;i++) {	//for문 돌면서  1~3까지 더하기
			arr[cnt]=i;
			sumcnt(i,sum+i,arr,cnt+1);	//sumcnt를 재귀로 실행하면서 sum에 i값을 더해서 넘겨줌
		}
	}
}
