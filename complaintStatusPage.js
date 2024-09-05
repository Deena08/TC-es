function checkStatus() {
    const complaintID = document.getElementById('complaintID').value.trim();
    const statusResult = document.getElementById('statusResult');

    if (complaintID === '') {
        statusResult.textContent = 'Please enter a complaint ID.';
        statusResult.style.color = 'red';
        return;
    }

    // Simulate fetching complaint status (mock data)
    const complaintStatuses = {
        '123456': 'Your complaint is being reviewed. Expected resolution in 3 days.',
        '654321': 'Your complaint has been resolved. Thank you for your patience.',
        // Add more mock complaint statuses here
    };

    const status = complaintStatuses[complaintID] || 'Complaint ID not found. Please check and try again.';
    statusResult.textContent = status;
    statusResult.style.color = status.includes('not found') ? 'red' : 'green';
}

function logout() {
    // Redirect to login page
    window.location.href = "login.html";
}
