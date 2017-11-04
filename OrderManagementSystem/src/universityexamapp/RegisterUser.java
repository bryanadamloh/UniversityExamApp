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
import java.io.*;
public class RegisterUser extends Frame implements ActionListener{
    
    String randomNum;
    JTextField username, password;
    JComboBox rolecb;
    JButton submit;
    public RegisterUser(){
        JFrame f = new JFrame("Register New User");
        
        //Label
        JLabel title, name, pass, role, module;
        title = new JLabel("Register Trisyslogics Staff");
        title.setBounds(120, 40, 300, 20);
        name = new JLabel("Name:");
        name.setBounds(105, 90, 150, 20);
        pass = new JLabel("Password:");
        pass.setBounds(80, 140, 150, 20);
        role = new JLabel("Select Role:");
        role.setBounds(75, 190, 150, 20);
        
        //TextField and ComboBox
        username = new JTextField();
        username.setBounds(150, 90, 150, 20);
        password = new JPasswordField(10);
        password.setBounds(150, 140, 150, 20);
        String userRole[] = {"Sales Manager", "Purchase Manager"};
        rolecb = new JComboBox(userRole);
        rolecb.setBounds(150, 190, 150, 20);
        
        //Button
        submit = new JButton("Register");
        submit.setBounds(150, 240, 90, 30);
        
        f.add(title); f.add(name); f.add(pass); f.add(role);
        f.add(username); f.add(password); f.add(rolecb); f.add(submit);
        f.setSize(400,350);
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
                if(br.readLine() != null && "Sales Manager".equals(rolecb.getSelectedItem()))
                {
                    SMAdd();
                    username.setText("");
                    password.setText("");
                    rolecb.setSelectedIndex(0);
                }
                else if(br.readLine() != null && "Purchase Manager".equals(rolecb.getSelectedItem()))
                {
                   PMAdd();
                   username.setText("");
                   password.setText("");
                   rolecb.setSelectedIndex(0);
                }
                
                JOptionPane.showMessageDialog(null, "Registration has been made successfully! Your ID is " + randomNum, "Info", JOptionPane.INFORMATION_MESSAGE);
                br.close();
            }
            catch (IOException i)
            {
                i.printStackTrace();
            }
        }
    }
    
    public String SMAdd() throws IOException
    {
        BufferedWriter bw = new BufferedWriter(new FileWriter("user.txt", true));
        Random gen = new Random();
        randomNum = String.format("SM" + "%04d", gen.nextInt(9999));
        
        bw.newLine();
        bw.write(randomNum + ":" + username.getText() + ":" + password.getText() + ":" + rolecb.getSelectedItem());
        bw.close();
        
        return randomNum;
    }
    
    public String PMAdd() throws IOException
    {
        BufferedWriter bw = new BufferedWriter(new FileWriter("user.txt", true));
        Random gen = new Random();
        randomNum = String.format("PM" + "%04d", gen.nextInt(9999));
        
        bw.newLine();
        bw.write(randomNum + ":" + username.getText() + ":" + password.getText() + ":" + rolecb.getSelectedItem());
        bw.close();
        
        return randomNum;
    }
}
