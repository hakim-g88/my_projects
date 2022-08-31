fetch("/civilian").then(response => response.json()).then(
data => {
  Object.keys(data).forEach((key) => {
    let item = document.createElement("li");
    let link = document.createElement("a");
    item.id = key;
    link.innerHTML = `${data[key].firstName} ${data[key].secondName} ${data[key].occupation.toLowerCase()}. Age: ${data[key].age}`;
    link.href = `/person/${key}`;
    item.appendChild(link);
    document.getElementById("listContainer").appendChild(item);
  })
});