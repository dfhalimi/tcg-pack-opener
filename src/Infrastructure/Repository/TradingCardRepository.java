package Infrastructure.Repository;

import Domain.Entity.TradingCard;
import Domain.Enum.TradingCardRarity;
import Infrastructure.Database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class TradingCardRepository {
    private final List<TradingCard> ownedCards;
    private Connection connection;

    public TradingCardRepository() throws SQLException {
        ownedCards = new ArrayList<>();
        try {
            connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            System.err.println("Failed to initialize the database connection.");
            e.printStackTrace();
        }
    }

    public List<TradingCard> getOwnedCards() {
        return ownedCards;
    }

    public List<TradingCard> getRandomCards(int numberOfCards) {
        List<TradingCard> randomCards = new ArrayList<>();

        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM trading_cards;");

            List<TradingCard> allCards = new ArrayList<>();
            while (resultSet.next()) {
                TradingCard card = new TradingCard(
                        resultSet.getInt("card_number"),
                        resultSet.getString("name"),
                        TradingCardRarity.valueOf(resultSet.getString("rarity"))
                );

                allCards.add(card);
            }

            Random random = new Random();
            for (int i = 0; i < numberOfCards; i++) {
                int randomIndex = random.nextInt(allCards.size());
                randomCards.add(allCards.get(randomIndex));
            }
        } catch (SQLException e) {
            System.err.println("Failed to get trading cards from database.");
            e.printStackTrace();
        }

        return randomCards;
    }

    public void addCard(TradingCard card) {
        ownedCards.add(card);
    }

    public void removeCard(TradingCard cardToRemove) {
        ownedCards.removeIf(card -> Objects.equals(card.getId(), cardToRemove.getId()));
    }
}
