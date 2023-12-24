<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>My Carbon Data</title>
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
            border-radius: 5px;
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

        table {
		    margin: 0 auto; /* Add this line to center the table */
		    width: 100%;
		    max-width: 800px; /* Adjust the max-width as needed */
		    margin: 20px 0; /* Center the table with top and bottom margin */
		    border-collapse: collapse;
		    margin-top: 20px;
		}
		
		th, td {
		    border: 1px solid #ddd;
		    padding: 12px;
		    text-align: center;
		}
		
		th {
		    background-color: #508cd1;
		    color: white;
		}
		
		tr:hover {
		    background-color: #f5f5f5;
		}
		
		/* Adjust the length of the Action column */
		td .details-link,
		td .edit-button,
		td .delete-button {
		    display: inline-block;
		    padding: 8px;
		    margin: 4px;
		    text-decoration: none;
		    color: #333;
		    background-color: #eee;
		    border: 1px solid #ddd;
		    border-radius: 4px;
		}
		
		td .edit-button,
		td .delete-button {
		    background-color: #508cd1;
		    color: white;
		}
        
        .chart-container {
            background-color: #bbbcbc;
            display: flex;
            justify-content: space-around;
            margin-top: 20px;
        }

        .chart {
            width: 45%;
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
        <!-- Main Content -->
        <div>
            <h2>My Carbon Data</h2>

            <!-- Dummy Chart 1: Bar Chart -->
            <div class="chart-container">
                <canvas id="barChart" class="chart"></canvas>

                <!-- Dummy Chart 2: Pie Chart -->
                <canvas id="pieChart" class="chart"></canvas>
            </div>

            <table>
                <thead>
                <tr>
                    <th>Carbon Data</th>
                    <th>Month</th>
                    <th>Carbon Score</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>January 2023</td>
                    <td>250</td>
                    <td>Low</td>
                    <td>
					    <a href="#" class="details-link">View Details</a>
					    <button class="edit-button">Edit</button>
					    <button class="delete-button">Delete</button>
					</td>
                </tr>
                <tr>
                    <td>February 2023</td>
                    <td>320</td>
                    <td>Medium</td>
                    <td>
					    <a href="#" class="details-link">View Details</a>
					    <button class="edit-button">Edit</button>
					    <button class="delete-button">Delete</button>
					</td>
                </tr>
                </tbody>
            </table>

        </div>
    </div>
</div>

<script>
    // Dummy Data for Charts
    var barChartData = {
        labels: ['January', 'February', 'March', 'April', 'May'],
        datasets: [{
            label: 'Monthly Carbon Data',
            backgroundColor: '#508cd1',
            data: [150, 220, 180, 200, 250]
        }]
    };

    var pieChartData = {
        labels: ['Low', 'Medium', 'High'],
        datasets: [{
            data: [30, 40, 30],
            backgroundColor: ['#92bdf5', '#f8f4f4', '#f9f8f8']
        }]
    };

    // Create Bar Chart
    var barChartCtx = document.getElementById('barChart').getContext('2d');
    var barChart = new Chart(barChartCtx, {
        type: 'bar',
        data: barChartData
    });

    // Create Pie Chart
    var pieChartCtx = document.getElementById('pieChart').getContext('2d');
    var pieChart = new Chart(pieChartCtx, {
        type: 'pie',
        data: pieChartData
    });
</script>

</body>
</html>
