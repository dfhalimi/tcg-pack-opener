package Presentation.Service;

import Domain.Entity.TradingCard;
import Domain.Service.TradingCardDomainService;
import Presentation.Entity.TradingCardGUI;

import java.util.List;

public class TradingCardPresentationService {
    private final TradingCardDomainService tradingCardDomainService;

    public TradingCardPresentationService(
            TradingCardDomainService tradingCardDomainService
    ) {
        this.tradingCardDomainService = tradingCardDomainService;
    }

    public void initUI() {
        tradingCardDomainService.pullRandomCards(5);
        List<TradingCard> ownedCards = tradingCardDomainService.getAllOwnedCards();
        TradingCardGUI gui = new TradingCardGUI(ownedCards);
        gui.setVisible(true);
    }
}
