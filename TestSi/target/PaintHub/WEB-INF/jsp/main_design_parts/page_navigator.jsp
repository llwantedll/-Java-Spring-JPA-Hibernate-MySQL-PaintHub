<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="page_navigator">
    <jsp:useBean id="pageNavigator" class="com.llwantedll.model.logic.PageNavigator" scope="request"/>
    <c:if test="${pageNavigator.imagesCount>0}">

        <a class="page_link" href="<c:url value="/find?page=1&find=${findParameter}"/>"> << </a>

        <a class="${pageNavigator.currentPage == 1 ? "disabled_link" : "page_link"}"
           href="<c:url value="/find?page=${pageNavigator.currentPage-1}&find=${findParameter}"/>">back</a>

        <c:forEach items="${pageNavigator.pages}" var="page">
                <a class="${pageNavigator.currentPage == page ? "disabled_link" : "page_link"}"
                   href="<c:url value="/find?page=${page}&find=${findParameter}"/>">${page}</a>
        </c:forEach>

        <a class="${pageNavigator.currentPage == pageNavigator.lastPage ? "disabled_link" : "page_link"}"
           href="<c:url value="/find?page=${pageNavigator.currentPage+1}&find=${findParameter}"/>">next</a>

        <a class="page_link" href="<c:url value="/find?page=${pageNavigator.lastPage}&find=${findParameter}" />"> >> </a>
    </c:if>

    <c:if test="${pageNavigator.imagesCount==0}">
        <div>No content found</div>
    </c:if>
</div>