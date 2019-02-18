package umm3601.todos;

import java.util.Arrays;
import java.util.Map;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;

public class TodosDatabase {

  private Todo[] allTodos;

  public TodosDatabase(String todosDataFile) throws IOException {
    Gson gson = new Gson();
    FileReader reader = new FileReader(todosDataFile);
    allTodos = gson.fromJson(reader, Todo[].class);
  }

  public Todo getTodo(String id) {
    return Arrays.stream(allTodos).filter(x -> x._id.equals(id)).findFirst().orElse(null);
  }

  public Todo[] listTodos(Map<String, String[]> queryParams) {
    return allTodos;
  }

}
