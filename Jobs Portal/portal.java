import java.util.*;
import java.io.*;
import java.sql.*;
import java.net.*;
public class portal implements Serializable
{   
    private static final String url = "jdbc:mysql://localhost:3306/Portal";
    private static final String user = "root";
    private static final String password = "root"; 
    int ch,ch1,ch3,flag=0,flag1=0,d,e;
    char ch2,choice;  
    String ch4,ch5,ch6;
    Vector it=new Vector();
    HashMap<String,Integer> hit=new HashMap<>();
    Stack<Integer> wd=new Stack<Integer>();
    Stack<Integer> ad=new Stack<Integer>();
    Stack<Integer> ph=new Stack<Integer>();
    Stack<Integer> st=new Stack<Integer>();
    Stack<Integer> ta=new Stack<Integer>();
    Stack<Integer> jd=new Stack<Integer>();

    Vector cs=new Vector();
    HashMap<String,Integer> hcs=new HashMap<>();
    Stack<Integer> sa=new Stack<Integer>();
    Stack<Integer> pe=new Stack<Integer>();
    Stack<Integer> th=new Stack<Integer>();
    Stack<Integer> bm=new Stack<Integer>();
   
    Vector nv=new Vector();
    HashMap<String,Integer> hnv=new HashMap<>();
    Stack<Integer> ga=new Stack<Integer>();
    Stack<Integer> sade=new Stack<Integer>();
    Stack<Integer> sla=new Stack<Integer>();
    Stack<Integer> gpe=new Stack<Integer>();
    Stack<Integer> vgse=new Stack<Integer>();
  
     public static void main(String args[])
        { 	
		portal p=new portal();
		p.start();
        }    
         public void start()
	{
	   portal p1 = new portal();
	    try {               
                
                Socket s = new Socket("127.0.0.1",5000);               
                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
		DataInputStream dis=new DataInputStream(s.getInputStream());
		DataOutputStream dos=new DataOutputStream(s.getOutputStream());
                    
		String query=" ";
		Scanner in=new Scanner(System.in);
		Scanner sc=new Scanner(System.in);
		System.out.println("||============================== JOBS PORTAL ==============================||");
		System.out.println("1] Login [Existing User]");        	
		System.out.println("2] Sign-Up [New User]");		
        	System.out.println("Enter Your Choice:\n");
		ch3=in.nextInt();
		if(ch3==1)
		{
		  dos.writeInt(ch3);
		 try
		  {
		     do
		       {
			System.out.println("\nEnter your E-mail address:\n");
			ch4=in.next();
			dos.writeUTF(ch4);
			flag=dis.readInt();
			  if(flag==1)
			    {
				flag1=1;
			    }
			  else
			    {
				System.out.println("Incorrect E-mail Id\n");
				flag1=0;
			    }
		      }while(flag!=1);

		     do
		       {
			System.out.println("\nEnter your password:\n");
			ch5=in.next();
			dos.writeUTF(ch5);
			  flag=dis.readInt();
			  if(flag==1)
			    {
				flag1=1;
			    }
			  else
			    {
				System.out.println("Incorrect password\n");
				flag1=0;
			    }
		      }while(flag!=1);
			
		   System.out.println("\nLogged in successfully!\n");
		    
		  }catch(Exception e)
		    {
			System.out.println(e);
		    }
		 }
		else if(ch3==2)
		  {
		     try
		      {
			dos.writeInt(ch3);
			System.out.println("\nEnter your Full Name:\n");
			ch6=sc.nextLine();
			dos.writeUTF(ch6);
			
		      do
		       {
			System.out.println("\nEnter your E-mail address:\n");
			ch4=in.next();
			dos.writeUTF(ch4);
			flag=dis.readInt();
			  if(flag==1)
			    {		
				System.out.println("Email_Id already registered!");
				flag1=1;
			    }
			  else
			    {
				
				flag1=0;
			    }
		      }while(flag!=0);	
		  

			System.out.println("\nEnter your password:\n");
			ch5=in.next();
			dos.writeUTF(ch5);		        
			System.out.println("\nRegistered successfully!\n");
		      }catch(Exception e)
			{
			    System.out.println(e);
			}  
		}

                    p1.display();
                    p1.postsIt();
		    p1.postsCs();
		    p1.postsNv();
		    p1.ctcIt();
		    p1.ctcCs();
		    p1.ctcNv();
		    p1.vacanciesIt();
		    p1.vacanciesCs();
		    p1.vacanciesNv();
                    p1.apply();                    
                    oos.writeObject(p1);
                    dos.writeInt(p1.ch);
                    dos.writeInt(p1.ch1);
                    System.out.println("Thank-you for applying !");
                    s.close();
                }catch(Exception e)
               	{
                	    System.out.println(e);
              	}     
	}
     public void postsIt()
        {    		
         	it.add("1] Web Developer");
         	it.add("2] Android Developer");
         	it.add("3] Project Head");
         	it.add("4] Software Tester");
         	it.add("5] Technical Assistant");
         	it.add("6] Java Developer");
        }
     public void ctcIt()
	{		
		hit.put("Web Developer",4);
		hit.put("Android Developer",3);
		hit.put("Project Head",5);
		hit.put("Software Tester",3);
		hit.put("Technical Assistant",3);
		hit.put("Java Developer",4);
	}
    public void vacanciesIt()
        {
           	for(int i=1;i<6;i++)   //"Web Developer"
         	 {
         	    wd.push(i);
             }    
          	for(int i=1;i<5;i++)   //Android Developer
         	 {
         	    ad.push(i);
                 }
           	for(int i=1;i<4;i++)  //Project Head
         	 {
         	    ph.push(i);
              }      
           	for(int i=1;i<4;i++)   //Software Tester
         	 {
         	    st.push(i);
                 }     	
           	for(int i=1;i<3;i++)    //Technical Assistant
         	 {
         	    ta.push(i);
                 }     	
         	for(int i=1;i<4;i++)	//Java Developer
         	 {
         	    jd.push(i);
                 }
        }  
     
