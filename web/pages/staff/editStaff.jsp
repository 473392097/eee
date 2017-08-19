<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Calendar.js"></script>

</head>

<body class="emp_body">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="44%" align="left">[员工管理]</td>
   
    <td width="52%"align="right">
    	<!-- 提交表单 -->
       <a href="javascript:void(0)" onclick="document.forms[0].submit()">
       	<img src="${pageContext.request.contextPath}/images/button/save.gif" />
       </a>
       <!-- 执行js，进行返回 -->
       <a href="javascript:void(0)" onclick="window.history.go(-1)"><img src="${pageContext.request.contextPath}/images/button/tuihui.gif" /></a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>
<s:debug></s:debug><s:property value="#request.crmDepartmentList[0].postSet"></s:property>
<form  method="post" >
	
	<input type="hidden" name="staffId" value="2c9091c14c78e58b014c78e7ecd90007"/>
	
	<table width="88%" border="0" class="emp_table" style="width:80%;">
	 <tr>
	    <td>登录名：</td>
	    <td><input type="text" name="loginName"   value="<s:property value="#request.findStaff.loginName"></s:property>"  /> </td>
	    <td>密码：</td>
	    <td><input type="password" name="loginPwd" value="<s:property value="#request.findStaff.loginPwd"></s:property>" /> </td>
	  </tr>
	 <tr>
	    <td>姓名：</td>
	    <td><input type="text" name="staffName" value="<s:property value="#request.findStaff.staffName"></s:property> "/> </td>
	    <td>性别：</td>
	    <td>
	    	<input type="radio" name="gender" checked="checked" value="<s:property value="#request.findStaff.gender"></s:property>"/>男
	    	<input type="radio" name="gender" value="<s:property value="#request.findStaff.gender"></s:property>"/>女
	    </td>
	  </tr>
	 <tr>

	    <td width="10%">所属部门：</td>
	    <td width="20%">

	    	<select name="crmDepartment.depName" id="dep" >

			    <option value="">----请--选--择----</option>
				<%--<s:iterator value="#request.crmDepartmentList" var="dep">--%>
			    <%--<option value="<s:property value="#dep.depId"></s:property>" selected="selected"><s:property value="#dep.depName"></s:property></option>--%>
				<%--</s:iterator>--%>
			</select>

	    </td>
	    <td width="8%">职务：</td>
	    <td width="62%">
	    	<select name="crmPost.postName" id="post">
			    <option value="">----请--选--择----</option>
               <%--<s:iterator value="#request.crmDepartmentList.postSet" var="post">--%>
			    <%--<option  value="<s:property value="#post.postName"></s:property>"><s:property value="#post.postName"></s:property></option>--%>
			   <%--</s:iterator>--%>
			</select>
	    </td>
	  </tr>


	  <tr>
	    <td width="10%">入职时间：</td>
	    <td width="20%">
	    	<input type="text" name="onDutyDate" value="<s:property value="#request.findStaff.onDutyDate"></s:property>" readonly="readonly" onfocus="c.showMoreDay=true; c.show(this);"/>
	    </td>
	    <td width="8%"></td>
	    <td width="62%"></td>
	  </tr>
	</table>
</form>


    <%--$("#dep").change(function(data){--%>
    	<%--var id=(Number)($("#dep").select().val())--%>
        <%--//var id=eval((Number)($("#dep").select().val()));--%>
        <%--$("#postSelectId").empty()--%>
        <%--$("#postSelectId").append("<s:iterator value='%{#request.crmDepartmentList["id"].postSet}' var='post'>");--%>
        <%--$("#postSelectId").append("<option value='<s:property value='#post.postName'></s:property>'><s:property value='#post.postName'></s:property></option>");--%>
        <%--$("#postSelectId").append("</s:iterator>");--%>
        <%--$("#postSelectId").append("<option value='Value'>Text2</option>");--%>

	<%--});--%>

	<%--ajax方法--%>
	<%--function fn() {--%>
		<%--var ab=$("dep").val()--%>
		<%--$.ajax({--%>
		     <%--type:"post",--%>
		     <%--url:"depart.action",--%>
			<%--success:function (data) {--%>
				<%--alert(data);--%>
            <%--}--%>
		<%--})--%>
    <%--}--%>


    <%--function fun2() {--%>
	    <%--var json = eval(json)--%>
		<%--$.each(){--%>
	        <%--var dep=json[0]--%>
		<%--}--%>

    <%--}--%>

<%--</script>--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/cascade.js"></script>
</body>
</html>
