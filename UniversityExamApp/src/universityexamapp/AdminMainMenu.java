/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityexamapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AdminMainMenu extends Frame{
    
    public static void main(String[] args){
        new AdminMainMenu();
    }
    
    Button InsertUser, EditUser, SearchUser, DeleteUser;
    public AdminMainMenu(){
        JFrame f = new JFrame("Main Menu");
        
        InsertUser = new Button("Add New User");
        EditUser = new Button("Modify Existing User Information");
        SearchUser = new Button("View User Information");
        DeleteUser = new Button("Deleting Existng User");
        
        f.add(InsertUser); f.add(EditUser); f.add(SearchUser); f.add(DeleteUser);
        
        f.setSize(400,400);
        f.setLayout(new BoxLayout(f.getContentPane() ,BoxLayout.Y_AXIS));
        f.setVisible(true);
        f.setLocation(900, 300);
    }

}
