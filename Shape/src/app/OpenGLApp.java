package app;
import graph.Cube;
import graph.Graphic;
import graph.Point;
import graph.Rectangle;
import graph.Triangle;

public class OpenGLApp {
	public static void main(String[] args) 
	{
		
		Graphic gra = initGL(); 
		display(gra);
		reshape();

	}
	
	 public static Graphic initGL()          //���ͼ�ζ�����Ҫ��Բ���ͼ�ζ���ĳ�ʼ�������� 
	 {
		 
	//	 Point.getRectangle();
	//	 Point.getTriangle();
	//	 Point.getCube();
		 Graphic gra = new Graphic(400,600);
		 Rectangle r = Point.getRectangle();
		 Triangle t =Point.getTriangle();
		 Cube c = Point.getCube();
		 gra.add(r);
		 gra.add(t);
		 gra.add(c);
         display(gra);
         return gra;
	 }
	 public static void display(Graphic gra)         //�������б�����Graphics��ʵ����ͼ�εģ�
	 {
		 gra.draw();	  
	 }
	 public static void reshape()         //�����޸�Graphics��ʵ����ͼ�ε���������ֵ��
	 {
	   
		 
		 
	 }
}
	
	
	/*
	 public static void initGL()          //���ͼ�ζ�����Ҫ��Բ���ͼ�ζ���ĳ�ʼ�������� 
	 {
		 
	//	 Point.getRectangle();
	//	 Point.getTriangle();
	//	 Point.getCube();
		 Graphic gra = new Graphic(400,600);
		 Rectangle r = Point.getRectangle();
		 Triangle t =Point.getTriangle();
		 Cube c = Point.getCube();
		 gra.add(r);
		 gra.add(t);
		 gra.add(c);
	 }
	 public static void display()         //�������б�����Graphics��ʵ����ͼ�εģ�
	 {
	
		
		 gra.draw();	  
	 }
	
	
	 
}
*/