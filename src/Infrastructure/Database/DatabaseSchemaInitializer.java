package Infrastructure.Database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSchemaInitializer {
    public static void initializeDatabase() {
        String schemaFilePath = "src/main/resources/schema.sql";

        try (Connection connection = DatabaseConnection.getConnection();
             BufferedReader reader = new BufferedReader(new FileReader(schemaFilePath))) {

            StringBuilder sqlBuilder = new StringBuilder();
            String line;

            // Read the schema file line by line
            while ((line = reader.readLine()) != null) {
                sqlBuilder.append(line).append(" ");
                if (line.trim().endsWith(";")) {
                    // Once we encounter a complete SQL statement, execute it
                    String sqlStatement = sqlBuilder.toString().trim();
                    try (Statement statement = connection.createStatement()) {
                        statement.execute(sqlStatement);
                    }
                    // Clear the builder for the next statement
                    sqlBuilder.setLength(0);
                }
            }

            System.out.println("Database schema initialized successfully.");

        } catch (IOException e) {
            System.err.println("Failed to read the SQL schema file.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Failed to initialize the database schema.");
            e.printStackTrace();
        }
    }
}