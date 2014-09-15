<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Bank Customers/Accounts</title>
</head>
<body>
	<div>List of Accounts:</div>
	<table cellpadding="5" cellspacing="5" border="1">
		<thead>
			<tr>
				<th>Customer Name</th>
				<th>Account #</th>
				<th>Account Balance</th>
				<th>Account Open Date</th>
				<th>Last Tx Date</th>
			</tr>
		</thead>
		<tbody>
	<c:forEach items="${customerAccounts}" var="account">
			<tr>
				<td><a href="customer.html?id=${account.customer.customerId}">${account.customer.name}</a></td>
				<td><a href="account.html?id=${account.accountId}">${account.accountId}</a></td>
				<td>${account.balance}</td>
				<td>${account.createDate}</td>
				<td>${account.updateDate}</td>
			</tr>
	</c:forEach>
		</tbody>
	</table>
	<div style="padding-top: 10px;">List of Customers:</div>
	<table cellpadding="5" cellspacing="5" border="1">
		<thead>
			<tr>
				<th>Customer Name</th>
				<th>Customer Id</th>
				<th># of Accounts</th>
			</tr>
		</thead>
		<tbody>
	<c:forEach items="${customers}" var="customer">
			<tr>
				<td><a href="customer.html?id=${customer.customerId}">${customer.name}</a></td>
				<td>${customer.customerId}</td>
				<td>${fn:length(customer.accounts)}</td>
			</tr>
	</c:forEach>
		</tbody>
	</table>
</body>
</html>