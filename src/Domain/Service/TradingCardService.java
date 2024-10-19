package Domain.Service;

import Domain.Entity.TradingCard;
import Infrastructure.Repository.TradingCardRepository;

import java.util.List;

public class TradingCardService {
    private final TradingCardRepository tradingCardRepository;

    public TradingCardService(
            TradingCardRepository tradingCardRepository
    ) {
        this.tradingCardRepository = tradingCardRepository;
    }

    public List<TradingCard> getAllOwnedCards() {
        return tradingCardRepository.getOwnedCards();
    }

    public void addCardToCollection(TradingCard card) {
        tradingCardRepository.addCard(card);
    }

    public void removeCardFromCollection(TradingCard card) {
        tradingCardRepository.removeCard(card);
    }
}
