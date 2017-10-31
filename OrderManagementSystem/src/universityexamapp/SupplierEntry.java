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
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class SupplierEntry extends Frame implements ActionListener{
    
    public static void main(String[] args){
        new SupplierEntry();
    }
    
    //For JComboBox Population
    List<String> itemInfo = new ArrayList<>();
    File file = new File("item.txt");
    
    JTextField supplierID, supplierName;
    JComboBox itemCB;
    JButton submit;
    public SupplierEntry(){
        
        //Populate the JComboBox with text file
        ReadFile();
        String[] lineArray = itemInfo.toArray(new String[]{});
        
        JFrame f = new JFrame("Supplier Entry");
        
        //Label
        JLabel title, ID, name, item, itemName;
        title = new JLabel("Register New Supplier");
        title.setBounds(125, 40, 300, 20);
        ID = new JLabel("Supplier ID:");
        ID.setBounds(80, 90, 150, 20);
        name = new JLabel("Supplier Name:");
        name.setBounds(57, 140, 150, 20);
        item = new JLabel("Item ID:");
        item.setBounds(100, 190, 150, 20);
        
        //TextField
        supplierID = new JTextField();
        supplierID.setBounds(150, 90, 150, 20);
        supplierName = new JTextField();
        supplierName.setBounds(150, 140, 150, 20);
        itemCB = new JComboBox(lineArray);
        itemCB.setBounds(150, 190, 150, 20);
        
        //Button
        submit = new JButton("Submit");
        submit.setBounds(150, 240, 90, 30);
        
        f.add(title); f.add(ID); f.add(name); f.add(item);
        f.add(supplierID); f.add(supplierName); f.add(itemCB); f.add(submit);
        f.setSize(400,350);
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
                BufferedReader br = new BufferedReader(new FileReader("supplier.txt"));
                if(br.readLine() == null)
                {
                    SupplierAdd();
                    supplierID.setText("");
                    supplierName.setText("");
                }
                else
                {
                    SupplierWrite();
                    supplierID.setText("");
                    supplierName.setText("");
                }
                
                JOptionPane.showMessageDialog(null, "Supplier has been added successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
            catch (IOException i)
            {
                i.printStackTrace();
            }
        }
    }
    
    public void SupplierAdd() throws IOException
    {
        PrintWriter pw = new PrintWriter("supplier.txt");
        pw.write(supplierID.getText() + ":" + supplierName.getText() + ":" + itemCB.getSelectedItem());
        pw.close();
    }
    
    public void SupplierWrite() throws IOException
    {
        BufferedWriter bw = new BufferedWriter(new FileWriter("supplier.txt", true));
        bw.newLine();
        bw.append(supplierID.getText() + ":" + supplierName.getText() + ":" + itemCB.getSelectedItem());
        bw.close();
    }
    
    public void ReadFile()
    {
        try
        {
           Scanner scan = new Scanner(file);
           while(scan.hasNext())
           {
               String itemName = null;
               String item = scan.nextLine();
               String[] details = item.split(":");
               String ID = details[0];
               
               itemInfo.add(ID);
           }
           
           scan.close();
        }
        catch (IOException i)
        {
            i.printStackTrace();
        }
        
    }
    
}
