package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj6603 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		while(true) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int k=Integer.parseInt(st.nextToken());
			if(k==0)
				break;
			int arr[]=new int[k];
			for(int i=0;i<k;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			combi(arr, new int[6], 0, 0);
			System.out.println();
		}
	}
	static void combi(int arr[], int sel[], int n, int r) {
		if(sel.length==r) {
			for(int i=0;i<sel.length;i++) {
				System.out.print(sel[i]+" ");
			}
			System.out.println();
			return;
		}
		if(arr.length==n) {
			return;
		}
		sel[r]=arr[n];
		combi(arr, sel, n+1, r+1);
		combi(arr, sel, n+1, r);
	}
}
