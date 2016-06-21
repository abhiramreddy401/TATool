<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="java.io.*" %>
<%
try{ 
		File file=new File("D://chart6.jpg");
		FileInputStream fileInStream = new FileInputStream(file);  
		 OutputStream outStream = response.getOutputStream();     
		 long fileLength;  
		 byte[] byteStream;  
		 fileLength = file.length();  
		 byteStream = new byte[(int)fileLength];  
		 fileInStream.read(byteStream, 0, (int)fileLength);  
		 response.setContentType("image/html");  
		 response.setContentLength((int)fileLength);  
		 //response.setHeader("Cache-Control","no-store,no-cache, must-revalidate, post-check=0, pre-check=0");  
		 //response.setHeader("Pragma", "no-cache");  
		 fileInStream.close();  
		 outStream.write(byteStream);  
		 outStream.flush();  
		 outStream.close();  
	}catch(IOException e)  
	{  
		System.err.println("Problem occurred creating chart.");  
	} 
	%>
</body>
</html>