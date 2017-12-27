import java.io.*;
import java.net.*;
public class Readdemo
        {
        public static void main(String args[])
                {
                try{
                URL u=new URL("http://www.sify.com/index.html");
                System.out.println("\nRead the data from Sify site.\n");
                InputStream is=u.openStream();
                int ch;
                while((ch=is.read())!=-1)
                        {
                        System.out.print((char)ch);
                        }
                is.close();
                }catch(Exception ee)
                        {
                        ee.printStackTrace();
                        }
                }
                }




