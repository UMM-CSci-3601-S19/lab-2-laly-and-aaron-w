package umm3601.todos;

import java.util.Arrays;
import java.util.Map;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;

import static javax.xml.bind.DatatypeConverter.parseBoolean;

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
    if (queryParams.containsKey("status")) {
      boolean status;
      if (queryParams.get("status")[0].equals("complete")) {
        status = true;
      } else {
        status = false;
      }
      filteredTodos = getTodosByStatus(filteredTodos, status);
    }
    if (queryParams.containsKey("contains")) {
      filteredTodos = getTodosByBodyString(filteredTodos, queryParams.get("contains")[0]);
    }
    if (queryParams.containsKey("owner")) {
      filteredTodos = getTodosByOwner(filteredTodos, queryParams.get("owner")[0]);
    }
    if (queryParams.containsKey("category")) {
      filteredTodos = getTodosByCategory(filteredTodos, queryParams.get("category")[0]);
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

  public Todo[] getTodosByOwner(Todo[] todos, String owner) {
    return Arrays.stream(todos).filter(x -> x.owner.equals(owner)).toArray(Todo[]::new);
  }

  public Todo[] getTodosByCategory(Todo[] todos, String category) {
    return Arrays.stream(todos).filter(x -> x.category.equals(category)).toArray(Todo[]::new);
  }

  public Todo[] getCompleteTodos(Todo[] todos) {
    return Arrays.stream(todos).filter(x -> x.status).toArray(Todo[]::new);
  }

  public Todo[] getIncompleteTodos(Todo[] todos) {
    return Arrays.stream(todos).filter(x -> !x.status).toArray(Todo[]::new);
  }

  public Todo[] getTodosByStatus(Todo[] todos, boolean status) {
    if (status) {
      return Arrays.stream(todos).filter(x -> x.status).toArray(Todo[]::new);
    } else {
      return Arrays.stream(todos).filter(x -> !x.status).toArray(Todo[]::new);
    }
  }

}
