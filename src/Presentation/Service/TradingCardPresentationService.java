package Presentation.Service;

import Domain.Entity.TradingCard;
import Domain.Service.TradingCardDomainService;
import Presentation.View.MainMenuGUI;
import Presentation.View.OwnedCardsGUI;
import Presentation.View.PackOpenerGUI;

import java.util.List;

public class TradingCardPresentationService {
    private final TradingCardDomainService tradingCardDomainService;

    public TradingCardPresentationService(
            TradingCardDomainService tradingCardDomainService
    ) {
        this.tradingCardDomainService = tradingCardDomainService;
    }

    public void initUI() {
        MainMenuGUI gui = new MainMenuGUI(this);
        gui.setVisible(true);
    }

    public void handleOpenPacksButtonClick(MainMenuGUI gui) {
        new PackOpenerGUI(this).setVisible(true);
        gui.dispose();
    }

    public void handleViewOwnedCardsButtonClick(MainMenuGUI gui) {
        List<TradingCard> ownedCards = tradingCardDomainService.getAllOwnedCards();
        new OwnedCardsGUI(ownedCards).setVisible(true);
        gui.dispose();
    }

    public void handleOpenPackButtonClick(PackOpenerGUI gui) {
        List<TradingCard> cardsFromPack = tradingCardDomainService.pullRandomCards(5);
        gui.updateTable(cardsFromPack);
    }
}
