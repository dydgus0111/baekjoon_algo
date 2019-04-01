package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class bj2309 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int arr[]=new int[9];
		for(int i=0;i<9;i++) {
			arr[i]=sc.nextInt();
		}
		combi(new int[7], arr, 0, 0);
	}
	static void combi(int sel[],int[] arr, int n,int r) {
		if(sel.length==r) {
			int sum=0;
			for(int i=0;i<sel.length;i++) {
				sum+=sel[i];
			}
			if(sum==100) {
				Arrays.sort(sel);
				for(int i=0;i<sel.length;i++) {
					System.out.println(sel[i]);
				}
			}
			return;
		}
		if(arr.length==n) {
			return;
		}
		sel[r]=arr[n];
		combi(sel, arr, n+1, r+1);
		combi(sel, arr, n+1, r);
	}
}
