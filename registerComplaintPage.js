function updateCategories() {
    const complaintType = document.getElementById('complaintType').value;
    const categorySelect = document.getElementById('category');

    let categories = [];
    switch (complaintType) {
        case 'billing':
            categories = ['Incorrect Bill Amount', 'Billing for Unused Period'];
            break;
        case 'voltage':
            categories = ['Low Voltage', 'High Voltage'];
            break;
        case 'disruption':
            categories = ['Frequent Power Cuts', 'Intermittent Power Supply'];
            break;
        case 'street-light':
            categories = ['Non-Functional Light', 'Dim Light'];
            break;
        case 'pole':
            categories = ['Damaged Pole', 'Leaning Pole'];
            break;
        default:
            categories = [];
    }

    categorySelect.innerHTML = '<option value="">Select Category</option>';
    categories.forEach(function(category) {
        const option = document.createElement('option');
        option.value = category;
        option.textContent = category;
        categorySelect.appendChild(option);
    });
}

function submitComplaint() {
    alert("Complaint submitted successfully! Your unique complaint ID is: " + generateComplaintID());
    // Redirect or display success message
    // window.location.href = "success.html"; // Example
}

function cancelComplaint() {
    document.querySelector('form').reset();
}

function generateComplaintID() {
    return Math.floor(100000 + Math.random() * 900000); // Generate a random 6-digit ID
}

function logout() {
    // Redirect to login page
    window.location.href = "loginPage.html";
}

function submitComplaint() {
    // Redirect to login page
    window.location.href = "homePage.html";
}
