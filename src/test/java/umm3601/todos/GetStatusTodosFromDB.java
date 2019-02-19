package umm3601.todos;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class GetStatusTodosFromDB {

  @Test
  public void getCompleteTodos() throws IOException {
    TodosDatabase db = new TodosDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] completeTodos = db.getCompleteTodos(allTodos);
    for (Todo todo:completeTodos) {
      assertEquals(true, todo.status.equals(true));
    }
  }

  @Test
  public void getIncompleteTodos() throws IOException {
    TodosDatabase db = new TodosDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] incompleteTodos = db.getIncompleteTodos(allTodos);
    for (Todo todo:incompleteTodos) {
      assertEquals(true, todo.status.equals(false));
    }
  }
}
