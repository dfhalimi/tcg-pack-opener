package Presentation.Entity;

import Domain.Entity.TradingCard;
import Presentation.Service.TradingCardPresentationService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TradingCardGUI extends JFrame {
    private final TradingCardPresentationService tradingCardPresentationService;
    private JTable cardTable;
    List<TradingCard> ownedCards;

    public TradingCardGUI(
            TradingCardPresentationService tradingCardPresentationService,
            List<TradingCard>              ownedCards
    ) {
        this.tradingCardPresentationService = tradingCardPresentationService;
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

        cardTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(cardTable);

        add(scrollPane, BorderLayout.CENTER);

        JButton openPackButton = new JButton("Open Pack");
        openPackButton.addActionListener(e -> tradingCardPresentationService.handleOpenPackButtonClick(this));

        add(openPackButton, BorderLayout.SOUTH);
    }

    public void updateTable(List<TradingCard> newCards) {
        DefaultTableModel model = (DefaultTableModel) cardTable.getModel();
        model.setRowCount(0);

        for (TradingCard card : newCards) {
            model.addRow(new Object[]{card.getCardNumber(), card.getName(), card.getRarity()});
        }
    }
}
