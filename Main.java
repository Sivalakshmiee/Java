
//updated
import javax.swing.*;
import java.io.IOException;
import javax.swing.text.StyledEditorKit.BoldAction;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.sql.*;

class FrontPage extends JFrame implements ActionListener {
    JPanel panel;
    JLabel user_label, password_label, titleLabel, howLabel, sign, dev, alert;
    JTextField userName_text;
    JTextArea how_text;
    JPasswordField password_text;
    JButton submit, signin;
    JPanel panel1;
    String str;

    public void sign() {
        user_label = new JLabel();
        user_label.setText("Username");
        user_label.setFont(new Font("Times new roman", Font.BOLD, 17));
        userName_text = new JTextField();

        password_label = new JLabel();
        password_label.setText("Password");
        password_label.setFont(new Font("Times new roman", Font.BOLD, 17));
        password_text = new JPasswordField();

        titleLabel = new JLabel();
        titleLabel.setText("INVENTORY MANAGEMENT SYSTEM");
        titleLabel.setFont(new Font("Verdana", Font.BOLD, 23));

        alert = new JLabel();

        alert.setFont(new Font("Verdana", Font.BOLD, 15));

        howLabel = new JLabel();
        howLabel.setText("HOW IT WORKS");
        howLabel.setFont(new Font("Times new roman", Font.BOLD, 15));

        how_text = new JTextArea();
        how_text.setText(
                "Inventory is the goods or materials a \n business intends to sell to customers for profit.\n  Inventory management, a critical element of the \n supply chain, is the tracking of inventory \n from manufacturers to warehouses and \n from these facilities to a point of sale.\n The goal of inventory management is to have the \n right products in the right place at the right time.\n This requires inventory visibility — knowing when \n to order, how much to order and where to store stock. ");

        sign = new JLabel();
        sign.setText("If you are new user for this application please sign in");

        signin = new JButton();
        Color s = new Color(255, 10, 0);
        signin.setBackground(s);
        signin.setText("Sign in");

        submit = new JButton();
        Color e = new Color(45, 190, 120);
        submit.setBackground(e);
        submit.setText("Login");

        dev = new JLabel();
        dev.setText("@Developed by Sivalakshmi");

        panel = new JPanel(null);
        titleLabel.setBounds(420, 45, 500, 30);
        signin.setBounds(820, 530, 100, 30);
        user_label.setBounds(450, 400, 100, 30);
        userName_text.setBounds(820, 400, 300, 30);
        password_label.setBounds(450, 450, 150, 30);
        password_text.setBounds(820, 450, 300, 30);
        submit.setBounds(450, 530, 100, 30);
        sign.setBounds(650, 530, 400, 150);
        howLabel.setBounds(100, 120, 140, 100);
        how_text.setBounds(100, 200, 250, 400);
        dev.setBounds(1090, 500, 500, 270);
        alert.setBounds(520, 150, 500, 30);

        Color c = new Color(220, 210, 250);
        panel.setBackground(c);
        panel.add(titleLabel);
        panel.add(user_label);
        panel.add(userName_text);
        panel.add(password_label);
        panel.add(password_text);
        panel.add(submit);
        panel.add(sign);
        panel.add(signin);
        panel.add(howLabel);
        panel.add(howLabel);
        panel.add(how_text);
        panel.add(dev);
        panel.add(alert);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        submit.addActionListener(this);
        signin.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("INVENTORY MANAGEMENT SYSTEM");
        setSize(1000, 1000);
        setVisible(true);
        setLocationRelativeTo(null);

    }

    public void actionPerformed(ActionEvent ae) {
        String str;
        str = ae.getActionCommand();

        if (str.equalsIgnoreCase("SIGN IN")) {
            new signin();
            System.out.println(str);
        } else if (str.equalsIgnoreCase("LOGIN")) {
            System.out.println(str);
            String Username1 = userName_text.getText();
            String Password1 = password_text.getText();
            int count = 0;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/main", "root", "");
                Statement st = con.createStatement();
                String sql = "SELECT * FROM signin ";
                // st.executeQuery(sql);
                PreparedStatement pr = con.prepareStatement(sql);
                ResultSet rs = pr.executeQuery();
                while (rs.next()) {
                    String user1 = rs.getString("username");
                    String pass1 = rs.getString("password");
                    if (Username1.equals(user1) && Password1.equals(pass1)) {
                        count++;
                        new inventory();
                        break;

                    }
                }
                if (count <= 0) {
                    alert.setText("Login failed! Sign in first");
                    System.out.println("error");

                }

            } catch (Exception e) {
                System.out.println(e);

            }

        }
    }

}

// sign in page
class signin extends JFrame implements ActionListener {
    JPanel panel;
    JLabel user_label;
    JLabel password_label;
    JLabel repass_label;
    JLabel img_label;
    JLabel dev;
    JLabel howLabel;
    JLabel gifLabel;
    JLabel email_label;
    JLabel titleLabel;
    JTextField userName_text, email_text;
    JTextArea how_text;
    JPasswordField password_text, repass_text;
    JButton submit;
    String username, email, password, repassword;

