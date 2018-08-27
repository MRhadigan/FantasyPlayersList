<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Update Player</h1>

<form method="post">
			<div class="form-group">
			    <label for="id">Name</label>
			    <!-- pre-populate the input value from the existing food (if any) -->
			     <input class="form-control" id="id" name="id" value="${players.id}" required minlength="2" autocomplete= "off">
			     
			</div>
			<div class="form-group">
			    <label for="pos">Position</label>
			    <input class="form-control" id="pos" name="pos" value="${players.pos}" autocomplete= "off">
			</div>
			<div class="form-group">
			    <label for="team">Team</label>
			    <input class="form-control" id="team" name="team" value="${players.team}" required minlength="2" autocomplete= "off">
			</div>
			<div class="form-group">
			    <label for="bench">Bench</label>
			    <input class="form-control" id="bench" name="bench" value="${players.bench}" required minlength="2" autocomplete= "off">
			</div>
			<div class="form-group">
			    <label for="points">Points</label>
			    <input class="form-control" id="points" name="points" value="${players.points}" required minlength="2" autocomplete= "off">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
			 <a href="/index" class="btn btn-link">Cancel</a>
		</form>

</body>
</html>