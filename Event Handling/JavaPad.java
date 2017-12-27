import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class JavaPad extends Frame implements ActionListener
{
	TextArea ta;
	Menu m;
	MenuBar mb;
	MenuItem mi1,mi2,mi3,mi4;
	Font f;
	public JavaPad(String title)
	{
		super(title);
		mb=new MenuBar();
		m=new Menu("File");
		mi1=new MenuItem("New");
		mi2=new MenuItem("Open");
		mi3=new MenuItem("Save");
		mi4=new MenuItem("Exit");
		mi1.addActionListener(this);
		mi2.addActionListener(this);
		mi3.addActionListener(this);
		mi4.addActionListener(this);
		m.add(mi1);
		m.add(mi2);
		m.add(mi3);
		m.addSeparator();
		m.add(mi4);
		mb.add(m);
		setMenuBar(mb);
		ta=new TextArea();
		add(ta);
		ta.setFont(new Font("Arial",Font.BOLD,20));
		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
		setSize(500,500);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==mi1)
		{
			ta.setText("");
		}
		else
		if(ae.getSource()==mi2)
		{
			try
			{
				FileDialog fd=new FileDialog(this,"Open",FileDialog.LOAD);
				fd.setVisible(true);
				String dir=fd.getDirectory();
				String fname=fd.getFile();
				FileInputStream fis=new FileInputStream(dir+fname);
				DataInputStream dis=new DataInputStream(fis);
				String str="",msg="";
				while((str=dis.readLine())!=null)
				{
					msg+=str;
					msg+="\n";
				}
				ta.setText(msg);
				fis.close();
				dis.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		if(ae.getSource()==mi3)
		{
			try
			{
				FileDialog fd=new FileDialog(this,"Save",FileDialog.SAVE);
				fd.setVisible(true);
				String txt=ta.getText();
				String dir=fd.getDirectory();
				String fname=fd.getFile();
				FileOutputStream fos=new FileOutputStream(dir+fname);
				DataOutputStream dos=new DataOutputStream(fos);
				dos.writeBytes(txt);
				dos.close();
				fos.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			System.exit(0);
		}
	}
	public static void main(String args[])
	{
		JavaPad j=new JavaPad("MyPad");
	}
}