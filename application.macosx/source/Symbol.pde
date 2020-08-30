class Symbol{
  
  int x;
  int y;
  char value;
  float speed;
  int symbolSize = 15;
  
  Symbol(int x, int y){
    this.x = x;
    this.y = y;
    value = char((int) random(0x30A0, 0x3100));
  }
  
  void show(int a){
    fill(0,255,100, a);
    
    text(value,x,y);
  }
  
  void changeValue(){
    int rand = (int)random(1,5);
    if(rand == 1){
      value = char((int) random(0x30A0, 0x3100));
    }
  }
  
  
}
