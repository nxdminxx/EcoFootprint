<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Confirmation</title>
    <style>
        #form-container {
            text-align: center;
            margin-top: 20px;
        }

        img {
            width: 650px;
            height: 400px;
            overflow: hidden;
            margin-right: 10px;
        }

        #terms-checkbox {
            margin-top: 20px;
        }
    </style>
</head>
<body>

    <div id="form-container">
        <p>Confirmation Data</p>
        <img src="img/ConfirmationTerm.png" alt="Term and Condition">
        <br>
        <input type="checkbox" id="terms-checkbox" name="terms-checkbox">
        <label for="terms-checkbox">I agree to the terms and conditions and the privacy policy</label>
    </div>

</body>
</html>
