package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUpOne extends JFrame implements ActionListener {

    int formNumber;
    JTextField nt,fnt,et,at,ct,st,pint;
    JButton next;
    JRadioButton male ,female,married,unmarried ,oth;

    JDateChooser dc;

    SignUpOne()
    {
        setLayout(null);
        Random r= new Random();

        // Generate a random four-digit number
         formNumber = 1000 + r.nextInt(9000); // nextInt(9000) will give a range from 0 to 8999

        JLabel form = new JLabel("Application Form Number: " +formNumber) ;
        form.setFont(new Font("Sans",Font.BOLD,38));
        form.setBounds(140,20,600,40);
        add(form);

        JLabel persondetails = new JLabel("Page 1: Personal Details.") ;
        persondetails.setFont(new Font("Sans",Font.BOLD,22));
        persondetails.setBounds(290,80,400,30);
        add(persondetails);

        JLabel name = new JLabel("Name:" ) ;
        name.setFont(new Font("Sans",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        nt= new JTextField();
        nt.setFont(new Font("SansSerif",Font.BOLD,14));
        nt.setBounds(300,140,400,30);
        add(nt);

        JLabel fname = new JLabel("Father's Name:" ) ;
        fname.setFont(new Font("Sans",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);

        fnt = new JTextField();
        fnt.setFont(new Font("SansSerif",Font.BOLD,14));
        fnt.setBounds(300,190,400,30);
        add(fnt);

        JLabel dob = new JLabel("Date Of Birth:" ) ;
        dob.setFont(new Font("Sans",Font.BOLD,20));
        dob.setBounds(100,240,400,30);
        add(dob);

         dc = new JDateChooser();
        dc.setBounds(300, 240,200,30);
        add(dc);

        JLabel gender = new JLabel("Gender:" ) ;
        gender.setFont(new Font("Sans",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);

        male= new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.LIGHT_GRAY);
        add(male);

        female= new JRadioButton("Female");
        female.setBounds(450,290,80,30);
        female.setBackground(Color.LIGHT_GRAY);
        add(female);

        ButtonGroup gen = new ButtonGroup();
        gen.add(male);
        gen.add(female);

        JLabel email = new JLabel("Email Address:" ) ;
        email.setFont(new Font("Sans",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);

        et = new JTextField();
        et.setFont(new Font("SansSerif",Font.BOLD,14));
        et.setBounds(300,340,400,30);
        add(et);

        JLabel maritial = new JLabel("Maritial  Status:" ) ;
        maritial.setFont(new Font("Sans",Font.BOLD,20));
        maritial.setBounds(100,390,200,30);
        add(maritial);

        married = new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.LIGHT_GRAY);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,120,30);
        unmarried.setBackground(Color.LIGHT_GRAY);
        add(unmarried);

        oth= new JRadioButton("Other");
        oth.setBounds(630,390,100,30);
        oth.setBackground(Color.LIGHT_GRAY);
        add(oth);

        ButtonGroup mar = new ButtonGroup();
        mar.add(married);
        mar.add(unmarried);
        mar.add(oth);


        JLabel address = new JLabel(" Address:" ) ;
        address.setFont(new Font("Sans",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);

        at = new JTextField();
        at.setFont(new Font("SansSerif",Font.BOLD,14));
        at.setBounds(300,440,400,30);
        add(at);

        JLabel city = new JLabel("City:" ) ;
        city.setFont(new Font("Sans",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);

        ct = new JTextField();
        ct.setFont(new Font("SansSerif",Font.BOLD,14));
        ct.setBounds(300,490,200,30);
        add(ct);

        JLabel state = new JLabel("State:" ) ;
        state.setFont(new Font("Sans",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);

        st = new JTextField();
        st.setFont(new Font("SansSerif",Font.BOLD,14));
        st.setBounds(300,540,200,30);
        add(st);

        JLabel pin = new JLabel("Pin Code:" ) ;
        pin.setFont(new Font("Sans",Font.BOLD,20));
        pin.setBounds(100,590,200,30);
        add(pin);

        pint = new JTextField();
        pint.setFont(new Font("SansSerif",Font.BOLD,14));
        pint.setBounds(300,590,200,30);
        add(pint);


        next = new JButton("Next");
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.LIGHT_GRAY);

        setSize(900,800);
        setLocation(350 ,10);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e){
        String formNo = ""+formNumber;
        String name= nt.getText();
        String fname = fnt.getText();
        String dob= ((JTextField) dc.getDateEditor().getUiComponent()).getText();
        String gender= null;

        if(male.isSelected()){
            gender= "Male";
        }
        else if (female.isSelected()){
            gender= "Female";
        }

        String email =et.getText();
        String maritial = null;

        if(married.isSelected())
        {
            maritial = "Married";
        } else if (unmarried.isSelected()) {
            maritial = "Unmarried";

        }
        else if(oth.isSelected()){
            maritial= "Other";
        }
        String address= at.getText();
        String city= ct.getText();
        String state= st.getText();
        String pin= pint.getText();


        try {
            if(name.isEmpty()){
                JOptionPane.showMessageDialog(null,"Name cannot be empty");

            }else {
                Conn c = new Conn();
                String query="insert into signup values('"+formNo+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+maritial+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignUpTwo(formNo).setVisible(true);
            }
        }catch (Exception x){
            System.out.println(x);
        }


    }




    public static void main(String[] args) {

        new SignUpOne();

    }
}
