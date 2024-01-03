<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Template</title>
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
		color:	#757575;
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
		color:	black;
	    background-color: #e6e6e6;
	    border-radius: 5px; /* Add rounded corners on hover */
	}
	
	#sidebar ul li:hover a {
		color:	black;
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
	
	 #form-container {
            text-align: center;
            margin-top: 20px;
            margin-left:100px;
        }
</style>
</head>
<body>

<!-- Main Content with Sidebar -->
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
        <div>
				
				template container

        </div>
    </div>
</div>


</body>
</html>