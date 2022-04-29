package ArcadeProject;

import java.sql.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView; 

public class ArcadeDB {
   private static Connection con = null;
   
   public static void Connect()
   {
      try {
         con = DriverManager.getConnection(
                "jdbc:sqlserver://csa-sql\\MSSQLSERVER;" +
                "user=JavaUser;password=JavaUser1;" +
                "database=Morse_Arcade");
      } catch (Exception e)
      {
          System.err.println("Exception: " + e.getMessage());
      }
   }  
   
   public static ResultSet Query(String query)
   {
      ResultSet table = null;
      try {
         Statement sqlStatement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_UPDATABLE);

         ResultSet recordSet = sqlStatement.executeQuery(query);
         table = recordSet;
      } catch (Exception e)
      {
         System.err.println("Exception: " + e.getMessage());
      }
      
      return table;
   }
   
   public static ResultSet Execute(String name, String... args)
   {
      ResultSet rs = null;
      String argFormat = "";
      for (String s : args)
      {
         argFormat += "?, ";
      }
      
      argFormat = argFormat.substring(0, argFormat.length()-2);
      
      CallableStatement cs = null;
      
      try {
      cs = con.prepareCall("{call " + name + "(" +argFormat + ")}");
      
      int i = 1;
      for (String s : args)
      {
         cs.setString(i, s);
         i++;
      }
      
      rs = cs.executeQuery();
      return rs;
      } catch (Exception e)
      {System.err.println("Exception in Calling Stored Procedure: " + e.getMessage());}
      
      return rs;
   }
   
   public static String getProductImage(String productID)
   {
      String link = "";
      try {
        ResultSet product = ArcadeDB.Execute("GetProductDetailed", productID);
        product.next();
        link = product.getString("Link");
      } catch (Exception e) {
      
      }
      
      if (!link.equals("")) {
         Image image = new Image(link);
         //ImageView imageView = new ImageView(image);
         return link;
      } else {
         return null;
      }
   }
   
   public static void Close()
   {
      try {
      con.close();
      }
      catch (Exception e){}
     }
}