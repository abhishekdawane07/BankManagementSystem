package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Transcations extends JFrame implements ActionListener
{
    String pinnumber;
    JLabel TransactionLabel;
    JButton deposite_Button,withdrawl_Button,cash_Button,statement_Button,pinchange_Button,balance_Button,exit_Button;
    Transcations(String pinnumber)
    {
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 960, 1080);
        add(l2);
        
        TransactionLabel = new JLabel("Please Select Your Transaction");
        TransactionLabel.setForeground(Color.WHITE);
        TransactionLabel.setFont(new Font("System", Font.BOLD, 16));
        TransactionLabel.setBounds(235,400,700,35);
        l2.add(TransactionLabel);
       
        deposite_Button = new JButton("DEPOSIT");
        deposite_Button.setBounds(170,499,150,35);
        l2.add(deposite_Button);
        deposite_Button.addActionListener(this);
        
        withdrawl_Button = new JButton("CASH WITHDRAWL");
        withdrawl_Button.setBounds(390,499,150,35);
        l2.add(withdrawl_Button);
        withdrawl_Button.addActionListener(this);
        
        cash_Button = new JButton("FAST CASH");
        cash_Button.setBounds(170,543,150,35);
        l2.add(cash_Button);
        cash_Button.addActionListener(this);
        
        statement_Button = new JButton("MINI STATEMENT");
        statement_Button.setBounds(390,543,150,35);
        l2.add(statement_Button);
        statement_Button.addActionListener(this);
        
        pinchange_Button = new JButton("PIN CHANGE");
        pinchange_Button.setBounds(170,588,150,35);
        l2.add(pinchange_Button);
        pinchange_Button.addActionListener(this);
        
        balance_Button = new JButton("BALANCE ENQUIRY");
        balance_Button.setBounds(390,588,150,35);
        l2.add(balance_Button);
        balance_Button.addActionListener(this);
        
        exit_Button = new JButton("EXIT");
        exit_Button.setBounds(390,633,150,35);
        l2.add(exit_Button);
        exit_Button.addActionListener(this);
        
        setLayout(null);
        
        setSize(960,1080);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==deposite_Button)
        { 
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==withdrawl_Button)
        { 
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==cash_Button)
        { 
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==statement_Button)
        { 
           new MiniStatement(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==pinchange_Button)
        { 
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==balance_Button)
        { 
            this.setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==exit_Button)
        { 
            System.exit(0);
        }
    }
    public static void main(String args[])
    {
        new Transcations("").setVisible(true);
    }
}