package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpTwo extends JFrame implements ActionListener {

    JTextField pant,at, aget, acct;
    JButton next;
    JRadioButton sy, sn,accy,accn;
    JComboBox <String> religion,categ,incateg,educateg,occupation;
    String formNo;


    SignUpTwo(String formNo )
    {
        this.formNo=formNo;
        setLayout(null);

        setTitle("PAGE 2");


        JLabel adddetails = new JLabel("Page 2: Additional Details.") ;
        adddetails.setFont(new Font("Sans",Font.BOLD,22));
        adddetails.setBounds(290,80,400,30);
        add(adddetails);

        JLabel rel = new JLabel("Religion:" ) ;
        rel.setFont(new Font("Sans",Font.BOLD,20));
        rel.setBounds(100,140,100,30);
        add(rel);

        String[] religions= { "Hindu","Muslim","Sikh","Christian","Other" };
        religion = new JComboBox<>(religions);
        religion.setBounds(300,140,400,30);
        religion.setFont(new Font("SansSerif",Font.BOLD,14));
        add(religion);


        JLabel cat = new JLabel("Category:" ) ;
        cat.setFont(new Font("Sans",Font.BOLD,20));
        cat.setBounds(100,190,200,30);
        add(cat);

        String[] category = {"General","OBC","SC","ST","Other"};
        categ= new JComboBox<>(category);
        categ.setFont(new Font("SansSerif",Font.BOLD,14));
        categ.setBounds(300,190,400,30);
        add(categ);


        JLabel income = new JLabel("Income:" ) ;
        income.setFont(new Font("Sans",Font.BOLD,20));
        income.setBounds(100,240,400,30);
        add(income);

        String[] incomecategory = {"NULL","< 150,000","<250,000","<500,000",">500,000"};
        incateg = new JComboBox<>(incomecategory);
        incateg.setFont(new Font("SansSerif",Font.BOLD,14));
        incateg.setBounds(300,240,400,30);
        add(incateg);

        JLabel education = new JLabel("Educational" ) ;
        education.setFont(new Font("Sans",Font.BOLD,20));
        education.setBounds(100,290,200,30);
        add(education);

        JLabel qual = new JLabel("Qualification :" ) ;
        qual.setFont(new Font("Sans",Font.BOLD,20));
        qual.setBounds(100,315,200,30);
        add(qual);

        String[] eduvals = {"Non-Graduate","Graduate","Post-Graduate","Doctorate","Other"};
        educateg = new JComboBox<>(eduvals);
        educateg.setFont(new Font("SansSerif",Font.BOLD,14));
        educateg.setBounds(300,315,400,30);
        add(educateg);


        JLabel occ = new JLabel("Occupation :" ) ;
        occ.setFont(new Font("Sans",Font.BOLD,20));
        occ.setBounds(100,390,200,30);
        add(occ);

        String[] occvals = {"Salaried Employee","Business","Student","Retired","Other"};
        occupation = new JComboBox<>(occvals);
        occupation.setFont(new Font("SansSerif",Font.BOLD,14));
        occupation.setBounds(300,390,400,30);
        add(occupation);



        JLabel pan = new JLabel(" PAN Number:" ) ;
        pan.setFont(new Font("Sans",Font.BOLD,20));
        pan.setBounds(100,440,200,30);
        add(pan);

        pant = new JTextField();
        pant.setFont(new Font("SansSerif",Font.BOLD,14));
        pant.setBounds(300,440,400,30);
        add(pant);

        JLabel adhaar = new JLabel("Adhaar Number:" ) ;
        adhaar.setFont(new Font("Sans",Font.BOLD,20));
        adhaar.setBounds(100,490,200,30);
        add(adhaar);

        at = new JTextField();
        at.setFont(new Font("SansSerif",Font.BOLD,14));
        at.setBounds(300,490,400,30);
        add(at);

        JLabel age = new JLabel("Senior Citizen:" ) ;
        age.setFont(new Font("Sans",Font.BOLD,20));
        age.setBounds(100,540,200,30);
        add(age);


        sy = new JRadioButton("Yes");
        sy.setBounds(300,540,100,30);
        sy.setBackground(Color.LIGHT_GRAY);
        add(sy);

        sn = new JRadioButton("No");
        sn.setBounds(450,540,100,30);
        sn.setBackground(Color.LIGHT_GRAY);
        add(sn);

        ButtonGroup senior = new ButtonGroup();
        senior.add(sy);
        senior.add(sn);



        JLabel acc = new JLabel("Existing Account :" ) ;
        acc.setFont(new Font("Sans",Font.BOLD,20));
        acc.setBounds(100,590,200,30);
        add(acc);


        accy = new JRadioButton("Yes");
        accy.setBounds(300,590,100,30);
        accy.setBackground(Color.LIGHT_GRAY);
        add(accy);

        accn = new JRadioButton("No");
        accn.setBounds(450,590,100,30);
        accn.setBackground(Color.LIGHT_GRAY);
        add(accn);

        ButtonGroup exacc = new ButtonGroup();
        exacc.add(accy);
        exacc.add(accn);


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

        String form = ""+formNo;
        String sreligion= (String)religion.getSelectedItem();
        String scategory = (String)categ.getSelectedItem();
        String sincome= (String)incateg.getSelectedItem();
        String seducation= (String)educateg.getSelectedItem();
        String soccupation= (String)occupation.getSelectedItem();
        String seniorcitizen = null;

        if(sy.isSelected()){
            seniorcitizen= "Yes";
        }
        else if (sn.isSelected()){
            seniorcitizen= "No";
        }


        String existacct = null;

        String address= at.getText();
        if(accy.isSelected())
        {
            existacct = "Yes";
        } else if (accn.isSelected()) {
            existacct = "No";
        }
        String span= pant.getText();
        String sadhaar= at.getText();



        try {

                Conn c = new Conn();
                String query="insert into signuptwo values('"+form+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+sadhaar+"','"+seniorcitizen+"','"+existacct+"')";
                c.s.executeUpdate(query);
                //SignUpThree Object

                setVisible(false);
                  new SignUpThree(formNo).setVisible(true);

        }catch (Throwable x){
            x.printStackTrace();
        }


    }




    public static void main(String[] args) {

        new SignUpTwo("");

    }
}
