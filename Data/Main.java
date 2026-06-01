import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.sql.*;

import java.net.InetSocketAddress;
import java.util.Map;

//For compiling on the shell on repl: Same on mac
//javac -cp sqlite-jdbc-3.23.1.jar: Main.java
//java -cp sqlite-jdbc-3.23.1.jar: Main

//Use for windows
//javac -cp sqlite-jdbc-3.23.1.jar; Main.java
class Main {

 public static void main(String[] args)throws IOException{
    (new Main()).init();
  }


  void print(Object o){ System.out.println(o);}
  void printt(Object o){ System.out.print(o);}

  void init() throws IOException{
   

    // create a port - our Gateway
    int port = 8000;
    int port2 = 8100;
      
    //create the HTTPserver object
    HttpServer server = HttpServer.create(new InetSocketAddress(port),0);
    HttpServer server_2 = HttpServer.create(new InetSocketAddress(port2),0);

    // create the database object
    Database db = new Database("jdbc:sqlite:Mcdonalds.db");

    
   // Add your  code here
    String sql = "SELECT * FROM foods";
    server.createContext("/", new RouteHandler("You are connected, but route not given or incorrect....") );
    server.createContext("/foods", new RouteHandler(db,sql));

    String sql2 = "SELECT * FROM foods2";
    server_2.createContext("/", new RouteHandler("You are connected, but route not given or incorrect....") );
    server_2.createContext("/foods2", new RouteHandler(db,sql2));

  
    //Start the server
    server.start();
    server_2.start();

    System.out.println("Server is listening on port "+port);
       
      
    }    
}
