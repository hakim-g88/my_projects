function personShow(id) {
  fetch("/civilian/" + id).then(response => response.json()).then(
  data => {
    document.getElementById("name").innerHTML = `NAME: ${data.firstName} ${data.secondName}`;
    document.getElementById("age").innerHTML = `AGE: ${data.age}`;
    document.getElementById("occupation").innerHTML = `OCCUPATION: ${data.occupation.toLowerCase()}`;
    document.getElementById("editButton").href = "/edit/" + id;
  });
}

function personDelete() {
  if (confirm("You wanna delete an item?")) {
    fetch("/civilian/" + document.person, {method: "DELETE"}).then(x => window.location.replace("/"));
  }
}
