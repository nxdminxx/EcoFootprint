<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #92bdf5;
    }

    #dashboard-container {
        display: flex;
        width: 1400px;
        margin: 50px auto;
        padding: 20px;
        background-color: #508cd1;
        border: 1px solid #ccc;
        border-radius: 5px;
    }

    #sidebar-container {
        display: flex;
        width: 200px;
        padding: 20px;
        background-color: #f8f4f4;
        border: 1px solid #ccc;
        border-radius: 5px;
    }

    #content-container {
        display: flex;
        width: 1100px;
        padding: 20px;
        margin-left: 20px;
        background-color: #f9f8f8;
        border: 1px solid #ccc;
        border-radius: 5px;
    }

    #sidebar {
        width: 200px;
        padding-right: 20px; /* Adjust spacing between sidebar and form content */
    }

    #sidebar ul {
        list-style-type: none;
        padding: 0;
    }

    #sidebar ul li {
        padding: 10px;
        background-color: #ddd;
        margin-bottom: 5px;
    }

    .user-info {
        display: flex;
        align-items: center;
    }

    .user-image {
        width: 50px;
        height: 50px;
        margin-right: 10px;
        border-radius: 50%; /* Make the image appear as a circle */
        overflow: hidden; /* Ensure content is clipped to the rounded border */
    }

    .user-image img {
        width: 100%; /* Make the image take up 100% of the container */
        height: 100%; /* Make the image take up 100% of the container */
        object-fit: cover; /* Maintain aspect ratio and cover the container */
    }


    .user-name {
        flex-grow: 1;
    }

    .progress-bar {
        width: 100%;
        background-color: #ddd;
        height: 20px;
        border-radius: 5px;
        margin-bottom: 10px;
    }

    .progress {
        width: 0;
        height: 100%;
        background-color: #4caf50;
        border-radius: 5px;
    }

    .form-column {
        display: inline-block;
        width: 45%;
        margin-right: 5%;
    }

    .form-step {
        display: none;
    }

    button {
        background-color: #4caf50;
        color: white;
        padding: 10px 15px;
        margin-top: 10px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    button:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>

<!-- Main Content with Sidebar -->
<div id="dashboard-container">

    <div id="sidebar-container">
        <div id="sidebar">
            <div class="user-info">
                <img src="/profile.jpg" alt="Profile" class="user-image">
                <span class="user-name">Ifah</span>
            </div>

            <ul>
                <ul>
                    <li><a href="${pageContext.request.contextPath}/dashboard/home">Dashboard</a></li>
                    <li><a href="${pageContext.request.contextPath}/dashboard/footprintForm">Footprint Form</a></li>
                    <li><a href="${pageContext.request.contextPath}/dashboard/myCarbonData">My Carbon Data</a></li>
                    <br><br>
                    <li><a href="${pageContext.request.contextPath}/dashboard/logout">Logout</a></li>
                </ul>
            </ul>
        </div>
    </div>

    <div id="content-container">
        <!-- Main Content -->
        <div>
            <h2>Carbon Footprint Form</h2>

            <!-- Progress Bar -->
            <div class="progress-bar">
                <div class="progress" id="progress"></div>
            </div>

            <!-- Multi-Step Form Content -->
            <div id="form-container">
                <form id="multi-step-form" action="api/footprint/save" method="post">
                    <!-- Step 1 (Water Form) -->
                    <div class="form-step" id="step-1">
                        <h2>Step 1 - Water Form</h2>
                        <div class="form-column">
                            <label for="waterField">Water Field:</label>
                            <input type="text" id="waterField" name="waterField" required>
                        </div>
                        <!-- Add more fields as needed -->

                        <button type="button" onclick="nextStep()">Next</button>
                    </div>

                    <!-- Step 2 (Electricity Form) -->
                    <div class="form-step" id="step-2">
                        <h2>Step 2 - Electricity Form</h2>
                        <div class="form-column">
                            <label for="electricityField">Electricity Field:</label>
                            <input type="text" id="electricityField" name="electricityField" required>
                        </div>
                        <!-- Add more fields as needed -->

                        <button type="button" onclick="prevStep()">Previous</button>
                        <button type="button" onclick="nextStep()">Next</button>
                    </div>

                    <!-- Step 3 (Recycle Form) -->
                    <div class="form-step" id="step-3">
                        <h2>Step 3 - Recycle Form</h2>
                        <div class="form-column">
                            <label for="recycleField">Recycle Field:</label>
                            <input type="text" id="recycleField" name="recycleField" required>
                        </div>
                        <!-- Add more fields as needed -->

                        <button type="button" onclick="prevStep()">Previous</button>
                        <button type="submit">Submit</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>


<script>
    // Function to initialize the form steps
    function initializeFormSteps() {
        const formSteps = document.getElementsByClassName("form-step");
        for (let i = 0; i < formSteps.length; i++) {
            formSteps[i].style.display = "none";
        }

        // Show the first form step initially
        const initialStep = document.getElementById("step-1");
        initialStep.style.display = "block";
    }

    // Function to update the progress bar based on the current step
    function updateProgressBar(currentStep) {
        const totalSteps = 3; // Update this to the total number of steps
        const percent = (currentStep - 1) / (totalSteps - 1) * 100;
        progress.style.width = percent + "%";
    }

    function loadStep(stepNumber) {
        const currentStep = document.getElementById(`step-${stepNumber}`);
        currentStep.style.display = "none";

        const nextStepNumber = stepNumber + 1;
        const nextStep = document.getElementById(`step-${nextStepNumber}`);
        nextStep.style.display = "block";

        // Update the progress bar
        updateProgressBar(nextStepNumber);
    }

    // Function to handle form submission
    function submitForm() {
        const form = document.getElementById("multi-step-form");
        form.submit();
    }

    // Initialize the form steps
    initializeFormSteps();
</script>

</body>
</html>