    signin() {
        titleLabel = new JLabel();
        titleLabel.setText("Sign In");
        titleLabel.setFont(new Font("Verdana", Font.BOLD, 23));

        user_label = new JLabel();
        user_label.setText("Username");
        user_label.setFont(new Font("Times new roman", Font.BOLD, 17));
        userName_text = new JTextField();

        email_label = new JLabel();
        email_label.setText("Email");
        email_label.setFont(new Font("Times new roman", Font.BOLD, 17));
        email_text = new JTextField();

        password_label = new JLabel();
        password_label.setText("Password");
        password_label.setFont(new Font("Times new roamn", Font.BOLD, 17));
        password_text = new JPasswordField();

        repass_label = new JLabel();
        repass_label.setText("Re-password");
        repass_label.setFont(new Font("Times new roamn", Font.BOLD, 17));
        repass_text = new JPasswordField();

        submit = new JButton("SIGN IN");

        img_label = new JLabel(new ImageIcon("signin.png"));
        gifLabel = new JLabel(new ImageIcon("line1.gif"));

        dev = new JLabel();
        dev.setText("@Developed by Sivalakshmi");

        howLabel = new JLabel();
        howLabel.setText(
                "Inventory is the goods or materials a business intends to sell to customers for profit. Inventory management, a critical element of the supply chain, is the tracking of inventory from manufacturers to warehouses and from these facilities to a point of sale.\n The goal of inventory management is to have the right products in the right place at the right time.\n This requires inventory visibility — knowing when to order, how much to order and where to store stock. ");
        howLabel.setFont(new Font("Times new roman", Font.ITALIC, 15));

        panel = new JPanel(null);
        titleLabel.setBounds(600, 25, 100, 30);
        img_label.setBounds(520, 35, 270, 270);
        user_label.setBounds(500, 350, 100, 30);
        userName_text.setBounds(650, 350, 250, 30);
        email_label.setBounds(500, 400, 250, 30);
        email_text.setBounds(650, 400, 250, 30);
        password_label.setBounds(500, 450, 100, 30);
        password_text.setBounds(650, 450, 250, 30);
        repass_label.setBounds(500, 500, 150, 30);
        repass_text.setBounds(650, 500, 250, 30);
        submit.setBounds(720, 570, 100, 30);
        // // how_text.setBounds(40, 100, 160, 400);
        howLabel.setBounds(60, 20, 140, 100);
        dev.setBounds(1020, 700, 500, 30);
        gifLabel.setBounds(500, 620, 390, 3);

        Color c = new Color(32, 178, 170);
        panel.setBackground(c);
        panel.add(titleLabel);
        panel.add(img_label);
        panel.add(user_label);
        panel.add(userName_text);
        panel.add(email_label);
        panel.add(email_text);
        panel.add(password_label);
        panel.add(password_text);
        panel.add(repass_label);
        panel.add(repass_text);
        panel.add(submit);
        panel.add(dev);
        // // panel.add(how_text);
        panel.add(howLabel);
        panel.add(gifLabel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        submit.addActionListener(this);
        add(panel, BorderLayout.CENTER);

        setTitle("Sign in");
        setSize(1000, 1000);
        setVisible(true);
        setLocationRelativeTo(null);

    }

    public void actionPerformed(ActionEvent ae) {

        String username = userName_text.getText();
        String password = password_text.getText();
        String email = email_text.getText();
        String repassword = repass_text.getText();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/main", "root", "");
            System.out.println("Xampp Mysql Connected....");
            Statement st = con.createStatement();
            st.executeUpdate(
                    "insert into signin values('" + username + "','" + email + "','" + password + "','"
                            + repassword + "')");
            System.out.println("Inserted Successfully");

        } catch (Exception e) {
            System.out.println("Not Connected");
        }
        new inventory();
    }
}

class inventory extends JFrame implements ActionListener {
    JLabel titlelabel, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, n1, n2, imgLabel, imgLable1,
            imgLabel2, imgLabel3, imgLabel4, imgLabel5,
            imgLabel6, imgLabel7;
    JButton Next;
    JPanel panel;

