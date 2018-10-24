<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form class="login_main_form" method="post" action="${pageContext.request.contextPath}/login">
    <label>Sign in</label>
    <input type="text" name="login" placeholder="login"/>
    <input type="password" name="password" placeholder="password"/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="Enter"/>
    <div class="error_text">${error}</div>
    <div><a class="page_link" href="<c:url value="/register"/>">Sign Up</a></div>
</form>