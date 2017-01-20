<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<rapid:override name="pageTitle">Reservation - ${reservation.uuid}</rapid:override>
<rapid:override name="content">
    <article class="container-fluid">
        <div class="panel panel-default">
            <div class="panel-heading clearfix">
                <h4 class="col-md-1">Details</h4>
                <a class="btn btn-default btn-lg pull-right" data-dismiss="modal" aria-label="Close"
                   href=<c:url value='/reservations'/>>Back</a>
            </div>
            <div class="panel-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Id</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">${reservation.id}</p>
                        </div>
                        <label class="col-sm-2 control-label">Event</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">
                                    ${reservation.event.name}
                                <a class="btn btn-info btn-xs" data-dismiss="modal" aria-label="Close"
                                   href=<c:url value='/events/${reservation.event.id}'/>>Details</a>
                            </p>
                        </div>
                        <label class="col-sm-2 control-label">Name</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">${reservation.getFullName()}</p>
                        </div>
                        <label class="col-sm-2 control-label">Email</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">${reservation.email}</p>
                        </div>
                        <label class="col-sm-2 control-label">Telephone</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">${reservation.telephone}</p>
                        </div>
                        <label class="col-sm-2 control-label">Tickets</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">${reservation.amount}</p>
                        </div>
                        <label class="col-sm-2 control-label">Final Price</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">${reservation.finalPrice}</p>
                        </div>
                        <label class="col-sm-2 control-label">Confirmed</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">
                                <c:choose>
                                    <c:when test="${reservation.isConfirmed()}">
                                        <span class="label label-success">Yes</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="label label-warning">No</span>
                                    </c:otherwise>
                                </c:choose>
                            </p>
                        </div>
                        <label class="col-sm-2 control-label">Reservation Key</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">
                                <strong>${reservation.reservationKey}</strong>
                                <span class="label label-default">Remember! Important to receive tickets.</span>
                            </p>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </article>
</rapid:override>

<%@ include file="../base.jsp" %>
