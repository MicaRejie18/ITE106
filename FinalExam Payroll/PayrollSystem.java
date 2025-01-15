import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class PayrollSystem extends JFrame {
    private JTextField txtEmployeeID, txtName, txtHourlyRate, txtHoursWorked;
    private DefaultTableModel tableModel;
    private JTable table;
    private ArrayList<String> payrollRecords = new ArrayList<>();
    private static final String FILE_NAME = "payroll.txt";

    public PayrollSystem() {
        setTitle("Payroll System");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // Light blue color scheme
        Color primaryColor = new Color(173, 216, 230);
        Color secondaryColor = new Color(240, 248, 255);
        Color buttonColor = new Color(100, 149, 237);
        Color accentColor = new Color(30, 144, 255);
        Color headerColor = new Color(0, 102, 204);

        Font headerFont = new Font("Segoe UI", Font.BOLD, 16);
        Font inputFont = new Font("Segoe UI", Font.PLAIN, 14);
        Font buttonFont = new Font("Segoe UI", Font.BOLD, 14);

        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        inputPanel.setBackground(secondaryColor);
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblEmployeeID = new JLabel("Employee ID:");
        lblEmployeeID.setFont(inputFont);
        inputPanel.add(lblEmployeeID);
        txtEmployeeID = new JTextField();
        txtEmployeeID.setFont(inputFont);
        inputPanel.add(txtEmployeeID);

        JLabel lblName = new JLabel("Name:");
        lblName.setFont(inputFont);
        inputPanel.add(lblName);
        txtName = new JTextField();
        txtName.setFont(inputFont);
        inputPanel.add(txtName);

        JLabel lblHourlyRate = new JLabel("Hourly Rate:");
        lblHourlyRate.setFont(inputFont);
        inputPanel.add(lblHourlyRate);
        txtHourlyRate = new JTextField();
        txtHourlyRate.setFont(inputFont);
        inputPanel.add(txtHourlyRate);

        JLabel lblHoursWorked = new JLabel("Hours Worked:");
        lblHoursWorked.setFont(inputFont);
        inputPanel.add(lblHoursWorked);
        txtHoursWorked = new JTextField();
        txtHoursWorked.setFont(inputFont);
        inputPanel.add(txtHoursWorked);

        JButton btnAddEmployee = new JButton("Add Employee");
        styleButton(btnAddEmployee, buttonColor, buttonFont);
        inputPanel.add(btnAddEmployee);

        JButton btnCalculatePay = new JButton("Calculate Pay");
        styleButton(btnCalculatePay, accentColor, buttonFont);
        inputPanel.add(btnCalculatePay);

        add(inputPanel, BorderLayout.NORTH);

        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBackground(primaryColor);

        tableModel = new DefaultTableModel(new String[]{"Employee ID", "Name", "Hourly Rate", "Hours Worked", "Gross Pay", "Net Pay"}, 0);
        table = new JTable(tableModel);
        table.setBackground(Color.WHITE);
        table.setForeground(Color.BLACK);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setFillsViewportHeight(true);
        table.setRowHeight(30);
        table.setGridColor(new Color(200, 200, 200));
        table.setSelectionBackground(accentColor);

        table.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (row % 2 == 0) {
                    c.setBackground(new Color(230, 240, 250)); 
                } else {
                    c.setBackground(Color.WHITE); 
                }
                return c;
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        tablePanel.add(scrollPane, BorderLayout.CENTER);
        add(tablePanel, BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(secondaryColor);
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JButton btnSaveRecord = new JButton("Save Record");
        styleButton(btnSaveRecord, buttonColor, buttonFont);
        buttonsPanel.add(btnSaveRecord);

        JButton btnDisplayRecords = new JButton("Display Records");
        styleButton(btnDisplayRecords, accentColor, buttonFont);
        buttonsPanel.add(btnDisplayRecords);

        add(buttonsPanel, BorderLayout.SOUTH);

        loadRecords();

        btnAddEmployee.addActionListener(e -> addEmployee());
        btnCalculatePay.addActionListener(e -> openPayScreen());
        btnSaveRecord.addActionListener(e -> saveRecords());
        btnDisplayRecords.addActionListener(e -> displayRecords());
    }

    private void styleButton(JButton button, Color backgroundColor, Font font) {
        button.setBackground(backgroundColor);
        button.setForeground(Color.WHITE);
        button.setFont(font);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setPreferredSize(new Dimension(150, 40));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(button.getBackground().darker());
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(button.getBackground().brighter());
            }
        });
    }

    private void addEmployee() {
        String id = txtEmployeeID.getText();
        String name = txtName.getText();
        String hourlyRateStr = txtHourlyRate.getText();
        String hoursWorkedStr = txtHoursWorked.getText();

        if (id.isEmpty() || name.isEmpty() || hourlyRateStr.isEmpty() || hoursWorkedStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (String record : payrollRecords) {
            if (record.startsWith(id + ",")) {
                JOptionPane.showMessageDialog(this, "Employee ID must be unique.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        try {
            double hourlyRate = Double.parseDouble(hourlyRateStr);
            double hoursWorked = Double.parseDouble(hoursWorkedStr);

            double grossPay = hourlyRate * hoursWorked;
            double netPay = grossPay * 0.8; 

            String record = String.format("%s,%s,%.2f,%.2f,%.2f,%.2f", id, name, hourlyRate, hoursWorked, grossPay, netPay);
            payrollRecords.add(record);
            tableModel.addRow(new Object[]{id, name, hourlyRate, hoursWorked, grossPay, netPay});
            JOptionPane.showMessageDialog(this, "Employee added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid number format.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openPayScreen() {
        String id = txtEmployeeID.getText();
        for (String record : payrollRecords) {
            if (record.startsWith(id + ",")) {
                String[] parts = record.split(",");
                double hourlyRate = Double.parseDouble(parts[2]);
                double hoursWorked = Double.parseDouble(parts[3]);
                double grossPay = hourlyRate * hoursWorked;
                double netPay = grossPay * 0.8; 

                JFrame payScreen = new JFrame("Pay Details");
                payScreen.setSize(400, 200);
                payScreen.setLocationRelativeTo(null);
                payScreen.setLayout(new BorderLayout());

                JPanel payPanel = new JPanel();
                payPanel.setBackground(new Color(224, 255, 255));
                payPanel.setLayout(new BoxLayout(payPanel, BoxLayout.Y_AXIS));
                payScreen.add(payPanel, BorderLayout.CENTER);

                JLabel lblGrossPay = new JLabel(String.format("Gross Pay: %.2f", grossPay));
                lblGrossPay.setFont(new Font("Segoe UI", Font.BOLD, 16));
                lblGrossPay.setAlignmentX(Component.CENTER_ALIGNMENT);

                JLabel lblNetPay = new JLabel(String.format("Net Pay: %.2f", netPay));
                lblNetPay.setFont(new Font("Segoe UI", Font.BOLD, 16));
                lblNetPay.setAlignmentX(Component.CENTER_ALIGNMENT);

                payPanel.add(Box.createRigidArea(new Dimension(0, 20)));
                payPanel.add(lblGrossPay);
                payPanel.add(Box.createRigidArea(new Dimension(0, 10)));
                payPanel.add(lblNetPay);

                payScreen.setVisible(true);
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Employee not found.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void saveRecords() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String record : payrollRecords) {
                writer.write(record);
                writer.newLine();
            }
            JOptionPane.showMessageDialog(this, "Records saved successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving records.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displayRecords() {
        tableModel.setRowCount(0); 
        for (String record : payrollRecords) {
            String[] parts = record.split(",");
            tableModel.addRow(new Object[]{parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]});
        }
    }

    private void loadRecords() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                payrollRecords.add(line);
                String[] parts = line.split(",");
                tableModel.addRow(new Object[]{parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]});
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "No existing records found.", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PayrollSystem().setVisible(true));
    }
}
