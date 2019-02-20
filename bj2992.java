package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class bj2992 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException{
		//s와 구성이 같으면서 s보다 큰 수중 가장 작은수
		s=br.readLine();
		char []arr=new char[s.length()];
		for(int i=0;i<s.length();i++) {
			arr[i]=s.charAt(i);
		}
		permu(arr, 0);
		if(ans==Integer.MAX_VALUE)
			System.out.println(0);
		else
			System.out.println(ans);
	}
	static int ans=Integer.MAX_VALUE;
	static String s="";
	static void permu(char[] arr,int n) {
		if(n==arr.length) {
			StringBuilder sb=new StringBuilder();
			for(int i=0;i<arr.length;i++) {
				sb.append(arr[i]);
			}
			if(Integer.parseUnsignedInt(sb.toString())>Integer.parseInt(s)
					&&Integer.parseUnsignedInt(sb.toString())<ans) {
				ans=Integer.parseUnsignedInt(sb.toString());
			}
			return;
		}
		for(int i=n;i<arr.length;i++) {
			swap(arr,i,n);
			permu(arr,n+1);
			swap(arr,i,n);
		}
	}
	static void swap(char[] arr,int a, int b) {
		char tmp=arr[a];
		arr[a]=arr[b];
		arr[b]=tmp;
	}
}
