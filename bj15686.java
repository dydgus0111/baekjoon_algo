package test;

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.StringTokenizer;

public class bj15686 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int map[][];
	static List<Point> chicken;
	static List<Point> home;
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		minv=Integer.MAX_VALUE;
		ansarr=new int[M];
		map=new int[N][N];
		home=new ArrayList<Point>();
		chicken=new ArrayList<Point>();
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int tmp=Integer.parseInt(st.nextToken());
				map[i][j]=tmp;
				if(tmp==2)
					chicken.add(new Point(i, j));
				else if(tmp==1)
					home.add(new Point(i, j));
			}
		}
		int arr[]=new int[chicken.size()];
		for(int i=0;i<chicken.size();i++) {
			arr[i]=i;
		}
		combi(arr,new int[M], 0, 0);
		System.out.println(minv);
	}
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	static int calc(int arr[]) {
		int sum=0;
		for(int i=0;i<home.size();i++) {
			int min=Integer.MAX_VALUE;
			for(int j=0;j<arr.length;j++) {
				int tmp=Math.abs(home.get(i).x-chicken.get(arr[j]).x)+Math.abs(home.get(i).y-chicken.get(arr[j]).y);
				if(min>tmp) {
					min=tmp;
				}
			}
			sum+=min;
		}
		return sum;
	}
	static int minv;
	static int ansarr[];
	static void combi(int[] arr,int[] sel, int r, int n) {
		if(r==sel.length) {
			int tmp=0;
			tmp=calc(sel);
			if(tmp<minv) {
				minv=tmp;
			}
			return;
		}
		if(n==arr.length)
			return;
		sel[r]=arr[n];
		combi(arr,sel, r+1, n+1);
		combi(arr,sel, r, n+1);
	}
}

