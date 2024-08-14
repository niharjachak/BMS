package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton deposit,withdraw,fastcash,st,pinchange,balance,exit;
    String  pin;

    FastCash(String pin){
        this.pin= pin;
        setLayout(null);

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i1= i.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i2= new ImageIcon(i1);
        JLabel image= new JLabel(i2);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Please Select your Withdrawal Amount");
        text.setBounds(220,300,700,35);
        text.setFont(new Font("Calibre",Font.BOLD,16));
        text.setForeground(Color.white);
        image.add(text);

        deposit= new JButton("RS 200");
        deposit.setBounds(170,415,150,30);
        deposit.setFont(new Font("Calibre",Font.BOLD,14));
        deposit.addActionListener(this);
        image.add(deposit);


        withdraw= new JButton("Rs 500");
        withdraw.setBounds(355,415,150,30);
        withdraw.setFont(new Font("Calibre",Font.BOLD,14));
        withdraw.addActionListener(this);
        image.add(withdraw);

        fastcash= new JButton("Rs 1000");
        fastcash.setBounds(170,450,150,30);
        fastcash.setFont(new Font("Calibre",Font.BOLD,14));
        fastcash.addActionListener(this);
        image.add(fastcash);

        st= new JButton("Rs 2000");
        st.setBounds(355,450,150,30);
        st.setFont(new Font("Calibre",Font.BOLD,14));
        st.addActionListener(this);
        image.add(st);

        pinchange= new JButton("Rs  5000");
        pinchange.setBounds(170,485,150,30);
        pinchange.setFont(new Font("Calibre",Font.BOLD,14));
        pinchange.addActionListener(this);
        image.add(pinchange);

        balance= new JButton("Rs 10000");
        balance.setBounds(355,485,150,30);
        balance.setFont(new Font("Calibre",Font.BOLD,14));
        balance.addActionListener(this);
        image.add(balance);

        exit= new JButton("Back");
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
            setVisible(false);
            new Transactions(pin).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pin= '"+pin+"'");
                int balance =0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance+= Integer.parseInt(rs.getString("amount"));
                    }
                    else {
                        balance-= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource()!= exit && balance <Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                }
                else {
                    Date date = new Date();

                    String query = "insert into bank values ('"+pin+"','"+date+"','Withdrawal','"+amount+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs"+amount+"Debited Succesfully");

                    setVisible(false);
                    new Transactions(pin).setVisible(true);

                }
            }catch (Exception e){
                System.out.println(e);
            }

        }


    }


    public static void main(String[] args) {

        new FastCash("");
    }
}
