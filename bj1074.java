package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1074 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		StringTokenizer token=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(token.nextToken());
		int r=Integer.parseInt(token.nextToken());
		int c=Integer.parseInt(token.nextToken());
		
		int ans=0;
		int x=(int)Math.pow(2, n)/2;
		int y=(int)Math.pow(2, n)/2;
		while(n-->0) {
			int temp=(int)Math.pow(2, n)/2;
			int skip=(int)Math.pow(4, n);
			if(r<y&&c<x) {
				//1: 왼쪽위
				x-=temp;
				y-=temp;
			}
			else if(r<y&&c>=x) {
				//2: 오른쪽 위
				x+=temp;
				y-=temp;
				ans+=skip;
			}
			else if(r>=y&&c<x) {
				//3: 왼쪽 아래
				x-=temp;
				y+=temp;
				ans+=skip*2;
			}
			else{
				//4: 오른쪽 아래
				x+=temp;
				y+=temp;
				ans+=skip*3;
			}
		}
		System.out.println(ans);
	}
	
}
