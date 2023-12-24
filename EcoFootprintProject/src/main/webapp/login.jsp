<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js">

<style>

body {
  background: #007bff;
  background: linear-gradient(to right, #0062E6, #33AEFF);
}

.login {
  min-height: 100vh;
}

.bg-image {
  background-image: url('https://source.unsplash.com/WEQbe2jBg40/600x1200');
  background-size: cover;
  background-position: center;
}

.login-heading {
  font-weight: 300;
}

.btn-login {
  font-size: 0.9rem;
  letter-spacing: 0.05rem;
  padding: 0.75rem 1rem;
}

.card-img-left {
  width: 50%;
  /* Link to your background image using in the property below! */
  background-size: cover;
}


.login-image img {
	width: 100%; /* Make the image take up 100% of the container */
	height: 50%; /* Make the image take up 100% of the container */
	object-fit: cover; /* Maintain aspect ratio and cover the container */
}



</style> 


<body>
  <div class="container">
    <div class="row">
      <div class="col-lg-10 col-xl-9 mx-auto">
        <div class="card flex-row my-5 border-0 shadow rounded-3 overflow-hidden">
        
        
          <div class="card-img-left d-none d-md-flex">
			<img src="img/bluebackground414x512.png"  class="login-image">
          </div>
          
          
          
          <div class="card-body p-4 p-sm-5">
            <img src="img/MBIP.png"  class="login-image"><br> <br>
          
            <form>

              <div class="form-floating mb-3">
                <input type="text" class="form-control" id="username" placeholder="username" required autofocus>
                <label for="floatingInputUsername">Username</label>
              </div>


              <div class="form-floating mb-3">
                <input type="password" class="form-control" id="password" placeholder="Password">
                <label for="floatingPassword">Password</label>
              </div>

              <div class="d-grid mb-2">
        		<button class="btn btn-lg btn-primary btn-login fw-bold text-uppercase" type="submit" onclick="redirectToDashboard()">Sign In</button>
              </div>
              
                  <div class="form-check mb-3">
                  <input class="form-check-input" type="checkbox" value="" id="rememberPasswordCheck">
                  <label class="form-check-label" for="rememberPasswordCheck">
                    Remember password
                  </label>
                </div>

              <a class="d-block text-center mt-2 small" href="register.jsp">Doesn't have an account? Register</a>
                   
<!--               <a class="d-block text-center mt-2 small" href="#">Login as Guest</a> -->

				<script>
				    function redirectToDashboard() {
				        // Redirect to dashboard.jsp
				        window.location.href = 'dashboard.jsp';
				    }
				</script>

            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>



</body>
</html>