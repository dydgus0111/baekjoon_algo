package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj6443 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException{
		int N=Integer.parseInt(br.readLine());
		for(int t=0;t<N;t++) {
			String str= br.readLine();
			char[] alpha=new char[str.length()];
			char[] check=new char[str.length()];
			for(int i=0;i<str.length();i++) {
				alpha[i]=str.charAt(i);
			}
//			permu(alpha,0);
			combi(alpha,check,0,0);
			list.sort(null);
			for(int i=0;i<list.size();i++)
				System.out.println(list.get(i));
			list.clear();
		}
	}
	static List<String> list=new ArrayList<>();
//	static void swap(char[] a, int i, int j) {
//		char tmp=a[i];
//		a[i]=a[j];
//		a[j]=tmp;
//	}
//	static void permu(char[] arr, int n) {
//		if(arr.length==n) {
//			StringBuilder sb=new StringBuilder();
//			for(int i=0;i<arr.length;i++) {
//				sb.append(arr[i]);
//			}
//			if(list.isEmpty())
//				list.add(sb.toString());
//			else {
//				boolean flag=true;
//				for(int i=0;i<list.size();i++) {
//					if(list.get(i).equals(sb.toString()))
//						flag&=false;
//				}
//				if(flag)
//					list.add(sb.toString());
//			}
//			return;
//		}
//		for(int i=n;i<arr.length;i++) {
//			swap(arr,i,n);
//			permu(arr,n+1);
//			swap(arr,i,n);
//		}
//	}
	static void combi(char[] arr,char[] c,int n,int r) {
		if(c.length==n) {
			StringBuilder sb=new StringBuilder();
			for(int i=0;i<c.length;i++) {
				sb.append(arr[i]);
			}
			list.add(sb.toString());
			return;
		}
		c[r]=arr[n];
		combi(arr, c, n+1, r+1);
		combi(arr,c,n+1,r);
	}
}
