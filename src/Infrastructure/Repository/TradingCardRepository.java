package Infrastructure.Repository;

import Domain.Entity.TradingCard;
import Domain.Enum.TradingCardRarity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TradingCardRepository {
    private final List<TradingCard> ownedCards;

    public TradingCardRepository() {
        ownedCards = new ArrayList<>();

        ownedCards.add(new TradingCard(1, "Stoat", TradingCardRarity.COMMON));
        ownedCards.add(new TradingCard(2, "Squirrel", TradingCardRarity.COMMON));
        ownedCards.add(new TradingCard(2, "Squirrel", TradingCardRarity.RARE));
        ownedCards.add(new TradingCard(3, "Wolf", TradingCardRarity.ULTRA_RARE));
    }

    public List<TradingCard> getOwnedCards() {
        return ownedCards;
    }

    public void addCard(TradingCard card) {
        ownedCards.add(card);
    }

    public void removeCard(TradingCard cardToRemove) {
        ownedCards.removeIf(card -> Objects.equals(card.getId(), cardToRemove.getId()));
    }
}
