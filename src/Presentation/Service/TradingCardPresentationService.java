package Presentation.Service;

import Domain.Entity.TradingCard;
import Domain.Service.TradingCardDomainService;
import Presentation.View.TradingCardGUI;

import java.util.List;

public class TradingCardPresentationService {
    private final TradingCardDomainService tradingCardDomainService;

    public TradingCardPresentationService(
            TradingCardDomainService tradingCardDomainService
    ) {
        this.tradingCardDomainService = tradingCardDomainService;
    }

    public void initUI() {
        List<TradingCard> ownedCards = tradingCardDomainService.getAllOwnedCards();
        TradingCardGUI gui = new TradingCardGUI(this, ownedCards);
        gui.setVisible(true);
    }

    public void handleOpenPackButtonClick(TradingCardGUI gui) {
        List<TradingCard> cardsFromPack = tradingCardDomainService.pullRandomCards(5);
        gui.updateTable(cardsFromPack);
    }
}
