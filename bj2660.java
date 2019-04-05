import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class bj2660 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N=Integer.parseInt(br.readLine());
		int map[][]=new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			Arrays.fill(map[i], 987654321);
		}
		while(true) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			if(a==-1&&b==-1)
				break;
			map[a][b]=1;
			map[b][a]=1;
		}
		for(int k=1;k<=N;k++) {
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(map[i][j]>map[i][k]+map[k][j]) {
						map[i][j]=map[i][k]+map[k][j];
					}
				}
			}
		}
		int arr[]=new int[N+1];
		int min=987654321;
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(i==j) continue;
				arr[i]=Math.max(arr[i], map[i][j]);
			}
			min=Math.min(arr[i], min);
		}
		int mincnt=0;
		for(int i=1;i<=N;i++) {
			if(min==arr[i])
				mincnt++;
		}
		System.out.println(min+" "+mincnt);
		for(int i=1;i<=N;i++) {
			if(min==arr[i])
				System.out.print(i+" ");
		}
	}
}
