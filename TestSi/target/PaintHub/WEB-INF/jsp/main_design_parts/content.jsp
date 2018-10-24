<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${images}" var="image">
    <div class="element_image">
        <c:if test="${pageContext.request.isUserInRole('ROLE_ADMIN')}">
            <div>
                <a href="<c:url value="/delete_image/${image.id}"/>">
                    <img src="<c:url value="/resources/images/close.png"/>"
                         width="25px" height="25px"/>
                </a>
            </div>
        </c:if>

        <a href="/image_profile/${image.id}">
            <img src="data:image/jpg;base64,${image.img64base}" width="200px" height="200px"/>
        </a>
        <div class="image_name">${image.name}</div>
        <div>Author: <a class="page_link" href="<c:url value="/profile/${image.user.login}"/>" methods="get">${image.user.login}</a></div>
    </div>
</c:forEach>