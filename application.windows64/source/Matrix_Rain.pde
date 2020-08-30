int STREAMS_QUANTATY = 1300 / 15;

Stream[] streams = new Stream[STREAMS_QUANTATY];

void setup(){
  size(1300,700);
  surface.setTitle("Matrix rain");
  
  int x = 0;
  
  for(int i = 0; i < 1300 / 15; i++){
    streams[i] = new Stream( x, (int)random(0,500), (int)random(3,15) );
    x += 15;
  }
  
}

void draw(){
  background(0);
  
  for(int i = 0; i < streams.length; i++){
    streams[i].showStream();
  }
  
}
