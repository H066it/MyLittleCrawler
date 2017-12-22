<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<div id="udtModal" class="modal fade" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg" style="background-color: white;">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
			<h4 id="myModalLabel">Password Check</h4>
		</div>
		<form action="udtPwdChk">
			<div class="modal-body">
				<input type="hidden" name="fId" value="${dto.FId }">
				<input type="password" name="fPassword" id="fPassword">
			</div>
			<div class="modal-footer">
				<button type="submit" class="btn btn-primary">Check</button>
				<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
			</div>
		</form>
		</div>
	</div>
</body>
</html>