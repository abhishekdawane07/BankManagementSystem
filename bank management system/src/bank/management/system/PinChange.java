package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PinChange extends JFrame implements ActionListener
{
    JPasswordField newJPasswordField,repinJPasswordField;
    JButton changeButton,BackButton;                               
    JLabel pinchange_JLabel,newpinchange_JLabel,repinchange_JLabel;
    String pinnumber;
    
    PinChange(String pinnumber)
    {
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l4 = new JLabel(i3);
        l4.setBounds(0, 0, 960, 1080);
        add(l4);
        
        pinchange_JLabel = new JLabel("CHANGE YOUR PIN");
        pinchange_JLabel.setFont(new Font("System", Font.BOLD, 16));
        pinchange_JLabel.setForeground(Color.WHITE);
        pinchange_JLabel.setBounds(280,330,800,35);
        l4.add(pinchange_JLabel);
        
        newpinchange_JLabel = new JLabel("New PIN:");
        newpinchange_JLabel.setFont(new Font("System", Font.BOLD, 16));
        newpinchange_JLabel.setForeground(Color.WHITE);
        newpinchange_JLabel.setBounds(180,390,150,35);
        l4.add(newpinchange_JLabel);
        
        repinchange_JLabel = new JLabel("Re-Enter New PIN:");
        repinchange_JLabel.setFont(new Font("System", Font.BOLD, 16));
        repinchange_JLabel.setForeground(Color.WHITE);
        repinchange_JLabel.setBounds(180,440,200,35);
        l4.add(repinchange_JLabel);
        
        newJPasswordField = new JPasswordField();
        newJPasswordField.setFont(new Font("Raleway", Font.BOLD, 25));
        newJPasswordField.setBounds(350,390,180,25);
        l4.add(newJPasswordField);
        
        repinJPasswordField = new JPasswordField();
        repinJPasswordField.setFont(new Font("Raleway", Font.BOLD, 25));
        repinJPasswordField.setBounds(350,440,180,25);
        l4.add(repinJPasswordField);
        
        changeButton = new JButton("CHANGE");
        changeButton.setBounds(390,588,150,35);
        changeButton.addActionListener(this);
        l4.add(changeButton);        
        
        BackButton = new JButton("BACK");
        BackButton.setBounds(390,633,150,35);
        BackButton.addActionListener(this);
        l4.add(BackButton);
        setLayout(null);
        
        setSize(960,1080);
        setLocation(500,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        try
        {        
            String npin = newJPasswordField.getText();
            String rpin = repinJPasswordField.getText();
            
            if(!npin.equals(rpin))
            {
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            
            if(ae.getSource()==changeButton)
            {
                if (newJPasswordField.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                }
                if (repinJPasswordField.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                }
                
                Conn c = new Conn();
                String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";
                String query2 = "update login set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";
                String query3 = "update signupthree set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transcations(rpin).setVisible(true);
            
            }
            else if(ae.getSource()==BackButton)
            {
                new Transcations(pinnumber).setVisible(true);
                setVisible(false);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public static void main(String args[])
    {
        new PinChange("").setVisible(true);
    }
}
