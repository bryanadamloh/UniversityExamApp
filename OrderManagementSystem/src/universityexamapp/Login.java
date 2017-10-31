/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityexamapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Login extends Frame implements ActionListener{
    
    public static void main(String[] args){
        new Login();
    }
    
    private JTextField username;
    private JPasswordField password;
    private JButton login;
    public Login(){
        JFrame f = new JFrame("Login Page");
        
        //Label
        JLabel title, user, pass;
        title = new JLabel("Welcome to Trisyslogics Order Management System");
        title.setBounds(45, 40, 300, 20);
        user = new JLabel("Username:");
        user.setBounds(80, 90, 150, 20);
        pass = new JLabel("Password:");
        pass.setBounds(80, 140, 150, 20);
        
        //TextField
        username = new JTextField();
        username.setBounds(150, 90, 150, 20);
        password = new JPasswordField(10);
        password.setBounds(150, 140, 150, 20);
        
        //Button
        login = new JButton("Login");
        login.setBounds(150, 180, 80, 30);
        
        f.add(title); f.add(user); f.add(pass); f.add(username); f.add(password); f.add(login);
        f.setSize(400,300);
        f.setLayout(null);
        f.setVisible(true);
        f.setLocation(900, 300);
        
        //add ActionListener
        login.addActionListener(this);
    }
    
    public void actionPerformed (ActionEvent e){
        if(e.getSource() == login){
            int findUser = 0;
            findUser = search(username.getText(), password.getText());
            
            if(findUser == 0)
            {
                new AdminMainMenu();
            }
            else if(findUser == 1)
            {
                new SMMainMenu();
            }
            else if(findUser == 2)
            {
                new PMMainMenu();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Invalid Username and Password!", "Login Error", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    private static int search(String username, String password){
        String log;
        log = "user.txt";
        File login = new File(log);
        
        //return 0 for admin, return 1 for SM, return 2 for PM
        try
        {
            Scanner scan = new Scanner(login);
            while(scan.hasNext())
            {
                String user = scan.nextLine();
                String[] details = user.split(":");
                String name = details[1];
                String pass = details[2];
                String role = details[3];
                
                if(name.equals(username) && pass.equals(password) && role.equals("Admin"))
                {
                    return 0;
                }
                else if(name.equals(username) && pass.equals(password) && role.equals("Sales Manager"))
                {
                    return 1;
                }
                else if(name.equals(username) && pass.equals(password) && role.equals("Purchase Manager"))
                {
                    return 2;
                }
            }
        }
        catch(FileNotFoundException f)
        {
            f.printStackTrace();
        }
        
        //if its false, return value -1
        return -1;
    }
}
