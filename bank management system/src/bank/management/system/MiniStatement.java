package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener 
{
    JButton b1, b2;
    JLabel mini_statement_Label;
    
    MiniStatement(String pinnumber)
    {
        super("Mini Statement");
        getContentPane().setBackground(Color.WHITE);
        setSize(400,600);
        setLocation(20,20);
        
        mini_statement_Label = new JLabel();
        add(mini_statement_Label);
        
        JLabel Indian_Jlabel = new JLabel("Indian Bank");
        Indian_Jlabel.setBounds(150, 20, 100, 20);
        add(Indian_Jlabel);
        
        JLabel details_Label = new JLabel();
        details_Label.setBounds(20, 80, 300, 20);
        add(details_Label);
        
        JLabel final_Label = new JLabel();
        final_Label.setBounds(20, 400, 300, 20);
        add(final_Label);
        
        try
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while(rs.next())
            {
                details_Label.setText("Card Number:    " + rs.getString("cardno").substring(0, 4) + "XXXXXXXX" + rs.getString("cardno").substring(12));
            }
        }
        catch(Exception e)
        {
            
        }
        	 
        try
        {
            int balance = 0;
            Conn c  = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM bank where pin = '"+pinnumber+"'");
            while(rs.next())
            {
                mini_statement_Label.setText(mini_statement_Label.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit"))
                {
                    balance += Integer.parseInt(rs.getString("amount"));
                }
                else
                {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            final_Label.setText("Your total Balance is Rs "+balance);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        setLayout(null);
        b1 = new JButton("Exit");
        add(b1);
        
        b1.addActionListener(this);
        
        mini_statement_Label.setBounds(20, 140, 400, 200);
        b1.setBounds(20, 500, 100, 25);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        this.setVisible(false);
    }
    
    public static void main(String[] args)
    {
        new MiniStatement("").setVisible(true);
    }
}