    inventory() {
        titlelabel = new JLabel();
        titlelabel.setText("Laptops");
        titlelabel.setFont(new Font("Times new roamn", Font.BOLD, 23));

        imgLabel = new JLabel(new ImageIcon("Img 3.jpg"));

        p1 = new JLabel();
        p1.setText("ASUS VivoBook 14");
        p1.setFont(new Font("Times new roamn", Font.BOLD, 15));

        p2 = new JLabel();
        p2.setText("Price: Rs 54,000");
        p2.setFont(new Font("Times new roamn", Font.BOLD, 15));

        imgLable1 = new JLabel(new ImageIcon("Img 2.jpg"));

        p3 = new JLabel();
        p3.setText("DELL 15");
        p3.setFont(new Font("Times new roamn", Font.BOLD, 15));

        p4 = new JLabel();
        p4.setText("Price: Rs 40,000");
        p4.setFont(new Font("Times new roamn", Font.BOLD, 15));

        imgLabel2 = new JLabel(new ImageIcon("Img 4.png"));

        p5 = new JLabel();
        p5.setText("HP 15s");
        p5.setFont(new Font("Times new roamn", Font.BOLD, 15));

        p6 = new JLabel();
        p6.setText("Price: Rs 50,000");
        p6.setFont(new Font("Times new roamn", Font.BOLD, 15));

        imgLabel3 = new JLabel(new ImageIcon("Img 5.png"));

        p7 = new JLabel();
        p7.setText("Apple MacBook Pro");
        p7.setFont(new Font("Times new roamn", Font.BOLD, 15));

        p8 = new JLabel();
        p8.setText("Price: Rs 2,19,890");
        p8.setFont(new Font("Times new roamn", Font.BOLD, 15));

        imgLabel4 = new JLabel(new ImageIcon("Img 6.png"));

        p9 = new JLabel();
        p9.setText("Lenovo IdeaPad");
        p9.setFont(new Font("Times new roamn", Font.BOLD, 15));

        p10 = new JLabel();
        p10.setText("Price: Rs 55,000");
        p10.setFont(new Font("Times new roamn", Font.BOLD, 15));

        imgLabel5 = new JLabel(new ImageIcon("Img 7.jpg"));

        p11 = new JLabel();
        p11.setText("LG gram");
        p11.setFont(new Font("Times new roamn", Font.BOLD, 15));

        p12 = new JLabel();
        p12.setText("Price: Rs 82,000");
        p12.setFont(new Font("Times new roamn", Font.BOLD, 15));

        imgLabel6 = new JLabel(new ImageIcon("Img 8.jpg"));

        p13 = new JLabel();
        p13.setText("Redmi Book Pro");
        p13.setFont(new Font("Times new roamn", Font.BOLD, 15));

        p14 = new JLabel();
        p14.setText("Price: Rs 48,000");
        p14.setFont(new Font("Times new roamn", Font.BOLD, 15));

        imgLabel7 = new JLabel(new ImageIcon("Img 9.png"));

        n1 = new JLabel();
        n1.setText("Mi NoteBook");
        n1.setFont(new Font("Times new roamn", Font.BOLD, 15));

        n2 = new JLabel();
        n2.setText("Price: Rs 67,000");
        n2.setFont(new Font("Times new roamn", Font.BOLD, 15));

        Next = new JButton("Next");
        Next.addActionListener(this);

        panel = new JPanel(null);
        titlelabel.setBounds(600, 35, 170, 30);
        imgLabel.setBounds(40, 150, 250, 150);
        p1.setBounds(45, 300, 150, 30);
        p2.setBounds(45, 320, 150, 30);
        imgLable1.setBounds(330, 150, 250, 150);
        p3.setBounds(350, 300, 150, 30);
        p4.setBounds(350, 320, 150, 30);
        imgLabel2.setBounds(610, 150, 250, 150);
        p5.setBounds(650, 300, 150, 30);
        p6.setBounds(650, 320, 150, 30);
        imgLabel3.setBounds(900, 150, 250, 150);
        p7.setBounds(950, 300, 150, 30);
        p8.setBounds(950, 320, 150, 30);
        imgLabel4.setBounds(40, 400, 250, 150);
        p9.setBounds(45, 550, 150, 30);
        p10.setBounds(45, 570, 150, 30);
        imgLabel5.setBounds(330, 400, 250, 150);
        p11.setBounds(350, 550, 150, 30);
        p12.setBounds(350, 570, 150, 30);
        imgLabel6.setBounds(610, 400, 250, 150);
        p13.setBounds(650, 550, 150, 30);
        p14.setBounds(650, 570, 150, 30);
        imgLabel7.setBounds(900, 400, 250, 150);
        n1.setBounds(950, 550, 150, 30);
        n2.setBounds(950, 570, 150, 30);
        Next.setBounds(1100, 50, 80, 30);

        Color c = new Color(32, 178, 170);
        panel.setBackground(c);
        panel.add(titlelabel);
        panel.add(p1);
        panel.add(imgLabel);
        panel.add(p2);
        panel.add(p3);
        panel.add(imgLable1);
        panel.add(p4);
        panel.add(imgLabel2);
        panel.add(p5);
        panel.add(p5);
        panel.add(p6);
        panel.add(imgLabel3);
        panel.add(p7);
        panel.add(p8);
        panel.add(imgLabel4);
        panel.add(p9);
        panel.add(p10);
        panel.add(imgLabel5);
        panel.add(p11);
        panel.add(p12);
        panel.add(imgLabel6);
        panel.add(p13);
        panel.add(p14);
        panel.add(imgLabel7);
        panel.add(n1);
        panel.add(n2);
        panel.add(Next);

        setTitle("Laptop Details");
        setSize(1000, 1000);
        setVisible(true);
        setLocationRelativeTo(null);
        add(panel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new inventory2();

    }

}

class inventory2 extends JFrame implements ActionListener {
    JLabel titlelabel, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, n1, n2, imgLabel, imgLable1,
            imgLabel2, imgLabel3, imgLabel4, imgLabel5,
            imgLabel6, imgLabel7;
    JButton Next;
    JPanel panel;

