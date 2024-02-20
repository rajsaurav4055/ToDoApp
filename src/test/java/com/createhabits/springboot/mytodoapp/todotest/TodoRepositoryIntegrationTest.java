package com.createhabits.springboot.mytodoapp.todotest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.createhabits.springboot.mytodoapp.todo.Todo;
import com.createhabits.springboot.mytodoapp.todo.TodoRepository;

import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class TodoRepositoryIntegrationTest {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    public void testFindByUsername() {
        Todo todo = new Todo();
        todo.setUsername("TestUser");
        todo.setDescription("Test Todo");
        todo.setTargetDate(LocalDate.now());
        todo.setDone(false);
        todoRepository.save(todo);

        List<Todo> todos = todoRepository.findByUsername("TestUser");

        assertEquals(1, todos.size());
        assertEquals("Test Todo", todos.get(0).getDescription());
    }
}

