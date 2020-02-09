<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reimbursments Tables</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">


<link rel=stylesheet type="text/css" href="/reimbursement/resources/css/theme.css">
<link rel=stylesheet type="text/css" href="/reimbursement/resources/css/mystyles.css">


	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</head>
<body>
	<div class="bg">
	<div class="container">
	<div><a href="MakeExpense.do" type="Submit" class="btn btn-primary btn-block">Create Request</a></div>
	<div class="panel-body  panel lpanel-login">
		<div class="form-group">
			<table border="2" class="table" id="reimbtable">
				<tr class="btn-primary btn-fake">
					<th>User Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Type</th>
					<th>Amount</th>
					<th>Date submitted</th>
					<th>Date resolved</th>
					<th>Status</th>
					<th>Description</th>
					<th>Ticket Id</th>
					<th>Button!</th>
					
				</tr>
				${table}
			</table>
		</div>
	</div>
	</div>
</div>
</body>
</html>