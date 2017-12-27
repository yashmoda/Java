import java.io.*;
import java.net.*;
      public class Client
         {
         public static void main(String args[])
              {
              String name=args[0];
              try{
              Socket s=new Socket("172.20.10.2",12000);
              BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
              PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
                          while(true)
                                {
                                String msg=br.readLine();
                                pw.println(name+" is: "+msg);
                                }
                                }catch(Exception ee)
                                   {
                                   ee.printStackTrace();
                                   }
                             }

                       }
