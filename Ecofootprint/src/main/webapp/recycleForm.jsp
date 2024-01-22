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
		
		.checkbox-container {
	        display: flex;
	        flex-direction: column;
	    }
	
	    .checkbox-container label {
	        display: flex;
	        align-items: center;
	        margin-bottom: 10px;
	    }
	
	    .checkbox-container label span {
	        margin-right: 10px;
	        white-space: nowrap; /* Added to prevent text wrapping */
	    }
	
	    .checkbox-container input[type="checkbox"] {
	        margin-left: 5px; /* Adjusted margin-left */
	    }
	    
    </style>
</head>

<body>

	<!-- Recycle Consumption Form -->
	<form action="" method="post" enctype="multipart/form-data">
	
	    <!-- Left Side Inputs -->
	    <div class="column" style="grid-column: 1;">
	    
		    <div class="input-containers">
		    	<label for="recyclePeriod">Recycle Period:</label><br>
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
		    
		    <div class="input-containers">
			    <label for="practicingHabit">4. How are you practicing recycling habits?</label><br>
			    <div class="checkbox-container">
			        <label>
			            <span>Using Composite</span>
			            <input type="checkbox" id="composite" name="recyclingHabits" value="composite">
			        </label>
			
			        <label>
			            <span>Separate Waste Type</span>
			            <input type="checkbox" id="separateWaste" name="recyclingHabits" value="separateWaste">
			        </label>
			
			        <label>
			            <span>Pre-Loved Clothes</span>
			            <input type="checkbox" id="preLoved" name="recyclingHabits" value="preLoved">
			        </label>
			    </div>
			</div>
	        
	    </div>
	
	<!-- Middle Inputs -->
	<div class="column" style="grid-column: 2;">
		
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

    <!-- Right Side Inputs -->
    <div class="column" style="grid-column: 3;">
    	<div class="column" style="margin-top: 20px;">
        <img src="img/recycleActivity.jpg" alt="Recycle Activity" style="max-width: 100%; height: auto; border: 2px solid black; padding-top: 10px;">
    	</div>
    </div>

</form>

<!-- Include external JavaScript file -->
<script src="recycleForm.js"></script>
</body>
</html>