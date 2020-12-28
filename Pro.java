package application;

import javafx.scene.image.ImageView;

public class Pro {
private int ind;
	
	private ImageView ivex;
	private int g;
	private int star,xp1,xp2,xp3;
	private float cx;
	private DatTab r;private double gd;
	public Pro(ImageView az,int fd,int hg,DatTab qa,int in,double x, int x1, int x2, int x3, float ang)
	{this.setIvex(az);this.setG(fd);this.setStar(hg);this.setR(qa);
		this.setInd(in);
	this.setGd(x);	this.setCx(ang);
	this.setXp1(x1);this.setXp2(x2);this.setXp3(x3);}
	public int getG() {
		return g;
	}
	public void setG(int g) {
		this.g = g;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public ImageView getIvex() {
		return ivex;
	}
	public void setIvex(ImageView ivex) {
		this.ivex = ivex;
	}
	public DatTab getR() {
		return r;
	}
	public void setR(DatTab r) {
		this.r = r;
	}
	public int getInd() {
		return ind;
	}
	public void setInd(int ind) {
		this.ind = ind;
	}
	public double getGd() {
		return gd;
	}
	public void setGd(double gd) {
		this.gd = gd;
	}
	public int getXp1() {
		return xp1;
	}
	public void setXp1(int xp1) {
		this.xp1 = xp1;
	}
	public int getXp2() {
		return xp2;
	}
	public void setXp2(int xp2) {
		this.xp2 = xp2;
	}
	public int getXp3() {
		return xp3;
	}
	public void setXp3(int xp3) {
		this.xp3 = xp3;
	}
	public float getCx() {
		return cx;
	}
	public void setCx(float cx) {
		this.cx = cx;
	}
	
}
