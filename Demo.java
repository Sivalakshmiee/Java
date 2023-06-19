import java.sql.*;

class Demo {
    public static void main(String args[]) {
        System.out.println("Poda venna");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "");
            System.out.println("Connected");
        } catch (Exception e) {
            System.out.println("Not connected");
        }
    }

}