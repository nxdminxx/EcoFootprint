<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
	<title>Footprint Form</title>
    <style>
         #form-container {
            position: relative;
            width: 750px;
            height: 400px;
            border-radius: 15px;
            overflow: show;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }
        
        .termimage {
           padding-top: 10px;
           padding-left: 80px;
           align-items: center;
        }
        
        img {
           overflow: hidden;
           margin-right: 10px;
        }

        .term-checkbox {
           display: flex;
           flex-direction: column;
        }

        .term-checkbox label {
           display: flex;
           align-items: center;
        }

        .term-checkbox label span {
           margin-right: 150px;
           white-space: nowrap;
       }

        .term-checkbox input[type="checkbox"] {
           margin-left: 150px; 
        }
    </style>
</head>
<body>

    <div id="form-container">
    	<div class ="termimage">
    		<img style = " width: 600px;height: 350px;" src="img/ConfirmationTerm.png" alt="Term and Condition">
    	</div>
        <div class="term-checkbox">
	        <label>
	        	<input type="checkbox" id="confirmation" name="confirmation" value="confirmation">
	        	<span>I agree to the terms and conditions and the privacy policy</span>
	        </label>
        </div>
    </div>

</body>
</html>


