<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div align="center">
  <h1>Adviser Register Form</h1>
  <form action="<%= request.getContextPath() %>/creatReport" method="post">
   <table style="with: 80%">
    <tr>
     <td>Id Adviser</td>
     <td><input type="text" name="idviser_id" /></td>
    </tr>
    <tr>
     <td>Id Crypto</td>
     <td><input type="text" name="crypto_id" /></td>
    </tr>
    <tr>
     <td>title</td>
     <td><input type="text" name="title" /></td>
    </tr>
    <tr>
     <td>Content</td>
     <td><input type="text" name="content" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>
</body>
</html>