<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<rapid:override name="pageTitle">Partner - ${partner.name}</rapid:override>
<rapid:override name="content">
    <article class="container-fluid">
        <div class="panel panel-default">
            <div class="panel-heading clearfix">
                Details
                <a class="btn btn-default move-right" data-dismiss="modal" aria-label="Close"
                  href=<c:url value='/reservations/new?event_id=${event.id}'/>>Select</a>
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
                            <p class="form-control-static">${event.partner.name}</p>
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
