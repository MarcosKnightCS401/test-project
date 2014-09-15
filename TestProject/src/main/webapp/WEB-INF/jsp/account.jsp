<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Bank Account: ${account.accountId}</title>
</head>
<body>
	<div>Account #${account.accountId}:</div>
	<hr/>
	<table cellpadding="5" cellspacing="5" border="1">
		<thead>
			<tr>
				<th>Customer Name</th>
				<th>Account Balance</th>
				<th>Account Open Date</th>
				<th>Last Tx Date</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><a href="customer.html?id=${account.customerOutput.customerId}">${account.customerOutput.name}</a></td>
				<td>${account.balance}</td>
				<td>${account.createDate}</td>
				<td>${account.updateDate}</td>
			</tr>
		</tbody>
	</table>
	<div><a href="index.html">All Customers/Accounts</a></div>
</body>
</html>