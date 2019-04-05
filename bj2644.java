import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//플로이드워셜
public class bj2644 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		int p1=Integer.parseInt(st.nextToken());
		int p2=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(br.readLine());
		int d[][]=new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			Arrays.fill(d[i], 987654321);
		}
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			d[a][b]=1;
			d[b][a]=1;
		}
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(d[i][j]>d[i][k]+d[k][j]) {
						d[i][j]=d[i][k]+d[k][j];
					}
				}
			}
		}
		if(d[p1][p2]==987654321)
			System.out.println(-1);
		else
			System.out.println(d[p1][p2]);
	}
}
