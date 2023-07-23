

package bank.management.system;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;

public class SignupTwo extends JFrame implements ActionListener {
    
    JLabel addtionaldetails,religionlabel,catagorylabel,incomelabel,educationallabel,qualification,occupationlabel,panlabel,adharlabel,citizen,existingacc,l11;
    JTextField panTextField,aadharJTextField;
    JComboBox religionJComboBox,catagoryJComboBox,incomeJComboBox,educationalJComboBox,occupationJComboBox;
    JRadioButton syesJRadioButton,snoJRadioButton,eyesJRadioButton,enoJRadioButton;
    String formno;
    JButton next;
    
    Random ran = new Random();
    long random = Math.abs((ran.nextLong() % 9000L) + 1000L);
    
    SignupTwo(String formno)
    {
        this.formno = formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        addtionaldetails = new JLabel("Page 2: Personal Details");
        addtionaldetails.setFont(new Font("Raleway", Font.BOLD, 22));
        addtionaldetails.setBounds(290,80,400,30);
        add(addtionaldetails);
        
        religionlabel = new JLabel("religion:");
        religionlabel.setFont(new Font("Raleway", Font.BOLD, 20));
        religionlabel.setBounds(100,140,100,30);
        add(religionlabel);
        
        String religion1[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religionJComboBox = new JComboBox(religion1);
        religionJComboBox.setBackground(Color.WHITE);
        religionJComboBox.setFont(new Font("Raleway", Font.BOLD, 14));
        religionJComboBox.setBounds(300,140,400,30);
        add(religionJComboBox);
        
        catagorylabel = new JLabel("Catagory:");
        catagorylabel.setFont(new Font("Raleway", Font.BOLD, 20));
        catagorylabel.setBounds(100,190,200,30);
        add(catagorylabel);
        
       String valcategory[] = {"General","OBC","SC","ST","Other"};
        catagoryJComboBox = new JComboBox(valcategory);
        catagoryJComboBox.setBackground(Color.WHITE);
        catagoryJComboBox.setFont(new Font("Raleway", Font.BOLD, 14));
        catagoryJComboBox.setBounds(300,190,400,30);
        add(catagoryJComboBox);
        
        incomelabel = new JLabel("Income:");
        incomelabel.setFont(new Font("Raleway", Font.BOLD, 20));
        incomelabel.setBounds(100,240,200,30);
        add(incomelabel);
        
        String valincome[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
        incomeJComboBox = new JComboBox(valincome);
        incomeJComboBox.setBackground(Color.WHITE);
        incomeJComboBox.setFont(new Font("Raleway", Font.BOLD, 14));
        incomeJComboBox.setBounds(300, 240, 400, 30);
	add(incomeJComboBox);
        
        educationallabel = new JLabel("Educational");
        educationallabel.setFont(new Font("Raleway", Font.BOLD, 20));
        educationallabel.setBounds(100,290,200,30);
        add(educationallabel);
        
        String valeducation[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        educationalJComboBox = new JComboBox(valeducation);
        educationalJComboBox.setBackground(Color.WHITE);
        educationalJComboBox.setFont(new Font("Raleway", Font.BOLD, 14));
        educationalJComboBox.setBounds(300, 315, 400, 30);
	add(educationalJComboBox);
        
        qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(100,310,200,30);
        add(qualification);
        
        
       
        
        occupationlabel = new JLabel("Occupation:");
        occupationlabel.setFont(new Font("Raleway", Font.BOLD, 20));
        occupationlabel.setBounds(100,390,200,30);
        add(occupationlabel);
        
        String valoccupation[] = {"Salaried","Self-Employmed","Business","Student","Retired","Others"};
        occupationJComboBox = new JComboBox(valoccupation);
        occupationJComboBox.setBackground(Color.WHITE);
        occupationJComboBox.setFont(new Font("Raleway", Font.BOLD, 14));
        occupationJComboBox.setBounds(300,390,400,30);
        add(occupationJComboBox);
        
        panlabel = new JLabel("Pan:");
        panlabel.setFont(new Font("Raleway", Font.BOLD, 20));
        panlabel.setBounds(100,440,200,30);
        add(panlabel);
        
        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(300,440,400,30);
        add(panTextField);
        
        adharlabel = new JLabel("Aadhar:");
        adharlabel.setFont(new Font("Raleway", Font.BOLD, 20));
        adharlabel.setBounds(100,490,200,30);
        add(adharlabel);
        
        aadharJTextField = new JTextField();
        aadharJTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharJTextField.setBounds(300,490,400,30);
        add(aadharJTextField);
        
        citizen = new JLabel("Citizen:");
        citizen.setFont(new Font("Raleway", Font.BOLD, 20));
        citizen.setBounds(100,540,200,30);
        add(citizen);
        
        syesJRadioButton = new JRadioButton("Yes");
        syesJRadioButton.setFont(new Font("Raleway", Font.BOLD, 14));
        syesJRadioButton.setBackground(Color.WHITE);
        syesJRadioButton.setBounds(300,540,100,30);
        add(syesJRadioButton);
        
        snoJRadioButton = new JRadioButton("No");
        snoJRadioButton.setFont(new Font("Raleway", Font.BOLD, 14));
        
        snoJRadioButton.setBackground(Color.WHITE);
        snoJRadioButton.setBounds(500,540,100,30);
        add(snoJRadioButton);
        
        ButtonGroup senior = new ButtonGroup();
        senior.add(syesJRadioButton);
        senior.add(snoJRadioButton);
        
        
        existingacc = new JLabel("Existing Acc:");
        existingacc.setFont(new Font("Raleway", Font.BOLD, 20));
        existingacc.setBounds(100,590,200,30);
        add(existingacc);
        
        snoJRadioButton.setBackground(Color.WHITE);
        snoJRadioButton.setBounds(500,540,100,30);
        add(snoJRadioButton);
        
        ButtonGroup Senior = new ButtonGroup();
        senior.add(syesJRadioButton);
        senior.add(snoJRadioButton);
        eyesJRadioButton = new JRadioButton("Yes");
        eyesJRadioButton.setFont(new Font("Raleway", Font.BOLD, 14));
        eyesJRadioButton.setBackground(Color.WHITE);
        eyesJRadioButton.setBounds(300,590,100,30);
        add(eyesJRadioButton);
        
        enoJRadioButton = new JRadioButton("No");
        enoJRadioButton.setFont(new Font("Raleway", Font.BOLD, 14));
        
        enoJRadioButton.setBackground(Color.WHITE);
        enoJRadioButton.setBounds(500,590,100,30);
        add(enoJRadioButton);
        
        ButtonGroup existing = new ButtonGroup();
        existing.add(eyesJRadioButton);
        existing.add(enoJRadioButton);
        
        
        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620,660,80,30);
        next.addActionListener(this); 
        add(next);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l11 = new JLabel(i3);
        l11.setBounds(20, 0, 100, 100);
        add(l11);
        
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(500,120);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String religion = (String)religionJComboBox.getSelectedItem(); 
        String category = (String)catagoryJComboBox.getSelectedItem();
        String income = (String)incomeJComboBox.getSelectedItem();
        String education = (String)educationalJComboBox.getSelectedItem();
        String occupation = (String)occupationJComboBox.getSelectedItem();
        
        String pan = panTextField.getText();
        String aadhar = aadharJTextField.getText();
        
        
        String scitizen = "";
        if(syesJRadioButton.isSelected())
        { 
            scitizen = "Yes";
        }
        else if(snoJRadioButton.isSelected())
        { 
            scitizen = "No";
        }
           
        String eaccount = "";
        if(eyesJRadioButton.isSelected()){ 
            eaccount = "Yes";
        }else if(enoJRadioButton.isSelected()){ 
            eaccount = "No";
        }
        
        
        try
        {
            if(aadharJTextField.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            }
            else
            {
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+aadhar+"','"+scitizen+"','"+eaccount+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
        } catch(Exception e)
        {
            System.out.println(e);
        }
        
       
    }
    
    public static void main(String args[]){
        
        new SignupTwo("").setVisible(true);
    }
}
