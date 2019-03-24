package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2455 {
	public static void main(String[] args) throws IOException {
		int max=Integer.MIN_VALUE;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int sum=0;
		for(int i=0;i<4;i++) {
			StringTokenizer token=new StringTokenizer(br.readLine());
			int out=Integer.parseInt(token.nextToken());
			int in=Integer.parseInt(token.nextToken());
			sum=sum+in-out;
			if(sum>max)
				max=sum;
		}
		System.out.println(max);
	}
}
