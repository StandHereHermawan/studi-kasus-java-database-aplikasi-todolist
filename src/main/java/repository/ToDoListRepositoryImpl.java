package repository;

import entity.ToDoList;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ToDoListRepositoryImpl implements ToDoListRepository {

    private DataSource dataSource;

    public ToDoListRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public ToDoList[] getAll() {
        return ;
    }

    public void add(ToDoList toDoList) {
        String sql = "INSERT INTO todolist(todo) VALUES (?)";

        try (Connection connection = dataSource.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, toDoList.getToDo());
            statement.executeUpdate();

        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    public boolean isExist(Integer number) {
        String sql = "SELECT id FROM todolist WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, number);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return true;
                } else {
                    return false;
                }
            }

        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    public boolean remove(Integer number) {
        if (isExist(number)) {
            String sql = "DELETE FROM todolist WHERE id = ?";
            try (Connection connection = dataSource.getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setInt(1, number);
                statement.executeUpdate();

                return true;
            } catch (SQLException exception) {
                throw new RuntimeException(exception);
            }
        } else {
            return false;
        }
    }
}
