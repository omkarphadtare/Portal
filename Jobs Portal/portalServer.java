import java.io.*;
import java.util.*;
import java.net.*;
import java.sql.*;

class portalServer
{
  public static void main(String[] args)
    {
       connector c=new connector();
       c.start();
    }
}

class connector extends Thread
{
    private static final String url = "jdbc:mysql://localhost:3306/Portal";
    private static final String user = "root";
    private static final String password = "root"; 
    String a,b,c,j,k,query="";
    int d,e;
    ServerSocket ss;
    connector()
      { 
         try{
          ss=new ServerSocket(5000);
          System.out.println("Server created! Waiting for client...");
            }
         catch(Exception e)
           {
              System.out.println(e);
           }
      }
    
    public void run()
      {
          while(true)
            {  
               try{
                 Socket s = new Socket();                
                 s = ss.accept();
                 
                 portal p1 = new portal();
            	 System.out.println("\nNew Client Connected!");
                  
                    ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                    ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
		    DataInputStream dis=new DataInputStream(s.getInputStream());
		    DataOutputStream dos=new DataOutputStream(s.getOutputStream());
		    java.util.Date date=new java.util.Date();
	            java.sql.Timestamp sqlTime=new java.sql.Timestamp(date.getTime());
		    int i=dis.readInt();
			if(i==1)
			{
			  try
			  {
		    		Class.forName("com.mysql.jdbc.Driver");
		    		Connection con=DriverManager.getConnection(url,user,password);
		    		Statement stmt=con.createStatement();
			  	int flag=0;
			  	do
			   	{
				a=dis.readUTF();
				query="select * from SignUp where Email_Id='"+a+"'";
				ResultSet rs=stmt.executeQuery(query);
				if(rs.absolute(1))
			   	 {
					flag=1;
					dos.writeInt(flag);
			   	 }
				else
			  	  {
					flag=0;
					dos.writeInt(flag);
			    	  }
			  	 }while(flag!=1);

			 	do
			   	{
				j=dis.readUTF();
				query="select * from SignUp where Email_Id='"+a+"' and Password='"+j+"'";
				ResultSet rs=stmt.executeQuery(query);
				if(rs.absolute(1))
				    {
					flag=1;
					dos.writeInt(flag);
				    }
				 else
				    {
					flag=0;
					dos.writeInt(flag);
			    	   }
			   	 }while(flag!=1);
					
					
                		p1 =(portal)ois.readObject();
				p1.applyDisplay();
               			d = dis.readInt();
                		e = dis.readInt();
				stmt.execute("insert into LogIn values('"+c+"','"+k+"','"+sqlTime+"',"+d+","+e+");");
				System.out.println("Values added to the database");
			  }catch(Exception e)
				{
					System.out.println(e);
				}
			}
		

			else if(i==2)
			 {
			    try
			     {
		    		Class.forName("com.mysql.jdbc.Driver");
		    		Connection con=DriverManager.getConnection(url,user,password);
		    		Statement stmt=con.createStatement();
			  	int flag=0;

				b=(String)dis.readUTF();
						  	
				do
			   	{
				c=(String)dis.readUTF();
				query="select * from SignUp where Email_Id='"+c+"'";
				ResultSet rs=stmt.executeQuery(query);
				if(rs.absolute(1))
			    	 {		
					flag=1;
					dos.writeInt(flag);
				 }
				else
			   	 {
					flag=0;
					dos.writeInt(flag);	
			    	 }
		      		}while(flag!=0);

				
				k=dis.readUTF();
				stmt.execute("insert into SignUp values('"+b+"','"+c+"','"+k+"','"+sqlTime+"');");

				p1 =(portal)ois.readObject();        
				p1.applyDisplay();
				d=dis.readInt();
				e=dis.readInt();
      				stmt.execute("insert into LogIn values('"+c+"','"+k+"','"+sqlTime+"',"+d+","+e+");");
				System.out.println("Values added to the database");      
	           	}catch(Exception e)
                 	{
                 	  System.out.println(e);
                 	}
		     }
				
		    		           
               }catch(Exception e)
                 	{
                 	  System.out.println(e);
                 	}
    	 }
     }
}   
