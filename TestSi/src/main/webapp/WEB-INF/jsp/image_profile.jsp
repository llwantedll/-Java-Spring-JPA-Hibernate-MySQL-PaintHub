<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: llwan
  Date: 15.10.2018
  Time: 19:26
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

        <td class="right_nav">
            <jsp:useBean id="imageProfile"
                         class="com.llwantedll.model.entities.Image"
                         scope="request"/>

            <div class="profile">
                <div class="image_name">${imageProfile.name}</div>
                <div><img src="data:image/jpg;base64,${imageProfile.img64base}"/></div>
                <div>Author: <a class="page_link" href="/profile/${imageProfile.user.login}">${imageProfile.user.login}</a></div>
                <div>Description: ${imageProfile.description}</div>
                <div>Load date: ${imageProfile.dateLoad.toString()}</div>
                <div>
                    Tags:
                    <c:forEach items="${imageProfile.tags}" var="tag">
                        ${tag.name}
                    </c:forEach>
                </div>
            </div>
        </td>

    </tr>

    <jsp:include page="main_design_parts/footer_main.jsp"/>

</table>
</body>
</html>