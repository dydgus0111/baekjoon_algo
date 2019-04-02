package backjoon;

import java.util.Scanner;

public class bj2851 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int arr[]=new int[10];
		for(int i=0;i<10;i++) {
			arr[i]=sc.nextInt();
		}
		int sum=0;
		int idx=0;
		for(int i=0;i<10;i++) {
			sum+=arr[i];
			if(sum>=100) {
				idx=i;
				break;
			}
		}
		if(sum==100)
			System.out.println(sum);
		else {
			int before=sum-arr[idx];
			if(Math.abs(sum-100)>Math.abs(100-before)) {
				System.out.println(before);
			}
			else if(Math.abs(sum-100)<Math.abs(100-before)) {
				System.out.println(sum);
			}
			else if(Math.abs(sum-100)==Math.abs(100-before)) {
				System.out.println(sum);
			}
		}
	}
}
