<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<script src="js/jquery-3.2.0.min.js"></script>
		<script type="text/javascript">
			$(function(){
				$.ajax({
					type : 'get',
				 	url :'http://localhost:8080/fz/policy/find.do' ,
				 	success : function(obj){
				 		if(obj.state=="SUCCESS"){
				 			var data = obj.data;
				 			var length = data.length;
				 			for(var i=0;i<length;i++){
				 				var value = data[i];
				 				var tr = $("<tr onclick=\"de();\"></tr>");
				 				var td=$("<td>"+value.id+"</td>"+"<td>"+value.ptype+"</td>"+"<td>"+value.scopetime+"</td>"+"<td>"+value.account+"</td>");
				 			}
				 		}else{
				 			alert(obj.message);
				 		}
				 	},
				 	dataType : 'json'
				})
			})
			function de(){
				var id = {'id' :this.find("td")[0]};
				window.location.href='../detail.jsp?id='+id;
			}
		</script>
		<title>欢迎您</title>
	</head>
	<body>
		<table border="1" id ="t1">
			<tr>
			<th>id</th>
			<th>保险类型</th>
			<th>作用时间</th>
			<th>保险金额</th>
			</tr>
		</table>
	</body>
</html>
