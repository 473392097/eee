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

	<input type="hidden" name="crmStaff.staffId" value="<s:property value="#request.findStaff.staffId"/>"/>

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

<form action="${pageContext.request.contextPath}first_save.action" method="post">

	<input  type="hidden" name="crmStaff.staffId" value="<s:property value="%{#request.findStaff.staffId}"></s:property>"/>
	<table width="88%" border="0" class="emp_table" style="width:80%;">
	 <tr>
		 <td>登录名：</td>
	    <td><input type="text" name="crmStaff.loginName" value="" /> </td>
	    <td>密码：</td>
	    <td><input type="password" name="crmStaff.loginPwd" /> </td>
	  </tr>
	 <tr>
	    <td>姓名：</td>
	    <td><input type="text" name="crmStaff.staffName" value="" id="staffAction_add_staffName"/> </td>
	    <td>性别：</td>
	    <td><input type="radio" name="crmStaff.gender"  checked="checked" value="男"/>男
	    	<input type="radio" name="crmStaff.gender"  value="女"/>女
		</td>
	  </tr>
	 <tr>
	    <td width="10%">所属部门：</td>
	    <td width="20%">
			<select name="crmStaff.post.department.depId" id="dep" >
				<option value="">----请--选--择----</option>
			</select>

	    </td>
	    <td width="8%">职务：</td>
	    <td width="62%">
			<select name="crmStaff.post.postId" id="post">
				<option value="">----请--选--择----</option>
			</select>
	    </td>
	  </tr>
	   <tr>
	    <td width="10%">入职时间：</td>
	    <td width="20%">
	    	<input type="text" name="crmStaff.onDutyDate" value="" readonly="readonly"  onfocus="c.showMoreDay=true; c.show(this);" />
	    </td>
	    <td width="8%"></td>
	    <td width="62%"></td>
	  </tr>
	</table>
</form>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/cascade.js"></script>
</body>
</html>
