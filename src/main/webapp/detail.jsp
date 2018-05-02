<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/jquery-3.2.0.min.js"></script>
        <script type="text/javascript">
        	var id = location.search; 
        	$(function(){
        		$.ajax({
					type: 'get',
					url : 'http://localhost:8080/fz/policy/findById.do' ,
					data : id,
					dataType : 'json',
					success : function(result){
						if(result.state ==SUCCESS){
							var data = result.data;
							var type = data.ptype;
							var desc = null;
							$("#id").html(id);
							$("#name").html(data.name);
							$("#type").html(type);
							$("#time").html(data.scopetime);
							$("#money").html(data.account);
							if(type==1){
								desc="人寿保险->死亡保险。保险金额为5000元。如果投保人在5年内意外死亡，家属将得到20000元保险金";
							}else if(type==2){
								desc="人寿保险->生病保险。保险金额为200元。如果您在一年内生病了，您可以得到60%的医药费；";
							}else if(type==3){
								desc="人寿保险->意外保险。保险金额为3000元。如果您在三年内发生事故，您可以得到50%的医疗费；";
							}else if(type==4){
								desc="财产保险->车险。保险金额为5000元。如果汽车在一年内发生故障，您可以得到充足的修复费用；";
							}else {
								desc="财产保险->火灾保险。保险金额为2000元。如果房产在三年内发生火灾，您可以得到损失财产的30%；";
							}
							$("#desc").html(desc);
						}
					}
				})
        });     	
        	function jump(){
        		uname = $("#uname").text();
        		age = $("#age").text();
        		address = $("#address").text();
        		phone = $("#phone").text();
        		sex = $("#sex").text();
        		idCard = $("#idCard").text();
        		eid = $("#eid").text();
        		if(uname.trim()=="" ||uname==null){
        			alert("用户姓名不能为空");
        			return;
        		}
        		if(age.trim()=="" ||age==null){
        			alert("用户年龄不能为空");
        			return;
        		}
        		if(address.trim()=="" ||address==null){
        			alert("用户地址不能为空");
        			return;
        		}
        		if(phone.trim()=="" ||phone==null){
        			alert("手机号不能为空");
        			return;
        		}
        		if(sex.trim()=="" ||sex==null){
        			alert("性别不能为空");
        			return;
        		}
        		if(idCard.trim()=="" ||idCard==null){
        			alert("身份证号不能为空");
        			return;
        		}
        		if(eid.trim()=="" ||eid==null){
        			alert("员工id不能为空");
        			return;
        		}
        		var cdata = {'name' :uname,'age':age,'sex':sex,'address':address,'idCard':idCard,'phoneNumber':phone,'employeeId':eid};
        		$.ajax({
        			type:"post",
        			url:"http://localhost:8080/fz/customer/add.do",
        			data : cdata,
        			async:true,
        			success : function(obj){
        				if(obj.state==SUCCESS){
        					addRecord();
        				}else{
        					alert(obj.msg);
        				}
        			}
        		});
        	}
        	function addRecord(){
        		var name = $("#name");
        		var type = $("type");
        		var time = $("time");
        		var account = $("money");
        		var scopetime = null;
        		if(type == 2 || type ==4){
        			scopetime = 1;
        		}else if(type ==1){
        			scopetime = 5;
        		}else{
        			scopetime = 3;
        		}
        		var mydate = new Date();
        		var affecttime = mydate.pattern("yyyy-MM-dd hh:mm:ss");
        		var pdata = {'pid':id,'affecttime':affecttime,'name':name,'account':account,'scopetime':scopetime,'stype':type,'isInactive':'T','uname':uname,'eid':eid,'idCard':idCard};
        		$.ajax({
        			type:"get",
        			url:"record/add.do",
        			data : pdata ,
        			async:true,
        			success : function(obj){
        				if(obj.state==SUCCESS){
        					window.location.href='success.jsp';
        				}
        			}
        		});
        	}
        	function cancel(){
        		window.location.href="index.jsp";
        	}
        </script>
        <title>保险详情</title>
    </head>
    <body>
    	<form>
	    	<table border="2">
	    		<tr>
					<th>id</th>
					<td id="id"></td>
	    		</tr>
	    		<tr>
	    			<th>
	    				保险名称
	    			</th>
	    			<td id="name"></td>
	    		</tr>
	    		<tr>
	    			<th>
	    				保险类型
	    			</th>
	    			<td id="type"></td>
	    		</tr>
	    		<tr>
	    			<th>作用时间</th>
	    			<td id="time"></td>
	    		</tr>
	    		<tr>
	    			<th>保险金额</th>
	    			<td id="money"></td>
	    		</tr>
	    		<tr>
	    			<th>保险描述</th>
	    			<td id="desc"></td>
	    		</tr>
	    	</table>
	    	<table>
	    		<tr>
	    			<th>投保人姓名</th>
	    			<td id="uname"></td>
	    		</tr>
	    		<tr>
	    			<th>年龄</th>
	    			<td id="age"></td>
	    		</tr>
	    		<tr>
	    			<th>地址</th>
	    			<td id="address"></td>
	    		</tr>
	    		<tr>
	    			<th>电话</th>
	    			<td id="phone"></td>
	    		</tr>
	    		<tr>
	    			<th>性别</th>
	    			<td id="sex"></td>
	    		</tr>
	    		<tr>
	    			<th>身份证号</th>
	    			<td id="idCard"></td>
	    		</tr>
	    		<tr>
	    			<th>办理员工号</th>
	    			<td id="eid"></td>
	    		</tr>
	    		<tr>
	    			<td><button>分期</button></td>
	    			<td><button>全款</button></td>
	    		</tr>
	    	</table>
    	</form>
    	<button onclick="jump();">购买</button>
    	<button onclick="cancel();">返回</button>
 	</body>
</html>