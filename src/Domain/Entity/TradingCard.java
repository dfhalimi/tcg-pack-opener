package Domain.Entity;

import Domain.Enum.TradingCardRarity;

import java.util.UUID;

public class TradingCard {
    public TradingCard(
            int cardNumber,
            String name,
            TradingCardRarity rarity
    ) {
        this.id = UUID.randomUUID().toString();
        this.cardNumber = cardNumber;
        this.name = name;
        this.rarity = rarity;
    }

    private final String id;

    public String getId() {
        return id;
    }


    private int cardNumber;

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }


    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    private TradingCardRarity rarity;

    public TradingCardRarity getRarity() {
        return rarity;
    }

    public void setRarity(TradingCardRarity rarity) {
        this.rarity = rarity;
    }
}
