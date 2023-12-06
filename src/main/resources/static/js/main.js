function createNavBar() {
    const div = document.createElement("div");
    div.id = "navBar";

    const logo = document.createElement('img');
    logo.id = "logo";
    logo.src = '/images/logo1.png';
    logo.alt = 'Logo';

    const pageTitle = document.createElement("span");
    pageTitle.id = "pageTitle";
    pageTitle.textContent = document.title;

    const table = document.createElement("table");

    const row = table.insertRow(0);

    row.insertCell(0).appendChild(createMenuButton("Home", "/"));
    row.insertCell(1).appendChild(createMenuButton("Search", "/survey/all"));
    row.insertCell(2).appendChild(createMenuButton("Settings", "/settings"));

    if (localStorage.getItem("loggedIn") === "true") {
        row.insertCell(3).appendChild(createMenuButton("Account", "/Account"));
        row.insertCell(4).appendChild(createMenuButton("Logout", "/logout"));
    } else {
        row.insertCell(3).appendChild(createMenuButton("Login", "/login"));
    }


    div.appendChild(logo);
    div.appendChild(pageTitle);
    div.appendChild(table);
    document.body.prepend(div);
}

function createMenuButton(name, link) {
    const buttonElement = document.createElement("button");
    buttonElement.setAttribute("onclick", "window.location.href = '" + link + "'");
    buttonElement.setAttribute("class", "btn btn-link")
    buttonElement.textContent = name;
    return buttonElement;
}

function changeLoggedInStatus(state) {
    localStorage.setItem("loggedIn", state);
}

window.onload = function() {
    createNavBar();
    document.body.setAttribute("data-bs-theme", localStorage.getItem("colorMode"))
};