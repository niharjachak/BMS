package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {

    JPasswordField pin,repin;
    JButton change,back;
    String pinnumber;

    PinChange(String pinnumber){
        this.pinnumber= pinnumber;
        setLayout(null);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 =  i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);

        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Change PIN");
        text.setForeground(Color.white);
        text.setFont(new Font("SanSerif",Font.BOLD,16));
        text.setBounds(250,280,500,35);
        image.add(text);

        JLabel newpin = new JLabel("New PIN:");
        newpin.setForeground(Color.white);
        newpin.setFont(new Font("SanSerif",Font.BOLD,16));
        newpin.setBounds(165,320,180,25);
        image.add(newpin);

        pin= new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        pin.setBounds(330,320,180,25);
        image.add(pin);

        JLabel confirmpin = new JLabel("Confrim New PIN:");
        confirmpin.setForeground(Color.white);
        confirmpin.setFont(new Font("SanSerif",Font.BOLD,16));
        confirmpin.setBounds(165,360,180,25);
        image.add(confirmpin);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,25));
        repin.setBounds(330,360,180,25);
        image.add(repin);

        change = new JButton("Change PIN");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setVisible(true);


    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==change){
            try {
                String pass = pin.getText();
                String rpass = repin.getText();

                if (!pass.equals(rpass)) {
                    JOptionPane.showMessageDialog(null, "New PIN and Confirmed PIN do not match! ");
                }

                if(pass.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter New PIN ");

                }
                if(rpass.equals(" ")){
                    JOptionPane.showMessageDialog(null, "Please re-enter New PIN ");

                }

                Conn conn = new Conn();
                String query1= "  update bank set pin='"+rpass+"'where pin='"+pinnumber+"'  ";
                String query2= "  update login set pin='"+rpass+"'where pin='"+pinnumber+"'  ";
                String query3= "  update signupthree set pin='"+rpass+"'where pin='"+pinnumber+"'  ";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, " New PIN updated successfuly");

                setVisible(false);
                new Transactions(pinnumber).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }


    }


    public static void main(String[]args)
    {
            new PinChange("").setVisible(true);

    }
}

