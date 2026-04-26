
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MainApp {

    static int currentUserId = -1; // store logged-in user

    public static void main(String[] args) {
        loginPage();
    }

    // 🔹 LOGIN PAGE
    static void loginPage() {
        JFrame f = new JFrame("Login");
        f.setSize(300,220);

        JTextField user = new JTextField();
        user.setBounds(100,30,120,25);

        JPasswordField pass = new JPasswordField();
        pass.setBounds(100,70,120,25);

        JButton login = new JButton("Login");
        login.setBounds(100,120,80,25);

        f.add(new JLabel("User")).setBounds(20,30,80,25);
        f.add(user);
        f.add(new JLabel("Pass")).setBounds(20,70,80,25);
        f.add(pass);
        f.add(login);

        login.addActionListener(e -> {
            String username = user.getText();
            String password = new String(pass.getPassword());

            if(username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(f,"Enter all fields");
                return;
            }

            try (Connection con = DBConnection.getCon();
                 PreparedStatement ps = con.prepareStatement(
                         "SELECT user_id FROM Users WHERE user_name=? AND pass=?")) {

                ps.setString(1, username);
                ps.setString(2, password);

                ResultSet rs = ps.executeQuery();

                if(rs.next()) {
                    currentUserId = rs.getInt("user_id");
                    JOptionPane.showMessageDialog(f,"Login Success");
                    f.dispose();
                    stationPage();
                } else {
                    JOptionPane.showMessageDialog(f,"Invalid Credentials");
                }

            } catch(Exception ex) {
                ex.printStackTrace();
            }
        });

        f.setLayout(null);
        f.setVisible(true);
    }

    // 🔹 STATION PAGE
    static void stationPage() {
        JFrame f = new JFrame("Stations");
        f.setSize(300,200);

        String stations[] = {"EV Hub A","EV Hub B"};
        JList<String> list = new JList<>(stations);
        list.setBounds(50,30,150,80);

        JButton next = new JButton("Book");
        next.setBounds(90,120,100,30);

        f.add(list);
        f.add(next);

        next.addActionListener(e -> {
            if(list.getSelectedValue() == null) {
                JOptionPane.showMessageDialog(f,"Select station");
                return;
            }
            f.dispose();
            bookingPage();
        });

        f.setLayout(null);
        f.setVisible(true);
    }

    // 🔹 BOOKING PAGE
    static void bookingPage() {
        JFrame f = new JFrame("Booking");
        f.setSize(300,200);

        String slots[] = {"10AM","2PM"};
        JComboBox<String> cb = new JComboBox<>(slots);
        cb.setBounds(80,40,120,25);

        JButton book = new JButton("Book");
        book.setBounds(90,100,100,30);

        f.add(cb);
        f.add(book);

        book.addActionListener(e -> {
            try (Connection con = DBConnection.getCon();
                 PreparedStatement ps = con.prepareStatement(
                         "INSERT INTO Booking VALUES (booking_seq.NEXTVAL, SYSDATE, ?, 'Booked', ?, 101)")) {

                ps.setString(1, cb.getSelectedItem().toString());
                ps.setInt(2, currentUserId); // dynamic user id
                ps.executeUpdate();

                JOptionPane.showMessageDialog(f,"Booking Done");
                f.dispose();
                paymentPage();

            } catch(Exception ex) {
                ex.printStackTrace();
            }
        });

        f.setLayout(null);
        f.setVisible(true);
    }

    // 🔹 PAYMENT PAGE
    static void paymentPage() {
        JFrame f = new JFrame("Payment");
        f.setSize(300,200);

        JButton pay = new JButton("Pay ₹300");
        pay.setBounds(80,70,120,30);

        f.add(pay);

        pay.addActionListener(e -> {
            try (Connection con = DBConnection.getCon();
                 PreparedStatement ps = con.prepareStatement(
                         "INSERT INTO Payment VALUES (payment_seq.NEXTVAL,300,'UPI',SYSDATE,'Success',booking_seq.CURRVAL)")) {

                ps.executeUpdate();

                JOptionPane.showMessageDialog(f,"Payment Success");
                f.dispose();
                feedbackPage();

            } catch(Exception ex) {
                ex.printStackTrace();
            }
        });

        f.setLayout(null);
        f.setVisible(true);
    }

    // 🔹 FEEDBACK PAGE
    static void feedbackPage() {
        JFrame f = new JFrame("Feedback");
        f.setSize(300,200);

        JTextArea ta = new JTextArea();
        ta.setBounds(30,30,200,80);

        JButton submit = new JButton("Submit");
        submit.setBounds(80,120,100,30);

        f.add(ta);
        f.add(submit);

        submit.addActionListener(e -> {
            try (Connection con = DBConnection.getCon();
                 PreparedStatement ps = con.prepareStatement(
                         "INSERT INTO Feedback VALUES (feedback_seq.NEXTVAL,5,?,SYSDATE,?,101)")) {

                ps.setString(1, ta.getText());
                ps.setInt(2, currentUserId);

                ps.executeUpdate();

                JOptionPane.showMessageDialog(f,"Feedback Submitted");

            } catch(Exception ex) {
                ex.printStackTrace();
            }
        });

        f.setLayout(null);
        f.setVisible(true);
    }
}

// 🔹 DB CONNECTION
class DBConnection {
    public static Connection getCon() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");

        return DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "system",
                "system"
        );
    }
}