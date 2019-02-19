

function getAllTodos() {
  console.log("Getting all the todos.");

  var HttpThingy = new HttpClient();
  HttpThingy.get("/api/todos", function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function getLimitedTodos() {
  console.log("Getting a limited number of todos.");
  var HttpThingy = new HttpClient();
  HttpThingy.get("/api/todos?limit=" + document.getElementById("limit").value, function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function getBodyString() {
  console.log("Getting todos whose bodies contain a given string.");
  var HttpThingy = new HttpClient();
  HttpThingy.get("/api/todos?contains=" + document.getElementById("contains").value, function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function getStatusTodos() {
  console.log("Get todos by status.");
  var HttpThingy = new HttpClient();
  HttpThingy.get("/api/todos?status=" + document.getElementById("status").value, function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function getCategoryTodos() {
  console.log("Get todos by category.");
  var HttpThingy = new HttpClient();
  HttpThingy.get("/api/todos?category=" + document.getElementById("category").value, function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function getOwnerTodos() {
  console.log("Get todos by owner.");
  var HttpThingy = new HttpClient();
  HttpThingy.get("/api/todos?owner=" + document.getElementById("owner").value, function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function getOrderedTodos() {
  console.log("Get todos ordered by field.");
  var HttpThingy = new HttpClient();
  HttpThingy.get("/api/todos?orderBy=" + document.getElementById("orderBy").value, function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function applyAllFilters() {
  console.log("Apply all filters.");
  var HttpThingy = new HttpClient();
  var path = "/api/todos";
  var count = 0;
  if (document.getElementById("limit").value.toString() !== "") {
    path += determineCharacter(count) + "limit=" + document.getElementById("limit").value;
    count += 1;
  }
  if (document.getElementById("status").value.toString() !== "") {
    path += determineCharacter(count) + "status=" + document.getElementById("status").value;
    count += 1;
  }
  if (document.getElementById("owner").value.toString() !== "") {
    path += determineCharacter(count) + "owner=" + document.getElementById("owner").value;
    count += 1;
  }
  if (document.getElementById("category").value.toString() !== "") {
    path += determineCharacter(count) + "category=" + document.getElementById("category").value;
    count += 1

  }
  if (document.getElementById("contains").value.toString() !== "") {
    path += determineCharacter(count) + "contains=" + document.getElementById("contains").value;
    count += 1
  }
  if (document.getElementById("orderBy").value.toString() !== "") {
    path += determineCharacter(count) + "orderBy=" + document.getElementById("orderBy").value
  }
  HttpThingy.get(path, function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function determineCharacter(n) {
  if (n === 0) return "?";
  else return "&";
}

function HttpClient() {
  // We'll take a URL string, and a callback function.
  this.get = function (aUrl, aCallback) {
    var anHttpRequest = new XMLHttpRequest();

    // Set a callback to be called when the ready state of our request changes.
    anHttpRequest.onreadystatechange = function () {

      /**
       * Only call our 'aCallback' function if the ready state is 'DONE' and
       * the request status is 200 ('OK')
       *
       * See https://httpstatuses.com/ for HTTP status codes
       * See https://developer.mozilla.org/en-US/docs/Web/API/XMLHttpRequest/readyState
       *  for XMLHttpRequest ready state documentation.
       *
       */
      if (anHttpRequest.readyState === 4 && anHttpRequest.status === 200)
        aCallback(anHttpRequest.responseText);
    };

    anHttpRequest.open("GET", aUrl, true);
    anHttpRequest.send(null);
  }
}
