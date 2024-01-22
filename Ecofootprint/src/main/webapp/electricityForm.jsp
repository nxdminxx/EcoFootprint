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

    </style>
</head>

<body>

<!-- Electricity Consumption Form -->
<form action="" method="post" enctype="multipart/form-data">

    <!-- Left Side Inputs -->
    <div class="column" style="grid-column: 1;">
	    <div class="input-containers">
	    	<label for="electricityNumOfDays">1. Number of days for each month:</label><br>
        	<input type="text" id="electricityNumOfDays" name="electricityNumOfDays" required><br>
	    </div>
        
        <div class="input-containers">
	    	<label for="electricityUsageRM">2. Current electric usage value in RM:</label><br>
        	<input type="text" id="electricityUsageRM" name="electricityUsageRM" required><br>
	    </div>

		<div class="input-containers">
	    	<label for="electricityUsageKWH">3. Current electric usage value in kWh:</label><br>
            <input type="text" id="electricityUsageKWH" name="electricityUsageKWH" required><br>
	    </div>
		
		<div class="input-containers">
	    	<label for="electricityMethods">4. Methods/Steps used to save electricity:</label><br>
        	<textarea id="" name="electricityMethods" rows="4" required></textarea><br>
	    </div>
        
        <div class="input-containers">
	    	<label for="electricityPractices">5. Electricity saving practices at home:</label><br>
        	<textarea id="electricityPractices" name="electricityPractices" rows="4" required></textarea><br>
	    </div>
        
    </div>

    <!-- Middle Inputs -->
    <div class="column" style="grid-column: 2;">
    	<div class="input-containers">
	    	<label for="monthYear">6. Month/Year:</label><br>
        	<input type="text" id="electricityMonth" name="electricityMonth" required><br>
	    </div>
        
        <div class="input-containers">
	    	<label for="proportionalFactor">7. Proportional Factor:</label><br>
        	<input type="text" id="electricityPropFactor" name="electricityPropFactor" required><br>
	    </div>
        
        <div class="input-containers">
            <label for="uploadBill">8. Upload your electricity bill (JPEG/PDF only):</label>
            <div class="file-drop" id="fileDrop">
            	<span class="file-icon">&#128196;</span><br>
                <span>Drag and drop your file here or click to choose</span>
                <input type="file" id="electricityBill" name="electricityBill" accept=".jpg, .jpeg, .pdf" class="file-input" required>
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
 
<!-- Include external JavaScript file -->
<script src="electricityForm.js"></script>
</body>
</html>