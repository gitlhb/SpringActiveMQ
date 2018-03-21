<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/js/jquery-3.1.1.js"></script>
    <title>发送JMS消息</title>
</head>
<script type="text/javascript">
</script>
<body>
<div>
    <form action="send1" method="post">
        往队列Queue1发送消息：<input type="text" name="message"/>
        <br>
        <input type="submit" value="发送消息1"/>
    </form>

    <form action="send2" method="post">
        往队列Queue2发送消息：<input type="text" name="message"/>
        <br>
        <input type="submit" value="发送消息2"/>
    </form>
</div>
<br>
</body>
</html>