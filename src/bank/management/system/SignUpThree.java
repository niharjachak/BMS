package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SignUpThree  extends JFrame implements ActionListener{
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formNo;
    SignUpThree( String formNo){
        this.formNo=formNo;

        setLayout(null);
        JLabel l1= new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);

        JLabel accountType= new JLabel("ACCOUNT TYPE:");
        accountType.setFont(new Font("Raleway",Font.BOLD,22));
        accountType.setBounds(100,140,200,30);
        add(accountType);

        r1 = new JRadioButton("SAVINGS ACCOUNT");
        r1.setFont(new Font("Rale way",Font.BOLD,16));
        r1.setBackground(Color.LIGHT_GRAY);
        r1.setBounds(110,190,250,20);
        add(r1);

        r2 = new JRadioButton("FIXED DEPOSIT ACCOUNT");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.LIGHT_GRAY);
        r2.setBounds(360,190,250,20);
        add(r2);

        r3 = new JRadioButton("CURRENT ACCOUNT ");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.LIGHT_GRAY);
        r3.setBounds(110,230,250,20);
        add(r3);

        r4 = new JRadioButton("RECCURING DEPOSIT ACCOUNT");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.LIGHT_GRAY);
        r4.setBounds(360,230,250,20);
        add(r4);

        ButtonGroup group = new ButtonGroup();
        group.add(r1);
        group.add(r2);
        group.add(r3);
        group.add(r4);


        JLabel card = new JLabel("CARD NUMBER: ");
        card.setFont(new Font("Raleway", Font.BOLD,22));
        card.setBounds(100,300,200,30);
        add(card);

        JLabel number =new JLabel("XXXX-XXXX-XXXX-6969");
        number.setFont(new Font("Raleway", Font.BOLD,22));
        number.setBounds(330,300,300,30);
        add(number);

        JLabel pin = new JLabel("PIN: ");
        pin.setFont(new Font("Raleway", Font.BOLD,22));
        pin.setBounds(100,370,300,30);
        add(pin);

        JLabel pinnumber= new JLabel("XXXX");
        pinnumber.setFont(new Font("Raleway", Font.BOLD,22));
        pinnumber.setBounds(330,370,300,30);
        add(pinnumber);

        JLabel services = new JLabel("SERVICES REQUIRED: ");
        services.setFont(new Font("Raleway", Font.BOLD,22));
        services.setBounds(100,450,400,30);
        add(services);

        c1= new JCheckBox("ATM CARD");
        c1.setForeground(Color.BLACK);
        c1.setBackground(Color.LIGHT_GRAY);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);

        c2= new JCheckBox("INTERNET BANKING");
        c2.setForeground(Color.BLACK);
        c2.setBackground(Color.LIGHT_GRAY);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        add(c2);

        c3= new JCheckBox("MOBILE BANKING");
        c3.setForeground(Color.BLACK);
        c3.setBackground(Color.LIGHT_GRAY);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        add(c3);

        c4= new JCheckBox("EMAIL/SMS ALERTS");
        c4.setForeground(Color.BLACK);
        c4.setBackground(Color.LIGHT_GRAY);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,550,200,30);
        add(c4);

        c5= new JCheckBox("CHECKBOOK");
        c5.setForeground(Color.BLACK);
        c5.setBackground(Color.LIGHT_GRAY);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5);

        c6= new JCheckBox("E-STATEMENTS");
        c6.setForeground(Color.BLACK);
        c6.setBackground(Color.LIGHT_GRAY);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,600,200,30);
        add(c6);

        c7= new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
        c7.setForeground(Color.BLACK);
        c7.setBackground(Color.LIGHT_GRAY);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,660,600,30);
        add(c7);

        submit = new JButton("Submit ");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(250,720,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel ");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);

        add(cancel);

        getContentPane().setBackground(Color.LIGHT_GRAY);

        setSize(850,820);
        setLocation(350,0);
        setVisible(true);


    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() ==submit)
        {
            String accountType = null;
            if(c1.isSelected()){
                accountType ="SAVINGS ACCOUNT";
            }
            else if(c2.isSelected()){
                accountType ="FIXED DEPOSIT ACCOUNT";

            } else if (c3.isSelected()) {
                accountType ="CURRENT ACCOUNT";
                
            }else if(c4.isSelected()){
                accountType ="RECCURING ACCOUNT";
            }
            Random r = new Random();
            long randomPart = Math.abs(r.nextLong() % 9000000L) + 1000000L; // Ensuring it's a 7-digit number
            long fixedPart = 5040629300000000L;
            String cardno = String.valueOf(fixedPart + randomPart);

            // Generate a random 4-digit PIN
            int pinno = r.nextInt(9000) + 1000;
            String pinnumber = Integer.toString(pinno);

            String facility = " ";

            if(c1.isSelected()){
                facility+= "ATM CARD";

            }
            else if (c2.isSelected()){
                facility+=" Internet Banking";
            }
            else if(c3.isSelected()){
                facility+=" Mobile Banking";
            }
            else if(c4.isSelected()) {
                facility+=" Email/SMS ALerts";
            } else if (c5.isSelected()) {
                facility+=" CheckBook";
            }
            else if (c5.isSelected()){
                facility+="E Statement";
            }

            try {
                if (accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type necessary!");
                }
                else{
                  Conn conn = new Conn();
                  String query1 = "insert into signupthree values('"+formNo+"','"+accountType+"','"+cardno+"','"+pinno+"','"+facility+"')";
                  String query2 = "insert into login values('"+formNo+"','"+cardno+"','"+pinno+"')";

                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);

                  JOptionPane.showMessageDialog(null,"Card number: "+cardno+"\n PIN: "+ pinno );

                  setVisible(false);
                  new Deposit(pinnumber).setVisible(true);
                }

            }catch (Exception e){
                System.out.println(e);
            }


        } else if (ae.getSource()==cancel) {

            setVisible(false);
            new Login().setVisible(true);
            
        }

    }


    public static void main(String[] args) {

        new SignUpThree("");
    }
}
