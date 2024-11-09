package Presentation.View;

import Domain.Entity.TradingCard;
import Presentation.Service.TradingCardPresentationService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class OwnedCardsGUI extends GUI {
    private final TradingCardPresentationService tradingCardPresentationService;
    private final List<TradingCard> ownedCards;

    public OwnedCardsGUI(
            TradingCardPresentationService tradingCardPresentationService,
            List<TradingCard>              ownedCards
    ) {
        this.tradingCardPresentationService = tradingCardPresentationService;
        this.ownedCards = ownedCards;
        initUI();
    }

    protected void initUI() {
        setTitle("Owned Cards");
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

        JTable cardTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(cardTable);

        add(scrollPane, BorderLayout.CENTER);

        JButton backButton = new JButton("Back to Main Menu");
        backButton.addActionListener(e -> tradingCardPresentationService.handleBackToMainMenuButtonClick(this));
        add(backButton, BorderLayout.SOUTH);
    }
}
