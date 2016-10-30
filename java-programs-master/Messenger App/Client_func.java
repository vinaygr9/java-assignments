import java.io.*;
import java.net.*;
public class Client_func implements Runnable
{
            static Socket sock=null;
            static PrintStream out;
            static BufferedReader in=null;
            static BufferedReader uip=null;
            static boolean flag=false;
            public static void main(String[] args)
            {
                        int port=1234;
                               String host="localhost";
                        try
                        {
                                    sock=new Socket(host,port);
                                    uip=new BufferedReader(new InputStreamReader(System.in));
                                    out=new PrintStream(sock.getOutputStream());
                                    in=new BufferedReader(new InputStreamReader(sock.getInputStream()));
                        }
                        catch(Exception exception)
                        {
                                    System.err.println("oops! strange host"+host);
                        }
                        if(sock!=null)
                        {
                                    try
                                    {
                                                new Thread(new Client_func()).start();
                                                while(!flag)
                                                {
                                                out.println(uip.readLine());
                                                }
                                    out.close();
                                    in.close();
                                    sock.close();
                        }
                        catch(Exception exception1)
                        {
                                    System.err.println("Input Output Exception"+exception1);
                        }
            }
}
public void run()
{
String message;
try
{
while((message=in.readLine())!=null)
System.out.println(message);
flag=true;
}
catch(IOException exception)
{
System.err.println("Input Output Exception" + exception);
}
}
}
