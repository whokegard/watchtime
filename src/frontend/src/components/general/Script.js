let icon = document.getElementById("icon");
let logo = document.getElementById("logo");
icon.onclick = function () {
    document.body.classList.toggle("dark-theme");
    if (document.body.classList.contains("dark-theme")) {
        logo.src = "images/text logo white.png";
    } else {
        logo.src = "images/text logo green.png";
    }
};
