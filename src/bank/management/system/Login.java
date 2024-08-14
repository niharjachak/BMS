package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, clear ,signup;
    JTextField ct;
    JPasswordField pt;

    Login(){
        setTitle("Automated Teller Machine");
        setLayout(null);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2= i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("SansSerif",Font.BOLD,36));
        text.setBounds(200,40,400,40);

        add(text);

        JLabel card = new JLabel("Card No:");
        card.setFont(new Font("Railway",Font.BOLD,26));
        card.setBounds(120,160,400,40);
        add(card);

        ct = new JTextField();
        ct.setBounds(300,160,230,40);
        ct.setFont(new Font("Sans",Font.BOLD,14));
        add(ct);

        JLabel pin = new JLabel("PIN: ");
        pin.setFont(new Font("SansSerif",Font.BOLD,26));
        pin.setBounds(120,230,250,40);
        add(pin);

        pt = new JPasswordField();
        pt.setBounds(300,230,230,40);
        pt.setFont(new Font("Sans",Font.BOLD,14));
        add(pt);

        login = new JButton("Sign In");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.PINK);
        login.setForeground(Color.BLACK);
        login.addActionListener(this);
        add(login);

        clear = new JButton("Clear");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.PINK);
        clear.setForeground(Color.BLACK);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SignUp");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.PINK);
        signup.setForeground(Color.BLACK);
        signup.addActionListener(this);
        add(signup);


        getContentPane().setBackground(Color.white);

        setSize(850,500);
        setVisible(true);
        setLocation(400,250);

    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()== clear){
            ct.setText("");
            pt.setText("");

        } else if (ae.getSource()== login) {
            Conn conn = new Conn();
            String cardNumber= ct.getText();
            String pin = pt.getText();

            String query = "select * from login where cardnumber= '"+cardNumber+"' and pin='"+pin+"'";
            try {
                ResultSet rs = conn.s.executeQuery(query);
                    if(rs.next()){
                        setVisible(false);
                        new Transactions(pin).setVisible(true);
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Incorrect Card Number or PIN");

                    }

            }catch(Exception e){
                System.out.println(e);
            }

        } else if (ae.getSource()== signup) {
            setVisible(false);
            new SignUpOne().setVisible(true);

        }

    }


    public static void main(String[] args) {

        new Login();

    }
}
