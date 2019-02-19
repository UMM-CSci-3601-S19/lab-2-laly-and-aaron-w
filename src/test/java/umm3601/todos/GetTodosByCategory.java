package umm3601.todos;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;

public class GetTodosByCategory {

  @Test
  public void getHomeworkTodos() throws IOException {
    TodosDatabase db = new TodosDatabase("src/main/data/todos.json");
    Todo[] todos = db.listTodos(new HashMap<>());
    todos = db.getTodosByCategory(todos, "homework");
    for (Todo todo:todos) {
      assertEquals("Incorrect category", "homework", todo.category);
    }
    assertEquals("Incorrect length", 79, todos.length);
  }

  @Test
  public void getGroceriesTodos() throws IOException {
    TodosDatabase db = new TodosDatabase("src/main/data/todos.json");
    Todo[] todos = db.listTodos(new HashMap<>());
    todos = db.getTodosByCategory(todos, "groceries");
    for (Todo todo : todos) {
      assertEquals("Incorrect category", "groceries", todo.category);
    }
    assertEquals("Incorrect length", 76, todos.length);
  }
}
