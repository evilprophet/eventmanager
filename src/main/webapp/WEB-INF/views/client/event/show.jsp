<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<rapid:override name="pageTitle">Event - ${event.name}</rapid:override>
<rapid:override name="content">
    <article class="container-fluid">
        <div class="panel panel-default">
            <div class="panel-heading clearfix">
                <h4 class="col-md-1">Details</h4>
                <a class="btn btn-default btn-lg pull-right" data-dismiss="modal" aria-label="Close"
                   href=<c:url value='/events'/>>Back</a>
                <a class="btn btn-success btn-lg pull-right" data-dismiss="modal" aria-label="Close"
                   href=<c:url value='/reservations/new?event_id=${event.id}'/>>Buy</a>
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
                                   href=<c:url value='/partners/${event.partner.id}'/>>Details</a>
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
                    </div>
                </form>
            </div>
        </div>
    </article>
</rapid:override>

<%@ include file="../base.jsp" %>
