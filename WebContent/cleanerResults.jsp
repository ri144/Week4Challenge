<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<!-- ><script type="text/javascript">
	$(document).ready(function(){
		alert(1);
		var x = document.getElementByClassName("education-container container-block");
		var edspace = document.getElementById("edspaces");
		for(var i = 1; i < parseInt(edspace.innerHTML) + 1;i++){ 
			
			
			var ele = document.createElement("h2");
			ele.className =  "container-block-title";
			ele.innerHTML = "Education";
			
			var eleItem = document.createElement("div");
			eleItem.className = "item";
		
			
			var eleDeg = document.createElement("h4");
			eleDeg.className = "degree";
			var z = "$\{deg".concat(i.toString()).concat("\} in $\{maj").concat(i.toString()).concat("\}");
			eleDeg.innerHTML = z;
			
			var eleU = document.createElement("h5");
			eleU.className = "meta";
			eleU.innerHTML = "$\{uni" + i.toString() + "\}";
			
			var eleY = document.createElement("div");
			eleY.className = "time";
			eleY.innerHTML = "$\{year".concat(i.toString()).concat("\}");
			
			eleItem.appendChild(eleDeg);
			eleItem.appendChild(eleU);
			eleItem.appendChild(eleY);
			x.appendChild(ele);
			x.appendChild(eleItem);
		}
	});


</script>
-->


<!-- link rel="stylesheet"  type="text/css">-->
<link id="theme-style" rel="stylesheet" href="assets/css/styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Results</title>
</head>
<body>
<p id="edspaces" style="visibility:hidden">${edspace}</p> 
<div class="wrapper">
        <div class="sidebar-wrapper">
            <div class="profile-container">
                <h1 class="name">${name}</h1>
			</div>
			<div class="contact-container container-block">
                <ul class="list-unstyled contact-list">
                    <li class="email"><i class="fa fa-envelope"></i><a href="mailto: yourname@email.com">${email}</a></li>
  				</ul>          
            </div>
            <div class="education-container container-block"></div><!--//education-container-->
            <script type="text/javascript">
				var x = document.getElementsByClassName("education-container container-block");
				var edspace = document.getElementById("edspaces");
				for(var i = 1; i < parseInt(edspace.innerHTML) + 1;i++){ 
					
					
					var ele = document.createElement("h2");
					ele.className =  "container-block-title";
					ele.innerHTML = "Education";
					
					var eleItem = document.createElement("div");
					eleItem.className = "item";
				
					
					var eleDeg = document.createElement("h4");
					eleDeg.className = "degree";
					var z = "$\{deg".concat(i.toString()).concat("\} in $\{maj").concat(i.toString()).concat("\}");
					eleDeg.innerHTML = z;
					
					var eleU = document.createElement("h5");
					eleU.className = "meta";
					eleU.innerHTML = "$\{uni" + i.toString() + "\}";
					
					var eleY = document.createElement("div");
					eleY.className = "time";
					eleY.innerHTML = "$\{year".concat(i.toString()).concat("\}");
					
					eleItem.appendChild(eleDeg);
					eleItem.appendChild(eleU);
					eleItem.appendChild(eleY);
					x.appendChild(ele);
					x.appendChild(eleItem);
				}
			</script>
            
        </div>
</div> 
<p>${edu}</p>
<b>Experience</b><br>
<p>${exp}</p>
<b>Skills</b><br>
<p>${skill}</p>

</body>
</html>
