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
public class RegisterItem extends Frame implements ActionListener{
    
    public static void main(String[] args){
        new RegisterItem();
    }
    
    JTextField itemCode, itemName, priceItem, supplierID;
    JButton submit;
    public RegisterItem(){
        JFrame f = new JFrame("Item Entry");
        
        //Label
        JLabel title, code, name, price, supplier;
        title = new JLabel("Register New Item");
        title.setBounds(135, 40, 300, 20);
        code = new JLabel("Item Code:");
        code.setBounds(85, 90, 150, 20);
        name = new JLabel("Item Name:");
        name.setBounds(80, 140, 150, 20);
        price = new JLabel("Price Per Item:");
        price.setBounds(60, 190, 150, 20);
        supplier = new JLabel("Supplier ID:");
        supplier.setBounds(80, 240, 150, 20);
        
        //Textfield
        itemCode = new JTextField();
        itemCode.setBounds(150, 90, 150, 20);
        itemName = new JTextField();
        itemName.setBounds(150, 140, 150, 20);
        priceItem = new JTextField();
        priceItem.setBounds(150, 190, 150, 20);
        supplierID = new JTextField();
        supplierID.setBounds(150, 240, 150, 20);
        
        //Button
        submit = new JButton("Submit");
        submit.setBounds(150, 290, 90, 30);
        
        f.add(title); f.add(code); f.add(name); f.add(price); f.add(supplier);
        f.add(itemCode); f.add(itemName); f.add(priceItem); f.add(supplierID); f.add(submit);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
        f.setLocation(900, 300);
        
        //ActionListener
        submit.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e)
    {
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
                    priceItem.setText("");
                    supplierID.setText("");
                }
                else
                {
                    ItemWrite();
                    itemCode.setText("");
                    itemName.setText("");
                    priceItem.setText("");
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
        PrintWriter pw = new PrintWriter("item.txt");
        pw.write(itemCode.getText() + ":" + itemName.getText() + ":" + priceItem.getText() + ":" + supplierID.getText());
        pw.close();
    }
    
    public void ItemWrite() throws IOException
    {
        BufferedWriter bw = new BufferedWriter(new FileWriter("item.txt", true));
        bw.newLine();
        bw.append(itemCode.getText() + ":" + itemName.getText() + ":" + priceItem.getText() + ":" + supplierID.getText());
        bw.close();
    }
}
