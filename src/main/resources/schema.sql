CREATE DATABASE IF NOT EXISTS tcg_pack_opener_dev;

USE tcg_pack_opener_dev;

CREATE TABLE IF NOT EXISTS trading_cards (
                               id VARCHAR(36) PRIMARY KEY,
                               card_number INT NOT NULL,
                               name VARCHAR(255) NOT NULL,
                               rarity VARCHAR(50) NOT NULL
);
