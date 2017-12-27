import java.io.*;
import java.net.*;
public class ThreadDemo extends Thread
{
	Socket s;
	public ThreadDemo(Socket s)
	{
	this.s=s;
	}
public void run()
{
String msg = null;
try{
BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
while((msg=br.readLine())!=null)
	{
	System.out.println("incoming Message from: "+msg);
	}
}catch(Exception ee)
{
ee.printStackTrace();
}
}
}
