/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityexamapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ItemMenu extends Frame implements ActionListener {
    
    Button newItem, editItem, deleteItem;
    public ItemMenu(){
        JFrame f = new JFrame("Item Entry");
        
        //Button
        newItem = new Button("Register New Item");
        editItem = new Button("Modify Existing Item");
        deleteItem = new Button("Delete Item");
        
        f.add(newItem); f.add(editItem); f.add(deleteItem);
        
        f.setSize(500,300);
        f.setLayout(new GridLayout(1,3));
        f.setVisible(true);
        f.setLocation(900, 300);
        
        newItem.addActionListener(this);
        editItem.addActionListener(this);
        deleteItem.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == newItem)
        {
            new RegisterItem();
        }
        else if(e.getSource() == deleteItem)
        {
            new DeleteItem();
        }
    }
}
