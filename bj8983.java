import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
public class bj8983{
       static BufferedReader br=new BufferedReader(new  InputStreamReader(System.in));
       static List<Hunt> hList;
       static List<Animal> aList;
       static int[] dx= {-1,1,0,0};
       static int[] dy= {0,0,-1,1};
       static int M;
       static int N;
       static long L;
       public static void main(String[] args) throws IOException {
              StringTokenizer token=new StringTokenizer(br.readLine());
              M=Integer.parseInt(token.nextToken());
              N=Integer.parseInt(token.nextToken());
              L=Long.parseLong(token.nextToken());
              long []hunt=new long[M];//사냥꾼 위치 저장
              token=new StringTokenizer(br.readLine());
              for(int i=0;i<M;i++) {
                     hunt[i]=Long.parseLong(token.nextToken());
                     
              }
              Arrays.sort(hunt);
              ans=0;
              aList=new ArrayList<>();//동물 위치 저장
              int hcnt=0;//현재 사냥하는 사냥꾼 위치
              for(int i=0;i<N;i++) {
                     token=new StringTokenizer(br.readLine());
                     long x=Long.parseLong(token.nextToken());
                     long y=Long.parseLong(token.nextToken());
                     aList.add(new Animal(x, y));
              }
              Collections.sort(aList, new Comparator<Animal>() {

				@Override
				public int compare(Animal o1, Animal o2) {
					return (int) (o1.x-o2.x);
				}
			});
              //동물의 위치를 기준으로 자기 바로 다음의 사대랑 그 전 사대에서 본인을 쏠 수 있는지 검사
              for(int i=0,j=0;i<aList.size();i++) {
            	  //j번째 사대가 i번째 동물보다 오른쪽에 올때까지 j를 증가시키시오
            	  while(j<M&&hunt[j]<aList.get(i).x) {
            		  j++;
            	  }
            	  boolean flag=false;
            	  //j-1 : 동물보다 왼쪽에 있는 사대
            	  //j-1번째 사대가 동물을 잡아 죽일 수 있는지 검사 ㄱ
            	  if(j>0&&dist(hunt[j-1], aList.get(i).x, aList.get(i).y)<=L) {
            		  flag=true;
            	  }
            	  //j : 동물과 같거나 오른쪽에 있는 사대
            	  //j번째 사대가 동물을 잡아죽일 수 있는지 검사 ㄱ
            	  if(j<M&&dist(hunt[j], aList.get(i).x, aList.get(i).y)<=L) {
            		  flag=true;
            	  }
            	  if(flag)
            		  ans++;
              }
              System.out.println(ans);
       }
       static int ans;
       static class Hunt {
              long x;
              long y;
              public Hunt(long x, long y) {
                     this.x=x;
                     this.y=y;
              }
              
       }
       static class Animal{
              long x;
              long y;
              public Animal(long x, long y) {
                     this.x=x;
                     this.y=y;
              }
              
       }
       static long dist(long x, long a, long b) {
    	   //x는 사대위치, a는 동물의 x좌표, b는 동물의 y좌표
    	   long dis=Math.abs(x-a)+b;
    	   return dis;
       }
              
}
