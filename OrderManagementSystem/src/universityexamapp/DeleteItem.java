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
public class DeleteItem extends Frame implements ActionListener{
    
    JLabel Name;
    JTextField itemID;
    JButton submit, search;
    public DeleteItem(){
        
        JFrame f = new JFrame("Delete Item");
        
        //Label
        JLabel title, item, name;
        title = new JLabel("Delete Existing Item");
        title.setBounds(130, 40, 300, 20);
        item = new JLabel("Enter Item ID to Delete:");
        item.setBounds(43, 85, 150, 20);
        name = new JLabel("Item Name:");
        name.setBounds(107, 125, 150, 20);
        
        //TextField
        itemID = new JTextField();
        itemID.setBounds(180, 85, 150, 20);
        Name = new JLabel();
        Name.setBounds(180, 125, 150, 20);
        
        //Button
        submit = new JButton("Delete");
        submit.setBounds(150, 170, 90, 30);
        search = new JButton(":");
        search.setBounds(330, 85, 20, 20);
        
        f.add(title); f.add(item); f.add(name); f.add(Name);
        f.add(itemID); f.add(submit); f.add(search);
        f.setSize(400,270);
        f.setLayout(null);
        f.setVisible(true);
        f.setLocation(900, 300);
        
        submit.addActionListener(this); 
        search.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == submit)
        {
            try
            {
                delete();
            }
            catch (IOException i)
            {
                i.printStackTrace();
            }
               
        }
        else if(e.getSource() == search)
        {
            try
            {
                searchItem();
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
            File itemFile = new File("item.txt");
            BufferedReader br = new BufferedReader(new FileReader(itemFile));
            File tempDB = new File("temp.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempDB));

            String item;
            while((item = br.readLine()) != null)
            {
                String[] details = item.split(":");
                String ItemID = details[0];

                if(!itemID.getText().equals(ItemID))
                {
                    bw.write(item + "\n");
                    bw.flush();
                }
            }

            br.close();
            bw.close();
            itemFile.delete();
            tempDB.renameTo(itemFile);
        
            JOptionPane.showMessageDialog(null, "Data has been deleted!", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (IOException i)
        {
            i.printStackTrace();
        }
    }
    
    public void searchItem() throws IOException
    {
        FileReader fr = new FileReader("item.txt");
        Scanner scan = new Scanner(fr);
        boolean found = false;
           while(scan.hasNext())
           {
               String item = scan.nextLine();
               String[] details = item.split(":");
               String ID = details[0];
               String itemName = details[1];
               
               if(itemID.getText().equals(ID))
               {
                   Name.setText(itemName);
                   found = true;
                   break;
               }
               else
               {
                   found = false;
                   Name.setText("");
               }
           }
           
           if(!found)
           {
               JOptionPane.showMessageDialog(null, "Invalid Item ID!", "Error", JOptionPane.INFORMATION_MESSAGE);
           }
        
           fr.close();
           scan.close();
    }
}
