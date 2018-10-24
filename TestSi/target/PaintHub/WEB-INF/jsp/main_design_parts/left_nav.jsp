<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<td class="left_nav" width="200px">

    <c:if test ="${pageContext.request.userPrincipal.name == null}">
        <jsp:include page="login_form.jsp"/>
    </c:if>

    <c:if test ="${pageContext.request.userPrincipal.name != null}">
        <jsp:include page="welcome_container.jsp"/>
    </c:if>

    <div>
        <form class="login_main_form" method="get" action="<c:url value="/find"/>">
            <input type="hidden" name="page" value="1">
            <input type="text" name="find" placeholder="search"/>
            <input type="submit" value="find">
        </form>
    </div>

    <div class="login_main_form">
        <div>Random tags</div>
        <c:forEach items="${tagCloud}" var="tag">
            <div>
                <a class="page_link"
                   href="<c:url value="/find?page=1&find=${tag.name}"/>">${tag.name}</a>
            </div>
        </c:forEach>
    </div>
</td>