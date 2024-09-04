function calculateTotal() {
    let checkboxes = document.querySelectorAll('.bill-checkbox');
    let total = 0;
    checkboxes.forEach(function(checkbox) {
        if (checkbox.checked) {
            total += parseInt(checkbox.value);
        }
    });
    document.getElementById('totalAmount').innerText = total;
}

function proceedToPay() {
    // Navigate to Payment page
    window.location.href = "paymentPage.html";
}

function logout() {
    // Redirect to login page
    window.location.href = "loginPage.html";
}
