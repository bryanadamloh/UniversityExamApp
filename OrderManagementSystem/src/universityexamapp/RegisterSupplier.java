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
public class RegisterSupplier extends Frame implements ActionListener{

    //For JComboBox Population
    List<String> itemInfo = new ArrayList<>();
    File file = new File("item.txt");
    
    public static String itemID, itemN;
    JLabel IName;
    JTextField supplierID, supplierName;
    JComboBox itemCB;
    JButton submit;
    public RegisterSupplier(){
        
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
        itemName = new JLabel("Item Name:");
        itemName.setBounds(77, 240, 150, 20);
        
        //TextField
        supplierID = new JTextField();
        supplierID.setBounds(150, 90, 150, 20);
        supplierName = new JTextField();
        supplierName.setBounds(150, 140, 150, 20);
        itemCB = new JComboBox(lineArray);
        itemCB.setBounds(150, 190, 150, 20);
        IName = new JLabel();
        IName.setBounds(150, 240, 150, 20);
        
        //Button
        submit = new JButton("Submit");
        submit.setBounds(150, 290, 90, 30);
        
        f.add(title); f.add(ID); f.add(name); f.add(item); f.add(itemName);
        f.add(supplierID); f.add(supplierName); f.add(itemCB); f.add(IName); f.add(submit);
        f.setSize(400,380);
        f.setLayout(null);
        f.setVisible(true);
        f.setLocation(900, 300);
        
        //ActionListener
        submit.addActionListener(this);
        itemCB.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource() == itemCB)
                {
                    searchIDforItem();
                    if(itemCB.getSelectedItem().equals(itemID))
                    {
                        IName.setText(itemN);
                    }
                }
                
            }
        });
        
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
                    IName.setText("");
                }
                else
                {
                    SupplierWrite();
                    supplierID.setText("");
                    supplierName.setText("");
                    IName.setText("");
                }
                
                JOptionPane.showMessageDialog(null, "Supplier has been added successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
                br.close();
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
        pw.write(supplierID.getText() + ":" + supplierName.getText() + ":" + itemCB.getSelectedItem() + ":" + IName.getText());
        pw.println();
        pw.close();
    }
    
    public void SupplierWrite() throws IOException
    {
        BufferedWriter bw = new BufferedWriter(new FileWriter("supplier.txt", true));
        bw.newLine();
        bw.append(supplierID.getText() + ":" + supplierName.getText() + ":" + itemCB.getSelectedItem() + ":" + IName.getText());
        bw.close();
    }
    
    public void ReadFile()
    {
        try
        {
           Scanner scan = new Scanner(file);
           while(scan.hasNext())
           {
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
    
    public void searchIDforItem()
    {
        try
        {
            Scanner scan = new Scanner(file);
            while(scan.hasNext())
            {
                String item = scan.nextLine();
                String[] details = item.split(":");
                String ID = details[0];
                String name = details[1];
                
                if(itemCB.getSelectedItem().equals(ID))
                {
                    itemID = ID;
                    itemN = name;
                }
                
            }
            
            scan.close();
        }
        catch (IOException i)
        {
            i.printStackTrace();
        }
    }
}
