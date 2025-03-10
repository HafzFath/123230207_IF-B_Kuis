/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg123230207_if.b_kuis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class B_Kuis {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginFrame().setVisible(true);
        });
    }
}

class MainFrame extends JFrame {
    private JTextField appleQuantityField, orangeQuantityField, mangoQuantityField;
    private JLabel welcomeLabel;

    public MainFrame(String username) {
        setTitle("Halaman Belanja Buah");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        welcomeLabel = new JLabel("Selamat Datang, " + username);
        welcomeLabel.setBounds(10, 20, 300, 25);
        panel.add(welcomeLabel);

        JLabel appleLabel = new JLabel("Apel (Rp15.000/kg):");
        appleLabel.setBounds(10, 60, 200, 25);
        panel.add(appleLabel);

        appleQuantityField = new JTextField("0");
        appleQuantityField.setBounds(210, 60, 100, 25);
        panel.add(appleQuantityField);

        JLabel orangeLabel = new JLabel("Jeruk (Rp12.000/kg):");
        orangeLabel.setBounds(10, 90, 200, 25);
        panel.add(orangeLabel);

        orangeQuantityField = new JTextField("0");
        orangeQuantityField.setBounds(210, 90, 100, 25);
        panel.add(orangeQuantityField);

        JLabel mangoLabel = new JLabel("Mangga (Rp20.000/kg):");
        mangoLabel.setBounds(10, 120, 200, 25);
        panel.add(mangoLabel);

        mangoQuantityField = new JTextField("0");
        mangoQuantityField.setBounds(210, 120, 100, 25);
        panel.add(mangoQuantityField);

        JButton buyButton = new JButton("Beli");
        buyButton.setBounds(10, 160, 80, 25);
        panel.add(buyButton);

        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double appleQuantity = parseQuantity(appleQuantityField.getText());
                    double orangeQuantity = parseQuantity(orangeQuantityField.getText());
                    double mangoQuantity = parseQuantity(mangoQuantityField.getText());
                    if (appleQuantity >= 0 && orangeQuantity >= 0 && mangoQuantity >= 0) {
                        double applePrice = 15000;
                        double orangePrice = 12000;
                        double mangoPrice = 20000;
                        double subtotal = (appleQuantity * applePrice) + (orangeQuantity * orangePrice) + (mangoQuantity * mangoPrice);
                        double tax = subtotal * 0.1; 
                        double total = subtotal + tax;
                        new PurchaseSummaryFrame(username, appleQuantity, orangeQuantity, mangoQuantity, applePrice, orangePrice, mangoPrice, subtotal, tax, total).setVisible(true);
                        dispose(); 
                    } else {
                        JOptionPane.showMessageDialog(MainFrame.this, "Jumlah tidak boleh negatif!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MainFrame.this, "Input tidak valid! Harap masukkan angka yang valid.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(100, 160, 80, 25);
        panel.add(logoutButton);

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(panel);
    }

    private double parseQuantity(String input) throws NumberFormatException {
        double quantity = Double.parseDouble(input);
        if (quantity < 0) {
            throw new NumberFormatException("Jumlah tidak boleh negatif");
        }
        return quantity;
    }

    public static void main(String[] args) {
        new MainFrame("Hafidz").setVisible(true);
    }
}
