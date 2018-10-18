package ung.ungnewsletter.enewsletter.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Newsletter {

    String Firstname , Lastname , Email, Password;

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }



    // This method  implements PreparedStatement properly.
    public int addUsertoDatabase() {
        int affectedRow=0;
        String query = "insert into Newsletter_Subscribe" + "(Category, Title, Description, Link)" // Edit This Line with Database Information
                + "values(?,?,?,?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement sqlStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);) {
            sqlStatement.setString(1, getFirstname());
            sqlStatement.setString(2, getLastname());
            sqlStatement.setString(3, getEmail());
            sqlStatement.setString(4, getPassword());


            // get the number of return rows
            affectedRow = sqlStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Status: operation failed due to " + e);

        }
        return affectedRow;

    }




}
