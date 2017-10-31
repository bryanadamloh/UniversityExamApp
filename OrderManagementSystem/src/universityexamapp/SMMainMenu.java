/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityexamapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SMMainMenu extends Frame implements ActionListener{
    
    public static void main(String[] args){
        new SMMainMenu();
    }
    
    Button ItemEntry, SupplyEntry, DailySalesEntry, PurchaseRequis, DisplayRequis, POList;
    public SMMainMenu(){
        JFrame f = new JFrame("Main Menu");
        
        //Button
        ItemEntry = new Button("Item Entry");
        SupplyEntry = new Button("Supplier Entry");
        DailySalesEntry = new Button("Daily Item-wise Sales Entry");
        PurchaseRequis = new Button("Create a Purchase Requisition");
        DisplayRequis = new Button("Display Requisition");
        POList = new Button("List of Purchaser Orders");
        
        f.add(ItemEntry); f.add(SupplyEntry); f.add(DailySalesEntry); f.add(PurchaseRequis); f.add(DisplayRequis); f.add(POList);
        
        f.setSize(600,400);
        f.setLayout(new GridLayout(2,3));
        f.setVisible(true);
        f.setLocation(900, 300);
        
        //ActionListener
        ItemEntry.addActionListener(this);
        SupplyEntry.addActionListener(this);
        DailySalesEntry.addActionListener(this);
        PurchaseRequis.addActionListener(this);
        DisplayRequis.addActionListener(this);
        POList.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == ItemEntry)
        {
            new ItemEntry();
        }
        else if(e.getSource() == SupplyEntry)
        {
            new SupplierEntry();
        }
    }
            
}
