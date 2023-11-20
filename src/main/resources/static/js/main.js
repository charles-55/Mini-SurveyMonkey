function createNavBar() {
    const div = document.createElement("div");
    div.id = "navBar";

    const table = document.createElement("table");
    const row = table.insertRow(0);

    const home = document.createElement('a');
    home.href = "/";
    home.textContent = "Home";

    const search = document.createElement('a');
    search.href = "/survey/all";
    search.textContent = "Search";

    const account = document.createElement('a');
    account.href = "/account";
    account.textContent = "Account";

    var login = document.createElement('a');
    login.href = "/login";
    login.textContent = "Login";

    row.insertCell(0).appendChild(home);
    row.insertCell(1).appendChild(search);
    row.insertCell(2).appendChild(account);
    row.insertCell(3).appendChild(login);

    div.appendChild(table);
    document.body.prepend(div);
}

window.onload = function() {
    createNavBar();
};
