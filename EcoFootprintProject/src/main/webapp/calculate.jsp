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
            height: 420px;
            border-radius: 15px;
            overflow: show;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }
        
        .imagebox {
           padding-top: 30px;
           padding-left: 220px;
        }
  
  .imagebox img {
            width: 300px;
            height: 250px;
            overflow: hidden;
            margin-right: 10px;
        }
        
        .detail {
         text-align: center;
            text-align: center;
            font-size: 15px;
        }

    </style>
</head>
<body>

    <div id="form-container">
     <div class ="imagebox">
      <img src="img/calculator imeg.png" alt="Calculation">
     </div>
         <div class="detail">
          <p>The process may take a few minutes.<br>
       You will be automatically directed to next page upon completing</p>
         <span style ="font-weight: bold;color: #E34343;font-size: 30px;">Your Data Is Being Calculated Now !</span>
        </div>
     
    </div>

</body>
</html>