
import javax.swing.*;
import java.io.IOException;
import javax.swing.text.StyledEditorKit.BoldAction;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.sql.*;

class order extends JFrame {
    JLabel Text_Label;

    public static void main(String[] args) {
        billing b = new billing();
        System.out.println(b.ans);

    }

    public order() {
        Text_Label = new JLabel();
        Text_Label.setText("Updated successfully......!");
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
