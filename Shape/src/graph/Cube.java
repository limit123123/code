package graph;

import java.awt.Graphics;
public class Cube extends Shape { 

	private int x;
	private int y;
	private int width;
	private int height;
	void SetCube(int x, int y,int width,int height) {	
		this.x = x;
		this.width = width;
		this.y=y;
		this.height = height;
	}

	@Override
	public void draw(Graphics g) {
		g.drawRect(x,y, width,height);
	}

}