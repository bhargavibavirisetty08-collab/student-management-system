import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class FinalRecruitmentSystem {

    static Connection con;

    public static void main(String[] args) {
        connectDB();
        new LoginPage();
    }

    static void connectDB() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:XE",
                    "system",
                    "system" // change if needed
            );

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}

// ================= LOGIN =================
class LoginPage extends JFrame implements ActionListener {

    JTextField user;
    JPasswordField pass;

    LoginPage() {
        setTitle("Login");

        user = new JTextField();
        pass = new JPasswordField();
        JButton login = new JButton("Login");

        setLayout(new GridLayout(3,2,10,10));
        add(new JLabel("Username")); add(user);
        add(new JLabel("Password")); add(pass);
        add(new JLabel("")); add(login);

        login.addActionListener(this);

        setSize(300,150);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if(user.getText().equals("admin") &&
                String.valueOf(pass.getPassword()).equals("admin")) {

            new Dashboard();
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Login");
        }
    }
}

// ================= DASHBOARD =================
class Dashboard extends JFrame {

    static JobPanel jobPanel;
    static ApplyPanel applyPanel;
    static ScreeningPanel screeningPanel;

    Dashboard() {

        setTitle("AI Recruitment System");

        JTabbedPane tabs = new JTabbedPane();

        ResumePanel resumePanel = new ResumePanel();
        jobPanel = new JobPanel();
        applyPanel = new ApplyPanel();
        screeningPanel = new ScreeningPanel();

        tabs.add("Resume", resumePanel);
        tabs.add("Company", new CompanyPanel());
        tabs.add("Job", jobPanel);
        tabs.add("Apply", applyPanel);
        tabs.add("AI Screening", screeningPanel);

        add(tabs);

        setSize(1000,650);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

// ================= RESUME =================
class ResumePanel extends JPanel {

    JTextField id, name, email, phone, exp;
    JComboBox<String> cityBox, skillsBox;

    ResumePanel() {

        setLayout(new GridLayout(8,2,10,10));

        id = new JTextField();
        name = new JTextField();
        email = new JTextField();
        phone = new JTextField();
        exp = new JTextField();

        cityBox = new JComboBox<>(new String[]{"Hyderabad","Vizag","Vijayawada"});
        skillsBox = new JComboBox<>(new String[]{
                "Java, SQL","Python, ML","C, C++","Web","AI"
        });

        add(new JLabel("Resume ID")); add(id);
        add(new JLabel("Name")); add(name);
        add(new JLabel("Email")); add(email);
        add(new JLabel("Phone")); add(phone);
        add(new JLabel("City")); add(cityBox);
        add(new JLabel("Experience")); add(exp);
        add(new JLabel("Skills")); add(skillsBox);

        JButton insert = new JButton("Add Resume");

        insert.addActionListener(e -> {
            try {
                int rid = Integer.parseInt(id.getText());

                PreparedStatement ps1 = FinalRecruitmentSystem.con.prepareStatement(
                        "INSERT INTO RESUME VALUES (?, ?, ?, ?, ?)");

                ps1.setInt(1, rid);
                ps1.setString(2, name.getText());
                ps1.setString(3, email.getText());
                ps1.setString(4, phone.getText());
                ps1.setString(5, (String) cityBox.getSelectedItem());
                ps1.executeUpdate();

                PreparedStatement ps2 = FinalRecruitmentSystem.con.prepareStatement(
                        "INSERT INTO RESUME_DETAILS VALUES (?, ?, ?, ?)");

                ps2.setInt(1, rid);
                ps2.setString(2, "B.Tech");
                ps2.setString(3, exp.getText());
                ps2.setString(4, (String) skillsBox.getSelectedItem());
                ps2.executeUpdate();

                JOptionPane.showMessageDialog(this, "Resume Added");

                Dashboard.applyPanel.loadData();
                Dashboard.screeningPanel.loadData();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        add(insert);
    }
}

// ================= COMPANY =================
class CompanyPanel extends JPanel {

    JTextField id, name;

    CompanyPanel() {

        setLayout(new GridLayout(3,2,10,10));

        id = new JTextField();
        name = new JTextField();

        add(new JLabel("Company ID")); add(id);
        add(new JLabel("Name")); add(name);

        JButton insert = new JButton("Add Company");

        insert.addActionListener(e -> {
            try {
                PreparedStatement ps = FinalRecruitmentSystem.con.prepareStatement(
                        "INSERT INTO COMPANY VALUES (?, ?, '', '')");

                ps.setInt(1, Integer.parseInt(id.getText()));
                ps.setString(2, name.getText());

                ps.executeUpdate();

                JOptionPane.showMessageDialog(this, "Company Added");

                Dashboard.jobPanel.loadCompanies();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        add(insert);
    }
}

// ================= JOB =================
class JobPanel extends JPanel {

    JTextField id, exp;
    JComboBox<Integer> companyBox;

    JobPanel() {

        setLayout(new GridLayout(4,2,10,10));

        id = new JTextField();
        exp = new JTextField();
        companyBox = new JComboBox<>();

        loadCompanies();

        add(new JLabel("Job ID")); add(id);
        add(new JLabel("Experience")); add(exp);
        add(new JLabel("Company ID")); add(companyBox);

        JButton insert = new JButton("Add Job");

        insert.addActionListener(e -> {
            try {
                PreparedStatement ps = FinalRecruitmentSystem.con.prepareStatement(
                        "INSERT INTO JOB VALUES (?, ?, 0, 'Open', ?)");

                ps.setInt(1, Integer.parseInt(id.getText()));
                ps.setInt(2, Integer.parseInt(exp.getText()));
                ps.setInt(3, (int) companyBox.getSelectedItem());

                ps.executeUpdate();

                JOptionPane.showMessageDialog(this, "Job Added");

                Dashboard.applyPanel.loadData();
                Dashboard.screeningPanel.loadData();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        add(insert);
    }

    void loadCompanies() {
        try {
            companyBox.removeAllItems();

            ResultSet rs = FinalRecruitmentSystem.con.createStatement()
                    .executeQuery("SELECT Company_ID FROM COMPANY");

            while(rs.next()) {
                companyBox.addItem(rs.getInt(1));
            }

        } catch (Exception e) {}
    }
}

// ================= APPLY =================
class ApplyPanel extends JPanel {

    JComboBox<Integer> resumeBox, jobBox;

    ApplyPanel() {

        setLayout(new GridLayout(3,2,10,10));

        resumeBox = new JComboBox<>();
        jobBox = new JComboBox<>();

        loadData();

        add(new JLabel("Resume ID")); add(resumeBox);
        add(new JLabel("Job ID")); add(jobBox);

        JButton apply = new JButton("Apply");

        apply.addActionListener(e -> {
            try {
                PreparedStatement ps = FinalRecruitmentSystem.con.prepareStatement(
                        "INSERT INTO APPLIES_TO VALUES (?, ?)");

                ps.setInt(1, (int) resumeBox.getSelectedItem());
                ps.setInt(2, (int) jobBox.getSelectedItem());

                ps.executeUpdate();

                JOptionPane.showMessageDialog(this, "Applied");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        add(apply);
    }

    void loadData() {
        try {
            resumeBox.removeAllItems();
            jobBox.removeAllItems();

            ResultSet r1 = FinalRecruitmentSystem.con.createStatement()
                    .executeQuery("SELECT Resume_ID FROM RESUME");
            while(r1.next()) resumeBox.addItem(r1.getInt(1));

            ResultSet r2 = FinalRecruitmentSystem.con.createStatement()
                    .executeQuery("SELECT Job_ID FROM JOB");
            while(r2.next()) jobBox.addItem(r2.getInt(1));

        } catch (Exception e) {}
    }
}

// ================= AI SCREENING =================
class ScreeningPanel extends JPanel {

    JComboBox<Integer> resumeBox, jobBox;
    JProgressBar progress;

    ScreeningPanel() {

        setLayout(new GridLayout(4,2,10,10));

        resumeBox = new JComboBox<>();
        jobBox = new JComboBox<>();

        loadData();

        add(new JLabel("Resume ID")); add(resumeBox);
        add(new JLabel("Job ID")); add(jobBox);

        JButton run = new JButton("Run AI");

        progress = new JProgressBar(0,100);
        progress.setStringPainted(true);

        run.addActionListener(e -> runAI());

        add(run);
        add(progress);
    }

    void loadData() {
        try {
            resumeBox.removeAllItems();
            jobBox.removeAllItems();

            ResultSet r1 = FinalRecruitmentSystem.con.createStatement()
                    .executeQuery("SELECT Resume_ID FROM RESUME");
            while(r1.next()) resumeBox.addItem(r1.getInt(1));

            ResultSet r2 = FinalRecruitmentSystem.con.createStatement()
                    .executeQuery("SELECT Job_ID FROM JOB");
            while(r2.next()) jobBox.addItem(r2.getInt(1));

        } catch (Exception e) {}
    }

    void runAI() {
        try {

            if(resumeBox.getSelectedItem() == null || jobBox.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Select values first");
                return;
            }

            int rid = (int) resumeBox.getSelectedItem();
            int jid = (int) jobBox.getSelectedItem();

            ResultSet r1 = FinalRecruitmentSystem.con.createStatement()
                    .executeQuery("SELECT Work_Experience, Skills FROM RESUME_DETAILS WHERE Resume_ID=" + rid);

            if(!r1.next()) {
                JOptionPane.showMessageDialog(this, "No Resume Data");
                return;
            }

            String expStr = r1.getString(1);
            String skills = r1.getString(2);

            expStr = expStr.replaceAll("[^0-9]", "");
            int exp = Integer.parseInt(expStr);

            if(skills == null) skills = "";
            skills = skills.toLowerCase();

            ResultSet r2 = FinalRecruitmentSystem.con.createStatement()
                    .executeQuery("SELECT Required_Experience FROM JOB WHERE Job_ID=" + jid);

            r2.next();
            int req = r2.getInt(1);

            int score = (exp >= req ? 50 : exp*50/req);

            if(skills.contains("java")) score += 20;
            if(skills.contains("sql")) score += 15;
            if(skills.contains("python")) score += 15;

            progress.setValue(score);

            String status = (score>=70?"Selected":score>=40?"Hold":"Rejected");

            JOptionPane.showMessageDialog(this,
                    "Score: " + score +
                            "\nStatus: " + status);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
}