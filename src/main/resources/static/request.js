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

function addAnimal() {
    var url = "http://localhost:8080/addAnimal";

    var data = {};
    data.nameOfAnimal = document.getElementById('name_Of_Animal').value,
        data.typeOfAnimal = document.getElementById('type_Of_Animal').value,
        data.ageOfAnimal = document.getElementById('age_Of_Animal').value,
        data.weightOfAnimal = document.getElementById('weight_Of_Animal').value,
        data.clientId = document.getElementById('client_id').value;

    var json = JSON.stringify(data);

    var xhr = new XMLHttpRequest();
    xhr.open("POST", url, true);
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    xhr.onload = function () {
        var animal = JSON.parse(xhr.responseText);
        if (xhr.readyState == 4 && xhr.status == "201") {
            console.table(animal);
        } else {
            console.error(animal);
        }
    }
    xhr.send(json);
};

function getClientsList() {
    var url = "http://localhost:8080/findAll";

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var myArr = JSON.parse(this.response);
            responseTableClients(myArr);
        }
    };
    xhttp.open("get", url, true);
    xhttp.send();
};

function responseTableClients(arrClients) {
    var response =
        "<table>" +
        "<caption>list of <span style='font-weight: bolder'> All clients </span> of the clinic</caption>" +
        "<thead><tr>         " +
        "<th>id      </th>          " +
        "<th>name    </th>          " +
        "<th>login   </th>          " +
        "<th>password</th>          " +
        "<th>delete  </th>          " +
        "</tr></thead><tbody>";
    var i;
    for (i = 0; i < arrClients.length; i++) {
        response +=
            "<tr>" +
            "<td>" + arrClients[i].id + "</td>" +
            "<td>" + arrClients[i].name + "</td>" +
            "<td>" + arrClients[i].login + "</td>" +
            "<td>" + arrClients[i].password + "</td>" +
            "<td><button type='button' onclick='deleteClientById(" + arrClients[i].id + ")'>delete</button></td>" +
            "</tr>";
    }
    response += "</tbody></table>";
    document.getElementById("response").innerHTML = response;
};

function getAnimalsList() {
    var url = "http://localhost:8080/findAllAnimals";

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var myArr = JSON.parse(this.response);
            responseTableAnimals(myArr);
        }
    };
    xhttp.open("get", url, true);
    xhttp.send();
};

function responseTableAnimals(arrAnimals) {
    var responseAnimals =
        "<table>" +
        "<caption>list of <span style='font-weight: bolder'> All animals </span> of the clinic</caption>" +
        "<thead><tr> " +
        "<th>Id            </th> " +
        "<th>Name  </th> " +
        "<th>Type  </th> " +
        "<th>Age   </th> " +
        "<th>Weight</th> " +
        "<th>Client Id </th> " +
        "<th>Delete</th>" +
        "</tr></thead><tbody>";
    var i;
    for (i = 0; i < arrAnimals.length; i++) {
        responseAnimals +=
            "<tr>" +
            "<td>" + arrAnimals[i].id + "</td>" +
            "<td>" + arrAnimals[i].nameOfAnimal + "</td>" +
            "<td>" + arrAnimals[i].typeOfAnimal + "</td>" +
            "<td>" + arrAnimals[i].ageOfAnimal + "</td>" +
            "<td>" + arrAnimals[i].weightOfAnimal + "</td>" +
            "<td>" + arrAnimals[i].clientId + "</td>" +
            "<td><button type='button' onclick='deleteAnimalById(" + arrAnimals[i].id + ")'>delete</button></td>" +
            "</tr>";
    }
    responseAnimals += "</tbody></table>";
    document.getElementById("response").innerHTML = responseAnimals;
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
    xhttp.send();
};

function getAnimalsByClientId(arr) {
    var response =
        "<table>" +
        "<caption>List of all Animals by client: <span style='font-weight: bolder'>" + arr[0].nameOfClient + "</span></caption>" +
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
            "<td>" + arr[i].client_id + "</td>" +
            "<td>" + arr[i].nameOfClient + "</td>" +
            "<td>" + arr[i].animal_id + "</td>" +
            "<td>" + arr[i].typeOfAnimal + "</td>" +
            "<td>" + arr[i].nameOfAnimal + "</td>" +
            "</tr>";
    }
    response += "</tbody></table>";
    document.getElementById("response").innerHTML = response;
};

