/**
 * 
 */
 function usersubmit() {
	alert("회원가입 요청됨:old style javascript");

	let user = {
		username: document.getElementById("username").value,
		password: document.getElementById("password").value,
		email: document.getElementById("email").value
	}
	console.log(user);

/* http request 
*/
	var ajaxrequest = new XMLHttpRequest();

	ajaxrequest.open('POST', '/user');
	JSON.stringify(user);
	ajaxrequest.onreadystatechange = function() {
		if (ajaxrequest.readyState == 4) {
			response = ajaxrequest.responseText;
			alert(response);
			location - "/";
		}
	}
	ajaxrequest.setRequestHeader("Content-Type", "application/json");
	ajaxrequest.send(JSON.stringify(user));
}

function memberjoin() {
	let btnsave = document.getElementById("btn-save");
	btnsave.onclick = usersubmit;
}

memberjoin();