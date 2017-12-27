import java.awt.*;
import java.awt.event.*;
import java.applet.*;
/*<applet code = "Move" width=400 height=400></applet>*/
public class Move extends Applet implements KeyListener
{
    int x=100, y=100, width, height;
    public void init()
    {
        setBackground(Color.yellow);
        addKeyListener(this);
    }
    @Override
    public void keyReleased(KeyEvent ke)
    {}
    public void keyTyped(KeyEvent ke)
    {}
    public void keyPressed(KeyEvent ke)
    {
        width=getSize().width;
        height=getSize().height;
        int pos=ke.getKeyCode();
        if(pos==KeyEvent.VK_LEFT)
        {
            x-=20;
            if(x<0)
            {
                x=width-20;
            }
            repaint();
        }
        else if(pos==KeyEvent.VK_RIGHT)
        {
            x+=20;
            if(x>width)
            {
                x=1;
            }
            repaint();
        }
        else if(pos==KeyEvent.VK_UP)
        {
            y-=20;
            if(y<0)
            {
                y=height-20;
            }
            repaint();
        }
        else if(pos==KeyEvent.VK_DOWN)
        {
            y+=20;
            if(y>height)
            {
                y=1;
            }
            repaint();
        }
    }
    public void paint(Graphics g)
    {
        g.setColor(Color.red);
        g.fillOval(x, y, 70, 70);
    }
}

