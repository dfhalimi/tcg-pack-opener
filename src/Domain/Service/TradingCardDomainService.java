package Domain.Service;

import Domain.Entity.TradingCard;
import Infrastructure.Repository.TradingCardRepository;

import java.util.List;

public class TradingCardDomainService {
    private final TradingCardRepository tradingCardRepository;

    public TradingCardDomainService(
            TradingCardRepository tradingCardRepository
    ) {
        this.tradingCardRepository = tradingCardRepository;
    }

    public List<TradingCard> getAllOwnedCards() {
        return tradingCardRepository.getOwnedCards();
    }

    public void pullRandomCards(int numberOfCards) {
        List<TradingCard> randomCards = this.tradingCardRepository.getRandomCards(numberOfCards);

        for (TradingCard tradingCard : randomCards) {
            addCardToCollection(tradingCard);
        }
    }

    public void addCardToCollection(TradingCard card) {
        tradingCardRepository.addCard(card);
    }

    public void removeCardFromCollection(TradingCard card) {
        tradingCardRepository.removeCard(card);
    }
}
