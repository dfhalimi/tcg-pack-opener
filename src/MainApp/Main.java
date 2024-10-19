package MainApp;

import Domain.Entity.TradingCard;
import Domain.Enum.TradingCardRarity;

public class Main {
    public static void main(String[] args) {
        TradingCard card = new TradingCard(1, "Stoat", TradingCardRarity.COMMON);

        System.out.println("Card number: " + card.getCardNumber());
        System.out.println("Card name: " + card.getName());
        System.out.println("Card rarity: " + card.getRarity().getValue());
    }
}
