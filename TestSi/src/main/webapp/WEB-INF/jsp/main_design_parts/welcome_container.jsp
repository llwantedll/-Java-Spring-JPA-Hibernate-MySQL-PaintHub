<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<form id="logoutForm" method="post" action="${pageContext.request.contextPath}/logout">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>

<div class="login_main_form">
    <div>
        <a href="/profile/${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.user.login}">
            <img id="avatar_main" src="data:image/jpg;base64,${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.user.avatar64base}" width="125px" height="125px"/>
        </a>
    </div>
    <div>${pageContext.request.userPrincipal.name}</div>
    <div><a class="page_link" href="<c:url value="/add_image"/>">Add Image</a></div>
    <div><a id="logout_button" onclick="document.forms['logoutForm'].submit()">Log out</a></div>
</div>