package umm3601.todos;

public class Todo {
  String _id;
  String owner;
  Boolean status;
  String body;
  String category;

  public String getField(String field) {
    if (field == "owner") {
      return this.owner;
    } else if (field == "body") {
      return this.body;
    } else if (field == "category") {
      return this.category;
    } else if (field == "status") {
      return this.status.toString();
    } else return "";
  }
}
