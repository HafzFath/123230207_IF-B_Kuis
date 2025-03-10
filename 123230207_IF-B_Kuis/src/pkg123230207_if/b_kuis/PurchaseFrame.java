/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg123230207_if.b_kuis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.text.NumberFormat;

/**
 *
 * @author Lab Informatika
 */


class PurchaseSummaryFrame extends JFrame {
    public PurchaseSummaryFrame(String username, double appleQuantity, double orangeQuantity, double mangoQuantity,
                                 double applePrice, double orangePrice, double mangoPrice,
                                 double subtotal, double tax, double total) {
        setTitle("Ringkasan Pembelian");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel appleSummary = new JLabel("Apel: " + appleQuantity + " kg x Rp" + NumberFormat.getInstance().format(applePrice));
        appleSummary.setBounds(10, 60, 350, 25);
        panel.add(appleSummary);

        JLabel orangeSummary = new JLabel("Jeruk: " + orangeQuantity + " kg x Rp" + NumberFormat.getInstance().format(orangePrice));
        orangeSummary.setBounds(10, 90, 350, 25);
        panel.add(orangeSummary);

        JLabel mangoSummary = new JLabel("Mangga: " + mangoQuantity + " kg x Rp" + NumberFormat.getInstance().format(mangoPrice));
        mangoSummary.setBounds(10, 120, 350, 25);
        panel.add(mangoSummary);
        
        

        JLabel subtotalLabel = new JLabel("Subtotal: Rp" + NumberFormat.getInstance().format(subtotal));
        subtotalLabel.setBounds(10, 150, 350, 25);
        panel.add(subtotalLabel);

        JLabel taxLabel = new JLabel("Pajak (10%): Rp" + NumberFormat.getInstance().format(tax));
        taxLabel.setBounds(10, 180, 350, 25);
        panel.add(taxLabel);

        JLabel totalLabel = new JLabel("Total Harga: Rp" + NumberFormat.getInstance().format(total));
        totalLabel.setBounds(10, 210, 350, 25);
        panel.add(totalLabel);

        JButton backButton = new JButton("Kembali");
        backButton.setBounds(10, 250, 80, 25);
        panel.add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainFrame(username).setVisible(true);
                dispose(); 
            }
        });

        add(panel);
    }
}
