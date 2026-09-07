import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Medicine {
    String name;
    double price;
    int stock;

    public Medicine(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}

public class PharmacyManagement extends JFrame {
    private ArrayList<Medicine> inventory = new ArrayList<>();
    private DefaultTableModel tableModel;
    private JTable medicineTable;
    private JTextField txtName, txtPrice, txtStock, txtSearch, txtQty;
    private JLabel lblTotal;
    private double grandTotal = 0.0;

    public PharmacyManagement() {
        setTitle("Pharmacy Management System (Java)");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Top Header
        JLabel header = new JLabel("Pharmacy Management System", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 22));
        header.setOpaque(true);
        header.setBackground(new Color(41, 128, 185));
        header.setForeground(Color.WHITE);
        header.setPreferredSize(new Dimension(800, 50));
        add(header, BorderLayout.NORTH);

        // Center Table
        String[] columns = {"Medicine Name", "Price (PKR)", "Stock Quantity"};
        tableModel = new DefaultTableModel(columns, 0);
        medicineTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(medicineTable);
        add(scrollPane, BorderLayout.CENTER);

        // Left Panel - Input Form
        JPanel inputPanel = new JPanel(new GridLayout(8, 1, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Add / Manage Stock"));

        txtName = new JTextField();
        txtPrice = new JTextField();
        txtStock = new JTextField();
        JButton btnAdd = new JButton("Add Medicine");

        inputPanel.add(new JLabel("Medicine Name:"));
        inputPanel.add(txtName);
        inputPanel.add(new JLabel("Price:"));
        inputPanel.add(txtPrice);
        inputPanel.add(new JLabel("Stock Quantity:"));
        inputPanel.add(txtStock);
        inputPanel.add(new JLabel(""));
        inputPanel.add(btnAdd);

        add(inputPanel, BorderLayout.WEST);

        // Bottom Panel - Billing & Actions
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 10));
        txtQty = new JTextField(5);
        JButton btnSell = new JButton("Sell / Add to Bill");
        lblTotal = new JLabel("Total Bill: PKR 0.0");
        lblTotal.setFont(new Font("Arial", Font.BOLD, 14));

        bottomPanel.add(new JLabel("Qty to Sell:"));
        bottomPanel.add(txtQty);
        bottomPanel.add(btnSell);
        bottomPanel.add(lblTotal);

        add(bottomPanel, BorderLayout.SOUTH);

        // Dummy Initial Data
        addInitialData();

        // Event Listeners
        btnAdd.addActionListener(e -> addMedicine());
        btnSell.addActionListener(e -> sellMedicine());
    }

    private void addInitialData() {
        inventory.add(new Medicine("Panadol 500mg", 30.0, 100));
        inventory.add(new Medicine("Brufen 400mg", 55.0, 50));
        inventory.add(new Medicine("Arinac Forte", 90.0, 40));
        refreshTable();
    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        for (Medicine m : inventory) {
            tableModel.addRow(new Object[]{m.name, m.price, m.stock});
        }
    }

    private void addMedicine() {
        try {
            String name = txtName.getText().trim();
            double price = Double.parseDouble(txtPrice.getText().trim());
            int stock = Integer.parseInt(txtStock.getText().trim());

            if (!name.isEmpty()) {
                inventory.add(new Medicine(name, price, stock));
                refreshTable();
                txtName.setText("");
                txtPrice.setText("");
                txtStock.setText("");
                JOptionPane.showMessageDialog(this, "Medicine Added Successfully!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid inputs!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void sellMedicine() {
        int selectedRow = medicineTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Select a medicine from table first!");
            return;
        }

        try {
            int qty = Integer.parseInt(txtQty.getText().trim());
            Medicine m = inventory.get(selectedRow);

            if (qty <= m.stock) {
                m.stock -= qty;
                double cost = m.price * qty;
                grandTotal += cost;
                lblTotal.setText("Total Bill: PKR " + grandTotal);
                refreshTable();
                txtQty.setText("");
                JOptionPane.showMessageDialog(this, "Sale Recorded! Cost: PKR " + cost);
            } else {
                JOptionPane.showMessageDialog(this, "Insufficient stock!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Enter valid quantity!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PharmacyManagement().setVisible(true);
        });
    }
}
