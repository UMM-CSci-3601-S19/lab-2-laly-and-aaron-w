package umm3601.todos;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertEquals;

public class GetTodosByBodyStringFromDB {

  @Test
  public void searchFor_sit_() throws IOException {
    TodosDatabase db = new TodosDatabase("src/main/data/todos.json");
    Todo[] todos = db.listTodos(new HashMap<>());
    Todo[] _sit_todos = db.getTodosByBodyString(todos, "sit");
    for(Todo todo:_sit_todos) {
      assertTrue(todo.body.contains("sit"));
    }
    System.out.println(_sit_todos.length);
    assertEquals("Incorrect number of todos containing sit", 69, _sit_todos.length);
  }

}
