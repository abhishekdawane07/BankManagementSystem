package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener
{
    JTextField Withdrawl_ammount_TextField;
    JButton Withdrawl_Button,back_Button;
    JLabel Withdrawl_ammount_JLabel;
    String pinnumber;
    Withdrawl(String pinnumber)
    {
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 1080);
        add(l3);
        
        Withdrawl_ammount_JLabel = new JLabel("ENTER AMOUNT YOU WANT TO WITHDRAWL");
        Withdrawl_ammount_JLabel.setForeground(Color.WHITE);
        Withdrawl_ammount_JLabel.setFont(new Font("System", Font.BOLD, 16));
        Withdrawl_ammount_JLabel.setBounds(190,350,400,35);
        l3.add(Withdrawl_ammount_JLabel);
        
        Withdrawl_ammount_TextField = new JTextField();
        Withdrawl_ammount_TextField.setFont(new Font("Raleway", Font.BOLD, 22));
        Withdrawl_ammount_TextField.setBounds(190,420,320,25);
        l3.add(Withdrawl_ammount_TextField);
        
        Withdrawl_Button = new JButton("WITHDRAW");
        Withdrawl_Button.setBounds(390,588,150,35);
        Withdrawl_Button.addActionListener(this);
        l3.add(Withdrawl_Button);
        
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
            String amount = Withdrawl_ammount_TextField.getText();
            Date date = new Date();
            if(ae.getSource()==Withdrawl_Button)
            {
                if(Withdrawl_ammount_TextField.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
                }
                else
                {
                    Conn c = new Conn();
                    c.s.executeUpdate("insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Withdraw Successfully");
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
        new Withdrawl("").setVisible(true);
    }
}
