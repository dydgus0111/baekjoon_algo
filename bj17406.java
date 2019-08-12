import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	//1. 배열 돌리기
    //swap이용해서 tmp랑 현재값 바꿔주기
	//(r-s, c-s) -> (r-s,c+s-1) 까지 y+1씩 이동, tmp는 (r-s,c+s)
	//tmp=>(r-s+1,c+s) -> (r+s-1,c+s) 까지 x+1씩 이동,tmp는 (r+s,c+s)
	//tmp=>(r+s,c+s-1) -> (r+s,c-s+1) 까지 y-1씩 이동, tmp는 (r+s,c-s)
	//tmp=>(r+s-1,c-s) -> (r-s+1,c-s) 까지 x-1씩 이동, tmp는 (r-s,c-s)
	//2. 연산 순서 순열 돌리기
	static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	static int N,M,K;
	static int map[][];
	static int copymap[][];
	static class rotate{
		int r,c,s;
		public rotate(int r, int c, int s) {
			this.r=r;
			this.c=c;
			this.s=s;
		}
	}
	static rotate rotateArr[];
	static int ans;
	public static void main(String[] args) throws IOException {
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		map=new int[N+1][M+1];
		copymap=new int[N+1][M+1];
		rotateArr=new rotate[K];
		ans=Integer.MAX_VALUE;
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<K;i++) {
			int r,c,s;
			st=new StringTokenizer(br.readLine());
			r=Integer.parseInt(st.nextToken());
			c=Integer.parseInt(st.nextToken());
			s=Integer.parseInt(st.nextToken());
			rotateArr[i]=new rotate(r, c, s);
		}
		permu(rotateArr, 0);
		System.out.println(ans);
	}
	static void print(int [][]map) {
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	static int swap(int a,int map[][],int r,int c) {
		int tmp=map[r][c];
		map[r][c]=a;
		a=tmp;
		return tmp;
	}
	static void rotateMap(int [][]map, rotate rotate) {
		//(r-s, c-s) -> (r-s,c+s-1) 까지 y+1씩 이동, tmp는 (r-s,c+s)
		//tmp=>(r-s+1,c+s) -> (r+s-1,c+s) 까지 x+1씩 이동,tmp는 (r+s,c+s)
		//tmp=>(r+s,c+s-1) -> (r+s,c-s+1) 까지 y-1씩 이동, tmp는 (r+s,c-s)
		//tmp=>(r+s-1,c-s) -> (r-s+1,c-s) 까지 x-1씩 이동, tmp는 (r-s,c-s)
		int r=rotate.r;
		int c=rotate.c;
		int s=rotate.s;
		int tmp=0;
		while(s>=0) {
			for(int i=c-s;i<c+s;i++) {
				if(i==c-s) {
					tmp=map[r-s][i+1];
					map[r-s][i+1]=map[r-s][i];
				}
				else {
					tmp=swap(tmp,map,r-s,i+1);
				}
			}
			for(int i=r-s;i<r+s;i++) {
				tmp=swap(tmp,map,i+1,c+s);
			}
			for(int i=c+s-1;i>=c-s;i--) {
				tmp=swap(tmp,map,r+s,i);
			}
			for(int i=r+s-1;i>=r-s;i--) {
				tmp=swap(tmp,map,i,c-s);
			}
			s--;
		}
	}
	static void permu(rotate[] arr,int idx) {
		if(idx==arr.length) {
			for(int i=0;i<=N;i++) {
				copymap[i]=Arrays.copyOf(map[i], map[i].length);
			}
			for(int i=0;i<arr.length;i++) {
				rotateMap(copymap, arr[i]);
			}
			rowSum(copymap);
			return;
		}
		for(int i=idx;i<arr.length;i++) {
			swapPermu(arr, i, idx);
			permu(arr, idx+1);
			swapPermu(arr, i, idx);
		}
	}
	static void swapPermu(rotate[] arr, int a, int b) {
		rotate tmp=arr[a];
		arr[a]=arr[b];
		arr[b]=tmp;
	}
	static void rowSum(int [][]map) {
		for(int i=1;i<=N;i++) {
			int sum=0;
			for(int j=1;j<=M;j++) {
				sum+=map[i][j];
			}
			if(sum<ans)
				ans=sum;
		}
	}
}
