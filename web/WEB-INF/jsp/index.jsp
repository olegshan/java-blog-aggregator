<%--
  Created by IntelliJ IDEA.
  User: Bors
  Date: 16.04.2016
  Time: 23:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/taglib.jsp" %>

    <h1>Latest news from the Java world:</h1>
<table class="table table-bordered table-hover table-striped">
    <thead>
    <tr>
        <th>date</th>
        <th>item</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${items}" var="item">
        <tr>
            <td>
                <c:out value="${item.publishedDate}"/>
                <br/>
                <c:out value="${item.blog.name}"/>
            </td>
            <td>
                <strong>
                    <a href="<c:out value="${item.link}"/>" target="_blank">
                        <c:out value="${item.title}"/>
                    </a>
                </strong>
                <br/>
                    ${item.description}
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

