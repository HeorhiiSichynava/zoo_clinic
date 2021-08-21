function addClient() {
    var url = "http://localhost:8080/registration";

    var data = {};
        data.name =     document.getElementById('client_name').value,
        data.login =    document.getElementById('client_login').value,
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
    load(registrationResult());
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
            "<td>" + arr[i].id + "</td>" +
            "<td>" + arr[i].name + "</td>" +
            "<td>" + arr[i].login + "</td>" +
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
    document.getElementById("table_response").innerHTML = response;
};

function myFunction() {
    var x = document.getElementById("myDIV");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
};

function regForm() {
    var url = "http://localhost:8080/";

    var xhttp = new XMLHttpRequest();
    xhttp.open("get", url, true)
    xhttp.onreadystatechange = function () {
        var regForm =
            "<br>" +
            "    <input type='text'      id='client_name'     value=''/> name    <br>\n" +
            "    <input type='text'      id='client_login'    value=''> login   <br>\n" +
            "    <input type='password'  id='client_password' value=''> password<br><br>\n" +
            "<button type='button' onclick='addClient()'>add Client</button>";

        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("table_response").innerHTML = regForm;
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
            "    <input type='text'      id='client_login'    value=''> login   <br>\n" +
            "    <input type='password'  id='client_password' value=''> password<br><br>\n" +
            "<button type='button' onclick='logOut()'>log out</button>";

        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("table_response").innerHTML = logForm;
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
    load(registrationResult());
};

function addAnimalForm() {
    var url = "http://localhost:8080/";

    var xhttp = new XMLHttpRequest();
    xhttp.open("get", url, true)
    xhttp.onreadystatechange = function () {
        var addForm =
            "<br>" +
            "    <input type='text'      id='name_Of_Animal'    value=''> name  <br><br>\n" +
            "    <input type='text'      id='type_Of_Animal'    value=''> type  <br><br>\n" +
            "    <input type='text'      id='age_Of_Animal'     value=''> age   <br><br>\n" +
            "    <input type='text'      id='weight_Of_Animal'  value=''> weight<br><br>\n" +
            "    <input type='text'      id='login_Of_Client'   value=''> client login<br><br>\n" +
            " <button type='button' onclick='addAnimal()'>add Animal</button>";

        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("table_response").innerHTML = addForm;
        }
    };
    xhttp.send();
}
function addAnimal() {
    var url = "http://localhost:8080/addAnimal";

    var data = {};
        data.nameOfAnimal   = document.getElementById('name_Of_Animal').value,
        data.typeOfAnimal   = document.getElementById('type_Of_Animal').value,
        data.ageOfAnimal    = document.getElementById('age_Of_Animal').value,
        data.weightOfAnimal = document.getElementById('weight_Of_Animal').value,
        data.loginOfClient  = document.getElementById('login_Of_Client').value;

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
    load(registrationResult());
};