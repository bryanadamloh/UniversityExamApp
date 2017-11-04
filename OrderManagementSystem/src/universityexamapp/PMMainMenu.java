/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityexamapp;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class PMMainMenu extends Frame implements ActionListener{
    
    Button ItemList, SupplyList, RequisList, GeneratePO, POList;
    public PMMainMenu(){
        JFrame f = new JFrame("Main Menu");
        
        //Button
        ItemList = new Button("List of Items");
        SupplyList = new Button("List of Suppliers");
        RequisList = new Button("Display Requisition");
        GeneratePO = new Button("Generate Purchase Order");
        POList = new Button("List of Purchase Orders");
        
        f.add(ItemList); f.add(SupplyList); f.add(RequisList); f.add(GeneratePO); f.add(POList);
        
        f.setSize(400,400);
        f.setLayout(new BoxLayout(f.getContentPane() ,BoxLayout.Y_AXIS));
        f.setVisible(true);
        f.setLocation(900, 300);
        
        //ActionListener
        ItemList.addActionListener(this);
        SupplyList.addActionListener(this);
        RequisList.addActionListener(this);
        GeneratePO.addActionListener(this);
        POList.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
        
    }
}
