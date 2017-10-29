/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityexamapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.io.File;
import java.io.*;
import java.util.Scanner;
public class RegisterUser extends Frame implements ActionListener{
    
    public static void main(String[] args){
        new RegisterUser();
    }
    
    JTextField username, password;
    JComboBox rolecb, modulecb;
    JButton submit;
    public RegisterUser(){
        JFrame f = new JFrame("Register New User");
        
        //Label
        JLabel title, name, pass, role, module;
        title = new JLabel("Register New Lecturer/Staff");
        title.setBounds(110, 40, 300, 20);
        name = new JLabel("Name:");
        name.setBounds(105, 90, 150, 20);
        pass = new JLabel("Password:");
        pass.setBounds(80, 140, 150, 20);
        role = new JLabel("Select Role:");
        role.setBounds(75, 190, 150, 20);
        module = new JLabel("Select Module:");
        module.setBounds(60, 240, 150, 20);
        
        //TextField and ComboBox
        username = new JTextField();
        username.setBounds(150, 90, 150, 20);
        password = new JPasswordField(10);
        password.setBounds(150, 140, 150, 20);
        String userRole[] = {"Lecturer", "Staff"};
        rolecb = new JComboBox(userRole);
        rolecb.setBounds(150, 190, 150, 20);
        String userModule[] = {"Computing Theory", "Artificial Intelligence", "Requirements Engineering", "Enterprise System"};
        modulecb = new JComboBox(userModule);
        modulecb.setBounds(150, 240, 150, 20);
        
        //Button
        submit = new JButton("Register");
        submit.setBounds(150, 290, 90, 30);
        
        f.add(title); f.add(name); f.add(pass); f.add(role); f.add(module);
        f.add(username); f.add(password); f.add(rolecb); f.add(modulecb); f.add(submit);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
        f.setLocation(900, 300);
        
        //add ActionListener
        submit.addActionListener(this);
    }
    
    public void actionPerformed (ActionEvent e){
        if (e.getSource() == submit)
        {
            try
            {
                BufferedReader br = new BufferedReader(new FileReader("user.txt"));
                if(br.readLine() != null)
                {
                    UserAdd();
                    username.setText("");
                    password.setText("");
                    rolecb.setSelectedIndex(0);
                    modulecb.setSelectedIndex(0);
                }
                
                JOptionPane.showMessageDialog(null, "Registration has been made successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
            catch (IOException i)
            {
                i.printStackTrace();
            }
        }
    }
    
    public void UserAdd() throws IOException
    {
        
    }
    
}