    public inventory2() {

        titlelabel = new JLabel();
        titlelabel.setText("Mobiles");
        titlelabel.setFont(new Font("Times new roamn", Font.BOLD, 23));

        imgLabel = new JLabel(new ImageIcon("Img 10.jpeg"));

        p1 = new JLabel();
        p1.setText("Vivo Y21");
        p1.setFont(new Font("Times new roamn", Font.BOLD, 15));

        p2 = new JLabel();
        p2.setText("Price: Rs 14,000");
        p2.setFont(new Font("Times new roamn", Font.BOLD, 15));

        imgLable1 = new JLabel(new ImageIcon("Img 11.jpeg"));

        p3 = new JLabel();
        p3.setText("IQOO 9 Pro");
        p3.setFont(new Font("Times new roamn", Font.BOLD, 15));

        p4 = new JLabel();
        p4.setText("Price: Rs 70, 000");
        p4.setFont(new Font("Times new roamn", Font.BOLD, 15));

        imgLabel2 = new JLabel(new ImageIcon("Img 12.jpeg"));

        p5 = new JLabel();
        p5.setText("Xiaomi");
        p5.setFont(new Font("Times new roamn", Font.BOLD, 15));

        p6 = new JLabel();
        p6.setText("Price: Rs 27,000");
        p6.setFont(new Font("Times new roamn", Font.BOLD, 15));

        imgLabel3 = new JLabel(new ImageIcon("Img 13.jpeg"));

        p7 = new JLabel();
        p7.setText("Samsumg s22");
        p7.setFont(new Font("Times new roamn", Font.BOLD, 15));

        p8 = new JLabel();
        p8.setText("Price: Rs 1,19,890");
        p8.setFont(new Font("Times new roamn", Font.BOLD, 15));

        imgLabel4 = new JLabel(new ImageIcon("Img 14.jpeg"));

        p9 = new JLabel();
        p9.setText("Samsung s21");
        p9.setFont(new Font("Times new roamn", Font.BOLD, 15));

        p10 = new JLabel();
        p10.setText("Price: Rs 55,000");
        p10.setFont(new Font("Times new roamn", Font.BOLD, 15));

        imgLabel5 = new JLabel(new ImageIcon("Img 15.jpeg"));

        p11 = new JLabel();
        p11.setText("Samsung A5");
        p11.setFont(new Font("Times new roamn", Font.BOLD, 15));

        p12 = new JLabel();
        p12.setText("Price: Rs 21,000");
        p12.setFont(new Font("Times new roamn", Font.BOLD, 15));

        imgLabel6 = new JLabel(new ImageIcon("Img 16.jpeg"));

        p13 = new JLabel();
        p13.setText("One Plus");
        p13.setFont(new Font("Times new roamn", Font.BOLD, 15));

        p14 = new JLabel();
        p14.setText("Price: Rs 37,000");
        p14.setFont(new Font("Times new roamn", Font.BOLD, 15));

        imgLabel7 = new JLabel(new ImageIcon("Img 17.jpeg"));

        n1 = new JLabel();
        n1.setText("Samsumg M32");
        n1.setFont(new Font("Times new roamn", Font.BOLD, 15));

        n2 = new JLabel();
        n2.setText("Price: Rs 21,000");
        n2.setFont(new Font("Times new roamn", Font.BOLD, 15));

        Next = new JButton("Next");
        Next.addActionListener(this);

        panel = new JPanel(null);
        titlelabel.setBounds(600, 35, 170, 30);
        imgLabel.setBounds(40, 150, 250, 150);
        p1.setBounds(45, 300, 150, 30);
        p2.setBounds(45, 320, 150, 30);
        imgLable1.setBounds(330, 150, 250, 150);
        p3.setBounds(350, 300, 150, 30);
        p4.setBounds(350, 320, 150, 30);
        imgLabel2.setBounds(610, 150, 250, 150);
        p5.setBounds(650, 300, 150, 30);
        p6.setBounds(650, 320, 150, 30);
        imgLabel3.setBounds(900, 150, 250, 150);
        p7.setBounds(950, 300, 150, 30);
        p8.setBounds(950, 320, 150, 30);
        imgLabel4.setBounds(40, 400, 250, 150);
        p9.setBounds(45, 550, 150, 30);
        p10.setBounds(45, 570, 150, 30);
        imgLabel5.setBounds(330, 400, 250, 150);
        p11.setBounds(350, 550, 150, 30);
        p12.setBounds(350, 570, 150, 30);
        imgLabel6.setBounds(610, 400, 250, 150);
        p13.setBounds(650, 550, 150, 30);
        p14.setBounds(650, 570, 150, 30);
        imgLabel7.setBounds(900, 400, 250, 150);
        n1.setBounds(950, 550, 150, 30);
        n2.setBounds(950, 570, 150, 30);
        Next.setBounds(1100, 50, 80, 30);

        Color c = new Color(32, 178, 170);
        panel.setBackground(c);
        panel.add(titlelabel);
        panel.add(p1);
        panel.add(imgLabel);
        panel.add(p2);
        panel.add(p3);
        panel.add(imgLable1);
        panel.add(p4);
        panel.add(imgLabel2);
        panel.add(p5);
        panel.add(p5);
        panel.add(p6);
        panel.add(imgLabel3);
        panel.add(p7);
        panel.add(p8);
        panel.add(imgLabel4);
        panel.add(p9);
        panel.add(p10);
        panel.add(imgLabel5);
        panel.add(p11);
        panel.add(p12);
        panel.add(imgLabel6);
        panel.add(p13);
        panel.add(p14);
        panel.add(imgLabel7);
        panel.add(n1);
        panel.add(n2);
        panel.add(Next);
        setTitle("Laptop Details");
        setSize(1000, 1000);
        setVisible(true);
        setLocationRelativeTo(null);
        add(panel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new inventory3();

    }

}

class inventory3 extends JFrame implements ActionListener {
    JLabel titlelabel, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, n1, n2, imgLabel, imgLable1,
            imgLabel2, imgLabel3, imgLabel4, imgLabel5,
            imgLabel6, imgLabel7;
    JButton Next;
    JPanel panel;

