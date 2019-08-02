<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>您好Springboot</title>
<!-- ajax使用步骤
1.jquery是js的函数类库(API),必须导入js文件\
2.让页面加载完成之后执行
3.发起ajax请求  $.ajax $.get $.getjson $.load
4.获取服务端的数据,利用js实现页面列表展现

 -->
 <script type="text/javascript" src="/js/jquery-3.4.1.min.js"></script>
 <script type="text/javascript">
//2.让页面加载完成之后执行
$(function(){
	//3.发起ajax请求 k:v
	$.ajax({
		   type:"get",
		   url:"http://localhost:8090/userList-ajax",
		   //data:ajax向服务器提供的数据{k:v}
		   dataType:"json",    //标识返回值结果
		   success:function(result){//result是服务器返回的数据
			   //result代表返回的结果
			   $.each(result,function(index,user){
				  // alert(index);//遍历第几个元素
				  //alert(user.name);
				  var id=user.id;
				  var name=user.name;
				  var age=user.age;
				  var sex=user.sex;

				  var tr="<tr align='center'><td>"+id+"</td><td>"+name+"</td><td>"+age+"</td><td>"+sex+"</td> </tr>"
					
						 $("#userTable").append(tr);//创造表格
				   
				   });
			
			 }
		});
	//2.使用$.getjson
});

 </script>
</head>
<body>
	<table id="userTable" border="1px" width="65%" align="center">
		<tr>
			<td colspan="6" align="center"><h3>学生信息</h3></td>
		</tr>
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>性别</th>
			<th></th>
		</tr>
		<!-- 利用c标签循环遍历对象 -->
		<c:forEach items="${userList}" var="u">
			<tr>
				<th>${u.id}</th>
				<th>${u.name}</th>
				<th>${u.age}</th>
				<th>${u.sex}</th>
			</tr>
		</c:forEach>
	</table>
</body>
</html>