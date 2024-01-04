<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>My Dashboard</title>
	<link rel="stylesheet" type="text/css" href="css/dashboard.css">
	<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>

    <!-- Main Content with Sidebar -->
    <div id="dashboard-container">

        <div id="sidebar-container">
            <div id="sidebar">
                <div class="user-info">
                    <img src="img/profile1.jpg" alt="Profile" class="user-image">
                    <div class="user-name">
                    	<p style="font-size: 10px">User ID: ${userId}</p>
                    	<p style="font-weight: bold;">${userName}</p>
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
                <h2>My Dashboard</h2>

                <div id="form-container" class="card-container">
                
\	                <div class="card">
	                    <img src="img/water.png" alt="Profile" class="card-image">
	                    <span class="card-details">
	                        <span class="card-title">Water Carbon</span>
	                        <p>${waterCarbonResult.waterCarbon} tCO2e</p>
	                    </span>
	                </div>
	
	                <div class="card">
	                    <img src="img/electric.png" alt="Profile" class="card-image">
	                    <span class="card-details">
	                        <span class="card-title">Electricity Carbon</span>
	                        <p>${electricityCarbonResult.electricityCarbon} tCO2e</p>
	                    </span>
	                </div>
	
	                <div class="card">
	                    <img src="img/recycle.png" alt="Profile" class="card-image">
	                    <span class="card-details">
	                        <span class="card-title">Recycle Carbon</span>
	                        <p>${recycleCarbonResult.recycleCarbon} tCO2e</p>
	                    </span>
	                </div>
	
	                <div class="card-large">
	                    <img src="img/footprint.png" alt="Profile" class="card-image">
	                    <span class="card-details">
	                        <span class="card-large-title">My Carbon Footprint Score</span>
	                        <p>${overallCarbonScore} %</p>
	                    </span>
	                </div>
                    
                     <!-- Second Row -->
			        <div class="card-welcome">
			        	<div class = "card-welcome-title">
			                <p style ="font-size: 25px;">Congratulation <span style = "color:#EB3939;">${userName}</span></p><br>
			                <p>For Your Diligent Efforts in Reducing Carbon Footprint<br></p>
			                <p style = "color:#DA9818;"> Together, we work for a brighter future and a healthier planet</p>
			            </div>
			            <img src="img/welcome.png" alt="Profile" class="card-image">
			        </div>
			
			        <div class="card-button1">
			            <img src="img/myData.png" alt="Profile" class="card-image">
			            <div class="card-button-details1">
			            	<p>Get <span style ="color:#F0AD00">Track</span> Of Your</p>
			            	<p style ="color:#F0AD00">Carbon Footprint</p>
			            	<p>Monthly!</p>
			                <button id = "trackButton" class="my-button1" style =>Track Now!</button>
			            </div>
			        </div>

			       <div class="card-graph">
					    <div class="card-graph-title">
					        <p>Carbon Statistic</p>
					        <canvas id="carbonChart" width="400" height="200"></canvas>
					    </div>
					</div>
			        <div class="card-button2">
			            <div class="card-button-details2">
			            	<p>View My</p>
			            	<p style = "color:#EB3939;">Carbon Footprint</p>
			            	<p>Now!</p>
			                <button id = "ViewDataButton" class="my-button2">View Here</button>
			            </div>
			            <img src="img/dashboard report.png" alt="Profile" class="card-image">
			        </div>
			        
                </div>
                
            </div>
        </div>
        
    </div>

<script>
    document.getElementById('trackButton').addEventListener('click', function() {
        // Redirect to footprintForm.jsp
        window.location.href = 'footprintForm.jsp';
    });
    
    document.getElementById('ViewDataButton').addEventListener('click', function() {
        // Redirect to footprintForm.jsp
        window.location.href = 'myCarbonData.jsp';
    });
    
    var waterCarbonResult = ${waterCarbonResult};
    var electricityCarbonResult = ${electricityCarbonResult};
    var recycleCarbonResult = ${recycleCarbonResult};

    // Calculate overall carbon score
    var overallCarbonScore = (waterCarbonResult + electricityCarbonResult + recycleCarbonResult) / 3;

    // Display overall carbon score on the page
    document.getElementById('overallCarbonScore').innerText = overallCarbonScore + ' %';

    // Retrieve water data by month
    var waterDataByMonth = ${waterDataByMonth};
    var electricityDataByMonth = ${electricityDataByMonth};
    var recycleDataByMonth = ${recycleDataByMonth};

    if (waterDataByMonth && waterDataByMonth.length > 0) {
        var months = waterDataByMonth.map(function(water) {
            return water.waterMonth;
        });

        var waterOverallCarbonScores = waterDataByMonth.map(function(water) {
            return water.overallCarbonScore;
        });

        var electricityOverallCarbonScores = electricityDataByMonth.map(function(electricity) {
            return electricity.overallCarbonScore;
        });

        var recycleOverallCarbonScores = recycleDataByMonth.map(function(recycle) {
            return recycle.overallCarbonScore;
        });

        var ctx = document.getElementById('carbonChart').getContext('2d');
        var carbonChart = new Chart(ctx, {
            type: 'line',
            data: {
                labels: months,
                datasets: [{
                    label: 'Water Carbon Score',
                    data: waterOverallCarbonScores,
                    borderColor: 'rgba(75, 192, 192, 1)',
                    borderWidth: 2,
                    fill: false
                }, {
                    label: 'Electricity Carbon Score',
                    data: electricityOverallCarbonScores,
                    borderColor: 'rgba(255, 99, 132, 1)',
                    borderWidth: 2,
                    fill: false
                }, {
                    label: 'Recycle Carbon Score',
                    data: recycleOverallCarbonScores,
                    borderColor: 'rgba(255, 206, 86, 1)',
                    borderWidth: 2,
                    fill: false
                }]
            },
            options: {
                scales: {
                    x: {
                        type: 'category',
                        title: {
                            display: true,
                            text: 'Month'
                        }
                    },
                    y: {
                        title: {
                            display: true,
                            text: 'Overall Carbon Score'
                        }
                    }
                }
            }
        });
    }
    
</script>

</body>
</html>
