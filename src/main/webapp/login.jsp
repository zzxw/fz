
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<style type="text/css">
            body
            {  
                 background:url('img/liu3719.jpg');  
                 background-position:center; 
                 background-repeat:no-repeat;  
                 background-color:  #CCCCCC;
            }


        </style>
		<script src="js/jquery-3.2.0.min.js"></script>
        
		<script language="javascript">
		function check1()
		{                                                                                         
		     if(document.ThisForm.userName.value=="")
			 {
			 	alert("请输入用户名");
				document.ThisForm.userName.focus();
				return false;
			 }
			 if(document.ThisForm.userPw.value=="")
			 {
			 	alert("请输入密码");
				document.ThisForm.userPw.focus();
				return false;
			 }
			 document.getElementById("indicator").style.display="block";
			 var userName = $("#userName").text();
			 var passsord = $("#password").text();
			 var data={'name':userName,'password':password};
			 $.ajax({
			 	type : 'post',
			 	url :'http://localhost:8080/fz/record/find.do' ,
			 	//url : '../find.do'
			 	data : data,
			 	success : function(obj){
			 		if(obj.state==SUCCESS){
			 			var userId=result.data.id;
						setCookie("userId", userId);
						location.href='index.jsp';
			 		}else{
						//显示错误消息
						var msg=result.message;
						console.log(msg);
						alert(msg);
					}
			 	},
			 	dataType : 'json'
			 });
		}

	    </script>

	</head>

	<body>
		<div id="Layer1" style="position:absolute; left:400px; top:200px; width:600px; height:131px; z-index:1">
			<form action="" name="ThisForm" method="post">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="100%" colspan="2" align="left">
							<font style="font-size: 50px;color: white;font-weight: bolder;display: block;text-align: left">
							    &nbsp;&nbsp;&nbsp;保险管理系统
				            </font>
						</td>
					</tr>
					<tr>
						<td width="100%" colspan="2" height="20">
							
						</td>
					</tr>
					<tr>
						<td width="40%" height="22" align="right">
							<span style="font-size: 20px;font-weight: 700;color: white;" >账&nbsp;&nbsp;&nbsp;号:&nbsp;&nbsp;</span>
						</td>
						<td width="60%" height="22">
							<input name="userName" id="userName"type="text" size="20" style="height:20px; border:solid 1px #bbbbbb">
						</td>
					</tr>
					<tr>
						<td width="40%" height="22" align="right">
							<span style="font-size: 20px;font-weight: 700;color: white;">密&nbsp;&nbsp;&nbsp;码:&nbsp;&nbsp;</span>
						</td>
						<td width="60%" height="22">
							<input name="userPw" id="password" type="password" size="20" style="height:20px; border:solid 1px #bbbbbb">
						</td>
					</tr>
					<tr>
						<td width="40%" height="22" align="right">
							<span style="font-size: 20px;font-weight: 700;color: white;">类&nbsp;&nbsp;&nbsp;型:&nbsp;&nbsp;</span>
						</td>
						<td width="60%" height="22">
							    <select name="userType" style="width: 150px;">
								    <option value="0">系统管理员</option>
								    <option value="2">普通员工</option>
								</select>
						</td>
					</tr>
					<tr>
						<td width="15%" height="22">
							
						</td>
						<td width="85%" height="22" align="left">
							
							<img src="img/dl.gif" onClick="check1()"> 
                            <img id="indicator" src="img/loading.gif" style="display:none"/>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>
