import java.io.*;
import java.net.*;
public class Server_func
{
      static ServerSocket Server_func=null;
      static sock sock=null;
      static  ClientThread_func th[]=new  ClientThread_func[10];
      public static void main(String args[])
      {
            int port=1234;
            System.out.println("Server Running......");
            System.out.println("[please Press Ctrl C to terminate ]");
            try
            {
                  Server_func=new ServerSocket (port);
            }
            catch(IOException exception)
            {
                  System.out.println("Exception for in/out");
            }
            while(true)
            {
                  try
                  {
                        sock=Server_func.accept();
                        for(int i=0;i<=9;i++)
                        {
                              if(th[i]==null)
                              {
                                    (th[i]=new  ClientThread_func(sock,th)).start();
                                    break;
                              }
                        }
                        }
                        catch(IOException exception)
                        {
                              System.out.println("Exception for in/out");
                        }
                  }
            }
      }

      class  ClientThread_func extends Thread
      {
            BufferedReader in=null;
            PrintStream out=null;
            sock sock=null;
             ClientThread_func th[];
            public  ClientThread_func(sock sock, ClientThread_func[] th)
            {
                  this.sock=sock;
                  this.th=th;
            }
            public void run()
            {
                  String message;
                  String usr_name;
                  try
                  {
                        in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
                        out = new PrintStream(sock.getOutputStream());
                        out.println("What is your Name?Enter it-");
                        usr_name = in.readLine();
                        out.println(usr_name + ":Welcome to chit chat room.");
                        out.println("To leave chit chat room type $$");
                        for (int i = 0; i <= 9; i++)
                              if (th[i] != null && th[i] != this)
                                    th[i].out.println("------------A new user arrived in chit chat Room:" + usr_name);
                              while (true)
                              {
                                    message = in.readLine();
                                    if (message.startsWith("$$"))
                                          break;
                                    for (int i = 0; i <= 9; i++)
                                          if (th[i] != null)
                                                th[i].out.println("<" + usr_name + ">" + message);
                              }
                              for (int k = 0; k <= 9; k++)
                                    if (th[k] != null && th[k] != this)
                                          th[k].out.println("------A user Leaving chit chat Room:" + usr_name + "--------");
                              out.println("please Press Ctrl C to return to prompt---");
                              for (int j = 0; j <= 9; j++)
                                    if (th[j] == this)
                                          th[j] = null;
                              in.close();
                              out.close();
                              sock.close();
                  }
                  catch (IOException exception)
                  {
                        System.out.println("Exception for in/out");
                  }
                  }
            }
