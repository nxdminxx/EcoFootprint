<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>My Dashboard</title>
	<link rel="stylesheet" type="text/css" href="css/dashboard.css">
</head>
<body>

    <!-- Main Content with Sidebar -->
    <div id="dashboard-container">

        <div id="sidebar-container">
            <div id="sidebar">
                <div class="user-info">
                    <img src="img/profile1.jpg" alt="Profile" class="user-image">
                    <div class="user-name">
                    <p style = "font-size: 10px">User ID: 555</p>
                    <p style = "font-weight: bold;">Irdina Sofea</p>
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
                    <div class="card">
                        <img src="img/water.png" alt="Profile" class="card-image">
                        <span class="card-details">
                            <span class="card-title">Water Carbon</span>
                            <p>1228 tCO2e</p>
                        </span>
                    </div>

                    <div class="card">
                        <img src="img/electric.png" alt="Profile" class="card-image">
                        <span class="card-details">
                            <span class="card-title">Electricity Carbon</span>
                            <p>100 tCO2e</p>
                        </span>
                    </div>

                    <div class="card">
                        <img src="img/recycle.png" alt="Profile" class="card-image">
                        <span class="card-details">
                            <span class="card-title">Recycle Carbon</span>
                            <p>500 tCO2e</p>
                        </span>
                    </div>

                    <div class="card-large">
                        <img src="img/footprint.png" alt="Profile" class="card-image">
                        <span class="card-details">
                            <span class="card-large-title">My Carbon Footprint Score</span>
                            <p>82.50%</p>
                        </span>
                    </div>
                    
                     <!-- Second Row -->
			        <div class="card-welcome">
			        	<div class = "card-welcome-title">
			                <p style ="font-size: 25px;">Congratulation <span style = "color:#EB3939;">Irdina Sofea</span></p><br>
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

			        <!-- Third Row -->
			        <div class="card-graph">
			        	<div class = "card-graph-title">
			                <p>Carbon Statistic</p>
			                <img src="img/graph.png" alt="graph">
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
</script>

</body>
</html>
