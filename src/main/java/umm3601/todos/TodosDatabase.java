package umm3601.todos;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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
    Todo[] filteredTodos = allTodos;
    if (queryParams.containsKey("contains")) {
      filteredTodos = getTodosByBodyString(filteredTodos, queryParams.get("contains")[0]);
    }
    if (queryParams.containsKey("limit")) {
      long limit = Long.parseLong(queryParams.get("limit")[0]);
      filteredTodos = getTodosByLimit(filteredTodos, limit);
    }
    return filteredTodos;
  }

  public Todo[] getTodosByLimit(Todo[] todos, long limit) {
    return Arrays.stream(todos).limit(limit).toArray(Todo[]::new);
  }

  public Todo[] getTodosByBodyString(Todo[] todos, String search) {
    return Arrays.stream(todos).filter(x -> x.body.contains(search)).toArray(Todo[]::new);
  }

  public Todo[] orderTodosByField(Todo[] todos, String field) {
    if (field == "owner") {

    }
    return todos;
  }

  public Todo[] orderTodosByOwner(Todo[] todos) {
    return todos;
  }

}
