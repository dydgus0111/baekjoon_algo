import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		int m=sc.nextInt();
		int[] arr=new int[n];
		int[] sel=new int[m];
		for(int i=0;i<n;i++) {
			arr[i]=i+1;
		}
		combi(arr, sel, 0, 0);    //조합을 통해서 n개중 m개를 이용해서 만들 수 있는 수 리스트에 저장
		for(int i=0;i<combi.size();i++) {    //조합을 통해 나온 숫자들의 조합을 다시 순열로 만들어서 저장
			permu(combi.get(i), 0);
		}
		list.sort(null);
		for(int i=0;i<list.size();i++) {    
			for(int j=0;j<list.get(i).length();j++) {
				System.out.print(list.get(i).charAt(j)+" ");
			}
			System.out.println();
		}
	}
	static List<String> combi=new ArrayList<>();
	static List<String> list=new ArrayList<>();
	static void combi(int[] arr,int[] sel, int n, int r) {
		if(sel.length==r) {
			StringBuilder sb=new StringBuilder();
			for(int i=0;i<sel.length;i++) {
				sb.append(sel[i]);
			}
			combi.add(sb.toString());
			return;
		}
		if(arr.length==n)
			return;
		sel[r]=arr[n];
		combi(arr, sel, n+1, r+1);
		combi(arr, sel, n+1, r);
	}
	static void permu(String str, int n) {
		if(str.length()==n) {
			list.add(str);
			return;
		}
		for(int i=n;i<str.length();i++) {
			StringBuilder sb=new StringBuilder();
			sb.append(str);
			swap(sb,i,n);
			str=sb.toString();
			permu(str, n+1);
			swap(sb,i,n);
			str=sb.toString();
		}
	}
    //StringBuilder를 이용한 문자 스왑
	static void swap(StringBuilder sb, int a, int b) {
		char tmp=sb.charAt(a);
		sb.setCharAt(a, sb.charAt(b));
		sb.setCharAt(b, tmp);
	}
}
