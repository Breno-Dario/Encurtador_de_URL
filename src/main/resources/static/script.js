function encurta() {
    const url = document.getElementById("originalUrl").value;

    fetch("/api/urls", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            originalUrl: url
        })
    })
    .then(response => response.json())
    .then(data => {
        const shortUrl = `${window.location.origin}/api/urls/${data.shortcode}`;

        document.getElementById("resultado").innerHTML =
            `URL curta: <a href="${shortUrl}" target="_blank">${shortUrl}</a>`;
    })
    .catch(() => {
        document.getElementById("resultado").innerText =
            "Erro ao encurtar a URL";
    });
}