function closeForm() {
    var url = "http://localhost:8080/";

    var xhttp = new XMLHttpRequest();
    xhttp.open("get", url, true)
    xhttp.onreadystatechange = function () {
        var regForm = "good bay";
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("response").innerHTML = regForm;
        }
    };
    xhttp.send();
};

function regForm() {
    var url = "http://localhost:8080/";

    var xhttp = new XMLHttpRequest();
    xhttp.open("get", url, true)
    xhttp.onreadystatechange = function () {
        var regForm =
            "<br>" +
            "<form>" +
            "<fieldset>"+
            "<legend>Form for adding Clients</legend>" +
            "    <input type='text'      id='client_name'     value=''/> name    <br>\n" +
            "    <input type='text'      id='client_login'    value=''> login   <br>\n" +
            "    <input type='password'  id='client_password' value=''> password<br><br>\n" +
            "</fieldset>"+
            "</form>" +
            "<button type='button' onclick='addClient()'>add Client</button>";

        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("response").innerHTML = regForm;
        }
    };
    xhttp.send();
};

function logForm() {
    var url = "http://localhost:8080/";

    var xhttp = new XMLHttpRequest();
    xhttp.open("get", url, true)
    xhttp.onreadystatechange = function () {
        var logForm =
            "<br>" +
            "<form>" +
            "<fieldset>"+
            "<legend>Log out</legend>" +
            "    <input type='text'      id='client_login'    value=''> login   <br>\n" +
            "    <input type='password'  id='client_password' value=''> password<br><br>\n" +
            "</fieldset>"+
            "</form>" +
            "<button type='button' onclick='logOut()'>log out</button>";

        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("response").innerHTML = logForm;
        }
    };
    xhttp.send();
};

function logOut() {
    var url = "http://localhost:8080/auth";

    var data = {};
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

function addAnimalForm() {
    var url = "http://localhost:8080/";

    var xhttp = new XMLHttpRequest();
    xhttp.open("get", url, true)
    xhttp.onreadystatechange = function () {
        var addForm =
            "<br>" +
            "<form>" +
            "<fieldset>"+
            "<legend>Form for adding animals</legend>" +
            "    <input type='text'      id='name_Of_Animal'    value=''> name  <br><br>\n" +
            "    <input type='text'      id='type_Of_Animal'    value=''> type  <br><br>\n" +
            "    <input type='text'      id='age_Of_Animal'     value=''> age   <br><br>\n" +
            "    <input type='text'      id='weight_Of_Animal'  value=''> weight<br><br>\n" +
            "    <input type='text'      id='client_id'         value=''> client id <br><br>\n" +
            "</form>" +
            "</fieldset>"+
            " <button type='button' onclick='addAnimal()'>add Animal</button>";

        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("response").innerHTML = addForm;
        }
    };
    xhttp.send();
};

function listAnimalsByClientIdForm() {
    var url = "http://localhost:8080/";

    var xhttp = new XMLHttpRequest();
    xhttp.open("get", url, true)
    xhttp.onreadystatechange = function () {
        var listAnimalsForm =
            "<br>\n" +
            "<form>" +
            "<legend>Show list animals by client id</legend>" +
            "<input type='text' id='find_by_client_id' value=''> id\n <br><br>" +
            "</form>" +
            "<button type='button' value='Send' name='Send' onclick='findByClientId()'>find</button>\n" +
            "<br>"

        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("response").innerHTML = listAnimalsForm;
        }
    };
    xhttp.send();
};

function deleteAnimalById(id) {
    var url = "http://localhost:8080/deleteAnimal/" + id;

    var xhr = new XMLHttpRequest();
    xhr.open("get", url, true);
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    xhr.send();
};

function deleteClientById(id) {
    var url = "http://localhost:8080/deleteClient/" + id;

    var xhr = new XMLHttpRequest();
    xhr.open("get", url, true);
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    xhr.send();
};