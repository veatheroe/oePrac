package s.oe.algorethem;

import java.util.ArrayList;
import java.util.List;


public class KLalgorithm {
	static int[][] matrix ={{0,1,0,0,0,0,4,0,2,0},{1,0,3,0,0,0,0,0,0,0},{0,3,0,0,0,0,0,2,0,1},{0,0,0,0,0,2,0,5,6,0},
						 {0,0,0,0,0,0,0,3,7,8},{0,0,0,2,0,0,1,0,0,0},{1,0,0,0,0,1,0,0,0,0},{0,0,3,5,3,0,0,0,0,0},
						 {2,0,0,6,7,0,0,0,0,0},{0,0,1,0,8,0,0,0,0,0}};
	static int sum(int i,String s,int[] A,int[] B){
		int sum =0;
		if(s.equals("ea")){
			for(int j=0;j<5;j++)
				sum+=matrix[A[i]][B[j]];
			return sum;
		}else if (s.equals("ia")) {
			for(int j=0;j<5;j++)
				sum+=matrix[A[i]][A[j]];
			return sum;			
		}else if (s.equals("eb")) {
			for(int j=0;j<5;j++)
				sum+=matrix[B[i]][A[j]];
			return sum;			
		}else {
			for(int j=0;j<5;j++)
				sum+=matrix[B[i]][B[j]];
			return sum;			
		}
	}
	static int[]  findMax(int[] A,int[] B,List list){
		int gain = 0,key=0;
		int[][] max = new int[100][3];
		int[] neg = {0,0,0};
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				if(list.contains(A[i])||list.contains(B[j]))
					continue;
				gain = sum(i, "ea",A,B)-sum(i,"ia",A,B)+sum(j, "eb",A,B)-sum(j, "ib",A,B)-2*matrix[A[i]][B[j]];
				max[key][0] = i;max[key][1] = j;max[key][2] = gain;key++;
			}
		}
		neg[0] = max[0][0];neg[1] = max[0][1];neg[2] = max[0][2];
		for(int i=0;i<key;i++){
			System.out.println(max[i][0]+"~~~~"+max[i][1]+"~~~~~"+max[i][2]);
		}
		if(max!=null){
			for(int i=0;i<key;i++){
				if(max[i][2]>neg[2]){
					neg[0] = max[i][0];
					neg[1] = max[i][1];
					neg[2] = max[i][2];
				}
			}
		}
		list.add(A[neg[0]]);
		list.add(B[neg[1]]);
		System.out.println("替换T"+(A[neg[0]]+1)+"和T"+(B[neg[1]]+1));
		return neg;

		
	}
	static void exchange(int[] A,int[] B,int i,int j){
		int m=0,n=0;
		for(;m<5;m++)
			if(A[m]==i)
				break;
		for(;n<5;n++){
			if(B[n]==j)
				break;
		}
		A[m]=j;B[n]=i;
		
	}
	public static void main(String[] args) {
		ArrayList<Integer> hasChanged = new ArrayList<Integer>();
		int[] A = {0,1,2,3,4};
		int[] B = {5,6,7,8,9};
		while(hasChanged.size()<10){
			int[] max = findMax(A,B,hasChanged);
			exchange(A, B, A[max[0]], B[max[1]]);
			System.out.println("-------------------------进行第"+hasChanged.size()/2+"次分组-----------------------------");
			System.out.println("分组后第一组任务为：T"+(A[0]+1)+",T"+(A[1]+1)+",T"+(A[2]+1)+",T"+(A[3]+1)+",T"+(A[4]+1)+".");
			System.out.println("分组后第二组任务为：T"+(B[0]+1)+",T"+(B[1]+1)+",T"+(B[2]+1)+",T"+(B[3]+1)+",T"+(B[4]+1)+".");
		}
	}

}
