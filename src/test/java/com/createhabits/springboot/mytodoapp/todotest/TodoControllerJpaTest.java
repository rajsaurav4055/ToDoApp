package com.createhabits.springboot.mytodoapp.todotest;


import org.junit.jupiter.api.Test;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import com.createhabits.springboot.mytodoapp.todo.Todo;
import com.createhabits.springboot.mytodoapp.todo.TodoControllerJpa;
import com.createhabits.springboot.mytodoapp.todo.TodoRepository;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;

public class TodoControllerJpaTest {
	
    // Mock TodoRepository
	TodoRepository todoRepository = mock(TodoRepository.class);
    TodoControllerJpa controller = new TodoControllerJpa(todoRepository);
    ModelMap model = new ModelMap();
    Todo todo = new Todo();
    
    // Mock BindingResult
    BindingResult result = mock(BindingResult.class);
    
    // Mock the Authentication object
    Authentication authentication = mock(Authentication.class);
    

    @Test
    public void testAddNewTodo() {  
        when(authentication.getName()).thenReturn("TestUser");
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String viewName = controller.addNewTodo(model, todo, result);
        
        verify(todoRepository, times(1)).save(todo);
        assertEquals("redirect:list-todos", viewName);
    }
    
    @Test
    public void testListAllTodos() {     
        when(authentication.getName()).thenReturn("TestUser");
        SecurityContextHolder.getContext().setAuthentication(authentication);

        List<Todo> todos = Collections.singletonList(new Todo());
        when(todoRepository.findByUsername("TestUser")).thenReturn(todos);

        String viewName = controller.listAllTodos(model);

        verify(todoRepository, times(1)).findByUsername("TestUser");
        assertEquals("listTodos", viewName);
        assertEquals(todos, model.get("todos"));
    }
    
    @Test
    public void testDeleteTodo() {
        String viewName = controller.deleteTodo(1);
        verify(todoRepository, times(1)).deleteById(1);
        assertEquals("redirect:list-todos", viewName);
    }
    
    @Test
    public void testShowUpdateTodoPage() {
        when(todoRepository.findById(1)).thenReturn(java.util.Optional.of(todo));
        String viewName = controller.showUpdateTodoPage(1, model);

        verify(todoRepository, times(1)).findById(1);
        assertEquals("todo", viewName);
        assertEquals(todo, model.get("todo"));
    }
    
    @Test
    public void testUpdateTodo() {
        String viewName = controller.updateTodo(model, todo, result);

        verify(todoRepository, times(1)).save(todo);
        assertEquals("redirect:list-todos", viewName);
    }

}


