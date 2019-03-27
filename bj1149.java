import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1149 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N=Integer.parseInt(br.readLine());
		int price[][]=new int[N+1][3];
		int d[][]=new int[N+1][3];
		for(int i=1;i<=N;i++) {
			StringTokenizer token=new StringTokenizer(br.readLine());
			int r=Integer.parseInt(token.nextToken());
			int g=Integer.parseInt(token.nextToken());
			int b=Integer.parseInt(token.nextToken());
			price[i][0]=r;
			price[i][1]=g;
			price[i][2]=b;
		}
		for(int i=1;i<N+1;i++) {
			d[i][0]=Math.min(d[i-1][1]+price[i][0], d[i-1][2]+price[i][0]);
			d[i][1]=Math.min(d[i-1][0]+price[i][1], d[i-1][2]+price[i][1]);
			d[i][2]=Math.min(d[i-1][0]+price[i][2], d[i-1][1]+price[i][2]);
		}
		int ans=0;
		if(d[N][0]<d[N][1]) {
			ans=d[N][0];
		}
		else
			ans=d[N][1];
		if(ans>d[N][2])
			ans=d[N][2];
		System.out.println(ans);
	}
}
