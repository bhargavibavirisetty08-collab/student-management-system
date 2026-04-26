import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RecruitmentAWT extends Frame implements ActionListener {

    // DB Connection
    static Connection con;

    // UI Components
    TextField rid, name, exp, skills;
    Choice jobChoice;
    TextArea output;
    Button addResume, apply, runAI;

    public RecruitmentAWT() {

        setTitle("AI Recruitment System (Single Company)");
        setSize(600,500);
        setLayout(new FlowLayout());

        add(new Label("Resume ID")); rid = new TextField(10); add(rid);
        add(new Label("Name")); name = new TextField(10); add(name);
        add(new Label("Experience (years)")); exp = new TextField(10); add(exp);
        add(new Label("Skills (comma separated)")); skills = new TextField(20); add(skills);

        addResume = new Button("Add Resume");
        add(addResume);

        add(new Label("Select Job"));
        jobChoice = new Choice();
        jobChoice.add("101 - Java Dev");
        jobChoice.add("102 - Python Dev");
        jobChoice.add("103 - Web Dev");
        add(jobChoice);

        apply = new Button("Apply");
        runAI = new Button("Run AI");

        add(apply);
        add(runAI);

        output = new TextArea(10,50);
        add(output);

        addResume.addActionListener(this);
        apply.addActionListener(this);
        runAI.addActionListener(this);

        connectDB();
        initDB();

        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    // DB Connection
    void connectDB() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:XE",
                    "system",
                    "system"
            );
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    // Initialize One Company + 3 Jobs
    void initDB() {
        try {
            Statement st = con.createStatement();

            // One company
            try {
                st.executeUpdate("INSERT INTO COMPANY VALUES (1,'ABC Pvt Ltd','','')");
            } catch(Exception e) {}

            // 3 jobs
            try {
                st.executeUpdate("INSERT INTO JOB VALUES (101,2,0,'Open',1,'java,sql')");
                st.executeUpdate("INSERT INTO JOB VALUES (102,3,0,'Open',1,'python,ml')");
                st.executeUpdate("INSERT INTO JOB VALUES (103,1,0,'Open',1,'web,html')");
            } catch(Exception e) {}

        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public void actionPerformed(ActionEvent e) {

        // Add Resume
        if(e.getSource() == addResume) {
            try {
                PreparedStatement ps1 = con.prepareStatement(
                        "INSERT INTO RESUME VALUES (?, ?, '', '', '')");

                ps1.setInt(1, Integer.parseInt(rid.getText()));
                ps1.setString(2, name.getText());
                ps1.executeUpdate();

                PreparedStatement ps2 = con.prepareStatement(
                        "INSERT INTO RESUME_DETAILS VALUES (?, 'B.Tech', ?, ?)");

                ps2.setInt(1, Integer.parseInt(rid.getText()));
                ps2.setString(2, exp.getText());
                ps2.setString(3, skills.getText());
                ps2.executeUpdate();

                output.setText("Resume Added Successfully\n");

            } catch(Exception ex) {
                output.setText("Error: " + ex.getMessage());
            }
        }

        // Apply
        if(e.getSource() == apply) {
            try {
                int jid = Integer.parseInt(jobChoice.getSelectedItem().split(" ")[0]);

                PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO APPLIES_TO VALUES (?, ?)");

                ps.setInt(1, Integer.parseInt(rid.getText()));
                ps.setInt(2, jid);
                ps.executeUpdate();

                output.setText("Applied to Job " + jid);

            } catch(Exception ex) {
                output.setText("Error: " + ex.getMessage());
            }
        }

        // AI Screening
        if(e.getSource() == runAI) {
            try {

                int ridVal = Integer.parseInt(rid.getText());
                int jid = Integer.parseInt(jobChoice.getSelectedItem().split(" ")[0]);

                ResultSet r1 = con.createStatement()
                        .executeQuery("SELECT Work_Experience, Skills FROM RESUME_DETAILS WHERE Resume_ID=" + ridVal);

                r1.next();
                int expVal = Integer.parseInt(r1.getString(1));
                String skillStr = r1.getString(2).toLowerCase();

                ResultSet r2 = con.createStatement()
                        .executeQuery("SELECT Required_Experience, Required_Skills FROM JOB WHERE Job_ID=" + jid);

                r2.next();
                int req = r2.getInt(1);
                String reqSkills = r2.getString(2);

                int score = (req == 0) ? 50 : (expVal >= req ? 50 : expVal*50/req);

                for(String rs : reqSkills.split(",")) {
                    if(skillStr.contains(rs.trim())) {
                        score += 20;
                    }
                }

                String status = (score>=70?"Selected":score>=40?"Hold":"Rejected");

                output.setText(
                        "Score: " + score +
                                "\nStatus: " + status
                );

            } catch(Exception ex) {
                output.setText("Error: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new RecruitmentAWT();
    }
}