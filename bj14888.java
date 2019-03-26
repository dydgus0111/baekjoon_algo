package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class bj14888 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static char[] op;
	static long[] num;
	public static void main(String[] args) throws NumberFormatException, IOException{
		N=Integer.parseInt(br.readLine());
		num=new long[N];
		int opnum[]=new int[4];//0:+, 1:-, 2:x, 3:/
		op=new char[N-1];
		hs=new HashSet<>();
		StringTokenizer token=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			num[i]=Integer.parseInt(token.nextToken());
		}
		token=new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			opnum[i]=Integer.parseInt(token.nextToken());
		}
		for(int i=0,cnt=0;i<4;i++) {
			int tmp=opnum[i];
			for(int j=0;j<tmp;j++) {
				if(i==0)
					op[cnt]='+';
				else if(i==1)
					op[cnt]='-';
				else if(i==2)
					op[cnt]='*';
				else if(i==3)
					op[cnt]='/';
				cnt++;
			}
		}
		permu(0);
		System.out.println(max);
		System.out.println(min);
	}
	static HashSet<String> hs;
	static long max=Long.MIN_VALUE;
	static long min=Long.MAX_VALUE;
	static void calc(StringBuilder op){
		StringBuilder modi=new StringBuilder();
		long calc=num[0];
		for(int i=1,cnt=0;i<num.length;i++,cnt++) {
			modi.append(num[i]);
			if(cnt<op.length()) {
				char tmpop=op.charAt(cnt);
				if(tmpop=='+') {
					calc+=num[i];
				}
				else if(tmpop=='-') {
					calc-=num[i];
				}
				else if(tmpop=='*') {
					calc*=num[i];
				}
				else if(tmpop=='/') {
					if(calc<0) {
						calc=(int)Math.abs(calc)/num[i];
						calc*=-1;
					}
					else
						calc=(int)calc/num[i];
				}
			}
		}
		if(calc>max) {
			max=calc;
		}
		if(calc<min) {
			min=calc;
		}
	}
	static void permu(int n){
		if(n==op.length) {
			StringBuilder sb=new StringBuilder();
			for(int i=0;i<op.length;i++) {
				sb.append(op[i]);
			}
			if(hs.contains(sb.toString()))
				return;
			hs.add(sb.toString());
			calc(sb);
			return;
		}
		for(int i=n;i<op.length;i++) {
			swap(op, i, n);
			permu(n+1);
			swap(op, i, n);
		}
	}
	static void swap(char[] arr, int a, int b) {
		char tmp=arr[a];
		arr[a]=arr[b];
		arr[b]=tmp;
	}
}
