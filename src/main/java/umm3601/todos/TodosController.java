package umm3601.todos;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import spark.Request;
import spark.Response;

import java.io.IOException;

import static umm3601.Util.*;

public class TodosController {

  private final Gson gson;
  private TodosDatabase database;

  public TodosController(TodosDatabase database) {
    gson = new Gson();
    this.database = database;
  }
}
