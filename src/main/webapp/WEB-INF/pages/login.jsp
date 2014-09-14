<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit User Details</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script> 
<script type="text/javascript">
var tId = null;
$(document).ready(function() {
	$('#userName').focus(function(){
		$('#infoDiv').html('Enter Credentials');
		$('#userName').val('');
		$('#password').val('');
	});
	
	$("#submit").click(function(){
		try{
			var thisForm = $('#loginForm');
			var userName = $('#userName').val();
			var password = $('#password').val();
			if(userName == '' || password == ''){
				$('#infoDiv').html('Please eneter credentials');		
				return;
			}
			var json = {userName : userName, password : password};
			$.ajax({
				type : 'POST',
				cache: false,
				data : JSON.stringify(json),
				url: thisForm.attr('action'),
				beforeSend: function(xhr) {
	                xhr.setRequestHeader("Accept", "application/json");
	                xhr.setRequestHeader("Content-Type", "application/json");
	            },
			 	success: function(response) {			 		
					$('#infoDiv').html('Successfuly Authenticated');
					$('#userName').val('');
					$('#password').val('');
					$('#prpfDiv').html('');
					$('#userDetails').html('<i style="color:blue;font-size:small;">Loading your profile...</i>');
					
					tId = setTimeout(loadProfile, 1000, response.userId);
					//loadProfile(response.userId);
		    	},
			    error: function(xhr, status, error) {
			    	$('#infoDiv').html("Error while authenticating ...");
			    }
			});
		}catch(e){
		}
	});
});
function loadProfile(userId){
	$.ajax({
		type : 'GET',
		cache: false,
		url: '${context}/users/' + userId + '/profile',
		beforeSend: function(xhr) {
            xhr.setRequestHeader("Accept", "application/json");
           // xhr.setRequestHeader("Content-Type", "application/json");
        },
	 	success: function(response) {
			$('#prpfDiv').html('Profile of Loggedin User');
			var tbl ='<table>';
			tbl += '<tr><td>Name</td><td>:</td><td>'+ response.firstName + ' ' + response.lastName + '</td></tr>';
			tbl += '<tr><td>DOB</td><td>:</td><td>'+ response.dateOfBirth + '</td></tr>';
			tbl += '<tr><td>Gender</td><td>:</td><td>'+ response.gender + '</td></tr>';
			tbl += '<tr><td>UI ID</td><td>:</td><td>'+ response.userId + '</td></tr>';
			if(response.grade) tbl += '<tr><td>Grade</td><td>:</td><td>'+ response.grade + '</td></tr>';
			var roles = response.roles;
			var al = roles[0].name;
			for(var i=1; i < roles.length; i++) al += ', ' + roles[i].name;
			tbl += '<tr><td>Roles</td><td>:</td><td>'+  al + '</td></tr>';
			tbl += '</table>';
			$('#userDetails').html(tbl);
    	},
	    error: function(xhr, status, error) {
	    	$('#userDetails').html("Error while fetching profile ...");
	    }
	});
	if(tId != null){
		clearTimeout(tId);
		tId = null;
	}
}
</script>
</head>
<body>
<table>
<tr>
<td width="400px"><div style="color: teal; font-size: 20px" id='infoDiv'>Enter Credentials</div></td>
<td><div style="color: teal; font-size: 20px" id='prpfDiv'></div></td></tr>
<tr><td width="400px" valign="top">
	<center>
		<form:form id="loginForm" modelAttribute="user" method="post" action="${context}/login/verify">
			<table width="400px" height="100px">
				<tr>
					<td><form:label path="userName">User Name</form:label></td>
					<td><form:input path="userName" value="${userName}"/></td>
				</tr>
				<tr>
					<td><form:label path="password">Password</form:label></td>
					<td><form:password path="password" value="${password}"/></td>
				</tr>
				<tr>
					<td></td>
					<td align="center"><input name="submit" id="submit" type="button" value="Verify" />
					</td>
				</tr>
			</table>
		</form:form>
	</center>
	</td><td width="400px" id='userDetails'>
	</td></tr></table>
</body>
</html>
