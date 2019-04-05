import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1613 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		int map[][]=new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			Arrays.fill(map[i], 987654321);
		}
		for(int i=0;i<K;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			map[a][b]=1;
		}
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(map[i][j]>map[i][k]+map[k][j])
						map[i][j]=map[i][k]+map[k][j];
				}
			}
		}
		int s=Integer.parseInt(br.readLine());
		for(int i=0;i<s;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			if(map[a][b]==987654321&&map[b][a]==987654321)
				System.out.println(0);
			else if(map[a][b]==987654321&&map[b][a]!=987654321)
				System.out.println(1);
			else if(map[a][b]!=987654321&&map[b][a]==987654321)
				System.out.println(-1);
		}
	}
}