    public inventory3() {

        titlelabel = new JLabel();
        titlelabel.setText("Other Products");
        titlelabel.setFont(new Font("Times new roamn", Font.BOLD, 23));

        imgLabel = new JLabel(new ImageIcon("Img 18.jpeg"));

        p1 = new JLabel();
        p1.setText("Fridge");
        p1.setFont(new Font("Times new roamn", Font.BOLD, 15));

        p2 = new JLabel();
        p2.setText("Price: Rs 44,000");
        p2.setFont(new Font("Times new roamn", Font.BOLD, 15));

        imgLable1 = new JLabel(new ImageIcon("Img 19.jpeg"));

        p3 = new JLabel();
        p3.setText("Washing Machine");
        p3.setFont(new Font("Times new roamn", Font.BOLD, 15));

        p4 = new JLabel();
        p4.setText("Price: Rs 23,000");
        p4.setFont(new Font("Times new roamn", Font.BOLD, 15));

        imgLabel2 = new JLabel(new ImageIcon("Img 20.jpeg"));

        p5 = new JLabel();
        p5.setText("Smart Watch");
        p5.setFont(new Font("Times new roamn", Font.BOLD, 15));

        p6 = new JLabel();
        p6.setText("Price: Rs 5000");
        p6.setFont(new Font("Times new roamn", Font.BOLD, 15));

        imgLabel3 = new JLabel(new ImageIcon("Img 21.jpeg"));

        p7 = new JLabel();
        p7.setText("AC");
        p7.setFont(new Font("Times new roamn", Font.BOLD, 15));

        p8 = new JLabel();
        p8.setText("Price: Rs 40,000");
        p8.setFont(new Font("Times new roamn", Font.BOLD, 15));

        imgLabel4 = new JLabel(new ImageIcon("Img 22.jpeg"));

        p9 = new JLabel();
        p9.setText("Touch Screen");
        p9.setFont(new Font("Times new roamn", Font.BOLD, 15));

        p10 = new JLabel();
        p10.setText("Price: Rs 90,000");
        p10.setFont(new Font("Times new roamn", Font.BOLD, 15));

        imgLabel5 = new JLabel(new ImageIcon("Img 23.jpeg"));

        p11 = new JLabel();
        p11.setText("Printer");
        p11.setFont(new Font("Times new roamn", Font.BOLD, 15));

        p12 = new JLabel();
        p12.setText("Price: Rs 11,000");
        p12.setFont(new Font("Times new roamn", Font.BOLD, 15));

        imgLabel6 = new JLabel(new ImageIcon("Img 26.jpeg"));

        p13 = new JLabel();
        p13.setText("TV");
        p13.setFont(new Font("Times new roamn", Font.BOLD, 15));

        p14 = new JLabel();
        p14.setText("Price: Rs 55,000");
        p14.setFont(new Font("Times new roamn", Font.BOLD, 15));

        imgLabel7 = new JLabel(new ImageIcon("Img 25.jpeg"));

        n1 = new JLabel();
        n1.setText("Power Bank");
        n1.setFont(new Font("Times new roamn", Font.BOLD, 15));

        n2 = new JLabel();
        n2.setText("Price: Rs 2600");
        n2.setFont(new Font("Times new roamn", Font.BOLD, 15));

        Next = new JButton("Next");
        Next.addActionListener(this);

        panel = new JPanel(null);
        titlelabel.setBounds(600, 35, 170, 30);
        imgLabel.setBounds(40, 150, 250, 150);
        p1.setBounds(45, 300, 150, 30);
        p2.setBounds(45, 320, 150, 30);
        imgLable1.setBounds(330, 150, 250, 150);
        p3.setBounds(350, 300, 150, 30);
        p4.setBounds(350, 320, 150, 30);
        imgLabel2.setBounds(610, 150, 250, 150);
        p5.setBounds(650, 300, 150, 30);
        p6.setBounds(650, 320, 150, 30);
        imgLabel3.setBounds(900, 150, 250, 150);
        p7.setBounds(950, 300, 150, 30);
        p8.setBounds(950, 320, 150, 30);
        imgLabel4.setBounds(40, 400, 250, 150);
        p9.setBounds(45, 550, 150, 30);
        p10.setBounds(45, 570, 150, 30);
        imgLabel5.setBounds(330, 400, 250, 150);
        p11.setBounds(350, 550, 150, 30);
        p12.setBounds(350, 570, 150, 30);
        imgLabel6.setBounds(610, 400, 250, 150);
        p13.setBounds(650, 550, 150, 30);
        p14.setBounds(650, 570, 150, 30);
        imgLabel7.setBounds(900, 400, 250, 150);
        n1.setBounds(950, 550, 150, 30);
        n2.setBounds(950, 570, 150, 30);
        Next.setBounds(1100, 50, 80, 30);

        Color c = new Color(32, 178, 170);
        panel.setBackground(c);
        panel.add(titlelabel);
        panel.add(p1);
        panel.add(imgLabel);
        panel.add(p2);
        panel.add(p3);
        panel.add(imgLable1);
        panel.add(p4);
        panel.add(imgLabel2);
        panel.add(p5);
        panel.add(p5);
        panel.add(p6);
        panel.add(imgLabel3);
        panel.add(p7);
        panel.add(p8);
        panel.add(imgLabel4);
        panel.add(p9);
        panel.add(p10);
        panel.add(imgLabel5);
        panel.add(p11);
        panel.add(p12);
        panel.add(imgLabel6);
        panel.add(p13);
        panel.add(p14);
        panel.add(imgLabel7);
        panel.add(n1);
        panel.add(n2);
        panel.add(Next);
        setTitle("Laptop Details");
        setSize(1000, 1000);
        setVisible(true);
        setLocationRelativeTo(null);
        add(panel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new billing();

    }

}

class billing extends JFrame implements ActionListener {
    JPanel panel;
    JLabel First_name, Last_name, Product_name, Mobile_number, mail, Add, Qty, Price, title, payment;
    JTextField Fn, Ln, Pn, Mn, Em, Ad, Qu, Pay;
    JButton order, generate;
    String Firstname, Lastname, Productname, Mobilenumber, Email, Address, Quntity, Payment;
    public char[] ans;

