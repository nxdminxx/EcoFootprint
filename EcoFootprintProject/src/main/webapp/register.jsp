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
		    <h5 class="card-title text-center mb-5 fw-bold fs-5">Personal Details</h5>
          <form>

              <div class="form-floating mb-3">
                <input type="text" class="form-control" id="floatingInputUsername" placeholder="myusername" required autofocus>
                <label for="floatingInputUsername">Identification Card</label>
              </div>

              <div class="form-floating mb-3">
                <input type="email" class="form-control" id="floatingInputEmail" placeholder="name@example.com">
                <label for="floatingInputEmail">Full Name</label>
              </div>
              
			  <div class="form-floating mb-3">
                <input type="email" class="form-control" id="floatingInputEmail" placeholder="name@example.com">
                <label for="floatingInputEmail">Email Address</label>
              </div>
              
              <div class="form-floating mb-3">
                <input type="email" class="form-control" id="floatingInputEmail" placeholder="name@example.com">
                <label for="floatingInputEmail">Phone Number</label>
              </div>
              
              <div class="form-floating mb-3">
                <input type="email" class="form-control" id="floatingInputEmail" placeholder="name@example.com">
                <label for="floatingInputEmail">Status</label>
              </div>
              

              <div class="form-floating mb-3">
                <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
                <label for="floatingPassword">Password</label>
              </div>

            </form>
          </div>

          
          <!---Location Details--->      
          <div class="card-body p-5 p-sm-300">
            <h5 class="card-title text-center mb-5 fw-bold fs-5">Location Details</h5>
            <form>

              <div class="form-floating mb-3">
                <input type="text" class="form-control" id="floatingInputUsername" placeholder="myusername" required autofocus>
                <label for="floatingInputUsername">Full address</label>
              </div>

              <div class="form-floating mb-3">
                <input type="email" class="form-control" id="floatingInputEmail" placeholder="name@example.com">
                <label for="floatingInputEmail">Category (eg: Terraced House)</label>
              </div>

                  <div class="form-check mb-3">
                  <input class="form-check-input" type="checkbox" value="" id="rememberPasswordCheck">
                  <label class="form-check-label" for="rememberPasswordCheck">
                    Active Geo Locator
                  </label>
                </div>
                
                <!---pop up message--->
                
				<div class="register-image-container">
				  <img src="img/geolocator.png" class="register-image-container" alt="Geolocator Image">
				</div>

              <div class="d-grid mb-2">
				<button class="btn btn-lg btn-primary btn-login fw-bold text-uppercase" type="button" onclick="redirectToProofImage()">Next</button>
              </div>

				<script>
				    function redirectToProofImage() {
				        // Redirect to ProofImage.jsp
				        window.location.href = 'ProofImage.jsp';
				    }
				</script>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>




    

    </html>