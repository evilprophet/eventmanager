<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<rapid:override name="pageTitle">Events</rapid:override>
<rapid:override name="content">
    <article class="container-fluid">
        <div class="panel panel-default">
            <div class="panel-heading clearfix">
                <h4 class="col-md-1">Events</h4>
                <a class="btn btn-default btn-lg pull-right" data-dismiss="modal" aria-label="Close"
                   href=<c:url value='/admin'/>>Back</a>
            </div>
            <div class="panel-body">
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th class="col-xs-1">Tickets</th>
                        <th class="col-xs-1">Price</th>
                        <th class="col-xs-2">Date</th>
                        <th class="col-xs-2">Available</th>
                        <th class="col-xs-2">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${events}" var="event">
                        <tr>
                            <td>${event.name}</td>
                            <td>${event.freeAmount}/${event.amount}</td>
                            <td>${event.price}</td>
                            <td>${event.eventDate}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${event.isAvailable()}">
                                        <span class="label label-success">Yes</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="label label-warning">No</span>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                <a class="btn btn-primary" data-dismiss="modal" aria-label="Close"
                                   href=<c:url value='/admin/events/${event.id}'/>>Show</a>
                                <a class="btn btn-success" data-dismiss="modal" aria-label="Close"
                                   href=<c:url value='/admin/events/${event.id}/edit'/>>Edit</a>
                                <a class="btn btn-danger" data-dismiss="modal" aria-label="Close"
                                   href=<c:url value='/admin/events/${event.id}/delete'/>>Delete</a>
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
