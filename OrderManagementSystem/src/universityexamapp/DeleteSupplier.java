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
public class DeleteSupplier extends Frame implements ActionListener{
    
    JLabel SuppName, ItemID;
    JTextField SuppID;
    JButton submit, search;
    public DeleteSupplier()
    {
        JFrame f = new JFrame("Delete Supplier");
        
        //Label
        JLabel title, supplier, suppname, itemid;
        title = new JLabel("Delete Existing Supplier");
        title.setBounds(120, 40, 300, 20);
        supplier = new JLabel("Enter Supplier ID to Delete:");
        supplier.setBounds(25, 85, 150, 20);
        suppname = new JLabel("Supplier Name:");
        suppname.setBounds(89, 125, 150, 20);
        itemid = new JLabel("Item ID:");
        itemid.setBounds(132, 165, 150, 20);
        
        //TextField
        SuppID = new JTextField();
        SuppID.setBounds(180, 85, 150, 20);
        SuppName = new JLabel();
        SuppName.setBounds(180, 125, 150, 20);
        ItemID = new JLabel();
        ItemID.setBounds(180, 165, 150, 20);
        
        //Button
        submit = new JButton("Delete");
        submit.setBounds(145, 210, 90, 30);
        search = new JButton(":");
        search.setBounds(330, 85, 20, 20);
        
        f.add(title); f.add(supplier); f.add(suppname); f.add(itemid);
        f.add(SuppID); f.add(submit); f.add(search); f.add(SuppName); f.add(ItemID);
        f.setSize(400,300);
        f.setLayout(null);
        f.setVisible(true);
        f.setLocation(900, 300);
        
        submit.addActionListener(this); 
        search.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == submit)
        {
            try
            {
                delete();
                SuppID.setText("");
                SuppName.setText("");
                ItemID.setText("");
            }
            catch (IOException i)
            {
                i.printStackTrace();
            }
        }
        else if (e.getSource() == search)
        {
            try
            {
                searchSupp();
            }
            catch (IOException i)
            {
                i.printStackTrace();
            }
        }
    }
    
    public void delete() throws IOException
    {
        try
        {
            File suppFile = new File("supplier.txt");
            BufferedReader br = new BufferedReader(new FileReader(suppFile));
            File tempDB = new File("temp.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempDB));

            String supplier;
            while((supplier = br.readLine()) != null)
            {
                String[] details = supplier.split(":");
                String suppID = details[0];

                if(!SuppID.getText().equals(suppID))
                {
                    bw.write(supplier + "\n");
                    bw.flush();
                }
            }

            br.close();
            bw.close();
            suppFile.delete();
            tempDB.renameTo(suppFile);
        
            JOptionPane.showMessageDialog(null, "Data has been deleted!", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (IOException i)
        {
            i.printStackTrace();
        }
    }
    
    public void searchSupp() throws IOException
    {
        FileReader fr = new FileReader("supplier.txt");
        Scanner scan = new Scanner(fr);
        boolean found = false;
           while(scan.hasNext())
           {
               String item = scan.nextLine();
               String[] details = item.split(":");
               String suppID = details[0];
               String suppName = details[1];
               String itemID = details[2];
               
               if(SuppID.getText().equals(suppID))
               {
                   SuppName.setText(suppName);
                   ItemID.setText(itemID);
                   found = true;
                   break;
               }
               else
               {
                   found = false;
                   SuppName.setText("");
                   ItemID.setText("");
               }
           }
           
           if(!found)
           {
               JOptionPane.showMessageDialog(null, "Invalid Supplier ID!", "Error", JOptionPane.INFORMATION_MESSAGE);
           }
        
           fr.close();
           scan.close();
    }
}
