/**
 * 
 */
 
 /*
 function usersubmit() {
	alert("회원가입 요청됨:old style javascript");

	let user = {
		username: document.getElementById("username").value,
		password: document.getElementById("password").value,
		email: document.getElementById("email").value
	}
	console.log(user);

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

*/

/**
 /sbootblog/src/main/resources/static/js/user.js
 */

 let userObject = {
    init: function(){
        let _this = this;

        $("#btn-save").on("click",() =>{
            _this.insertUser();
        });
    },

	insertUser: function() {
		alert("회원가입 요청됨 jq");
		// 회원정보 추출
		let user = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		}
		
		console.log(user);

		$.ajax({
			type: "POST",
			// 시험으로는 /user로 함
			url: "/auth/insertUser",
			data: JSON.stringify(user),
			contentType: "application/json; charset=utf-8"
		}).done(function(response) {
			console.log(response);
			alert(response[data]);
			// location = "/";
		}).fail(function(error) {
			alert("!/js/user.js에서 에러발생: " + error);
		});
	},
 }

 userObject.init();
