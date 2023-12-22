<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
        }

        #login-container {
            width: 300px;
            margin: 100px auto;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        input {
            width: 100%;
            padding: 8px;
            margin: 8px 0;
            box-sizing: border-box;
        }

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
    </style>
</head>
<body>

    <div id="login-container">
        <h2>Login</h2>
        <form action="#" method="post">
            <!-- Use the correct action URL pointing to the /login endpoint -->
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
    
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
    
            <button type="submit">Login</button>
        </form>

        <p>Don't have an account? <a href="/register">Register</a></p>
        
    </div>
    
    </body>
    </html>