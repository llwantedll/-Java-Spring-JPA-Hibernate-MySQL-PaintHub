<%--
  Created by IntelliJ IDEA.
  User: llwan
  Date: 17.10.2018
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        <td class="right_nav" align="center">
            <div class="page_navigator">
                <c:if test="${information.equals(\"about_us\")}">
                  All information available in our facebook page facebook.com/546
                </c:if>
                <c:if test="${information.equals(\"rules\")}">
                    <h3>Rules</h3>
                    1. Upload only your images <br>
                    2. No images with adult content <br>
                    3. Do not upload same images <br>
                </c:if>
            </div>
        </td>

    </tr>

    <jsp:include page="main_design_parts/footer_main.jsp"/>

</table>
</body>
</html>
