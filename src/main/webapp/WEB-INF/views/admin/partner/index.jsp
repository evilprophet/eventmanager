<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<rapid:override name="pageTitle">Partners</rapid:override>
<rapid:override name="content">
    <article class="container-fluid">
        <div class="panel panel-default">
            <div class="panel-heading clearfix">
                <h4 class="col-md-1">Partners</h4>
                <a class="btn btn-default btn-lg pull-right" data-dismiss="modal" aria-label="Close"
                   href=<c:url value='/admin'/>>Back</a>
                <a class="btn btn-success btn-lg pull-right" data-dismiss="modal" aria-label="Close"
                   href=<c:url value='/admin/partners/new'/>>New</a>
            </div>
            <div class="panel-body">
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th class="col-xs-2">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${partners}" var="partner">
                        <tr>
                            <td>${partner.name}</td>
                            <td>
                                <a class="btn btn-primary" data-dismiss="modal" aria-label="Close"
                                   href=<c:url value='/admin/partners/${partner.id}'/>>Show</a>
                                <a class="btn btn-success" data-dismiss="modal" aria-label="Close"
                                   href=<c:url value='/admin/partners/${partner.id}/edit'/>>Edit</a>
                                <a class="btn btn-danger" data-dismiss="modal" aria-label="Close"
                                   href=<c:url value='/admin/partners/${partner.id}/delete'/>>Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </article>
</rapid:override>

<%@ include file="../base.jsp" %>
