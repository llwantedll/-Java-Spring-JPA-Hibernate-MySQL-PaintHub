<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: llwan
  Date: 06.10.2018
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <spring:url value="/resources/style/style.css" var="style"/>
    <title>Free painting hab</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="${style}" rel="stylesheet" />
  </head>
  <body id="body_main">

  <table class="main_table" cellspacing="0" cellpadding="0" align="center">

    <jsp:include page="main_design_parts/header_main.jsp"/>
    <jsp:include page="main_design_parts/navigator_main.jsp"/>

    <tr class="main_nav">

      <jsp:include page="main_design_parts/left_nav.jsp"/>

      <td class="right_nav" align="center">
        <div class="error_text">${delete_text}</div>
        <jsp:include page="main_design_parts/content.jsp"/>
        <jsp:include page="main_design_parts/page_navigator.jsp"/>
      </td>

    </tr>

    <jsp:include page="main_design_parts/footer_main.jsp"/>

  </table>
  </body>
</html>
