package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

    JLabel text;
    JTextField amount;
    JButton deposit,back ;
    String pin;
    Deposit(String pin){
        this.pin = pin;

        setLayout(null);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);


        text = new JLabel("Enter The amount you want to Deposit");
       text.setForeground(Color.white);
        text.setFont(new Font("SansSerif",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);


        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(170,350,320,25);
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(358,485,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("Back");
        back.setBounds(358,520,150,30);
        back.addActionListener(this);
        image.add(back);



        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }

    public void actionPerformed (ActionEvent ae){

        if(ae.getSource()== deposit){

            String dep =amount.getText();
            Date date = new Date();
            if(dep.equals("")){
                JOptionPane.showMessageDialog(null,"Deposit Amount cannot be empty!");
            }
            else{
                try{
                Conn conn = new Conn();
                String query ="insert into bank values('"+pin+"','"+date+"','Deposit','"+dep+"');";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs"+dep+" Deposited Succesfully");
                setVisible(false);
                new Transactions(pin).setVisible(true);
                }catch (Exception e){
                    System.out.println(e);
                }
            }


        } else if (ae.getSource()==back) {
            new Transactions(pin).setVisible(true);


        }

    }

    public static void main(String[] args) {
        new Deposit("");
    }

}
