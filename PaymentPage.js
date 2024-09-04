function makePayment() {
    alert("Transaction Successful! Download your receipt.");
    // For demo purposes, showing a success message and download link
    let downloadLink = document.createElement('a');
    downloadLink.href = '#';
    downloadLink.innerText = 'Download Receipt';
    document.body.appendChild(downloadLink);
}

function goBackHome() {
    // Redirect to home page
    window.location.href = "home.html";
}

function logout() {
    // Redirect to login page
    window.location.href = "login.html";
}
