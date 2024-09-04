function registerCustomer() {
    const consumerId = document.getElementById("consumerId").value;
    const billNumber = document.getElementById("billNumber").value;
    const customerName = document.getElementById("customerName").value;
    const email = document.getElementById("email").value;
    const userId = document.getElementById("userId").value;
    const password = document.getElementById("password").value;
    const confirmPassword = document.getElementById("confirmPassword").value;

    // Validation for consumer ID and bill number
    if (consumerId.length !== 13 || isNaN(consumerId)) {
        alert("Please enter a valid 13-digit Consumer ID.");
        return;
    }
    if (billNumber.length !== 5 || isNaN(billNumber)) {
        alert("Please enter a valid 5-digit Bill Number.");
        return;
    }
    if (password !== confirmPassword) {
        alert("Passwords do not match.");
        return;
    }

    // Generate unique customer ID
    const uniqueCustomerId = Math.floor(Math.random() * 10000000000000);

    // Display acknowledgment message
    document.getElementById("acknowledgment").style.display = "block";
    document.getElementById("acknowledgment").innerHTML = `
        <p>Consumer Registration Successful</p>
        <p>Customer ID: ${uniqueCustomerId}</p>
        <p>Customer Name: ${customerName}</p>
        <p>Email: ${email}</p>
    `;
}
