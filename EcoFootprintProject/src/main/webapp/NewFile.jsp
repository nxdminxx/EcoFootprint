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
            background-color: #ffffff;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        #content-container {
            display: flex;
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

/*         .form-column {
            display: inline-block;
            width: 45%;
            margin-right: 5%;
        }

        .form-step {
            display: none;
        } */

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

        /* Step Progress Bar Styles */
        .step-progress {
            display: flex;
            justify-content: space-between;
            margin-bottom: 20px;
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
        }

        .step.active {
            background-color: #4caf50; /* Green color for active step */
            color: #fff;
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
                    <li><a href="dashboard.jsp">Dashboard</a></li>
                    <li><a href="footprintForm.jsp">Footprint Form</a></li>
                    <li><a href="myCarbonData.jsp">My Carbon Data</a></li>
                    <br><br>
                    <li><a href="login.jsp">Logout</a></li>
                </ul>
            </div>
        </div>

        <div id="content-container">
        
        	<h2>Calculate your Carbon Footprint</h2>
        	
            <div class="step-progress">
                <div class="step active" id="step1" onclick="showStep(1)">1</div>
                <div class="step" id="step2" onclick="showStep(2)">2</div>
                <div class="step" id="step3" onclick="showStep(3)">3</div>
                
               <%--  <div>
	                <div class="form-step" id="waterFormStep">
	                    <%@include file="waterForm.jsp" %>
	                </div>
	
	                <div class="form-step" id="electricityFormStep" style="display: none;">
	                    <%@include file="electricityForm.jsp" %>
	                </div>
	
	                <div class="form-step" id="recycleFormStep" style="display: none;">
	                    Include your recycle form content here
	                </div>
	            </div> --%>
            </div>
            
        </div>
    </div>

    <script>
        // JavaScript to toggle visibility of form steps
        function showStep(step) {
            document.querySelectorAll('.form-step').forEach(function (stepElement) {
                stepElement.style.display = 'none';
            });

            document.querySelectorAll('.step').forEach(function (stepElement) {
                stepElement.classList.remove('active');
            });

            document.getElementById('step' + step).classList.add('active');

            if (step === 1) {
                document.getElementById('waterFormStep').style.display = 'block';
            } else if (step === 2) {
                document.getElementById('electricityFormStep').style.display = 'block';
            } else if (step === 3) {
                document.getElementById('recycleFormStep').style.display = 'block';
            }
        }
    </script>

</body>
</html>