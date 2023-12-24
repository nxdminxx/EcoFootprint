<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Calculate Your Carbon Footprint - Recycle Consumption</title>
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
        h1 {
        	text-align: center;
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

<h1>Calculate Your Carbon Footprint</h1>

<!-- Recycle Consumption Form -->
<form action="" method="post" enctype="multipart/form-data">

    <!-- Left Side Inputs -->
    <div class="column" style="grid-column: 1;">
    <div class="input-containers">
        <div style="display: flex; gap: 10px;">
            <input type="text" id="startDate" name="startDate" placeholder="Start Date" required>
            <input type="text" id="endDate" name="endDate" placeholder="End Date" required>
        </div>
    </div>
    
     <div class="input-containers">
	    	<label for="typeRecycling">1. What type of recycling do you do:</label><br>
        	<input type="text" id="typeRecycling" name="typeRecycling" required><br>
	    </div>
	
	    <div class="input-containers">
	    	<label for="accumulatedTotalInKG">2. Accumulate total in KG:</label><br>
        	<input type="text" id="accumulatedTotalInKG" name="accumulatedTotalInKG" required><br>
	    </div>
        
        <div class="input-containers">
	    	<label for="describeMethod">3. Describe the  method:</label><br>
        	<textarea id="describeMethod" name="describeMethod"  rows="4" required></textarea><br>
	    </div>
        
    </div>

<!-- Middle Inputs -->
<div class="column" style="grid-column: 2;">
 
    4. How are you practicing recycling habits?<br>
        <input type="checkbox" name=recyclingHabits value="composite">Using Composite<br>
        <input type="checkbox" name=recyclingHabits value="seperateWaste">Separate Waste Type<br>
        <input type="checkbox" name=recyclingHabits value="preLoved">Pre-Loved Clothes<br></br>
        
 
    <div class="input-containers">
        <label for="accumulatedTotalInRM">5. Accumulated total in RM:</label><br>
        <input type="text" id="accumulatedTotalInRM" name="accumulatedTotalInRM" required><br>
    </div>

    <div class="input-containers">
        <label for="challengePractice">6. What are your challenges in practicing recycling into your lifestyle?</label><br>
        <textarea id="challengePractice" name="challengePractice" rows="4" required></textarea><br>
    </div>
    
    <div class="input-containers">
            <label for="uploadProof">Please upload proof of your recycling activity</label>
            <div class="file-drop" id="fileDrop">
            	<span class="file-icon">&#128196;</span><br>
                <span>Drag and drop your file here or click to choose</span>
                <input type="file" id="uploadProof" name="uploadProof" accept=".jpg, .jpeg, .pdf" class="file-input" required>
            </div>
        </div>
</div>


      
</form>
    <!-- Bottom Buttons -->
	<div class="button-container">
    <a href="electricityForm.jsp">
        <button type="button" onclick="previousStep()">Previous</button>
    </a>

    <a href="calculate.jsp">
        <button type="button" onclick="nextStep()">Calculate</button>
    </a>
</div>

<!-- Include external JavaScript file -->
<script src="recycleForm.js"></script>
</body>
</html>
