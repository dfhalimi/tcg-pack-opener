package Presentation.View;

import Domain.Entity.TradingCard;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class OwnedCardsGUI extends JFrame {
    private JTable cardTable;
    private List<TradingCard> ownedCards;

    public OwnedCardsGUI(
            List<TradingCard> ownedCards
    ) {
        this.ownedCards = ownedCards;
        initUI();
    }

    private void initUI() {
        setTitle("Pack Opener");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Card Number");
        tableModel.addColumn("Card Name");
        tableModel.addColumn("Card Rarity");

        for (TradingCard card : this.ownedCards) {
            tableModel.addRow(new Object[]{card.getCardNumber(), card.getName(), card.getRarity()});
        }

        cardTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(cardTable);

        add(scrollPane, BorderLayout.CENTER);
    }
}
