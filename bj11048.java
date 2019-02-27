import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj11048 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer token=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(token.nextToken());
		int M=Integer.parseInt(token.nextToken());
		int map[][]=new int[N][M];
		int d[][]=new int[N+1][M+1];
		for(int i=0;i<N;i++) {
			token=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(token.nextToken());
			}
		}
		d[1][1]=map[0][0];
		for(int i=1;i<N+1;i++) {
			for(int j=1;j<M+1;j++) {
				d[i][j]=Math.max(d[i-1][j], d[i][j-1])+map[i-1][j-1];
			}
		}
		System.out.println(d[N][M]);
	}
}
