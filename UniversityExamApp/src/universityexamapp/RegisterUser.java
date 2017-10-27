/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityexamapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Scanner;
public class RegisterUser extends Frame{
    
    public static void main(String[] args){
        new RegisterUser();
    }
    
    public RegisterUser(){
        JFrame f = new JFrame("Register New User");
        
        //Label
        JLabel title, name, password, role, module;
        title = new JLabel("Register New Lecturer/Staff");
        title.setBounds(80, 40, 300, 20);
        name = new JLabel("Name:");
        name.setBounds(80, 90, 150, 20);
        password = new JLabel("Password:");
        password.setBounds(80, 140, 150, 20);
        role = new JLabel("Select Role:");
        role.setBounds(80, 190, 150, 20);
        module = new JLabel("Select Module:");
        module.setBounds(80, 240, 150, 20);
        
        //TextField and ComboBox
        
               
    }
}
