package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener
{
    JTextField deposit_ammount_TextField;
    JButton deposit_Button,back_Button;
    JLabel deposit_ammount_JLabel;
    String pinnumber;
    Deposit(String pinnumber)
    {
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 1080);
        add(l3);
        
        deposit_ammount_JLabel = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        deposit_ammount_JLabel.setForeground(Color.WHITE);
        deposit_ammount_JLabel.setFont(new Font("System", Font.BOLD, 16));
        deposit_ammount_JLabel.setBounds(190,350,400,35);
        l3.add(deposit_ammount_JLabel);
        
        deposit_ammount_TextField = new JTextField();
        deposit_ammount_TextField.setFont(new Font("Raleway", Font.BOLD, 22));
        deposit_ammount_TextField.setBounds(190,420,320,25);
        l3.add(deposit_ammount_TextField);
        
        deposit_Button = new JButton("DEPOSIT");
        deposit_Button.setBounds(390,588,150,35);
        deposit_Button.addActionListener(this);
        l3.add(deposit_Button);
        
        back_Button = new JButton("BACK");
        back_Button.setBounds(390,633,150,35);
        back_Button.addActionListener(this);
        l3.add(back_Button);
        
        setLayout(null);
        
        setSize(960,1080);
        setUndecorated(true);
        setLocation(500,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        try
        {        
            String amount = deposit_ammount_TextField.getText();
            Date date = new Date();
            if(ae.getSource()==deposit_Button)
            {
                if(deposit_ammount_TextField.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
                }
                else
                {
                    Conn c = new Conn();
                    c.s.executeUpdate("insert into bank values('"+pinnumber+"', '"+date+"', 'Deposit', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Deposited Successfully");
                    setVisible(false);
                    new Transcations(pinnumber).setVisible(true);
                }
            }
            else if(ae.getSource()==back_Button)
            {
                setVisible(false);
                new Transcations(pinnumber).setVisible(true);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public static void main(String[] args)
    {
        new Deposit("").setVisible(true);
    }
}
