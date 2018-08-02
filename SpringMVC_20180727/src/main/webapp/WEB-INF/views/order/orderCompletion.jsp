<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>주문정보</h1>

	<c:forEach items="${orderCommand.orderItems}" var="item">
		<h3>${item.itemId} : ${item.number} : ${item.remark}</h3>	
	</c:forEach>
	
	<h3>베송지 정보 </h3>
	<h3>${orderCommand.address.zipcode} : ${orderCommand.address.address1} : ${orderCommand.address.address2}</h3>
	










</body>
</html>