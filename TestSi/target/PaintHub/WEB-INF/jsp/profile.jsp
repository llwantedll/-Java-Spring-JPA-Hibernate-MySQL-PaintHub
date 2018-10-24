<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: llwan
  Date: 14.10.2018
  Time: 15:11
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

    <tr class="main_nav">

        <jsp:include page="main_design_parts/left_nav.jsp"/>

        <td class="right_nav">
            <jsp:useBean id="userProfile"
                         class="com.llwantedll.model.entities.User"
                         scope="request"/>

                <div class="profile">
                    <div>User profile</div>
                    <div><img src="data:image/jpg;base64,${userProfile.avatar64base}" width="200px" height="200px"/></div>
                    <div class="image_name">${userProfile.login}</div>
                    <div>Email: ${userProfile.email}</div>
                    <div>Name: ${userProfile.name}</div>
                    <div>Birthday date ${userProfile.birthday.toString()}</div>
                </div>
        </td>

    </tr>

    <jsp:include page="main_design_parts/footer_main.jsp"/>

</table>
</body>
</html>