package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2823 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static char map[][];
	static boolean visited[][];
	static int dx[]= {1,-1,0,0};
	static int dy[]= {0,0,-1,1};
	static int cnt;
	static int R;
	static int C;
	static int ans;
	public static void main(String[] args) throws IOException {
		StringTokenizer st=new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		map=new char[R][C];
		cnt=0;
		for(int i=0;i<R;i++) {
			String str=br.readLine();
			for(int j=0;j<C;j++) {
				if(str.charAt(j)=='.')
					cnt++;
				map[i][j]=str.charAt(j);
			}
		}
		ans=-1;
		boolean flag=true;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]=='X')
					continue;
				int tcnt=0;
				for(int k=0;k<4;k++) {
					int nx=i+dx[k];
					int ny=j+dy[k];
					if(isRange(nx, ny)) {
						if(map[nx][ny]=='.') {
							tcnt++;
						}
					}
				}
				if(tcnt<=1) {
					ans=0;
					flag=false;
					break;
				}
			}
			if(!flag)
				break;
		}
		if(flag)
			System.out.println(0);
		else
			System.out.println(1);
	}
	static boolean isRange(int x, int y) {
		return x>=0&&x<R&&y>=0&&y<C;
	}
}
