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
  
  int getX(){
   return x;
  }
  
  
  void showStream(){
    
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
