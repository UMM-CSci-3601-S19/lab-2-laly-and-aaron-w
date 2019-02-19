package umm3601.todos;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;

public class GetTodosByOwner {

  @Test
  public void getRobertaTodos() throws IOException {
    TodosDatabase db = new TodosDatabase("src/main/data/todos.json");
    Todo[] todos = db.listTodos(new HashMap<>());
    todos = db.getTodosByOwner(todos, "Roberta");
    for (Todo todo:todos) {
      assertEquals("Incorrect owner", "Roberta", todo.owner);
    }
  }

  @Test
  public void getBlancheTodos() throws IOException {
    TodosDatabase db = new TodosDatabase("src/main/data/todos.json");
    Todo[] todos = db.listTodos(new HashMap<>());
    todos = db.getTodosByOwner(todos, "Blanche");
    for (Todo todo:todos) {
      assertEquals("Incorrect owner", "Blanche", todo.owner);
    }
  }
}
