package umm3601.todos;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class GetLimitedNumberOfTodosFromDB {

  @Test
  public void totalTodosLimit() throws IOException {
    TodosDatabase db = new TodosDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] _300Todos = db.getTodosByLimit(allTodos, 300);
    Todo[] _0Todos = db.getTodosByLimit(allTodos, 0);
    Todo[] _130Todos = db.getTodosByLimit(allTodos, 130);

    assertEquals("Incorrect limited number of todos", 300, _300Todos.length);
    assertEquals("Incorrect limited number of todos", 0, _0Todos.length);
    assertEquals("Incorrect limited number of todos", 130, _130Todos.length);
  }
}
