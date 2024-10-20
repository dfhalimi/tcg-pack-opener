package Presentation.Entity;

import Domain.Entity.TradingCard;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TradingCardGUI extends JFrame {
    List<TradingCard> ownedCards;

    public TradingCardGUI(
            List<TradingCard> ownedCards
    ) {
        this.ownedCards = ownedCards;
        initUI();
    }

    private void initUI() {
        setTitle("Owned Trading Cards");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Card Number");
        tableModel.addColumn("Card Name");
        tableModel.addColumn("Card Rarity");

        for (TradingCard card : ownedCards) {
            tableModel.addRow(new Object[]{card.getCardNumber(), card.getName(), card.getRarity().getValue()});
        }

        JTable cardTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(cardTable);

        add(scrollPane, BorderLayout.CENTER);
    }
}
