/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityexamapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class LecturerMainMenu extends Frame{
    
    public static void main(String[] args){
        new LecturerMainMenu();
    }
    
    JButton AddMarks, ViewMarks, EditMarks, DeleteMarks, StudentInfo, ModuleInfo;
    public LecturerMainMenu(){
        JFrame f = new JFrame("Main Menu");
        
        AddMarks = new JButton("Add Module Marks");
        ViewMarks = new JButton("View Module Marks");
        EditMarks = new JButton("Modify Module Marks");
        DeleteMarks = new JButton("Delete Module Marks");
        StudentInfo = new JButton("Student Information");
        ModuleInfo = new JButton("Module Information");
        
        f.add(AddMarks); f.add(ViewMarks); f.add(EditMarks); f.add(DeleteMarks); f.add(StudentInfo); f.add(ModuleInfo);
        
        f.setSize(600,400);
        f.setLayout(new GridLayout(2,3));
        f.setVisible(true);
        f.setLocation(900, 300);
    }
}
