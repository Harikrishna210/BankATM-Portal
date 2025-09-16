package bank.atm.portal;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    String pin;
    TextField textField;

    JButton b1,b2;
    Deposit(String pin){
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1400,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);


        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1400,700);
        add(l3);

        JLabel label1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD,16));
        label1.setBounds(400,150,400,35);
        l3.add(label1);         // l3.add because the text should visible on image.

        textField = new TextField();
        textField.setBackground(new Color(65,125,128));
        textField.setForeground(Color.WHITE);
        textField.setBounds(400,200,320,25);
        textField.setFont(new Font("Raleway",Font.BOLD,22));
        l3.add(textField);

        b1 = new JButton("DEPOSIT");
        b1.setBounds(620,305,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(620,345,150,35);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        l3.add(b2);




        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    try{
         String amount = textField.getText();
         Date date = new Date();
           if (e.getSource()==b1){
               if (textField.getText().equals("")){
                   JOptionPane.showMessageDialog(null,"Please enter the amount you want to Deposit");
               }else{
                   conn c = new conn();
                   c.statement.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Deposit', '"+amount+"')");
                   JOptionPane.showMessageDialog(null,"Rs. "+amount+" Deposited Successfully");
                   setVisible(false);
                   new Main_Class(pin);
               }
           }else if (e.getSource()==b2){
               setVisible(false);
               new Main_Class(pin);
           }
       }catch (Exception E){
        E.printStackTrace();
      }

    }

    public static void main(String[] args) {
        new Deposit("");
    }
}

