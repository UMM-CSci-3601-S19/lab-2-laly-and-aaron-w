package umm3601.todos;

import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class GetTodoByIDFromDB {

  @Test
  public void getID1() throws IOException {
    TodosDatabase db = new TodosDatabase("src/main/data/todos.json");
    Todo todo = db.getTodo("58895985c1849992336c219b");
    assertEquals("Incorrect id", "58895985c1849992336c219b", todo._id);
  }

  @Test
  public void getID2() throws IOException {
    TodosDatabase db = new TodosDatabase("src/main/data/todos.json");
    Todo todo = db.getTodo("58895985ae3b752b124e7663");
    assertEquals("Incorrect id", "58895985ae3b752b124e7663", todo._id);
  }
}
