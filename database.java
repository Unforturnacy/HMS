
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.sql.*;
import java.util.logging.*;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.lang.model.util.ElementScanner14;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.font.TextAttribute;


public class database {
    private String name;
    private String email;
    private String response;
    private String gender;
    private String occ;
    private String contact;
    private String phone;
    private String sympton;
    private String blood;
    private String religion;
    private double price;
    private String date;
    private String doctor;

    public database(String name,String email,String response)
    {
        this.name = name;
        this.email = email;
        this.response = response;
        insert_query();
    }

    public database(String name,String oc,String email,String gender,String tele, String sym,String blood,String add,String doc,double paid,String date)
    {
        this.name = name;
        this.occ =oc;
        this.contact = email;
        this.gender = gender;
        this.phone = tele;
        this.doctor = doc;
        this.sympton =sym;
        this.blood = blood ;   
        this.religion   = add;
        this.price = paid;
        this.date = date;
        insert_patient();
    }


    public void insert_query()
    {
        Statement sqlSt;
        String SQL = "insert into feedback (name, email, response)" + " values (?, ?, ?)";
     
        System.out.println(SQL);

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:3306/hospital";
            Connection dbConnect =  DriverManager.getConnection(dbURL, "root", "");
            sqlSt = dbConnect.createStatement();//allows SQL to be executed
            PreparedStatement preparedStmt = dbConnect.prepareStatement(SQL);
            preparedStmt.setString (1, name);
            preparedStmt.setString (2, email);
            preparedStmt.setString (3, response);
            preparedStmt.execute();
            sqlSt.close();
        }
        catch(ClassNotFoundException ex){
            System.out.println("DIDNT LOAD JAR");
        }
        catch (SQLException ex){
            System.out.println("SQL IS BAD" +ex.getMessage());
        }
    }

    public void insert_patient()
    {
        Statement sqlSt;
        String SQL = "insert into patients (name, occupation, email, gender, telephone, symptoms, blood, address, doctor_seen, amount_paid, app_date)" + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
     
        System.out.println(SQL);

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:3306/hospital";
            Connection dbConnect =  DriverManager.getConnection(dbURL, "root", "");
            sqlSt = dbConnect.createStatement();//allows SQL to be executed
            PreparedStatement preparedStmt = dbConnect.prepareStatement(SQL);
            preparedStmt.setString (1, name);
            preparedStmt.setString (2, occ);
            preparedStmt.setString (3, contact);
            preparedStmt.setString(4, gender);
            preparedStmt.setString    (5, phone);
            preparedStmt.setString    (6, sympton);
            preparedStmt.setString    (7, blood);
            preparedStmt.setString    (8, religion);
            preparedStmt.setString    (9, doctor);
            preparedStmt.setDouble(10, price);
            preparedStmt.setString    (11, date);
            preparedStmt.execute();
            sqlSt.close();
        }
        catch(ClassNotFoundException ex){
            System.out.println("DIDNT LOAD JAR");
        }
        catch (SQLException ex){
            System.out.println("SQL IS BAD" +ex.getMessage());
        }
    }
    
}
