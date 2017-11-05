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
public class ModifyItem extends Frame implements ActionListener{
    
    //For JComboBox Population
    List<String> itemInfo = new ArrayList<>();
    File file = new File("item.txt");
    
    public static String code, itemN, itemP, sID;
    JComboBox itemCB;
    JTextField itemName, itemPrice, supplierID;
    JButton submit;
    public ModifyItem(){
        
        //Populate the JComboBox with text file
        ReadFile();
        String[] lineArray = itemInfo.toArray(new String[]{});
        
        JFrame f = new JFrame("Modify Item");
        
        //Label
        JLabel title, ID, name, RM, suppID;
        title = new JLabel("Modify Exisitng Item");
        title.setBounds(135, 40, 300, 20);
        ID = new JLabel("Item Code:");
        ID.setBounds(85, 90, 150, 20);
        name = new JLabel("Item Name:");
        name.setBounds(80, 140, 150, 20);
        RM = new JLabel("Price Per Item:");
        RM.setBounds(60, 190, 150, 20);
        suppID = new JLabel("Supplier ID:");
        suppID.setBounds(80, 240, 150, 20);
        
        //TextField and ComboBox
        itemCB = new JComboBox(lineArray);
        itemCB.setBounds(150, 90, 150, 20);
        itemName = new JTextField();
        itemName.setBounds(150, 140, 150, 20);
        itemPrice = new JTextField();
        itemPrice.setBounds(150, 190, 150, 20);
        supplierID = new JTextField();
        supplierID.setBounds(150, 240, 150, 20);
        
        //Button
        submit = new JButton("Submit");
        submit.setBounds(150, 290, 90, 30);
        
        f.add(title); f.add(ID); f.add(name); f.add(RM); f.add(suppID);
        f.add(itemCB); f.add(itemName); f.add(itemPrice); f.add(supplierID); f.add(submit);
        f.setSize(400,400);
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
                    if(itemCB.getSelectedItem().equals(code))
                    {
                        itemName.setText(itemN);
                        itemPrice.setText(itemP);
                        supplierID.setText(sID);
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
                File itemFile = new File("item.txt");
                BufferedReader br = new BufferedReader(new FileReader(itemFile));
                File tempDB = new File("temp.txt");
                BufferedWriter bw = new BufferedWriter(new FileWriter(tempDB));
                
                String item;
                while((item = br.readLine()) != null)
                {
                    String[] details = item.split(":");
                    String itemID = details[0];
                    String name = details[1];
                    String price = details[2];
                    String suppID = details[3];
                    
                    if(itemID.equals(itemCB.getSelectedItem()))
                    {
                        item = item.replace(name, itemName.getText());
                        item = item.replace(price, itemPrice.getText());
                        item = item.replace(suppID, supplierID.getText());
                    }
                    
                    bw.write(item + "\n");
                    bw.flush();
                }
                
                br.close();
                bw.close();
                itemFile.delete();
                tempDB.renameTo(itemFile);
                
                JOptionPane.showMessageDialog(null, "Data has been modified!", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
            catch (IOException i)
            {
                i.printStackTrace();
            }
                  
        }
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
                String itemID = details[0];
                String name = details[1];
                String price = details[2];
                String suppID = details[3];
                
                if(itemCB.getSelectedItem().equals(itemID))
                {
                    code = itemID;
                    itemN = name;
                    itemP = price;
                    sID = suppID;
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
