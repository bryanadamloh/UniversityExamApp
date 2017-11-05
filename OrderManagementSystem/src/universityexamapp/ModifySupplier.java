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
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
public class ModifySupplier extends Frame implements ActionListener{
    
    //For JComboBox Population
    List<String> itemInfo = new ArrayList<>();
    File Ifile = new File("item.txt");
    List<String> suppInfo = new ArrayList<>();
    File Sfile = new File("supplier.txt");
    
    public static String itemID, itemN, suppID, suppN;
    JLabel IName;
    JTextField suppName;
    JComboBox itemCB, supplierCB;
    JButton submit;
    public ModifySupplier(){
        
        //Populate the JComboBox
        ReadItemFile();
        String[] ItemLineArray = itemInfo.toArray(new String[]{});
        ReadSupplierFile();
        String[] SuppLineArray = suppInfo.toArray(new String[]{});
        
        JFrame f = new JFrame("Modify Supplier");
        
        //Label
        JLabel title, ID, name, item, itemName;
        title = new JLabel("Modify Existing Supplier");
        title.setBounds(125, 40, 300, 20);
        ID = new JLabel("Supplier ID:");
        ID.setBounds(80, 90, 150, 20);
        name = new JLabel("Supplier Name:");
        name.setBounds(57, 140, 150, 20);
        item = new JLabel("Item ID:");
        item.setBounds(100, 190, 150, 20);
        itemName = new JLabel("Item Name:");
        itemName.setBounds(77, 240, 150, 20);
        
        //TextField and ComboBox
        supplierCB = new JComboBox(SuppLineArray);
        supplierCB.setBounds(150, 90, 150, 20);
        suppName = new JTextField();
        suppName.setBounds(150, 140, 150, 20);
        itemCB = new JComboBox(ItemLineArray);
        itemCB.setBounds(150, 190, 150, 20);
        IName = new JLabel();
        IName.setBounds(150, 240, 150, 20);
        
        //Button
        submit = new JButton("Submit");
        submit.setBounds(150, 290, 90, 30);
        
        f.add(title); f.add(ID); f.add(name); f.add(item); f.add(itemName);
        f.add(supplierCB); f.add(suppName); f.add(itemCB); f.add(IName); f.add(submit);
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
        supplierCB.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource() == supplierCB)
                {
                    searchIDforSupp();
                    if(supplierCB.getSelectedItem().equals(suppID))
                    {
                        suppName.setText(suppN);
                        itemCB.setSelectedItem(itemID);
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
                File suppFile = new File("supplier.txt");
                BufferedReader br = new BufferedReader(new FileReader(suppFile));
                File tempDB = new File("temp.txt");
                BufferedWriter bw = new BufferedWriter(new FileWriter(tempDB));
                
                String supp;
                while((supp = br.readLine()) != null)
                {
                    String[] details = supp.split(":");
                    String ID = details[0];
                    String name = details[1];
                    String iID = details[2];
                    String itemName = details[3];
                    
                    if(ID.equals(supplierCB.getSelectedItem()))
                    {
                        supp = supp.replace(name, suppName.getText());
                        supp = supp.replace(iID, itemCB.getSelectedItem().toString());
                        supp = supp.replace(itemName, IName.getText());
                    }
                    
                    bw.write(supp + "\n");
                    bw.flush();
                }
                
                br.close();
                bw.close();
                suppFile.delete();
                tempDB.renameTo(suppFile);
                
                JOptionPane.showMessageDialog(null, "Data has been modified!", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
            catch (IOException i)
            {
                i.printStackTrace();
            }
                  
        }
    }
    
    public void ReadItemFile()
    {
        try
        {
           Scanner scan = new Scanner(Ifile);
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
            Scanner scan = new Scanner(Ifile);
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
    
    public void ReadSupplierFile()
    {
        try
        {
           Scanner scan = new Scanner(Sfile);
           while(scan.hasNext())
           {
               String supp = scan.nextLine();
               String[] details = supp.split(":");
               String ID = details[0];
               
               suppInfo.add(ID);
           }
           
           scan.close();
        }
        catch (IOException i)
        {
            i.printStackTrace();
        }
    }
    
    public void searchIDforSupp()
    {
        try
        {
            Scanner scan = new Scanner(Sfile);
            while(scan.hasNext())
            {
                String supp = scan.nextLine();
                String[] details = supp.split(":");
                String ID = details[0];
                String name = details[1];
                String iID = details[2];
                String itemName = details[3];
                
                if(supplierCB.getSelectedItem().equals(ID))
                {
                    suppID = ID;
                    suppN = name;
                    itemID = iID;
                    itemN = itemName;
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
