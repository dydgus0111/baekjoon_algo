import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj11403 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N=Integer.parseInt(br.readLine());
		int map[][]=new int[N][N];
		for(int i=0;i<N;i++) {
			Arrays.fill(map[i], 987654321);
		}
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int num=Integer.parseInt(st.nextToken());
				if(num==1) {
					map[i][j]=1;
				}
			}
		}
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]>map[i][k]+map[k][j]) {
						map[i][j]=1;
					}
				}
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==987654321)
					System.out.print(0+" ");
				else
					System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
