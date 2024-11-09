package Presentation.View;

import Domain.Entity.TradingCard;
import Presentation.Service.TradingCardPresentationService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PackOpenerGUI extends GUI {
    private final TradingCardPresentationService tradingCardPresentationService;
    private JTable cardTable;

    public PackOpenerGUI(
            TradingCardPresentationService tradingCardPresentationService
    ) {
        this.tradingCardPresentationService = tradingCardPresentationService;
        initUI();
    }

    public void updateTable(List<TradingCard> newCards) {
        DefaultTableModel model = (DefaultTableModel) cardTable.getModel();
        model.setRowCount(0);

        for (TradingCard card : newCards) {
            model.addRow(new Object[]{card.getCardNumber(), card.getName(), card.getRarity()});
        }
    }

    protected void initUI() {
        setTitle("Pack Opener");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Card Number");
        tableModel.addColumn("Card Name");
        tableModel.addColumn("Card Rarity");

        cardTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(cardTable);

        add(scrollPane, BorderLayout.CENTER);

        JButton openPackButton = new JButton("Open Pack");
        openPackButton.addActionListener(e -> tradingCardPresentationService.handleOpenPackButtonClick(this));
        add(openPackButton, BorderLayout.NORTH);

        JButton backButton = new JButton("Back to Main Menu");
        backButton.addActionListener(e -> tradingCardPresentationService.handleBackToMainMenuButtonClick(this));
        add(backButton, BorderLayout.SOUTH);
    }
}
