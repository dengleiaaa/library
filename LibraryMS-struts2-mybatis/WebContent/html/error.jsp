<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<script type="text/javascript">
var message = "${requestScope.message}";

if (message == "登录失败") {
	alert(message);
}
if (message == "账号已存在") {
	alert(message);
}
</script>
</body>
</html>