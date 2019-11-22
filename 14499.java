import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int map[][];
	static int N;
	static int M;
	static int K;
	static int dice[]= {0,0,0,0,0,0};//위, 상, 하 , 좌, 우 , 바닥
	static int dx[]= {0,0,0,-1,1};//1동,2서,3북,4남
	static int dy[]= {0,1,-1,0,0};
	static int cx;
	static int cy;
	public static void main(String[] args) throws IOException {
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		cx=Integer.parseInt(st.nextToken());
		cy=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				int num=Integer.parseInt(st.nextToken());
				map[i][j]=num;
			}
		}
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<K;i++) {
			int op=Integer.parseInt(st.nextToken());
			boolean flag=false;
			flag=move(flag,op);
			if(flag) {
				if(map[cx][cy]==0) {
					map[cx][cy]=dice[5];
					System.out.println(dice[0]);
				}
				else {
					dice[5]=map[cx][cy];
					map[cx][cy]=0;
					System.out.println(dice[0]);
				}
			}
		}
	}
	static boolean isRange(int x, int y) {
		return x>=0&&x<N&&y>=0&&y<M;
	}
	static boolean move(boolean flag,int op) {
		if(op==1) {
			if(isRange(cx+dx[op], cy+dy[op])) {
				int tmp=dice[0];
				dice[0]=dice[4];
				dice[4]=dice[5];
				dice[5]=dice[3];
				dice[3]=tmp;
				cx=cx+dx[op];
				cy=cy+dy[op];
				flag=true;
			}
		}
		else if(op==2) {
			if(isRange(cx+dx[op], cy+dy[op])) {
				int tmp=dice[0];
				dice[0]=dice[3];
				dice[3]=dice[5];
				dice[5]=dice[4];
				dice[4]=tmp;
				cx=cx+dx[op];
				cy=cy+dy[op];
				flag=true;
			}
		}
		else if(op==3) {
			if(isRange(cx+dx[op], cy+dy[op])) {
				int tmp=dice[0];
				dice[0]=dice[2];
				dice[2]=dice[5];
				dice[5]=dice[1];
				dice[1]=tmp;
				cx=cx+dx[op];
				cy=cy+dy[op];
				flag=true;
			}
		}
		else if(op==4) {
			if(isRange(cx+dx[op], cy+dy[op])) {
				int tmp=dice[0];
				dice[0]=dice[1];
				dice[1]=dice[5];
				dice[5]=dice[2];
				dice[2]=tmp;
				cx=cx+dx[op];
				cy=cy+dy[op];
				flag=true;
			}
		}
		return flag;
	}
}
