/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityexamapp;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class ItemEntry extends Frame implements ActionListener{
    
    public static void main(String[] args){
        new ItemEntry();
    }
    
    JTextField itemCode, itemName, supplierID;
    JButton submit;
    public ItemEntry(){
        JFrame f = new JFrame("Item Entry");
        
        //Label
        JLabel title, code, name, supplier;
        title = new JLabel("Register New Item");
        title.setBounds(135, 40, 300, 20);
        code = new JLabel("Item Code:");
        code.setBounds(85, 90, 150, 20);
        name = new JLabel("Item Name:");
        name.setBounds(80, 140, 150, 20);
        supplier = new JLabel("Supplier ID:");
        supplier.setBounds(80, 190, 150, 20);
        
        //Textfield
        itemCode = new JTextField();
        itemCode.setBounds(150, 90, 150, 20);
        itemName = new JTextField();
        itemName.setBounds(150, 140, 150, 20);
        supplierID = new JTextField();
        supplierID.setBounds(150, 190, 150, 20);
        
        //Button
        submit = new JButton("Submit");
        submit.setBounds(150, 240, 90, 30);
        
        f.add(title); f.add(code); f.add(name); f.add(supplier);
        f.add(itemCode); f.add(itemName); f.add(supplierID); f.add(submit);
        f.setSize(400,350);
        f.setLayout(null);
        f.setVisible(true);
        f.setLocation(900, 300);
        
        //ActionListener
        submit.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == submit)
        {
            try
            {
                BufferedReader br = new BufferedReader(new FileReader("item.txt"));
                if(br.readLine() == null)
                {
                    ItemAdd();
                    itemCode.setText("");
                    itemName.setText("");
                    supplierID.setText("");
                }
                else
                {
                    ItemWrite();
                    itemCode.setText("");
                    itemName.setText("");
                    supplierID.setText("");
                }
                
                JOptionPane.showMessageDialog(null, "Item has been added successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
            catch (IOException i)
            {
                i.printStackTrace();
            }
        }
    }
    
    public void ItemAdd() throws IOException
    {
        BufferedWriter bw = new BufferedWriter(new FileWriter("item.txt",true));
        bw.append(itemCode.getText() + ":" + itemName.getText() + ":" + supplierID.getText());
        bw.close();
    }
    
    public void ItemWrite() throws IOException
    {
        BufferedWriter bw = new BufferedWriter(new FileWriter("item.txt"));
        bw.newLine();
        bw.write(itemCode.getText() + ":" + itemName.getText() + ":" + supplierID.getText());
        bw.close();
    }
}
