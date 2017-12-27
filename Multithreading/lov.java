import java.applet.Applet;
import java.awt.Component;
import java.awt.Color;
import java.applet.AudioClip;
import java.awt.Graphics;
/*<applet code="lov" width=1350 height=1350>
</applet>*/

public class lov extends Applet implements Runnable,AudioClip
{
Thread t;int x1=5,x2=5;
int count=0;AudioClip au,au1;
public void init()
{
setBackground(Color.cyan);au=getAudioClip(getCodeBase(),"a.au");
au1=getAudioClip(getCodeBase(),"aa.au");
}

public void start()
{
t=new Thread(this);
t.start();au1.play();
}
public void stop()
{
t.stop();
t=null;
}
public void run()
{
while(true)
{
count++;


repaint();
try{x1+=5;x2+=5;
Thread.sleep(100);
}catch(InterruptedException ie)
{
}
}
}



public void paint(Graphics g)
{if(count<=115){
g.setColor(Color.white);

g.fillOval(100+x1,200,66,66);
g.setColor(Color.black);

g.fillOval(148+x1,214,10,10);


//shoulders
g.drawLine(133+x1,265,133+x1,370);
g.drawLine(120+x1,290,146+x1,290);

//arms
g.drawLine(133+x1,290,100+x1,352);
g.drawLine(133+x1,315,100+x1,352);

//rose

g.drawLine(100+x1,342,100+x1,368);
//g.fillOval(148,214,10,10);

//west
g.drawLine(120+x1,370,146+x1,370);

//legs

g.drawLine(133+x1,370,104+x1,470);
g.drawLine(133+x1,370,162+x1,470);

//paws

g.drawLine(104+x1,470,124+x1,468);
g.drawLine(162+x1,470,182+x1,468);}

//drawing the girl

g.setColor(Color.white);



g.fillOval(800,200,66,66);
g.setColor(Color.black);

g.fillOval(810,214,10,10);


//shoulders
g.drawLine(833,265,833,370);
g.drawLine(820,290,846,290);



//west
g.drawLine(820,370,846,370);
//legs
g.drawLine(833,370,833,470);

//paws
g.drawLine(833,470,812,470);



//boy on knees
if(count==115){au1.stop();au.play();}
if(count>115){
g.setColor(Color.white);

g.fillOval(700,260,66,66);
g.setColor(Color.black);

g.fillOval(748,274,10,10);


//shoulders
g.drawLine(733,325,733,430);
g.drawLine(720,350,746,350);

//arms
g.drawLine(733,350,800,352);
g.drawLine(733,375,800,352);



//west
g.drawLine(720,430,746,430);

//legs

g.drawLine(733,430,733,470);
g.drawLine(674,470,733,470);


}
}public void loop()
{} public void play(){}
}


