      public void postsCs()
        {
         	cs.add("1] System Administrator");
         	cs.add("2] Presales Engineer");
         	cs.add("3] Threat Hunter");
         	cs.add("4] Business Manager");
        }
     public void ctcCs()
	{
		hcs.put("System Administrator",4);
		hcs.put("Presales Engineer",3);
		hcs.put("Threat Hunter",5);
		hcs.put("Business Manager",4);
	}  
     public void vacanciesCs()
        {        	
         	for(int i=1;i<6;i++)   //"System Administrator";        
         	 {
         	    sa.push(i);
                 }
           	for(int i=1;i<5;i++)   //Presales Engineer
         	 {
         	    pe.push(i);
                 }
         	for(int i=1;i<4;i++)   //Threat Hunter
         	 {
         	    th.push(i);
                 }
            for(int i=1;i<4;i++)     //Business Manager
         	 {
         	    bm.push(i);
                 }
          }
     public void postsNv()
        {
         	nv.add("1] Graphics Architect");
         	nv.add("2] Senior ASIC Design Engineer");
         	nv.add("3] Senior LSF Administrator");
         	nv.add("4] GPU Profiling Engineer");
         	nv.add("5] VR Graphics Software Engineer");
        }
     public void ctcNv()
	{
		hnv.put("Graphics Architect",4);
		hnv.put("Senior ASIC Design Engineer",5);
		hnv.put("Senior LSF Administrator",6);
		hnv.put("GPU Profiling Engineer",6);
		hnv.put("VR Graphics Software Engineer",6);
	}
     public void vacanciesNv()
        {
			for(int i=1;i<6;i++)   //Graphics Architect;
         	 {
         	    ga.push(i);
                 }
			for(int i=1;i<5;i++)   //Senior ASIC Design Engineer
         	 {
         	    sade.push(i);
                 }
			for(int i=1;i<4;i++)    //Senior LSF Administrator
         	 {
         	    sla.push(i);
                 }
			for(int i=1;i<4;i++)    //GPU Profiling Engineer
         	 {
         	    gpe.push(i);
                 }
			for(int i=1;i<3;i++)   //VR Graphics Software Engineer
         	 {
         	    vgse.push(i);
                 }
         } 
  
