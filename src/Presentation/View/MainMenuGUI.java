package Presentation.View;

import Presentation.Service.TradingCardPresentationService;

import javax.swing.*;
import java.awt.*;

public class MainMenuGUI extends GUI {
    private final TradingCardPresentationService tradingCardPresentationService;

    public MainMenuGUI(
            TradingCardPresentationService tradingCardPresentationService
    ) {
        this.tradingCardPresentationService = tradingCardPresentationService;
    }

    protected void initUI() {
        setTitle("Main Menu");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE; // Vertically relative positions
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.anchor = GridBagConstraints.CENTER;

        JButton openPacksButton = new JButton("Open Packs");
        openPacksButton.setPreferredSize(new Dimension(200, 50));
        openPacksButton.addActionListener(e -> this.tradingCardPresentationService.handleOpenPacksButtonClick(this));
        add(openPacksButton, gbc);

        JButton viewOwnedCardsButton = new JButton("View Owned Cards");
        viewOwnedCardsButton.setPreferredSize(new Dimension(200, 50));
        viewOwnedCardsButton.addActionListener(e -> this.tradingCardPresentationService.handleViewOwnedCardsButtonClick(this));
        add(viewOwnedCardsButton, gbc);

        JButton exitButton = new JButton("Exit");
        exitButton.setPreferredSize(new Dimension(200, 50));
        exitButton.addActionListener(e -> System.exit(0));
        add(exitButton, gbc);
    }
}
