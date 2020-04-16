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
	
	 public static Graphic initGL()          //添加图形对象，主要面对测试图形对象的初始化方法。 
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
	 public static void display(Graphic gra)         //绘制所有保存在Graphics类实例中图形的，
	 {
		 gra.draw();	  
	 }
	 public static void reshape()         //用来修改Graphics类实例中图形的区域属性值；
	 {
	   
		 
		 
	 }
}
	
	
	/*
	 public static void initGL()          //添加图形对象，主要面对测试图形对象的初始化方法。 
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
	 public static void display()         //绘制所有保存在Graphics类实例中图形的，
	 {
	
		
		 gra.draw();	  
	 }
	
	
	 
}
*/