<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

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
            background: #3230AC;
            background: linear-gradient(to right, #0062E6, #33AEFF);
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

        .register-image-container {
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
</head>
<body style="background-color: #3230AC;">
    <div class="container">
        <div class="row">
            <div class="col-lg-10 col-xl-9 mx-auto">
                <div class="card flex-row my-5 border-0 shadow rounded-10 overflow-hidden">
                    <br>
                    <a href="javascript:history.back()" class="arrow-button">
                        <i class="fas fa-arrow-left"></i>
                    </a>
                    <div class="card-body p-5 p-sm-300">
                        <h5 class="card-title text-center mb-5 fw-bold fs-5">Terms and Conditions</h5>

                        <img src="img/confirmationTerm.jpg" alt="Confirmation Term">
						<div class="form-check mb-3">
						    <input class="form-check-input" type="checkbox" value="" id="termAndCondition" required>
						    <label class="form-check-label" for="termAndCondition">
						        I agree to the terms and conditions and the privacy policy
						    </label>
						</div>


                        <br><br>
                        <div class="d-grid mb-2">
                            <button id="submitBtn" class="btn btn-lg btn-primary btn-login fw-bold text-uppercase"
                                type="button">Submit</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

<!-- Bootstrap Modal -->
<div class="modal fade" id="successModal" tabindex="-1" role="dialog" aria-labelledby="successModalLabel"
    aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="successModalLabel">Registration successful!</h5>
            </div>
            <div class="modal-body">
                User successfully registered. Please return to the login page.
            </div>
				<div class="modal-footer">
				    <button type="button" id="returnToLoginBtn" class="btn btn-success" data-bs-dismiss="modal">Return To Login Page</button>
				</div>

        </div>
    </div>
</div>


    <!-- Bootstrap JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>

    <!-- Custom JavaScript -->
    <script>
        document.getElementById('submitBtn').addEventListener('click', function () {
            // Trigger the Bootstrap modal
            var myModal = new bootstrap.Modal(document.getElementById('successModal'));
            myModal.show();
        });
        
        document.getElementById('returnToLoginBtn').addEventListener('click', function () {
            // Redirect to login.jsp
            window.location.href = 'login.jsp';
        });

    </script>
    

</body>
</html>
