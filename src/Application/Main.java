package Application;

import Domain.Entity.TradingCard;
import Domain.Service.TradingCardService;

import java.util.List;

public class Main {
    private final TradingCardService tradingCardService;

    public Main(
            TradingCardService tradingCardService
    ) {
        this.tradingCardService = tradingCardService;
    }

    public void printOwnedCards() {
        List<TradingCard> tradingCards = tradingCardService.getAllOwnedCards();
        for (TradingCard card : tradingCards) {
            System.out.println("Card number: " + card.getCardNumber());
            System.out.println("Card name: " + card.getName());
            System.out.println("Card rarity: " + card.getRarity().getValue());
            System.out.println("--------------");
        }
    }

    public static void main(String[] args) {
        SimpleDIContainer container = new SimpleDIContainer();

        Main app = container.getInstance(Main.class);
        app.printOwnedCards();
    }
}
