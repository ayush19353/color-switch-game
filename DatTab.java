package application;
import javafx.scene.layout.Pane;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
public class DatTab implements Serializable {
private static final long serialVersionUID=42L;
private static int id=0;
private int gameId;
private int sco;
private double g2,g3,g4,g5; 
private int inde,rgg1,rgg2,rgg3;
private double coming;
private float angle;
public DatTab()
{id++;
setGameId(id);
	setSco(0);setG2(0);setG3(0);setG4(0);setG5(0);}

public void update(int x1,double a2,double a3,double a4,double a5, int gk, double gz, int rg1, int rg2, int rg3, float angle)
{setSco(x1);
this.setG2(a2);this.setG3(a3);this.setG4(a4);this.setG5(a5);this.setInde(gk);
this.setComing(gz);this.setAngle(angle);
this.setRgg1(rg1);this.setRgg2(rg2);this.setRgg3(rg3);}
public void saveGame(){
    Main.getDatabase().getdatafiles().add(this);
    try{
        Main.serialize();
    }
    catch (IOException e){
        //System.out.println("Cant close stream");
    }
}

public int getSco() {
	return sco;
}

public void setSco(int sco) {
	this.sco = sco;
}

public int getGameId() {
	return gameId;
}

public void setGameId(int gameId) {
	this.gameId = gameId;
}

public double getG3() {
	return g3;
}

public void setG3(double g3) {
	this.g3 = g3;
}

public double getG5() {
	return g5;
}

public void setG5(double g5) {
	this.g5 = g5;
}

public double getG2() {
	return g2;
}

public void setG2(double g2) {
	this.g2 = g2;
}

public double getG4() {
	return g4;
}

public void setG4(double g4) {
	this.g4 = g4;
}

public int getInde() {
	return inde;
}

public void setInde(int inde) {
	this.inde = inde;
}

public double getComing() {
	return coming;
}

public void setComing(double gz) {
	this.coming = gz;
}

public int getRgg1() {
	return rgg1;
}

public void setRgg1(int rgg1) {
	this.rgg1 = rgg1;
}

public int getRgg2() {
	return rgg2;
}

public void setRgg2(int rgg2) {
	this.rgg2 = rgg2;
}

public int getRgg3() {
	return rgg3;
}

public void setRgg3(int rgg3) {
	this.rgg3 = rgg3;
}

public float getAngle() {
	return angle;
}

public void setAngle(float angle) {
	this.angle = angle;
}}
