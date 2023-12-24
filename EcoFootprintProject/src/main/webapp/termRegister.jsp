
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
        integrity="sha512-...." crossorigin="anonymous" referrerpolicy="no-referrer" />
<title>Terms and Conditions</title>
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

        .container {
            width: 80%;
            max-width: 900px;
            margin: auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            background-color: #fff;
            background-size: cover;
            background-position: center;
            position: relative;
        }

        h1 {
            text-align: center;
            color: #12276F;
            font-size: 30px;
            
        }

        .terms {
            margin-top: 20px;
            line-height: 1.5;
            font-size: 14px;
        }

        .checkbox-container {
            display: flex;
            align-items: center;
            justify-content: center;
            margin-top: 20px;
        }

        #agreeCheckbox {
            margin-right: 10px;
        }

        .back-button {
            position: absolute;
            padding-top : 20px;
            padding-left: 10px;
            top: 10px;
            left: 10px;
            font-size: 18px;
            cursor: pointer;
            font-size: 24px; 
            color: #12276F;
        }
        .submit-button-container {
		    position: relative;
		    margin-top: 50px;
		}
		
		.submit-button {
		    position: absolute;
		    bottom: 0;
		    left: 50%;
		    width: auto;
		    transform: translateX(-50%);
		    padding: 10px 20px;
		    border-radius: 20px;
		    border: 2px solid darkblue;
		    color: darkblue;
		    background-color: transparent;
		    cursor: pointer;
		    transition: background-color 0.3s ease, color 0.3s ease;
		}
		
		.submit-button:hover {
		    background-color: darkblue;
		    color: #fff;
		}
		
    </style>
</head>
<body>

<div class="container">
    <a href="register.jsp"><div class="back-button" onclick="goBack"><i class="fas fa-arrow-left"></i></div></a>

    <h1>Terms and Conditions</h1>

    <div class="terms">
        <!-- Your terms and conditions go here -->
        Your privacy should include the following information :
        <ul>
        <li>Third party vencors, including Google, use cookies to serve ads based on a user's prior visits to your website or other websites.</li>
        <li>Google's use of advertising cookies enables it and its partners to serve ads to your users based on their visit to your sites and/or other sites on the internet</li>
        <li>Users may opt out of personalized advertising by visiting <a href="">Ads Settings</a> (Alternatively, you can direct users to opt out of a third party verdor's use of cookies for personalized advertising by visiting <a href="">www.aboutads.info</a>).</li>
        </ul>
        
        If you have not opted out of the third party ad serving, the cookies of other third party vendors or ad networks may also be used to serve ads on your site, which should be disclosed in your privacy policy in the following manner :
        
        <ul>
        <li>Notify your site visitors of the third-party vendors and ad networks serving ads on your site.</li>
        <li>Provide links to the appropriate vendor and ad network websites.</li>
        <li>Inform your users that they may visit those websites to opt out of the use of cookies for personalized advertising (if the vendor or ad network offers this capability)Alternatively, you can direct users to opt out of some third party vendors use of cookies for personalized advertising by visiting <a href="">www.aboutads.info</a></li>
        
        Because publisher sites and laws across countires vary, we're unable to suggest specific privacy policy language.
        </ul>
    </div>

    <div class="checkbox-container">
        <input type="checkbox" id="agreeCheckbox">
        <label for="agreeCheckbox">I agree to the terms and conditions and the privacy policy</label>
    </div>
	<div class="submit-button-container">
    <a href="dashboard.jsp"><button class="submit-button" onclick="submitForm()">Submit</button></a>
    </div>
</div>

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

</body>
</html>