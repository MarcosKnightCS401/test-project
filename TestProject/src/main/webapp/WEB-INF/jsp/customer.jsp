<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Customer: ${theCustomer.name}</title>
</head>
<body>
	<div>${theCustomer.name} - Customer #${theCustomer.customerId} has ${fn:length(theCustomer.accountOutputs)} accounts</div>
	<hr/>
	<table cellpadding="5" cellspacing="5" border="1">
		<thead>
			<tr>
				<th>Account #</th>
				<th>Account Balance</th>
				<th>Account Open Date</th>
				<th>Last Tx Date</th>
			</tr>
		</thead>
		<tbody>
	<c:forEach items="${theCustomer.accountOutputs}" var="account">
			<tr>
				<td><a href="account.html?id=${account.accountId}">${account.accountId}</a></td>
				<td>${account.balance}</td>
				<td>${account.createDate}</td>
				<td>${account.updateDate}</td>
			</tr>
	</c:forEach>
		</tbody>
	</table>
	<div><a href="index.html">All Customers/Accounts</a></div>
</body>
</html>