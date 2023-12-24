<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Calculate Your Carbon Footprint - Electricity Consumption</title>
    <!-- Include your CSS styles here -->
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
        }

        form {
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            gap: 60px;
            padding: 20px;
            margin: auto;
            max-width: 1000px;
        }

        .column {
            margin-bottom: 15px;
            
        }
        .input-containers {
            padding-bottom: 15px; /* Add bottom padding to input container */
            
        }
        label {
           	display: block;
           	width: 100%; /* Set a specific width for labels */
        }

        input,
		textarea {
		    width: calc(100% - 10px);
		    box-sizing: border-box;
		    border-radius: 5px;
		    outline: none;
		    padding: 5px;
		    font-weight: normal; /* Set font weight to normal */
		}

		input:focus,
		textarea:focus {
		    width: calc(100% - 10px);
		    outline: none;
		}
        
        .file-drop {
            border: 2px dashed #ccc;
            padding: 20px;
            text-align: center;
            cursor: pointer;
            margin-top: 10px;
            border-radius: 25px; 
        }

        .file-input {
            display: none;
        }

        .file-drop:hover {
            border-color: #aaa;
        }
        .file-drop .file-icon {
    		font-size: 24px; /* Adjust the font size as needed */
    		margin-bottom: 10px; /* Add margin for spacing between the icon and text */
    		color: #007bff; /* Change this to your desired color code */
		}
		.button-container {
            text-align: center;
            margin-top: 20px;
            margin-bottom: 20px; /* Add bottom margin for spacing */
        }

        .button-container button {
            padding: 10px;
            width: 120px; /* Set a fixed width for the buttons */
            background-color: #A5A5A5; /* Light grey color */
            color: #fff;
            border: none;
            border-radius: 20px; /* Add rounded corners */
            cursor: pointer;
            transition: background-color 0.3s ease;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .button-container button:hover {
            background-color: #12276F; /* Dark blue color on hover */
            box-shadow: 0 6px 12px rgba(0, 0, 0, 0.2); 
        }
    </style>
</head>

<body>

<!-- Electricity Consumption Form -->
<form action="" method="post" enctype="multipart/form-data">

    <!-- Left Side Inputs -->
    <div class="column" style="grid-column: 1;">
	    <div class="input-containers">
	    	<label for="daysPerMonth">1. Number of days for each month:</label><br>
        	<input type="text" id="daysPerMonth" name="daysPerMonth" required><br>
	    </div>
        
        <div class="input-containers">
	    	<label for="electricUsageRM">2. Current electric usage value in RM:</label><br>
        	<input type="text" id="electricUsageRM" name="electricUsageRM" required><br>
	    </div>

		<div class="input-containers">
	    	<label for="electricUsageKWh">3. Current electric usage value in kWh:</label><br>
            <input type="text" id="electricUsageKWh" name="electricUsageKWh" required><br>
	    </div>
		
		<div class="input-containers">
	    	<label for="savingMethods">4. Methods/Steps used to save electricity:</label><br>
        	<textarea id="savingMethods" name="savingMethods" rows="4" required></textarea><br>
	    </div>
        
        <div class="input-containers">
	    	<label for="savingPractices">5. Electricity saving practices at home:</label><br>
        	<textarea id="savingPractices" name="savingPractices" rows="4" required></textarea><br>
	    </div>
        
    </div>

    <!-- Middle Inputs -->
    <div class="column" style="grid-column: 2;">
    	<div class="input-containers">
	    	<label for="monthYear">6. Month/Year:</label><br>
        	<input type="text" id="monthYear" name="monthYear" required><br>
	    </div>
        
        <div class="input-containers">
	    	<label for="proportionalFactor">7. Proportional Factor:</label><br>
        	<input type="text" id="proportionalFactor" name="proportionalFactor" required><br>
	    </div>
        
        <div class="input-containers">
            <label for="uploadBill">8. Upload your electricity bill (JPEG/PDF only):</label>
            <div class="file-drop" id="fileDrop">
            	<span class="file-icon">&#128196;</span><br>
                <span>Drag and drop your file here or click to choose</span>
                <input type="file" id="uploadBill" name="uploadBill" accept=".jpg, .jpeg, .pdf" class="file-input" required>
            </div>
        </div>
        
    </div>

    <!-- Right Side Inputs -->
    <div class="column" style="grid-column: 3;">
    	<div class="column" style="margin-top: 20px;">
        <label for="forBillsGuide">Form Bills Guide</label>
        <img src="img/PanduanSemakanBilElektrik.jpg" alt="Form Bills Guide" style="max-width: 100%; height: auto; border: 2px solid black; padding-top: 10px;">
    	</div>
    </div>
      
</form>
    <!-- Bottom Buttons -->
	<div class="button-container">
		<a href="waterForm.jsp">
    	<button type="button" onclick="previousStep()">Previous</button>
    	
    	<a href="recyleForm.jsp">
    	<button type="button" onclick="nextStep()">Next</button></a>
	</div>
<!-- Include external JavaScript file -->
<script src="electricityForm.js"></script>
</body>
</html>