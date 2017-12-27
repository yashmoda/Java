import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class ClientChat extends Frame implements Runnable,ActionListener
        {
        Button b;
        TextField tf;
        TextArea ta;
        Font f;
        //ServerSocket ss;
        Socket s;
        BufferedReader br;
        PrintWriter pw;
        Thread t;
        public ClientChat(String title)
                {
                super(title);
                setLayout(new FlowLayout());
                f=new Font("Arial",Font.BOLD,22);
                b=new Button("Chat");
                b.addActionListener(this);
                b.setFont(f);
                tf=new TextField(20);
                tf.setFont(f);
                ta=new TextArea(12,28);
                ta.setFont(f);
                ta.setEditable(false);
                add(tf);
                add(b);
                add(ta);
                try{
                s=new Socket("172.20.10.2",12999);
                br=new BufferedReader(new InputStreamReader(s.getInputStream()));
                pw=new PrintWriter(s.getOutputStream(),true);
                }catch(Exception ee)
                        {
                        }
                addWindowListener(new WindowAdapter()
                        {
                        public void windowClosing(WindowEvent we)
                                {
                                System.exit(0);
                                }
                        });
                setSize(350,300);
                setLocation(100,100);
                setVisible(true);
                t=new Thread(this);
                t.start();
                }
        public void actionPerformed(ActionEvent ae)
                {
                String text=tf.getText();
                pw.println(text);
                tf.setText("");
                }
        public void run()
                {
                while(true)
                        {
                        try{
                        String data=br.readLine();
                        ta.append(data+"\n");
                        }catch(Exception ee)
                                {
                                ee.printStackTrace();
                                }
                        }
                }
       public static void main(String args[])
                {
                ClientChat cc=new ClientChat("Client Side");
                }
       }






























































