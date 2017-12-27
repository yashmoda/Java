import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import java.applet.AudioClip;
/*<applet code="bird" width=1300 height=650></applet>*/
public class bird extends Applet implements Runnable
{
	Image i,ii,is,zz;
	int bpos,bspos;
	int a,b;
	Thread t,t1;
	Graphics g;
	public void init()
        {
		 t=new Thread(this);
		 t.start();

		 AudioClip ac=getAudioClip(getCodeBase(),"Birds 2.au");
		 ac.play();

		 i=getImage(getCodeBase(),"bird.gif");
		 ii=getImage(getCodeBase(),"back.jpg");
		 is=getImage(getCodeBase(),"birds.gif");
        }
  	public void paint(Graphics g)
       	{
         	g.drawImage(ii,0,0,this);
		g.drawImage(zz,0,0,this);

         	if(bpos>940)
                {
                	 sit(g);
                }
        	else{
                	g.drawImage(i,bpos,300,this);

        	}
         	g.drawImage(is,bspos,80,this);
         	g.drawImage(is,bspos+20,110,this);

        } 
   	public void sit(Graphics g)
        {
        	g.drawImage(i,965,340,this);
       	}
   	public void run()
        {
               
               for(bspos=0;bspos<getSize().width;bspos+=5)
                {
                          try
                          {
           	                t.sleep(100);
           	                bpos+=5;
   	   	          }catch(Exception e)
                  	  {}
        	          repaint();
                }
                if(bpos>940)
	        { 
			try
                      	{
                      		t.sleep(2000);
 		      		System.out.println("ih");
		                String str[]={"mspaint","sir.jpg"};
 		      		Runtime rr=Runtime.getRuntime();
                      		Process pp=rr.exec(str);
                      	}catch(Exception e)
                        {
	 		      System.out.println(e);
			}
            	}
            	while(true)
             	{
               		for(bspos=0;bspos<getSize().width;bspos+=7)
                        {
                          	try
                          	{
                           		t.sleep(100);
                          	}catch(Exception e)
                                {}
                          	repaint();
                        }
             }            
       }
}
          
