package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
//1.전체 알파벳중 c개를 뽑아서 만들 수 있는 문자열 만들기
//2.해당 문자열에 모음 개수가 하나도 없거나, 자음이 2개 미만인 문자열 제거
public class bj1759 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws NumberFormatException, IOException {
		 StringTokenizer token=new StringTokenizer(br.readLine());
		 L=Integer.parseInt(token.nextToken());
		 C=Integer.parseInt(token.nextToken());
		 String []alpha=new String[C];
		 String []sel=new String[L];
		 token=new StringTokenizer(br.readLine());
		 for(int i=0;i<alpha.length;i++) {
			 alpha[i]=token.nextToken();
		 }
		 combi(alpha,sel,0,0);
		 list.sort(null);
		 for(int i=0;i<list.size();i++) {
			 System.out.println(list.get(i));
		 }
	}
	static int C=0;
	static int L=0;
	static List<String> list=new ArrayList<>();
	static void combi(String[] arr, String[] sel, int cnt, int n) {
		if(cnt==sel.length) {
			List<String> temp=new ArrayList<>();
			StringBuilder sb=new StringBuilder();
			int conscnt=0;
			int vowelcnt=0;
			for(int i=0;i<sel.length;i++) {
				if(sel[i].equals("a")||sel[i].equals("o")||sel[i].equals("i")||sel[i].equals("e")||sel[i].equals("u"))
					vowelcnt++;
				else
					conscnt++;
				temp.add(sel[i]);
			}
			temp.sort(null);
			for(int i=0;i<temp.size();i++) {
				sb.append(temp.get(i));
			}
			if(vowelcnt>=1&&conscnt>=2)
				list.add(sb.toString());
			return;
		}
		if(n==arr.length)
			return;
		sel[cnt]=arr[n];
		combi(arr, sel, cnt+1,n+1);
		combi(arr,sel,cnt,n+1);
	}
}
