import java.io.*;
import java.net.*;

public class Server
{
ServerSocket ss;
Socket s;
public static void main (String args[])
	{
	new Server().call();
	}
public void call()
{
try{
ss=new ServerSocket(12000);
System.out.println("Server is ready");
while(true)
{
s=ss.accept();
new ThreadDemo(s).start();
}
}catch(Exception ee)
{}
}
}