    public billing() {

        title = new JLabel();
        title.setText("Order Your Prouduct");
        title.setFont(new Font("Times new roamn", Font.BOLD, 23));

        First_name = new JLabel();
        First_name.setText("First Name");
        First_name.setFont(new Font("Times new roamn", Font.BOLD, 17));
        Fn = new JTextField();

        Last_name = new JLabel();
        Last_name.setText("Last name");
        Last_name.setFont(new Font("Times new roamn", Font.BOLD, 17));
        Ln = new JTextField();

        mail = new JLabel();
        mail.setText("Email");
        mail.setFont(new Font("Times new roamn", Font.BOLD, 17));
        Em = new JTextField();

        Mobile_number = new JLabel();
        Mobile_number.setText("Mobile Number");
        Mobile_number.setFont(new Font("Times new roamn", Font.BOLD, 17));
        Mn = new JTextField();

        Add = new JLabel();
        Add.setText("Address");
        Add.setFont(new Font("Times new roamn", Font.BOLD, 17));
        Ad = new JTextField();

        Product_name = new JLabel();
        Product_name.setText("Product Name");
        Product_name.setFont(new Font("Times new roamn", Font.BOLD, 17));
        Pn = new JTextField();

        Qty = new JLabel();
        Qty.setText("Quantity");
        Qty.setFont(new Font("Times new roamn", Font.BOLD, 17));
        Qu = new JTextField();

        Price = new JLabel();
        Price.setText("Payment Price");
        Price.setFont(new Font("Times new roamn", Font.BOLD, 17));
        // Pay = new JTextField();

        payment = new JLabel();

        order = new JButton("Order");
        order.addActionListener(this);

        generate = new JButton("Generate");
        generate.addActionListener(this);

        panel = new JPanel(null);
        title.setBounds(550, 35, 250, 30);
        First_name.setBounds(120, 150, 100, 30);
        Fn.setBounds(400, 150, 150, 30);
        Last_name.setBounds(120, 200, 100, 30);
        Ln.setBounds(400, 200, 150, 30);
        mail.setBounds(120, 250, 100, 30);
        Em.setBounds(400, 250, 150, 30);
        Mobile_number.setBounds(120, 300, 200, 30);
        Mn.setBounds(400, 300, 150, 30);
        Add.setBounds(120, 350, 100, 30);
        Ad.setBounds(400, 350, 150, 30);
        Product_name.setBounds(120, 400, 150, 30);
        Pn.setBounds(400, 400, 150, 30);
        Qty.setBounds(120, 450, 100, 30);
        Qu.setBounds(400, 450, 150, 30);
        Price.setBounds(120, 500, 150, 30);
        // Pay.setBounds(400, 500, 150, 30);
        order.setBounds(1000, 600, 150, 30);
        generate.setBounds(400, 500, 100, 30);
        payment.setBounds(560, 500, 100, 30);

        Color c = new Color(32, 208, 170);
        panel.setBackground(c);
        panel.add(title);
        panel.add(First_name);
        panel.add(Fn);
        panel.add(Last_name);
        panel.add(Ln);
        panel.add(mail);
        panel.add(Em);
        panel.add(Mobile_number);
        panel.add(Mn);
        panel.add(Add);
        panel.add(Ad);
        panel.add(Product_name);
        panel.add(Pn);
        panel.add(Qty);
        panel.add(Qu);
        panel.add(Price);
        // panel.add(Pay);
        panel.add(order);
        panel.add(generate);
        panel.add(payment);

        setTitle("Order");
        setSize(1000, 1000);
        setVisible(true);
        setLocationRelativeTo(null);
        add(panel, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String Firstname = Fn.getText();
        String Lastname = Ln.getText();
        String Productname = Pn.getText();
        String Email = Em.getText();
        String Address = Ad.getText();
        String Mobilenumber = Mn.getText();
        String Quntity = Qu.getText();
        String s = e.getActionCommand();
        if (s.equalsIgnoreCase("Generate")) {
            if (Productname.equalsIgnoreCase("ASUS VivoBook 14")) {
                int price = 54000;
                int Qty1 = Integer.parseInt(Quntity);
                hello.ans = String.valueOf(price * Qty1);
                System.out.println(hello.ans);
                payment.setText(hello.ans);
            } else if (Productname.equalsIgnoreCase("DELL 15")) {
                int price = 40000;
                int Qty1 = Integer.parseInt(Quntity);
                hello.ans = String.valueOf(price * Qty1);
                System.out.println(hello.ans);
                payment.setText(hello.ans);
            } else if (Productname.equalsIgnoreCase("HP 15s")) {
                int price = 50000;
                int Qty1 = Integer.parseInt(Quntity);
                hello.ans = String.valueOf(price * Qty1);
                System.out.println(hello.ans);
                payment.setText(hello.ans);
            } else if (Productname.equalsIgnoreCase("Lenovo IdeaPad")) {
                int price = 55000;
                int Qty1 = Integer.parseInt(Quntity);
                hello.ans = String.valueOf(price * Qty1);
                System.out.println(hello.ans);
                payment.setText(hello.ans);
            } else if (Productname.equalsIgnoreCase("LG gram")) {
                int price = 82000;
                int Qty1 = Integer.parseInt(Quntity);
                hello.ans = String.valueOf(price * Qty1);
                System.out.println(hello.ans);
                payment.setText(hello.ans);
            } else if (Productname.equalsIgnoreCase("Apple MacBook Pro")) {
                int price = 219890;
                int Qty1 = Integer.parseInt(Quntity);
                hello.ans = String.valueOf(price * Qty1);
                System.out.println(hello.ans);
                payment.setText(hello.ans);
            } else if (Productname.equalsIgnoreCase("Redmi Book Pro")) {
                int price = 40000;
                int Qty1 = Integer.parseInt(Quntity);
                hello.ans = String.valueOf(price * Qty1);
                System.out.println(hello.ans);
                payment.setText(hello.ans);
            } else if (Productname.equalsIgnoreCase("MI NoteBook")) {
                int price = 67000;
                int Qty1 = Integer.parseInt(Quntity);
                hello.ans = String.valueOf(price * Qty1);
                System.out.println(hello.ans);
                payment.setText(hello.ans);
            } else if (Productname.equalsIgnoreCase("Vivo Y21")) {
                int price = 14000;
                int Qty1 = Integer.parseInt(Quntity);
                hello.ans = String.valueOf(price * Qty1);
                System.out.println(hello.ans);
                payment.setText(hello.ans);
            } else if (Productname.equalsIgnoreCase("IQOO 9 Pro")) {
                int price = 70000;
                int Qty1 = Integer.parseInt(Quntity);
                hello.ans = String.valueOf(price * Qty1);
                System.out.println(hello.ans);
                payment.setText(hello.ans);
            } else if (Productname.equalsIgnoreCase("Xiaomi")) {
                int price = 27000;
                int Qty1 = Integer.parseInt(Quntity);
                hello.ans = String.valueOf(price * Qty1);
                System.out.println(hello.ans);
                payment.setText(hello.ans);
            } else if (Productname.equalsIgnoreCase("Samsung s21")) {
                int price = 55000;
                int Qty1 = Integer.parseInt(Quntity);
                hello.ans = String.valueOf(price * Qty1);
                System.out.println(hello.ans);
                payment.setText(hello.ans);
            } else if (Productname.equalsIgnoreCase("Samsung A5")) {
                int price = 21000;
                int Qty1 = Integer.parseInt(Quntity);
                hello.ans = String.valueOf(price * Qty1);
                System.out.println(hello.ans);
                payment.setText(hello.ans);
            } else if (Productname.equalsIgnoreCase("One Plus")) {
                int price = 37000;
                int Qty1 = Integer.parseInt(Quntity);
                hello.ans = String.valueOf(price * Qty1);
                System.out.println(hello.ans);
                payment.setText(hello.ans);
            } else if (Productname.equalsIgnoreCase("Samsung s22")) {
                int price = 19890;
                int Qty1 = Integer.parseInt(Quntity);
                hello.ans = String.valueOf(price * Qty1);
                System.out.println(hello.ans);
                payment.setText(hello.ans);
            } else if (Productname.equalsIgnoreCase("Samsung M32")) {
                int price = 21000;
                int Qty1 = Integer.parseInt(Quntity);
                hello.ans = String.valueOf(price * Qty1);
                System.out.println(hello.ans);
                payment.setText(hello.ans);
            } else if (Productname.equalsIgnoreCase("Fridge")) {
                int price = 44000;
                int Qty1 = Integer.parseInt(Quntity);
                hello.ans = String.valueOf(price * Qty1);
                System.out.println(hello.ans);
                payment.setText(hello.ans);
            } else if (Productname.equalsIgnoreCase("Washing Machine")) {
                int price = 23000;
                int Qty1 = Integer.parseInt(Quntity);
                hello.ans = String.valueOf(price * Qty1);
                System.out.println(hello.ans);
                payment.setText(hello.ans);
            } else if (Productname.equalsIgnoreCase("Smart Watch")) {
                int price = 5000;
                int Qty1 = Integer.parseInt(Quntity);
                hello.ans = String.valueOf(price * Qty1);
                System.out.println(hello.ans);
                payment.setText(hello.ans);
            } else if (Productname.equalsIgnoreCase("Touch Screen")) {
                int price = 54000;
                int Qty1 = Integer.parseInt(Quntity);
                hello.ans = String.valueOf(price * Qty1);
                System.out.println(hello.ans);
                payment.setText(hello.ans);
            } else if (Productname.equalsIgnoreCase("Printer")) {
                int price = 11000;
                int Qty1 = Integer.parseInt(Quntity);
                hello.ans = String.valueOf(price * Qty1);
                System.out.println(hello.ans);
                payment.setText(hello.ans);
            } else if (Productname.equalsIgnoreCase("TV")) {
                int price = 55000;
                int Qty1 = Integer.parseInt(Quntity);
                hello.ans = String.valueOf(price * Qty1);
                System.out.println(hello.ans);
                payment.setText(hello.ans);
            } else if (Productname.equalsIgnoreCase("AC")) {
                int price = 40000;
                int Qty1 = Integer.parseInt(Quntity);
                hello.ans = String.valueOf(price * Qty1);
                System.out.println(hello.ans);
                payment.setText(hello.ans);
            } else if (Productname.equalsIgnoreCase("Power Bank")) {
                int price = 2600;
                int Qty1 = Integer.parseInt(Quntity);
                hello.ans = String.valueOf(price * Qty1);
                System.out.println(hello.ans);
                payment.setText(hello.ans);
            }
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/main", "root", "");
                System.out.println("Xampp Mysql Connected....");
                Statement st = con.createStatement();
                st.executeUpdate(
                        "insert into bill values('" + Firstname + "','" + Lastname + "','" + Email + "','"
                                + Mobilenumber
                                + "', '" + Address + "', '" + Productname + "', '" + Quntity + "', '" + hello.ans
                                + "')");
                System.out.println("Inserted Successfully");
            } catch (Exception ae) {
                System.out.println("Not Connected");
            }
        } else {
            new order();
        }
    }

}

class order extends JFrame {
    JLabel Text_Label;

    public order() {
        Text_Label = new JLabel();
        Text_Label.setText("Ordered successfully......!");
        Text_Label.setFont(new Font("Times new roamn", Font.BOLD, 17));

        JPanel panel = new JPanel();

        panel.add(Text_Label);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel, BorderLayout.CENTER);
        setTitle("Final order");
        setSize(655, 416);
        setVisible(true);
        setLocationRelativeTo(null);

    }

}

public class Main {

    public static void main(String[] args) {
        FrontPage i = new FrontPage();
        i.sign();
        System.out.println("hello");
    }
}