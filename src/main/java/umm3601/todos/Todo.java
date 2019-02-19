package umm3601.todos;

public class Todo {
  String _id;
  String owner;
  Boolean status;
  String body;
  String category;

  public String getField(String field) { //This method doesn't do anything, it's left to show what we tried
    if (field.equals("owner")) {
      return this.owner;
    } else if (field.equals("body")) {
      return this.body;
    } else if (field.equals("category")) {
      return this.category;
    } else if (field.equals("status")) {
      return this.status.toString();
    } else return "";
  }

  public String getOwner() {
    return this.owner;
  }

  public String getBody() {
    return this.body;
  }

  public String getCategory() {
    return this.category;
  }

  public String getStatus() {
    return this.status.toString();
  }
}
