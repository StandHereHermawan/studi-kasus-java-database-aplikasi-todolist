package util;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseUtilTest {
    @Test
    void testConnection() throws SQLException {
        HikariDataSource DataSource = DatabaseUtil.getDataSource();

        Connection connection = DataSource.getConnection();

        connection.close();

        DataSource.close();
    }
}
