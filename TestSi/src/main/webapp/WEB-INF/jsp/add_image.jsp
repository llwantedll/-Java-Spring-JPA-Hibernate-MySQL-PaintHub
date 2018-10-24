<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: llwan
  Date: 06.10.2018
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <spring:url value="/resources/style/style.css" var="style"/>
    <title>Free painting hab</title>
    <link href="${style}" rel="stylesheet" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body id="body_main">

<table class="main_table" cellspacing="0" cellpadding="0" align="center">

    <jsp:include page="main_design_parts/header_main.jsp"/>

    <jsp:include page="main_design_parts/navigator_main.jsp"/>

    <tr class="main_nav">

        <jsp:include page="main_design_parts/left_nav.jsp"/>

        <td class="right_nav" align="center">

            <div class="page_navigator">
                <form:form method="post" modelAttribute="addImageForm"
                           action="/add_image?${_csrf.parameterName}=${_csrf.token}"
                           acceptCharset="UTF-8"
                           enctype="multipart/form-data">

                    <spring:bind path="imageMP">
                        <div>
                            <form:input class="reg_text"
                                        path="imageMP"
                                        type="file"
                                        accept="image/x-png, image/gif, image/jpeg"
                                        name="image" placeholder="image" />
                        </div>
                    </spring:bind>

                    <spring:bind path="name">
                        <div>
                            <form:input class="reg_text"
                                        path="name" type="text"
                                        name="name"
                                        placeholder="image name"/>
                        </div>
                    </spring:bind>

                    <spring:bind path="description">
                        <div>
                            <form:textarea class="reg_textarea"
                                        path="description"
                                        type="textarea"
                                        name="description"
                                        placeholder="image description max 500 characters"/>
                        </div>
                    </spring:bind>

                    <spring:bind path="tagsString">
                        <div>
                            <form:textarea class="reg_textarea"
                                        path="tagsString"
                                        type="textarea"
                                        name="tagsString"
                                        placeholder="image tags, enter spliting by \",\" (without \"\")"/>
                        </div>
                    </spring:bind>

                    <div>
                        <input class="reg_text" type="submit" value="submit">
                    </div>
                    <div><form:errors path="imageMP"/></div>
                    <div><form:errors path="name"/></div>
                    <div><form:errors path="description"/></div>
                    <div><form:errors path="tagsString"/></div>
                </form:form>
            </div>
        </td>

    </tr>

    <jsp:include page="main_design_parts/footer_main.jsp"/>

</table>
</body>
</html>

