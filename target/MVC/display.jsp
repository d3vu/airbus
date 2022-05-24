<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
      <%@ page import = "java.util.*" %>
		<%
		List<String> ans = new ArrayList<String>();
		ans = (ArrayList)request.getAttribute("ans");
			for(int i=0; i<ans.size(); i++)
			{
				out.println(ans.get(i));
				out.print("<br>");
			}
		%>
		
		<table>
		<%  
		out.print("<table>");
		out.print("<tr> <td>");
		out.print("In side table");
		out.print("</td></tr>");
		out.print("<tr> <td>");
		out.print("In side table");
	    out.print("</td></tr>");
	    out.print("/<table>");
		%>			
		</table>
</body>
</html>