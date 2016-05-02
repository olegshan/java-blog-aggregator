<%--
  Created by IntelliJ IDEA.
  User: Bors
  Date: 26.04.2016
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/taglib.jsp" %>

<h1><c:out value="${user.name}"/></h1>


<%--<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
    New blog
</button>

<form:form commandName="blog" cssClass="form-horizontal">
    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">New blog</h4>
                </div>
                <div class="modal-body">

                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">Name:</label>
                        <div class="col-sm-10">
                            <form:input path="name" cssClass="form-control"/>
                            <form:errors path="name" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">URL:</label>
                        <div class="col-sm-10">
                            <form:input path="url" cssClass="form-control"/>
                            <form:errors path="url" />
                        </div>
                    </div>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <input type="submit" class="btn btn-primary" value="Save"/>
                </div>
            </div>
        </div>
    </div>
</form:form>--%>

<br/>
<br/>

<script type="text/javascript">
    $(document).ready(function () {
        $('.nav-tabs a:first').tab('show'); // Select first tab
        $('.triggerRemove').click(function (e) {
           e.preventDefault();
            $("#modalRemove .removeBtn").attr("href", $(this).attr("href"));
            $("#modalRemove").modal();
        });
    });
</script>

<div>

    <!-- Nav tabs -->
    <ul class="nav nav-tabs" role="tablist">
        <c:forEach items="${user.blogs}" var="blog">
            <li role="presentation"><a href="#blog_${blog.id}"aria-controls="profile" role="tab" data-toggle="tab">
                <c:out value="${blog.name}"/></a></li>
        </c:forEach>
    </ul>

    <!-- Tab panes -->
    <div class="tab-content">
        <c:forEach items="${user.blogs}" var="blog">
            <div class="tab-pane" id="blog_${blog.id}">
                <h1><c:out value="${blog.name}"/></h1>

                <a href="<spring:url value="/blog/remove/${blog.id}.html" />"
                   class="btn btn-danger triggerRemove">remove blog</a>

                <p><c:out value="${blog.url}"/></p>
                <table class="table table-bordered table-hover table-striped">
                    <thead>
                    <tr>
                        <th>Title</th>
                        <th>Link</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${blog.items}" var="item">
                        <tr>
                            <td><c:out value="${item.title}"/></td>
                            <td><c:out value="${item.link}"/></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:forEach>
    </div>

</div>

<!-- Modal -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="removeLabel">Remove blog</h4>
            </div>
            <div class="modal-body">
                Really remove?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                <a href="" class="btn btn-danger removeBtn">Remove</a>
            </div>
        </div>
    </div>
</div>