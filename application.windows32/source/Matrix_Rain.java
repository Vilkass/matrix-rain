import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Matrix_Rain extends PApplet {

int STREAMS_QUANTATY = 1300 / 15;

Stream[] streams = new Stream[STREAMS_QUANTATY];

public void setup(){
  
  surface.setTitle("Matrix rain");
  
  int x = 0;
  
  for(int i = 0; i < 1300 / 15; i++){
    streams[i] = new Stream( x, (int)random(0,500), (int)random(3,15) );
    x += 15;
  }
  
}

public void draw(){
  background(0);
  
  for(int i = 0; i < streams.length; i++){
    streams[i].showStream();
  }
  
}
class Stream{
  Symbol[] symbols;
  int streamSpeed = (int)random(1,10);
  int x;
  Stream(int x, int y, int n){
    //int n = 10;
    symbols = new Symbol[n];
    this.x = x;
    
    for(int i = 0; i < n; i++){
      symbols[i] = new Symbol(x, y);
      y += symbols[i].symbolSize;
    }
    
  }
  
  public int getX(){
   return x;
  }
  
  
  public void showStream(){
    
    for(int i = 0; i < symbols.length; i++){
      symbols[i].show(200);
      symbols[i].changeValue();
      symbols[i].y+= streamSpeed;
      if(symbols[i].y >= 700){
        symbols[i].y = 0;
      }
      if(i == symbols.length-1){
        symbols[i].show(500);
      }
    
    
    }
    
  }
  
  
  
  
}
class Symbol{
  
  int x;
  int y;
  char value;
  float speed;
  int symbolSize = 15;
  
  Symbol(int x, int y){
    this.x = x;
    this.y = y;
    value = PApplet.parseChar((int) random(0x30A0, 0x3100));
  }
  
  public void show(int a){
    fill(0,255,100, a);
    
    text(value,x,y);
  }
  
  public void changeValue(){
    int rand = (int)random(1,5);
    if(rand == 1){
      value = PApplet.parseChar((int) random(0x30A0, 0x3100));
    }
  }
  
  
}
  public void settings() {  size(1300,700); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Matrix_Rain" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
