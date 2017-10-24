/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityexamapp;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Scanner;
public class Login extends Frame{

    public static void main(String[] args) {
        new Login();
    }
    
    JTextField user, pass;
    JButton login;
    public Login(){
        
        JFrame f = new JFrame();
        f.setSize(300, 300);
        f.setVisible(true);
    }
}
