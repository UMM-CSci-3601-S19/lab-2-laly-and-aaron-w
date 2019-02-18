package umm3601.todos;

import java.util.Arrays;
import java.util.Map;

public class TodosDatabase {

  private Todo[] allTodos;

  public Todo getTodo(String id) {
    return Arrays.stream(allTodos).filter(x -> x._id.equals(id)).findFirst().orElse(null);
  }

  public Todo[] listTodos(Map<String, String[]> queryParams) {
    return allTodos;
  }

}
