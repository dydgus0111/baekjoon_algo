import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1260 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		StringTokenizer token=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(token.nextToken());
		int m=Integer.parseInt(token.nextToken());
		int v=Integer.parseInt(token.nextToken());
		
		int [][]arr=new int[n+1][n+1];
		for(int i=0;i<m;i++) {
			token=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(token.nextToken());
			int y=Integer.parseInt(token.nextToken());
			arr[x][y]=1;
			arr[y][x]=1;
		}
		dfs(arr,new boolean[n+1],v,0);
		System.out.println();
		bfs(arr,v);
	}
	static void dfs(int[][] arr,boolean[] visited,int v,int idx) {
		if(idx==visited.length) {
			return;
		}
		visited[v]=true;
		System.out.print(v+" ");
		for(int i=1;i<arr[v].length;i++) {
			if(!visited[i]&&arr[v][i]==1) {
				dfs(arr,visited,i,idx+1);
			}
		}
		
	}
	
	static void bfs(int[][] arr,int v) {
		Queue<Integer> queue=new LinkedList<Integer>();
		boolean[] check = new boolean[arr.length];
		queue.add(v);
		check[v]=true;
		while(!queue.isEmpty()) {
			int node=queue.poll();
			System.out.print(node+" ");
			for(int i=1;i<arr[node].length;i++) {
				if(!check[i]&&arr[node][i]==1) {
					queue.add(i);
					check[i]=true;
				}
			}
		}
	}
}
