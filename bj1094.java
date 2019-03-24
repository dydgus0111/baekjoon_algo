package backjoon;

import java.util.Scanner;

public class bj1094 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int X=sc.nextInt();
		int N=64;
		int cnt=0;
		while(true) {
			if(N>X) {
				N/=2;
			}
			else if(N<X) {
				X-=N;
				cnt++;
			}
			else if(N==X) {
				cnt++;
				break;
			}
		}
		System.out.println(cnt);
	}
}
