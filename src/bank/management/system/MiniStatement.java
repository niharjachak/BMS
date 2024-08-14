package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {
    String pinnumber;

    MiniStatement(String pinnumber){
        this.pinnumber= pinnumber;

        setLayout(null);
        setTitle("Mini Statement");


        JLabel text = new JLabel(" ");
        add(text);

        JLabel mini= new JLabel();
        mini.setBounds(20,140,400, 200);
        add(mini);

        JLabel bank = new JLabel("Bank");
        bank.setBounds(150,20,100,20);
        add(bank);



        JLabel card= new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20,400,320,20);

        add(balance);
        try {
            Conn conn = new Conn();

            ResultSet rs=conn.s.executeQuery("select * from login where pin = '"+pinnumber+"'  ");
            while(rs.next()){
                balance.setText( "Card Number: "+rs.getString("cardnumber").substring(0,4)+" XXXX XXXX " +rs.getString("cardnumber").substring(12) );
            }
        }catch(Exception e){
            System.out.println(e);
        }
        try{

            Conn conn = new Conn();
            int bal= 0;
            ResultSet r = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(r.next()){
                mini.setText(mini.getText()+"<html>"+ r.getString("date")+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ r.getString("type") +" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+r.getString("amount")+"<br><br><html>");

                if(r.getString("type").equals("Deposit")){
                    bal+= Integer.parseInt(r.getString("amount"));
                }
                else {
                    bal-= Integer.parseInt(r.getString("amount"));
                }
            }
            balance.setText("Current Account Balance : Rs "+bal);

        }catch(Exception e)
        {
            System.out.println(e);
        }



        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setVisible(true);
    }


    public static void main(String[] args) {
        new MiniStatement("");
    }
}
