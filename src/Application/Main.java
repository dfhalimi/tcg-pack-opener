package Application;

import Infrastructure.Database.DatabaseSchemaInitializer;
import Presentation.Service.TradingCardPresentationService;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        DatabaseSchemaInitializer.initializeDatabase();

        SimpleDIContainer container = new SimpleDIContainer();

        SwingUtilities.invokeLater(() -> {
            TradingCardPresentationService tradingCardPresentationService = container.getInstance(TradingCardPresentationService.class);
            tradingCardPresentationService.initUI();
        });
    }
}