     public void display()
        {
		System.out.println("||============================== JOBS PORTAL ==============================||");
        	System.out.println("||====== FIRMS ======||");
        	System.out.println("1)Infosys\n 2)CyberSecurity\n 3)Nvidia\n");
        }	       	
      
     public void apply()
    	 {
	      Scanner in=new Scanner(System.in);
    	      System.out.println("Choose the Firm you wish to apply for!");
           do{
              System.out.println("Enter 1)Infosys 2)CyberSecurity 3)Nvidia\n");
	      ch=in.nextInt();
	      if(ch==1)
   		{
		   System.out.println("|===Infosys===|");
		   System.out.println(it.get(0));
		   System.out.println(it.get(1));
		   System.out.println(it.get(2));
		   System.out.println(it.get(3));
		   System.out.println(it.get(4));
		   System.out.println(it.get(5));
			
		   System.out.println("Choose the Designation you wish to apply for!");
		   ch1=in.nextInt();
		      if(ch1==1)
			{
			  if(wd.isEmpty())
			   {
				System.out.println("No vacancies available for this post");
			   }
			  else
			   {
	          	   System.out.println("No. of Vacancies are: "+ wd.peek());
			   System.out.println("Package offered (LPA): "+ hit.get("Web Developer"));
			   System.out.println("Do you wish to continue?(Y/N)\n");
			   ch2=in.next().charAt(0);
				if(ch2=='Y'||ch2=='y')
				  {
					System.out.println("Applied for the post successfully!\n");
					wd.pop();
				  }
				else
				  {	
					System.out.println("Try for another designation!\n");
				  }
			   }
			  } 
			if(ch1==2)
			{
			  if(ad.isEmpty())
			   {
				System.out.println("No vacancies available for this post");
			   }
			  else
			   {
	          	   System.out.println("No. of Vacancies are: "+ ad.peek());
			   System.out.println("Package offered (LPA): "+ hit.get("Android Developer"));
			   System.out.println("Do you wish to continue?(Y/N)\n");
			   ch2=in.next().charAt(0);
				if(ch2=='Y'||ch2=='y')
				  {
					System.out.println("Applied for the post successfully!\n");
					ad.pop();
				  }
				else
				  {	
					System.out.println("Try for another designation!\n");
				  }
			   }
			}
		      if(ch1==3)
			{
			  if(ph.isEmpty())
			   {
				System.out.println("No vacancies available for this post");
			   }
			  else
			   {
	          	   System.out.println("No. of Vacancies are: "+ ph.peek());
			   System.out.println("Package offered (LPA): "+ hit.get("Project Head"));
			   System.out.println("Do you wish to continue?(Y/N)\n");
			   ch2=in.next().charAt(0);
				if(ch2=='Y'||ch2=='y')
				  {
					System.out.println("Applied for the post successfully!\n");
					ph.pop();
				  }
				else
				  {	
					System.out.println("Try for another designation!\n");
				  }
			  }
			}
		      if(ch1==4)
			{
			  if(st.isEmpty())
			   {
				System.out.println("No vacancies available for this post");
			   }
			  else
			   {
	          	   System.out.println("No. of Vacancies are: "+ st.peek());
			   System.out.println("Package offered (LPA): "+ hit.get("Software Tester"));
			   System.out.println("Do you wish to continue?(Y/N)\n");
			   ch2=in.next().charAt(0);
				if(ch2=='Y'||ch2=='y')
				  {
					System.out.println("Applied for the post successfully!\n");
					st.pop();
				  }
				else
				  {	
					System.out.println("Try for another designation!\n");
				  }
			  }
			}
		       if(ch1==5)
			{
			 if(ta.isEmpty())
			   {
				System.out.println("No vacancies available for this post");
			   }
			  else
			   {
	          	   System.out.println("No. of Vacancies are: "+ ta.peek());
			   System.out.println("Package offered (LPA): "+ hit.get("Technical Assistant"));
			   System.out.println("Do you wish to continue?(Y/N)\n");
			   ch2=in.next().charAt(0);
				if(ch2=='Y'||ch2=='y')
				  {
					System.out.println("Applied for the post successfully!\n");
					ta.pop();
				  }
				else
				  {	
					System.out.println("Try for another designation!\n");
				  }
			   }
			}
		        if(ch1==6)
			{
			 if(jd.isEmpty())
			   {
				System.out.println("No vacancies available for this post");
			   }
			  else
			   {
	          	   System.out.println("No. of Vacancies are: "+ jd.peek());
			   System.out.println("Package offered (LPA): "+ hit.get("Java Developer"));
			   System.out.println("Do you wish to continue?(Y/N)\n");
			   ch2=in.next().charAt(0);
				if(ch2=='Y'||ch2=='y')
				  {
					System.out.println("Applied for the post successfully!\n");
					jd.pop();
				  }
				else
				  {	
					System.out.println("Try for another designation!\n");
				  }
			  }
			}
 		  }
	        else if(ch==2)
		{
		   System.out.println("|===CyberSecurity===|");
		   System.out.println(cs.get(0));
		   System.out.println(cs.get(1));
		   System.out.println(cs.get(2));
		   System.out.println(cs.get(3));
		   
		   System.out.println("Choose the Designation you wish to apply for!");
		   ch1=in.nextInt();
		      if(ch1==1)
			{
			  if(sa.isEmpty())
			   {
				System.out.println("No vacancies available for this post");
			   }
			  else
			   {
	          	   System.out.println("No. of Vacancies are: "+ sa.peek());
			   System.out.println("Package offered (LPA): "+ hcs.get("System Administrator"));
			   System.out.println("Do you wish to continue?(Y/N)\n");
			   ch2=in.next().charAt(0);
				if(ch2=='Y'||ch2=='y')
				  {
					System.out.println("Applied for the post successfully!\n");
					sa.pop();
				  }
				else
				  {	
					System.out.println("Try for another designation!\n");
				  }
			  }
			}
		      if(ch1==2)
			{
			  if(pe.isEmpty())
			   {
				System.out.println("No vacancies available for this post");
			   }
			  else
			   {
	          	   System.out.println("No. of Vacancies are: "+ pe.peek());
			   System.out.println("Package offered (LPA): "+ hcs.get("Presales Engineer"));
			   System.out.println("Do you wish to continue?(Y/N)\n");
			   ch2=in.next().charAt(0);
				if(ch2=='Y'||ch2=='y')
				  {
					System.out.println("Applied for the post successfully!\n");
					pe.pop();
				  }
				else
				  {	
					System.out.println("Try for another designation!\n");
				  }
			  }
			}
		      if(ch1==3)
			{
			  if(th.isEmpty())
			   {
				System.out.println("No vacancies available for this post");
			   }
			  else
			   {
	          	   System.out.println("No. of Vacancies are: "+ th.peek());
			   System.out.println("Package offered (LPA): "+ hcs.get("Threat Hunter"));
			   System.out.println("Do you wish to continue?(Y/N)\n");
			   ch2=in.next().charAt(0);
				if(ch2=='Y'||ch2=='y')
				  {
					System.out.println("Applied for the post successfully!\n");
					th.pop();
				  }
				else
				  {	
					System.out.println("Try for another designation!\n");
				  }
			 }
			}
		      if(ch1==4)
			{
			  if(bm.isEmpty())
			   {
				System.out.println("No vacancies available for this post");
			   }
			  else
			   {
	          	   System.out.println("No. of Vacancies are: "+ bm.peek());
			   System.out.println("Package offered (LPA): "+ hcs.get("Business Manager"));
			   System.out.println("Do you wish to continue?(Y/N)\n");
			   ch2=in.next().charAt(0);
				if(ch2=='Y'||ch2=='y')
				  {
					System.out.println("Applied for the post successfully!\n");
					bm.pop();
				  }
				else
				  {	
					System.out.println("Try for another designation!\n");
				  }
			  }
			}
		}
	      else if(ch==3)
		{
		   System.out.println("|===Nvidia===|");
		   System.out.println(nv.get(0));
		   System.out.println(nv.get(1));
		   System.out.println(nv.get(2));
		   System.out.println(nv.get(3));
		   System.out.println(nv.get(4));
		
		   System.out.println("Choose the Designation you wish to apply for!");
		   ch1=in.nextInt();
		      if(ch1==1)
			{
			  if(ga.isEmpty())
			   {
				System.out.println("No vacancies available for this post");
			   }
			  else
			   {
	          	   System.out.println("No. of Vacancies are: "+ ga.peek());
			   System.out.println("Package offered (LPA): "+ hnv.get("Graphics Architect"));
			   System.out.println("Do you wish to continue?(Y/N)\n");
			   ch2=in.next().charAt(0);
				if(ch2=='Y'||ch2=='y')
				  {
					System.out.println("Applied for the post successfully!\n");
					ga.pop();
				  }
				else
				  {	
					System.out.println("Try for another designation!\n");
				  }
			  }
			}
		      if(ch1==2)
			{
			  if(sade.isEmpty())
			   {
				System.out.println("No vacancies available for this post");
			   }
			  else
			   {
	          	   System.out.println("No. of Vacancies are: "+ sade.peek());
			   System.out.println("Package offered (LPA): "+ hnv.get("Senior ASIC Design Engineer"));
			   System.out.println("Do you wish to continue?(Y/N)\n");
			   ch2=in.next().charAt(0);
				if(ch2=='Y'||ch2=='y')
				  {
					System.out.println("Applied for the post successfully!\n");
					sade.pop();
				  }
				else
				  {	
					System.out.println("Try for another designation!\n");
				  }
			  }
			}
		      if(ch1==3)
			{
			  if(sla.isEmpty())
			   {
				System.out.println("No vacancies available for this post");
			   }
			  else
			   {
	          	   System.out.println("No. of Vacancies are: "+ sla.peek());
			   System.out.println("Package offered (LPA): "+ hnv.get("Senior LSF Administrator"));
			   System.out.println("Do you wish to continue?(Y/N)\n");
			   ch2=in.next().charAt(0);
				if(ch2=='Y'||ch2=='y')
				  {
					System.out.println("Applied for the post successfully!\n");
					sla.pop();
				  }
				else
				  {	
					System.out.println("Try for another designation!\n");
				  }
			  }
			}
		      if(ch1==4)
			{
			  if(gpe.isEmpty())
			   {
				System.out.println("No vacancies available for this post");
			   }
			  else
			   {
	          	   System.out.println("No. of Vacancies are: "+ gpe.peek());
			   System.out.println("Package offered (LPA): "+ hnv.get("GPU Profiling Engineer"));
			   System.out.println("Do you wish to continue?(Y/N)\n");
			   ch2=in.next().charAt(0);
				if(ch2=='Y'||ch2=='y')
				  {
					System.out.println("Applied for the post successfully!\n");
					gpe.pop();
				  }
				else
				  {	
					System.out.println("Try for another designation!\n");
				  }
			  }
			}
		       if(ch1==5)
			{
			  if(vgse.isEmpty())
			   {
				System.out.println("No vacancies available for this post");
			   }
			  else
			   {
	          	   System.out.println("No. of Vacancies are: "+ vgse.peek());
			   System.out.println("Package offered (LPA): "+ hnv.get("VR Graphics Software Engineer"));
			   System.out.println("Do you wish to continue?(Y/N)\n");
			   ch2=in.next().charAt(0);
				if(ch2=='Y'||ch2=='y')
				  {
					System.out.println("Applied for the post successfully!\n");
					vgse.pop();
				  }
				else
				  {	
					System.out.println("Try for another designation!\n");
				  }
			   }
			}
		}
	      else 
		{
		  System.out.println("Try Again!");
    	        }
	 System.out.println("Do you wish to continue?(Y/N)\n");
         choice=in.next().charAt(0);	      
	}while(choice=='Y'||choice=='y');      
      }
     public void applyDisplay()
       {
	try{
	  //Socket s = new Socket("127.0.0.1",5000);
	  //DataOutputStream dos=new DataOutputStream(s.getOutputStream());
            //d=dis.readInt();
			//e=dis.readInt();
          System.out.println("Post chosen is "+ch+" -> "+ch1);
	}catch(Exception e)
	 {
		System.out.println(e);
	 }
       }
}
