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
        display: flex;
        align-items: center;
        justify-content: center;
        height: 100vh;
        margin: 0;
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
        flex-direction: column; /* Stack children vertically */
        align-items: center; /* Center items horizontally */
        justify-content: center; /* Center items vertically */
        width: 1100px;
        padding: 20px;
        margin-left: 20px;
        background-color: #f9f8f8;
        border: 1px solid #ccc;
        border-radius: 5px;
        text-align: center; /* Center text horizontally */
    }

    #content-container h2 {
        font-size: 32px; /* Adjust the font size as needed */
        color: #000080; /* Blue-black color */
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

    #custom-box {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center; /* Center items vertically */
        padding: 20px;
        background-color: #fff;
        border: 1px solid #ccc;
        border-radius: 5px;
        text-align: center;
        max-width: 600px;
        width: 100%;
        box-sizing: border-box;
    }

    #custom-box img {
        width: 100%;
        height: auto;
        margin-bottom: 20px;
        max-width: 400px; /* Set a specific width for the image */
    }

    #custom-box h3 {
    font-size: 24px;
    margin-bottom: 10px;
    color: orange; /* Set the color to orange */
}


    #custom-box p {
        font-size: 16px;
    }

    #go-to-dashboard-button {
        background-color: #12276F;
        color: #fff;
        padding: 10px 20px;
        border-radius: 50px;
        text-decoration: none;
        display: inline-block;
        margin-top: 20px;
        align-self: center; /* Center the button horizontally */
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
                <span class="user-name">Ifah</span>
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
            <h2>Your Carbon Footprint Completed</h2>

            <!-- Custom Box -->
            <div id="custom-box">
                <img src="img/dashboard generate.png" alt="Dashboard Update">
                <h3>Your Dashboard Has Been Updated</h3>
                <p>Thank you for taking the time to fill the form.<br>Towards the Low Carbon Future Together</p>
                
            </div>
            <a href="dashboard.jsp" id="go-to-dashboard-button">Go to Dashboard</a>

            <div id="form-container">
                <!-- Your form content goes here -->
            </div>
        </div>
    </div>
</div>

</body>
</html>
