if (document.getElementById("doIt")) {
  document.getElementById("doIt").addEventListener("click", postPerson);
} else {
  document.getElementById("putIt").addEventListener("click", putPerson);
}

//if (window.location.href.endsWith("?")) {
//  window.location.replace("/");
//}

function getData() {
let data = {};
  data.firstName = document.getElementById("firstName").value;
  data.secondName = document.getElementById("secondName").value;
  data.occupation = document.getElementById("occupation").value;
  data.gender = document.getElementById("gender").value;
  data.age = parseInt(document.getElementById("age").value);
  if (document.id) {
    data.id = parseInt(document.id.toString());
  }
  return JSON.stringify(data);
}

function fillFields(id) {
fetch("/civilian/" + id).then(response => response.json()).then(data => {
  document.getElementById("firstName").value = data.firstName;
  document.getElementById("secondName").value = data.secondName;
  document.getElementById("occupation").value = data.occupation;
  document.getElementById("gender").value = data.gender;
  document.getElementById("age").value = data.age;
  document.id = id;
})
}

function doPerson(action) {
console.log("HIT");
var xhr = new XMLHttpRequest();
xhr.open(action, "/civilian", false);
console.log("HIT5");
xhr.onreadystatechange = function () {
     console.log("HIT6");
    if (this.readyState != 4) return;

    if (this.status == 200) {
        var data = JSON.parse(this.responseText);
        window.location.replace("/person/"+data.id);
    }
    console.log("HIT8");
};
xhr.setRequestHeader('Content-Type', 'application/json');
console.log("HITwer");
xhr.send(getData());
console.log("HIT9");
}

function postPerson() {
  doPerson("POST")
    }

    function putPerson() {
      doPerson("PUT")
        }