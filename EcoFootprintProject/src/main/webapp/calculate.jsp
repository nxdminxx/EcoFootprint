
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
            margin: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            background-color: #f0f0f0;
        }

        .rounded-container {
            position: relative;
            width: 750px;
            height: 500px;
            padding-bottom: 90px;
            border-radius: 15px;
            overflow: show;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }

        .rounded-container img {
            object-fit: contain; /* Keeps the aspect ratio and makes the image fit within the container */
            width: 100%;
            height: 100%;
            max-width: 100%; /* Ensure the image doesn't exceed its original width */
            max-height: 100%;
            padding-bottom : 30px;
        }

        .container-title {
            position: absolute;
            bottom: 0;
            left: 0;
            width: 100%;
     		font-weight: bold;
            color: #E34343;
            padding-bottom: 60px;
            text-align: center;
            font-size: 30px;
            border-bottom-left-radius: 15px;
            border-bottom-right-radius: 15px;
        
        }
        .small-text{
        	text-align: center;
        	text-color: black;
        }
        p{
        	
        	bottom: 0;
            left: 20px;
        	padding-bottom: 20px;
            color: black;
            text-align: center;
            font-size: 15px;
        }
    </style>
</head>
<body>

<div class="rounded-container">
    <img src="img/calculator imeg.png" alt="Image">
    
    <div class="container-title">Your Data Is Being Calculated Now !</div>
    <p>The process may take a few minutes. <br>
    You will be automatically directed to next page upon completing</p>
    
    
</div>

</body>
</html>