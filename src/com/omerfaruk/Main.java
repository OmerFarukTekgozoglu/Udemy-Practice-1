package com.omerfaruk;
import java.util.Scanner;
import java.sql.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your name:\t ");
        String name = scan.nextLine();
        System.out.println();
        System.out.print("Enter your last name:\t ");
        String lastname = scan.nextLine();
        Email em1 = new Email(name, lastname);

        Connection myConn = null;
        ResultSet myRs = null;
        Statement myStt = null;

        String dbURL = "jdbc:mysql://localhost:3306/users?useSSL=false";
        String dbUser = "udemy";
        String dbPassword = "udemy";

        try{

            myConn = DriverManager.getConnection(dbURL,dbUser,dbPassword);
            myStt = myConn.createStatement();

            System.out.println("Database connection is successful.");

            myRs = myStt.executeQuery("insert into employees"+
            "(first_name,last_name,department,salary,email,password,alternateMail)"+
            "values " +
            "('"+em1.getFirtsName()+"'"+","+"'"+em1.getLastName()+"'"+","+"'"+em1.getDepartment()+
                    "'"+","+"'"+em1.getSalary()+"'"+","+"'"+em1.getEmail()+"'"+","+"'"+ em1.getPassword()+
                    "'"+","+"'"+em1.getAlternateEmail()+"'");
            while (myRs.next()){
                System.out.println("Eklendi: " + myRs.getString(2));
            }


        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                if(myRs != null)
                    myConn.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
