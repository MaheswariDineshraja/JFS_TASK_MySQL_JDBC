package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC_Connectivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		// JDBC connection to testdb
		try(Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "root123456");) 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            if(connection!=null)
            {
                System.out.println("Connection Successfull!");
            }
            
            PreparedStatement preparedStatement=connection.prepareStatement("insert into employee  values (?,?,?,?)");
            
            //getting input from user
            System.out.println("Enter empcode:");
            preparedStatement.setInt(1, scanner.nextInt());
            scanner.nextLine();
            System.out.println("Enter empname:");
            preparedStatement.setString(2, scanner.nextLine());
          
            System.out.println("Enter emppage:");
            preparedStatement.setString(3, scanner.nextLine());
          
            System.out.println("Enter esalary:");
            preparedStatement.setString(4, scanner.nextLine());
            
            int afftectedRows=preparedStatement.executeUpdate();
            
            if(afftectedRows>0)
            {
                System.out.println("record inserted!!");
            }
            else
            {
                System.out.println("Problem in insertion!!");
            }
                    
        } 
        
        catch (ClassNotFoundException | SQLException e) {
            
               System.out.println(e.getMessage());

        }
        catch (Exception e) {
           System.out.println(e.getMessage());
        }

	}

}
