package graph;

import java.util.Scanner;

public class Point {

	public static void main(String[] args) 
	{
		Scanner in=new Scanner (System.in);
		  //������
		getCube();
		
	}
		
	 public static Cube getCube ()  { 
		Scanner in=new Scanner (System.in);
		 System.out.print("cube��x=");
		 int x=in.nextInt();
		 int y=x;
		System.out.print("cube��width=");   //��ӡ�߳�Ϊ����
		 int width=in.nextInt();
		int  height=width;
		 Cube C=new  Cube();
		 C.SetCube(x,y, width, height);
		return C;
	}
	 public static Rectangle getRectangle ()  { 
		 Scanner in=new Scanner (System.in);
		 System.out.print("Rectangle��x=");   //��ӡ�߳�Ϊ����
		 int x=in.nextInt();
		 System.out.print("Rectangle��y=");
		 int y=in.nextInt();
		 System.out.print("Rectangle��width=");
		 int width=in.nextInt();
		 System.out.print("Rectangle��height=");
		 int height=in.nextInt();
		 Rectangle R=new  Rectangle();
		 R.SetRectangle(x,y,width,height);
		 return R;
		
}

	 public static Triangle getTriangle ()  { 
		 Scanner in=new Scanner (System.in);
		 int x1=0;
		 int x2=0;
		 int x3=0;
		 int y1=0;
		 int y2=0;
		 int y3=0;
		 int[] y = new int[3];
		 int[] x = new int[3];
		 int i=0;
		 int j=0;
		 for( i=0;i<3;i++) {
			 System.out.print("Triangle��3������x=");   //��ӡ�߳�Ϊ����
			 x[i]=in.nextInt();
		
		 }
		 x1 =x[0]; 
		 x2 =x[1];
		 x3 =x[2];			
		 for( j=0;j<3;j++) {
			 System.out.print("Triangle��3������y=");
			 y[j]=in.nextInt();
				
			 }
		 y1 =y[0]; 
		 y2 =y[1];
		 y3 =y[2];	
	/*	 for( i=0;i<3;i++) {
			 System.out.println(x[i]);		
			 }
		 for( j=0;j<3;j++) {
			 System.out.println(y[j]);		
			 }
			 */
		 Triangle T=new  Triangle();
		 T.SetTriangle( x1,  y1,  x2,  y2,  x3,  y3);
		 return T;
		
}
	 
	 
	 
	 
	 
	 
}
