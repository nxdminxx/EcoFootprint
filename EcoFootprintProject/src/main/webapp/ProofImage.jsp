<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<!DOCTYPE html>
<html>
<head>
<title>Register Page</title>

<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js">

<style>


        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            background-image: url("img/bg.png" ); /* Replace 'your-background-image.jpg' with the path to your image */
    		background-size: cover;
    		background-position: center;
        }


.btn-login {
  font-size: 0.9rem;
  letter-spacing: 0.05rem;
  padding: 0.75rem 1rem;
}
.arrow-button {
  font-size: 24px; /* Adjust the size as needed */
  color: #333; /* Adjust the color as needed */
  /* Add other styles as needed */
}

.register-image-container{
    text-align: center;
  }
  
        #drop-area {
            width: 300px;
            height: 200px;
            border: 2px dashed #ccc;
            border-radius: 8px;
            margin: 0 auto;
            text-align: center;
            padding: 20px;
            cursor: pointer;
        }

        #preview {
            max-width: 100%;
            max-height: 100%;
        }


</style>

<body style="background-color: #3230AC;">
  <div class="container">
    <div class="row">
      <div class="col-lg-10 col-xl-9 mx-auto">
      
        <div class="card flex-row my-5 border-0 shadow rounded-10 overflow-hidden">
          
          <!---Personal Details--->
          <br>
          <a href="javascript:history.back()" class="arrow-button">
			<i class="fas fa-arrow-left"></i>
			</a>
          <div class="card-body p-5 p-sm-300">
		    <h5 class="card-title text-center mb-5 fw-bold fs-5">Proof of Identification Card/Passport</h5>
			  
			  
			    <div id="drop-area" ondrop="handleDrop(event)" ondragover="handleDragOver(event)">
			        <p>Drag & Drop your image here</p>
			    </div>
			    <div id="preview"></div>
			
			    <script>
			        function handleDrop(event) {
			            event.preventDefault();
			            var files = event.dataTransfer.files;
			
			            if (files.length > 0) {
			                var reader = new FileReader();
			                reader.onload = function (e) {
			                    var preview = document.getElementById('preview');
			                    preview.innerHTML = '<img id="image-preview" src="' + e.target.result + '" alt="Image Preview">';
			                };
			                reader.readAsDataURL(files[0]);
			            }
			        }
			
			        function handleDragOver(event) {
			            event.preventDefault();
			        }
			    </script>
	        <form>
	        
	            <form action="UploadServlet" method="post" enctype="multipart/form-data">
			        <input type="file" name="file" accept="image/*" required>
			        <br>
			        <input type="submit" value="Upload">
			    </form>
	        
			<br><br>
              <div class="d-grid mb-2">
                <button class="btn btn-lg btn-primary btn-login fw-bold text-uppercase" type="button" onclick=" redirectToTermsAndCondition()">Next</button>
              </div>
          </form>
          
<script>
    function goBack() {
        // Implement your back button logic here
        alert('Go back logic goes here');
    }

    function submitForm() {
        // Implement your form submission logic here
        alert('Form submitted!');
    }
</script>
          
          
          
          </div>
        </div>
      </div>
    </div>
  </div>
</body>




    

    </html>