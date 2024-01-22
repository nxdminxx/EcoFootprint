<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Footprint Form</title>
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
            background-color: #ffffff;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        #content-container {
            display: flex;
            flex-direction: column;
            align-items: center; /* Center content horizontally */
            width: 1100px;
            padding: 20px;
            margin-left: 20px;
            background-color: #ffffff;
            border-radius: 5px;
        }

        #sidebar {
            width: 200px;
            padding-right: 20px;
        }

        #sidebar a {
            color: #757575;
            text-decoration: none;
        }

        #sidebar ul {
            list-style-type: none;
            padding: 0;
        }

        #sidebar ul li {
            padding: 10px;
            background-color: #ffffff;
            margin-bottom: 5px;
            transition: background-color 0.3s ease;
        }

        #sidebar ul li:hover {
            color: black;
            background-color: #e6e6e6;
            border-radius: 5px; /* Add rounded corners on hover */
        }

        #sidebar ul li:hover a {
            color: black;
        }

        .user-info {
            display: flex;
            align-items: center;
        }

        .user-image {
            width: 50px;
            height: 50px;
            margin-right: 10px;
            border-radius: 50%;
            overflow: hidden;
        }

        .user-image img {
            width: 100%;
            height: 100%;
            object-fit: cover;
        }

        .user-name {
            flex-grow: 1;
        }

        .user-name p {
            margin: 0;
        }

        h1 {
            text-align: center;
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

       .button-container {
            text-align: center;
            margin-top: 20px;
            margin-bottom: 20px; /* Add bottom margin for spacing */
        }

        .button-container button {
            padding: 10px;
            width: 120px; /* Set a fixed width for the buttons */
            color: #fff;
            border: none;
            border-radius: 20px; /* Add rounded corners */
            cursor: pointer;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .button-container button:hover {
            background-color: #12276F; /* Dark blue color on hover */
            box-shadow: 0 6px 12px rgba(0, 0, 0, 0.2);
        }

        /* Add the previous button styles */
        .previous-button {
            background-color: #A5A5A5;
        }

        .previous-button:hover {
            background-color: #12276F;
        }

        /* Add the next button styles */
        .next-button {
            background-color: #12276F;
        }

        .next-button:hover {
            background-color: #29527;
            transition: background-color 0.3s ease;
        }
       
        /* Step Progress Bar Styles */
        .step-progress {
            display: flex;
            align-items: center; /* Align items horizontally */
            margin-bottom: 20px;
        }

        .step-container {
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-right: 20px; /* Add margin between steps */
        }

        .step {
            width: 30px;
            height: 30px;
            background-color: #ddd;
            border-radius: 50%;
            display: flex;
            justify-content: center;
            align-items: center;
            font-weight: bold;
            margin-bottom: 5px; /* Add margin between steps */
            color: #000; /* Set default color for steps */
        }

        .step.active, .step.visited {
            background-color: #1E3C72;
            color: #fff;
        }

        .step-label {
            text-align: center;
        }

        /* Additional style for step content */
        .step-content {
            display: none;
            margin-top: 20px;
        }

        .step-content.active {
            display: block;
        }
    </style>
</head>
<body>

<div id="dashboard-container">

    <div id="sidebar-container">
        <div id="sidebar">
            <div class="user-info">
                <img src="img/profile1.jpg" alt="Profile" class="user-image">
                <div class="user-name">
                    <p style="font-size: 10px">User ID: 555</p>
                    <p style="font-weight: bold;">Irdina Sofea</p>
                </div>
            </div>

            <ul>
                <li><a href="UserDashboard.js">Dashboard</a></li>
                <li><a href="footprintForm.jsp">Footprint Form</a></li>
                <li><a href="myCarbonData.jsp">My Carbon Data</a></li>
                <br><br>
                <li><a href="login.jsp">Logout</a></li>
            </ul>
        </div>
    </div>

    <div id="content-container">
        <h1>Calculate Your Carbon Footprint</h1>
        <div class="step-progress">
            <div class="step-container">
                <div class="step" id="step1" onclick="showStep(1)">1</div>
                <div class="step-label">Water Consumption</div>
            </div>
            <div class="step-container">
                <div class="step" id="step2" onclick="showStep(2)">2</div>
                <div class="step-label">Electricity Consumption</div>
            </div>
            <div class="step-container">
                <div class="step" id="step3" onclick="showStep(3)">3</div>
                <div class="step-label">Recycle Consumption</div>
            </div>
            <div class="step-container">
                <div class="step" id="step4" onclick="showStep(4)">4</div>
                <div class="step-label">Confirmation</div>
            </div>
            <div class="step-container">
                <div class="step" id="step5" onclick="showStep(5)">5</div>
                <div class="step-label">Calculate Data</div>
            </div>
            <div class="step-container">
                <div class="step" id="step6" onclick="showStep(6)">6</div>
                <div class="step-label">Submission</div>
            </div>
        </div>

        <!-- Step 1 Content -->
	    <div class="step-content" id="content1">
	        <div id="waterFormContainer"></div>
	        <div class="button-container">
	            <button class="next-button" onclick="showStep(2)">Next</button>
	        </div>
	    </div>
	
	    <!-- Step 2 Content -->
	    <div class="step-content" id="content2">
	        <!-- Empty container for electricityForm.jsp -->
	        <div id="electricityFormContainer"></div>
	        <div class="button-container">
	            <button class="previous-button" onclick="goToPreviousStep()">Previous</button>
	            <button class="next-button" onclick="showStep(3)">Next</button>
	        </div>
	    </div>
	
	    <!-- Step 3 Content -->
	    <div class="step-content" id="content3">
	        <!-- Empty container for recycleForm.jsp -->
	        <div id="recycleFormContainer"></div>
	        <div class="button-container">
	            <button class="previous-button" onclick="goToPreviousStep()">Previous</button>
	            <button class="next-button" onclick="showStep(4)">Next</button>
	        </div>
	    </div>
	
	    <!-- Step 4 Content -->
	    <div class="step-content" id="content4">
	        <!-- Empty container for confirmation.jsp -->
	        <div id="confirmationContainer"></div>
	        <div class="button-container">
	            <button class="previous-button" onclick="goToPreviousStep()">Previous</button>
	            <button class="next-button" onclick="showStep(5)">Submit</button>
	        </div>
	    </div>
	
	    <!-- Step 5 Content -->
	    <div class="step-content" id="content5">
	        <!-- Empty container for calculate.jsp -->
	        <div id="calculateContainer"></div>
	        <div class="button-container">
	            <button class="previous-button" onclick="goToPreviousStep()">Previous</button>
	            <button class="next-button" onclick="showStep(6)">Next</button>
	        </div>
	    </div>
	
	    <!-- Step 6 Content -->
	    <div class="step-content" id="content6">
	        <!-- Empty container for complete.jsp -->
	        <div id="completeContainer"></div>
	        <div class="button-container">
	            <button class="previous-button" onclick="goToPreviousStep()">Previous</button>
	            <button class="next-button" onclick="goToDashboard()">Go to dashboard</button>
	        </div>
	    </div>


        <script>
            // Function to load content dynamically
            function loadContent(page, containerId) {
                var container = document.getElementById(containerId);
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        container.innerHTML = this.responseText;
                    }
                };
                xhttp.open("GET", page, true);
                xhttp.send();
            }

            // Store visited steps in an array
            var visitedSteps = [];

            function showStep(stepNumber) {
                // Check if the step is already visited
                if (!visitedSteps.includes(stepNumber)) {
                    visitedSteps.push(stepNumber);
                }

                // Reset all steps to inactive
                var allSteps = document.querySelectorAll('.step');
                allSteps.forEach(function (step) {
                    step.classList.remove('active', 'visited');
                });

                // Activate the clicked step and mark visited steps
                visitedSteps.forEach(function (visitedStep) {
                    var step = document.getElementById('step' + visitedStep);
                    step.classList.add('visited');
                });

                // Activate the current step
                var clickedStep = document.getElementById('step' + stepNumber);
                clickedStep.classList.add('active');

                // Hide all content
                var allContent = document.querySelectorAll('.step-content');
                allContent.forEach(function (content) {
                    content.classList.remove('active');
                });

                // Show the content for the current step
                var currentContent = document.getElementById('content' + stepNumber);
                currentContent.classList.add('active');

                // Load specific content for each step
                if (stepNumber === 1) {
                    loadContent('waterForm.jsp', 'waterFormContainer');
                } else if (stepNumber === 2) {
                    loadContent('electricityForm.jsp', 'electricityFormContainer');
                } else if (stepNumber === 3) {
                    loadContent('recycleForm.jsp', 'recycleFormContainer');
                } else if (stepNumber === 4) {
                    loadContent('confirmation.jsp', 'confirmationContainer');
                } else if (stepNumber === 5) {
                    loadContent('calculate.jsp', 'calculateContainer');
                } else if (stepNumber === 6) {
                    loadContent('complete.jsp', 'completeContainer');
                }
            }

            // Function to go to the previous step
            function goToPreviousStep() {
                // Check if there are previous steps
                if (visitedSteps.length > 1) {
                    // Remove the current step from visited steps
                    visitedSteps.pop();
                    // Show the previous step
                    showStep(visitedSteps[visitedSteps.length - 1]);
                }
            }

            // Initialize progress bar when the page loads
            function initializeProgress() {
                // Assuming you want to start with step 1
                showStep(1);
            }

            // Trigger initialization when the page loads
            window.onload = initializeProgress;
            
            function goToDashboard() {
                // You can modify the window.location.href to the desired URL
                window.location.href = 'dashboard.jsp';
            }
        </script>

    </div>
</div>
</body>
</html>
