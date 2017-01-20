<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<rapid:override name="pageTitle">Reservations</rapid:override>
<rapid:override name="content">
    <article class="container-fluid">
        <div class="panel panel-default">
            <div class="panel-heading clearfix">
                <h4 class="col-md-1">Reservations</h4>
                <a class="btn btn-default btn-lg pull-right" data-dismiss="modal" aria-label="Close"
                   href=<c:url value='/admin'/>>Back</a>
            </div>
            <div class="panel-body">
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Event</th>
                        <th class="col-xs-1">Tickets</th>
                        <th class="col-xs-1">Final price</th>
                        <th class="col-xs-1">Confirmed</th>
                        <th class="col-xs-2">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${reservations}" var="reservation">
                        <tr>
                            <td>${reservation.getFullName()}</td>
                            <td>${reservation.email}</td>
                            <td>${reservation.event.name}</td>
                            <td>${reservation.amount}</td>
                            <td>${reservation.finalPrice}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${reservation.isConfirmed()}">
                                        <span class="label label-success">Yes</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="label label-warning">No</span>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                <a class="btn btn-primary" data-dismiss="modal" aria-label="Close"
                                   href=<c:url value='/admin/reservations/${reservation.id}'/>>Show</a>
                                <c:if test="${!reservation.isConfirmed()}">
                                    <a class="btn btn-danger" data-dismiss="modal" aria-label="Close"
                                       href=<c:url value='/admin/reservations/${reservation.id}/delete'/>>Delete</a>
                                </c:if>
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
