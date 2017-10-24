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
public class Login extends Frame implements ActionListener{
    
    public static void main(String[] args){
        new Login();
    }
    
    JTextField username;
    JButton login;
    public Login(){
        JFrame f = new JFrame("Login Page");
        
        //Label
        JLabel title, user, pass;
        title = new JLabel("Welcome to University Exam Application");
        title.setBounds(80, 40, 300, 20);
        user = new JLabel("Username:");
        user.setBounds(80, 90, 150, 20);
        pass = new JLabel("Password:");
        pass.setBounds(80, 140, 150, 20);
        
        //TextField
        username = new JTextField();
        username.setBounds(150, 90, 150, 20);
        JPasswordField password = new JPasswordField();
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
            
        }
    }
    
}
