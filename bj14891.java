import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//4:20
//마주 닿는 곳
//1 => t[1][2]
//2 => t[2][6] t[2][2]
//3 => t[3][6] t[3][2]
//4 => t[4][6]
//(t[1][2],t[2][6]), (t[2][2],t[3][6]), (t[3][2], t[4][6])
//극이 같으면 회전 X, 극이 다르면 걔랑 반대로 돔
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int[][] t;
	public static void main(String[] args) throws IOException {
		StringTokenizer token;
		t=new int[5][8];
		for(int i=1;i<5;i++) {
			String num=br.readLine();
			for(int j=0;j<8;j++) {
				t[i][j]=num.charAt(j)-'0';
			}
		}
		int K=Integer.parseInt(br.readLine());
		for(int i=0;i<K;i++) {
			token=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(token.nextToken());
			int d=Integer.parseInt(token.nextToken());
			rotate(N, d);
		}
		int sum=0;
		if(t[1][0]==1)
			sum+=1;
		if(t[2][0]==1)
			sum+=2;
		if(t[3][0]==1)
			sum+=4;
		if(t[4][0]==1)
			sum+=8;
		System.out.println(sum);
	}
	static void swap(int n,int d) {
		if(d==1) {	//시계방향 배열 오른쪽으로 밀기
			int tmp=t[n][7];
			for(int i=6;i>=0;i--) {
				t[n][i+1]=t[n][i];
			}
			t[n][0]=tmp;
		}
		else {	//d==-1 반시계방향 배열 왼쪽으로 밀기
			int tmp=t[n][0];
			for(int i=0;i<7;i++) {
				t[n][i]=t[n][i+1];
			}
			t[n][7]=tmp;
		}
	}
	static void rotate(int n,int d) {
		//회전하는데 같은 극이면 같은방향으로 회전
		//true는 같은 극, false는 다른 극
		//처음에 돌리는 애랑 붙어있는 애는 같은 극이면 회전 X
		boolean flag1=true;
		boolean flag2=true;
		boolean flag3=true;
		if(t[1][2]!=t[2][6]) {
			flag1=false;
		}
		if(t[2][2]!=t[3][6]) {
			flag2=false;
		}
		if(t[3][2]!=t[4][6]) {
			flag3=false;
		}
		if(n==1) {
			if(!flag1) {
				swap(2, d*-1);
				int tmp=d*-1;
				if(!flag2) {
					swap(3, tmp*-1);
					tmp*=-1;
					if(!flag3) 
						swap(4, tmp*-1);
				}
			}
			swap(n, d);
		}
		else if(n==2) {
			if(!flag1)
				swap(1, d*-1);
			if(!flag2) {
				swap(3, d*-1);
				int tmp=d*-1;
				if(!flag3)
					swap(4, tmp*-1);
			}
			swap(n, d);
		}
		else if(n==3) {
			if(!flag2) {
				swap(2, d*-1);
				int tmp=d*-1;
				if(!flag1)
					swap(1, tmp*-1);
			}
			if(!flag3)
				swap(4, d*-1);
			swap(n, d);
		}
		else if(n==4) {
			if(!flag3) {
				swap(3, d*-1);
				int tmp=d*-1;
				if(!flag2) {
					swap(2, tmp*-1);
					tmp=tmp*-1;
					if(!flag1)
						swap(1, tmp*-1);
				}
			}
			swap(n, d);
		}
	}
}
