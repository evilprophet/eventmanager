<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<rapid:override name="pageTitle">Event - ${event.name}</rapid:override>
<rapid:override name="content">
    <article class="container-fluid">
        <div class="panel panel-default">
            <div class="panel-heading clearfix">
                <h4 class="col-md-1">Details</h4>
                <a class="btn btn-default btn-lg pull-right" data-dismiss="modal" aria-label="Close"
                   href=<c:url value='/admin/events'/>>Back</a>
            </div>
            <div class="panel-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Id</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">${event.id}</p>
                        </div>
                        <label class="col-sm-2 control-label">Partner</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">
                                    ${event.partner.name}
                                <a class="btn btn-info btn-xs" data-dismiss="modal" aria-label="Close"
                                   href=<c:url value='/admin/partners/${event.partner.id}'/>>Details</a>
                            </p>
                        </div>
                        <label class="col-sm-2 control-label">Name</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">${event.name}</p>
                        </div>
                        <label class="col-sm-2 control-label">Description</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">${event.description}</p>
                        </div>
                        <label class="col-sm-2 control-label">Tickets</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">${event.freeAmount}/${event.amount}</p>
                        </div>
                        <label class="col-sm-2 control-label">Price</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">${event.price}</p>
                        </div>
                        <label class="col-sm-2 control-label">Date</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">${event.eventDate}</p>
                        </div>
                        <label class="col-sm-2 control-label">Publishing Date</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">${event.publishedAt}</p>
                        </div>
                        <label class="col-sm-2 control-label">Closing Date</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">${event.closedAt}</p>
                        </div>
                        <label class="col-sm-2 control-label">Available</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">
                                <c:choose>
                                    <c:when test="${event.isAvailable()}">
                                        <span class="label label-success">Yes</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="label label-warning">No</span>
                                    </c:otherwise>
                                </c:choose>
                            </p>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </article>

    <article class="container-fluid">
        <div class="panel panel-default">
            <div class="panel-heading clearfix">
                <h4 class="col-md-2">Reservations for partner</h4>
            </div>
            <div class="panel-body">
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Email</th>
                        <th class="col-xs-1">Tickets</th>
                        <th class="col-xs-1">Final price</th>
                        <th class="col-xs-1">Confirmed</th>
                        <th class="col-xs-1">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${reservations}" var="reservation">
                        <tr>
                            <td>${reservation.getFullName()}</td>
                            <td>${reservation.email}</td>
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
                                   href=<c:url value='/admin/events/${reservation.id}'/>>Show</a>
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
