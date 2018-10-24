<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <link href="${style}" rel="stylesheet"/>
</head>
<body>

<table class="main_table" cellspacing="0" cellpadding="0" align="center">

    <jsp:include page="main_design_parts/header_main.jsp"/>

    <tr class="main_nav">
        <td class="left_nav" width="200px" align="center">

            <div class="page_navigator">
                <form:form method="post"
                           action="/register?${_csrf.parameterName}=${_csrf.token}"
                           modelAttribute="userForm"
                           enctype="multipart/form-data">

                    <div><label> Please enter next information</label></div>
                    <spring:bind path="login">
                        <div>
                            <form:input class="reg_text" type="text" name="login" placeholder="login" path="login"/>
                        </div>
                    </spring:bind>
                    <spring:bind path="password">
                    <div>
                        <form:input class="reg_text" type="password" name="pass" placeholder="password" path="password"/>
                    </div>
                    </spring:bind>
                    <spring:bind path="confirmPassword">
                    <div>
                        <form:input class="reg_text" type="password" name="passConfirm" placeholder="confirm password" path="confirmPassword"/>
                    </div>
                    </spring:bind>
                    <spring:bind path="name">
                    <div>
                        <form:input class="reg_text" type="text" name="name" placeholder="your name" path="name"/>
                    </div>
                    </spring:bind>
                    <spring:bind path="avatarMP">
                    <div>
                        <form:input class="reg_text" type="file" name="avatarMP"
                                    accept="image/x-png, image/gif, image/jpeg"
                                    placeholder="avatar" path="avatarMP"/>
                    </div>
                    </spring:bind>
                    <spring:bind path="birthday">
                    <div>
                        <form:input class="reg_text" type="date" value="2000-01-01" min="1900-01-01" name="birthday" placeholder="birthday" path="birthday"/>
                    </div>
                    </spring:bind>
                    <spring:bind path="email">
                    <div>
                        <form:input class="reg_text" type="email" name="email" placeholder="email" path="email"/>
                    </div>
                    </spring:bind>
                    <div>
                        <input class="reg_text" type="submit" value="Register"/>
                    </div>
                    <form:errors path="login"/>
                    <form:errors path="password"/>
                    <form:errors path="confirmPassword"/>
                    <form:errors path="name"/>
                    <form:errors path="avatarMP"/>
                    <form:errors path="birthday"/>
                    <form:errors path="email"/>
                </form:form>
            </div>
        </td>
    </tr>

    <jsp:include page="main_design_parts/footer_main.jsp"/>

</table>
</body>
</html>
