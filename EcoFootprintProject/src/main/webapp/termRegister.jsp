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
            <h2>Terms and Conditions</h2>

            <div id="form-container">
                
            </div>
        </div>
    </div>
</div>


</body>
</html>