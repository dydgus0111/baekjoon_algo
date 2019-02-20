package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj7576 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		StringTokenizer token=new StringTokenizer(br.readLine());
		m=Integer.parseInt(token.nextToken());
		n=Integer.parseInt(token.nextToken());
		int [][]arr=new int[n][m];
		List<Integer> tx=new ArrayList<Integer>();
		List<Integer> ty=new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			token=new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++){
				arr[i][j]=Integer.parseInt(token.nextToken());
				if(arr[i][j]==1) {	//처음에 익은 토마토의 위치를 저장하는 list만들기
					tx.add(i);
					ty.add(j);
				}
			}
		}
		bfs(arr,tx,ty);
		boolean flag=true;
		for(int i=0;i<n;i++) {	//토마토가 다 익었는지 확인.
			for(int j=0;j<m;j++){
				if(arr[i][j]==0)	//안익은게 하나라도 있으면 flag false로
					flag&=false;
			}
		}
		if(!flag)
			System.out.println("-1");
		else
			System.out.println(ans);
	}
	static int m=0;
	static int n=0;
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,1,-1};
	static int ans=0;
	static class Pair{
		int x;
		int y;
		int cnt;
		Pair(int x,int y,int cnt){
			this.x=x;
			this.y=y;
			this.cnt=cnt;
		}
	}
	static void bfs(int[][] arr,List<Integer> tx, List<Integer> ty) {
		Queue<Pair> queue=new LinkedList<>();
		boolean[][]check=new boolean[n][m];
		for(int i=0;i<tx.size();i++) {
			queue.add(new Pair(tx.get(i),ty.get(i),1));
			check[tx.get(i)][ty.get(i)]=true;			
		}
		Pair pair = null;
		while(!queue.isEmpty()) {
			pair=queue.poll();
			for(int i=0;i<4;i++) {	//상하좌우로 이동
				int nx=pair.x+dx[i];
				int ny=pair.y+dy[i];
				if(nx>=0&&nx<n&&ny>=0&&ny<m) {
					if(arr[nx][ny]==0&&!check[nx][ny]) {
						queue.add(new Pair(nx,ny,pair.cnt+1));	//조건을 만족 하면 다음 위치로 이동하고 해당 칸에는 횟수 +1
						check[nx][ny]=true;
						arr[nx][ny]=pair.cnt;
					}
				}
			}
		}
		ans=pair.cnt-1;
	}
}