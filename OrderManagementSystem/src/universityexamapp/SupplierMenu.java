/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityexamapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SupplierMenu extends Frame implements ActionListener{
    
    Button newSupp, editSupp, deleteSupp;
    public SupplierMenu()
    {
        JFrame f = new JFrame("Supplier Entry");
        
        //Button
        newSupp = new Button("Register New Supplier");
        editSupp = new Button("Modify Existing Supplier");
        deleteSupp = new Button("Delete Supplier");
        
        f.add(newSupp); f.add(editSupp); f.add(deleteSupp);
        
        f.setSize(500,300);
        f.setLayout(new GridLayout(1,3));
        f.setVisible(true);
        f.setLocation(900, 300);
        
        newSupp.addActionListener(this);
        editSupp.addActionListener(this);
        deleteSupp.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == newSupp)
        {
            new RegisterSupplier();
        }
        else if(e.getSource() == deleteSupp)
        {
            new DeleteSupplier();
        }
    }
}
