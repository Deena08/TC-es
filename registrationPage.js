function registerCustomer() {
    const consumerId = document.getElementById("consumerId").value.trim();
    const billNumber = document.getElementById("billNumber").value.trim();
    const customerName = document.getElementById("customerName").value.trim();
    const email = document.getElementById("email").value.trim();
    const userId = document.getElementById("userId").value.trim();
    const password = document.getElementById("password").value;
    const confirmPassword = document.getElementById("confirmPassword").value;
    const acknowledgmentElement = document.getElementById("acknowledgment");

    // Reset the acknowledgment message
    acknowledgmentElement.style.display = "none";
    acknowledgmentElement.innerHTML = "";

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
    acknowledgmentElement.style.display = "block";
    acknowledgmentElement.innerHTML = `
        <h3 id="sucessfullMessage">Consumer Registration Successful</h3>

        <div id="black">
            <p>Customer ID: ${uniqueCustomerId}</p>
            <p>Customer Name: ${customerName}</p>
            <p>Email: ${email}</p>
        </div>

        
            <button onclick="login()">Login</button>
        
    `;
}

// Function to handle the login button click
function login() {
    // Redirect to login page
    window.location.href = "loginPage.html";
}
