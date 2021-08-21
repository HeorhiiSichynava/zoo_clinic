function addClient() {
    var url = "http://localhost:8080/registration";

    var data = {};
    data.name = document.getElementById('client_name').value,
        data.login = document.getElementById('client_login').value,
        data.password = document.getElementById('client_password').value;
    var json = JSON.stringify(data);

    var xhr = new XMLHttpRequest();
    xhr.open("POST", url, true);
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    xhr.onload = function () {
        var users = JSON.parse(xhr.responseText);
        if (xhr.readyState == 4 && xhr.status == "201") {
            console.table(users);
        } else {
            console.error(users);
        }
    }
    xhr.send(json);
};

function registrationResult() {
    var url = "http://localhost:8080/findAll";

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var myArr = JSON.parse(this.response);
            getListClients(myArr);
        }
    };
    xhttp.open("get", url, true);
    xhttp.send();
};

function getListClients(arr) {
    var response =
        "<table>" +
        "<caption>list of <span style='font-weight: bolder'> All clients </span> of the clinic</caption>" +
        "<thead><tr>         " +
        "<th>id      </th>          " +
        "<th>name    </th>          " +
        "<th>login   </th>          " +
        "<th>password</th>          " +
        "</tr></thead><tbody>";
    var i;
    for (i = 0; i < arr.length; i++) {
        response +=
            "<tr>" +
            "<td>" + arr[i].id       + "</td>" +
            "<td>" + arr[i].name     + "</td>" +
            "<td>" + arr[i].login    + "</td>" +
            "<td>" + arr[i].password + "</td></tr>"
    }
    response += "</tbody></table>";
    document.getElementById("table_response").innerHTML = response;
};

function findByClientId() {
    var id = document.getElementById('find_by_client_id').value;
    var url = "http://localhost:8080/find/" + id;

    var xhttp = new XMLHttpRequest();
    xhttp.open("get", url, true)

    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var myArr = JSON.parse(this.response);
            getAnimalsByClientId(myArr);
        }
    };
    xhttp.open("get", url, true);
    xhttp.send();
};

function getAnimalsByClientId(arr) {
    var response =
        "<table>" +
        "<caption>List of all Animals by client: <span style='font-weight: bolder'>"+arr[0].nameOfClient+"</span></caption>" +
        "<thead><tr>             " +
        "<th>Client id      </th>" +
        "<th>Name Of Client </th>" +
        "<th>Animal id      </th>" +
        "<th>Type Of Animal </th>" +
        "<th>Name Of Animal </th>" +
        "</tr></thead><tbody>";
    var i;
    for (i = 0; i < arr.length; i++) {
        response +=
            "<tr>" +
            "<td>" + arr[i].client_id    + "</td>" +
            "<td>" + arr[i].nameOfClient + "</td>" +
            "<td>" + arr[i].animal_id    + "</td>" +
            "<td>" + arr[i].typeOfAnimal + "</td>" +
            "<td>" + arr[i].nameOfAnimal + "</td>" +
            "</tr>";
    }
    response += "</tbody></table>";
    document.getElementById("table_response").innerHTML = response;
};