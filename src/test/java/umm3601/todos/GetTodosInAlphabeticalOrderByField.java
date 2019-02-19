package umm3601.todos;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static junit.framework.TestCase.assertTrue;

public class GetTodosInAlphabeticalOrderByField {

  @Test
  public void getAlphaCategoryTodos() throws IOException {
    TodosDatabase db = new TodosDatabase("src/main/data/todos.json");
    Todo[] todos = db.listTodos(new HashMap<>());
    todos = db.orderTodosByField(todos, "category");
    for (int i = 0; i< 299; i++) {
      assertTrue(todos[i].getCategory().compareTo(todos[i+1].getCategory()) <= 0);
    }
  }

  @Test
  public void getAlphaOwnerTodos() throws IOException {
    TodosDatabase db = new TodosDatabase("src/main/data/todos.json");
    Todo[] todos = db.listTodos(new HashMap<>());
    todos = db.orderTodosByField(todos, "owner");
    for (int i = 0; i< 299; i++) {
      assertTrue(todos[i].getOwner().compareTo(todos[i+1].getOwner()) <= 0);
    }
  }

  @Test
  public void getAlphaStatusTodos() throws IOException {
    TodosDatabase db = new TodosDatabase("src/main/data/todos.json");
    Todo[] todos = db.listTodos(new HashMap<>());
    todos = db.orderTodosByField(todos, "status");
    for (int i = 0; i< 299; i++) {
      assertTrue(todos[i].getStatus().compareTo(todos[i+1].getStatus()) <= 0);
    }
  }

  @Test
  public void getAlphaBodyTodos() throws IOException {
    TodosDatabase db = new TodosDatabase("src/main/data/todos.json");
    Todo[] todos = db.listTodos(new HashMap<>());
    todos = db.orderTodosByField(todos, "body");
    for (int i = 0; i< 299; i++) {
      assertTrue(todos[i].getBody().compareTo(todos[i+1].getBody()) <= 0);
    }
  }
}
