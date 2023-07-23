package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class BalanceEnquiry extends JFrame implements ActionListener
{
    JButton back_Button;
    JLabel balance_Label;
    String pinnumber;

    BalanceEnquiry(String pinnumber) 
    {
        this.pinnumber = pinnumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 1080);
        add(l3);

        int balance = 0;
        
        try
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
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
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        balance_Label = new JLabel();
        balance_Label.setText("Your Current Account Balance is Rs "+balance);
        balance_Label.setForeground(Color.WHITE);
        balance_Label.setFont(new Font("System", Font.BOLD, 16));
        balance_Label.setBounds(190, 350, 400, 35);
        l3.add(balance_Label);

        back_Button = new JButton("BACK");
        back_Button.setBounds(390, 633, 150, 35);
        back_Button.addActionListener(this);
        l3.add(back_Button);

        setLayout(null);
        
        setSize(960, 1080);
        setUndecorated(true);
        setLocation(500, 0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) 
    {
        setVisible(false);
        new Transcations(pinnumber).setVisible(true);
    }
    
    public static void main(String args[])
    {
        new BalanceEnquiry("").setVisible(true);
    }
}
