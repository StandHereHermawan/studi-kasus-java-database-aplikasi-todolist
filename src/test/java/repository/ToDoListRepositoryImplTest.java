package repository;

import com.zaxxer.hikari.HikariDataSource;
import entity.ToDoList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.DatabaseUtil;

public class ToDoListRepositoryImplTest {

    private HikariDataSource dataSource;

    private ToDoListRepository toDoListRepository;

    @BeforeEach
    void setUp() {
        dataSource = DatabaseUtil.getDataSource();
        toDoListRepository = new ToDoListRepositoryImpl(dataSource);
    }

    @Test
    void testAdd() {
        ToDoList toDoList = new ToDoList();
        toDoList.setToDo("Karditya");

        toDoListRepository.add(toDoList);
    }

    @Test
    void testRemove() {
        System.out.println(toDoListRepository.remove(1));
        System.out.println(toDoListRepository.remove(2));
        System.out.println(toDoListRepository.remove(3));
        System.out.println(toDoListRepository.remove(4));
    }

    @AfterEach
    void tearDown() {
        dataSource.close();
    }
}
