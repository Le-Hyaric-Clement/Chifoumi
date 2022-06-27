<%--
  Created by IntelliJ IDEA.
  User: stagiaire
  Date: 23/06/2022
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<%
    String resultat = (String) request.getAttribute("resultatFinal");
%>
<p>
    <%= resultat %>
</p>
<a href="index.jsp">Nouvelle Partie</a>
</body>
</html>
