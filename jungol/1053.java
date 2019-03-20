import java.util.List;
import java.util.Scanner;

public class jungol1053 {
	static List<long[][]> list;
	static long unit[][]={{1,1},{1,0}};
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true) {
			long N=sc.nextLong();
			if(N==-1)
				break;
			long ans=0;
			if(N==0)
				ans=0;
			else if(N==1)
				ans=1;
			else {
				long temp[][]=fibo(N);
				ans=temp[0][1]%10000;
			}
			System.out.println(ans);
		}
	}
	static long[][] fibo(long n) {
		if(n==1)
			return unit;
		else {
			long[][] res=fibo(n/2);
			res=mat(res,res);
			if(n%2==0)
				return res;
			else
				return mat(res,unit);
		}
	}
	static long[][] mat(long[][] arr2,long[][] unit){
		long arr[][]=new long[2][2];
		arr[0][0]=(arr2[0][0]*unit[0][0]+arr2[0][1]*unit[1][0])%10000;
		arr[0][1]=(arr2[0][0]*unit[0][1]+arr2[0][1]*unit[1][1])%10000;
		arr[1][0]=(arr2[1][0]*unit[0][0]+arr2[1][1]*unit[1][0])%10000;
		arr[1][1]=(arr2[1][0]*unit[0][1]+arr2[1][1]*unit[1][1])%10000;
		return arr;
	}
}