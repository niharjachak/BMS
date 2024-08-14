package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit,withdraw,fastcash, minist,pinchange,balance,exit;
    String  pin;

    Transactions(String pin){
        this.pin= pin;
        setLayout(null);

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i1= i.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i2= new ImageIcon(i1);
        JLabel image= new JLabel(i2);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Please Select your Transaction");
        text.setBounds(220,300,700,35);
        text.setFont(new Font("Calibre",Font.BOLD,16));
        text.setForeground(Color.white);
        image.add(text);

        deposit= new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.setFont(new Font("Calibre",Font.BOLD,14));
        deposit.addActionListener(this);
        image.add(deposit);


        withdraw= new JButton("Withdraw Cash");
        withdraw.setBounds(355,415,150,30);
        withdraw.setFont(new Font("Calibre",Font.BOLD,14));
        withdraw.addActionListener(this);
        image.add(withdraw);

        fastcash= new JButton("Fast Cash");
        fastcash.setBounds(170,450,150,30);
        fastcash.setFont(new Font("Calibre",Font.BOLD,14));
        fastcash.addActionListener(this);
        image.add(fastcash);

        minist = new JButton("Mini Statement");
        minist.setBounds(355,450,150,30);
        minist.setFont(new Font("Calibre",Font.BOLD,14));
        minist.addActionListener(this);
        image.add(minist);

        pinchange= new JButton("Change  PIN");
        pinchange.setBounds(170,485,150,30);
        pinchange.setFont(new Font("Calibre",Font.BOLD,14));
        pinchange.addActionListener(this);
        image.add(pinchange);

        balance= new JButton("Balance Enquiry");
        balance.setBounds(355,485,150,30);
        balance.setFont(new Font("Calibre",Font.BOLD,14));
        balance.addActionListener(this);
        image.add(balance);

        exit= new JButton("Exit");
        exit.setBounds(355,520,150,30);
        exit.setFont(new Font("Calibre",Font.BOLD,14));
        exit.addActionListener(this);
        image.add(exit);

        setSize(900,900);
        setLocation(300,0);
       //setUndecorated(true);



        setVisible(true);


    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== exit){
            System.exit(0);
        } else if (ae.getSource() == deposit) {

            setVisible(false);
            new Deposit(pin).setVisible(true);
        } else if (ae.getSource()== withdraw) {
            setVisible(false);
            new Withdraw(pin).setVisible(true);

        }
        else if (ae.getSource()==fastcash)
        {
            setVisible(false);
            new FastCash(pin).setVisible(true);
        } else if (ae.getSource()==pinchange) {
            setVisible(false);
            new PinChange(pin).setVisible(true);
        } else if (ae.getSource()==balance) {

            setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);

        } else if (ae.getSource()==minist) {
            new MiniStatement(pin).setVisible(true);
        }



    }


    public static void main(String[] args) {

        new Transactions("");
    }
}
