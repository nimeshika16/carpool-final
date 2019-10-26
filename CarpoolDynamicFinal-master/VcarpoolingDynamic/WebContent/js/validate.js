/**
 * 
 */


function store() {
	var uname=document.getElementById("userid").value;
	document.getElementById("user").innerHtml="user";
}

function field_focus(field, email) {
	if (field.value == email) {
		field.value = '';
	}
}


function regValidate( password,  password1) {
	var res=false;
	password=document.getElementById("password");
	password1=document.getElementById("password1");
	if(password.value==password1.value)
		res=true;
	else {
		res=false;
		password.value='';
		password1.value='';
		document.getElementById("password").focus();
		document.getElementById("password1").focus();
		document.getElementById("error").innerHTML="passwords do not match";
	}
	return res;
}

function field_blur(field, email) {
	if (field.value == '') {
		field.value = email;
	}
}




function myFunction() {
	  var x = document.getElementById("myLinks");
	  if (x.style.display === "block") {
	    x.style.display = "none";
	  } else {
	    x.style.display = "block";
	  }
	}