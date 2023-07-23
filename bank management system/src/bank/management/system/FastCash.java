package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener
{
    String pinnumber;
    JLabel Fast_WithdrawLabel;
    JButton rswithdraw500_Button,rswithdraw1000_Button,rswithdraw2000_Button,rswithdraw5000_Button,rswithdraw10000_Button,rswithdraw15000_Button,back_Button;
    FastCash(String pinnumber)
    {
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 960, 1080);
        add(l2);
        
        Fast_WithdrawLabel = new JLabel("SELECT WITHDRAWL AMOUNT");
        Fast_WithdrawLabel.setForeground(Color.WHITE);
        Fast_WithdrawLabel.setFont(new Font("System", Font.BOLD, 16));
        Fast_WithdrawLabel.setBounds(235,400,700,35);
        l2.add(Fast_WithdrawLabel);
       
        rswithdraw500_Button = new JButton("RS 500");
        rswithdraw500_Button.setBounds(170,499,150,35);
        l2.add(rswithdraw500_Button);
        rswithdraw500_Button.addActionListener(this);
        
        rswithdraw1000_Button = new JButton("RS 1000");
        rswithdraw1000_Button.setBounds(390,499,150,35);
        l2.add(rswithdraw1000_Button);
        rswithdraw1000_Button.addActionListener(this);
        
        rswithdraw2000_Button = new JButton("RS 2000");
        rswithdraw2000_Button.setBounds(170,543,150,35);
        l2.add(rswithdraw2000_Button);
        rswithdraw2000_Button.addActionListener(this);
        
        rswithdraw5000_Button = new JButton("5000");
        rswithdraw5000_Button.setBounds(390,543,150,35);
        l2.add(rswithdraw5000_Button);
        rswithdraw5000_Button.addActionListener(this);
        
        rswithdraw10000_Button = new JButton("RS 10000");
        rswithdraw10000_Button.setBounds(170,588,150,35);
        l2.add(rswithdraw10000_Button);
        rswithdraw10000_Button.addActionListener(this);
        
        rswithdraw15000_Button = new JButton("RS 15000");
        rswithdraw15000_Button.setBounds(390,588,150,35);
        l2.add(rswithdraw15000_Button);
        rswithdraw15000_Button.addActionListener(this);
        
        back_Button = new JButton("BACK");
        back_Button.setBounds(390,633,150,35);
        l2.add(back_Button);
        back_Button.addActionListener(this);
        
        setLayout(null);
        
        setSize(960,1080);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        try
        {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            int balance = 0;
            while (rs.next()) 
            {
                if (rs.getString("type").equals("Deposit")) 
                {
                    balance += Integer.parseInt(rs.getString("amount"));
                } 
                else 
                {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            } 
            if (ae.getSource() != back_Button && balance < Integer.parseInt(amount)) 
            {
                JOptionPane.showMessageDialog(null, "Insuffient Balance");
                return;
            }

            if (ae.getSource() == back_Button) 
            {
                this.setVisible(false);
                new Transcations(pinnumber).setVisible(true);
            }
            else
            {
                Date date = new Date();
                c.s.executeUpdate("insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                    
                setVisible(false);
                new Transcations(pinnumber).setVisible(true);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public static void main(String args[])
    {
        new FastCash("").setVisible(true);
    }
}
