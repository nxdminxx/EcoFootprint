<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Dashboard</title>
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

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }

    th, td {
        border: 1px solid #ddd;
        padding: 8px;
        text-align: left;
    }

    th {
        background-color: #508cd1;
        color: white;
    }

    tr:hover {
        background-color: #f5f5f5;
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

<!-- <script src="${pageContext.request.contextPath}/chart.js"></script> -->

</head>
<body>

<!-- Main Content with Sidebar -->
<div id="dashboard-container">

    <div id="sidebar-container">
        <div id="sidebar">
            <div class="user-info">
                <img src="img/profile1.jpg" alt="Profile" class="user-image">
                <span class="user-name">Ifah</span>
            </div>

            <ul>
                <li><a href="#">Dashboard</a></li>
                <li><a href="#">Footprint Form</a></li>
                <li><a href="#">My Carbon Data</a></li>
                <br><br>
                <li><a href="#">Logout</a></li>
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

            <!-- Table with Carbon Data -->
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
                    <!-- Sample data, replace with actual data from your backend -->
                    <tr>
                        <td>January 2023</td>
                        <td>250</td>
                        <td>Low</td>
                        <td><a href="#">View Details</a></td>
                    </tr>
                    <tr>
                        <td>February 2023</td>
                        <td>320</td>
                        <td>Medium</td>
                        <td><a href="#">View Details</a></td>
                    </tr>
                    <!-- Add more rows as needed -->
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
