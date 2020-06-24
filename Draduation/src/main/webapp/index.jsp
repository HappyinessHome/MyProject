<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false"  import="java.util.List,java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<body>

 <% request.setAttribute("test","hello");
    List list=new ArrayList();
    for(int i=0;i<10;i++){
        list.add(i+"hhh");
    }
    request.setAttribute("ss",list);
 %>
<h2>${requestScope.test}</h2>
 <c:forEach items="${requestScope.ss}" var="item" begin="0"  step="1">
     ${item}
 </c:forEach>
    <form action="./user/upload" method="post" enctype="multipart/form-data" >
        <input type="file" name="file">
        <input type="submit" value="上传">
    </form>
</body>
</html>
