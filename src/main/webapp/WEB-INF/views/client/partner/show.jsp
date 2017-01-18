<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<rapid:override name="pageTitle">Partner - ${partner.name}</rapid:override>
<rapid:override name="content">
    <article class="container-fluid">
        <div class="panel panel-default">
            <div class="panel-heading clearfix">
                <h4 class="col-md-1">Details</h4>
                <a class="btn btn-default btn-lg pull-right" data-dismiss="modal" aria-label="Close"
                   href=<c:url value='/partners'/>>Back</a>
            </div>
            <div class="panel-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Id</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">${partner.id}</p>
                        </div>
                        <label class="col-sm-2 control-label">Name</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">${partner.name}</p>
                        </div>
                        <label class="col-sm-2 control-label">Description</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">${partner.description}</p>
                        </div>
                        <label class="col-sm-2 control-label">Website</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">${partner.website}</p>
                        </div>
                        <label class="col-sm-2 control-label">Address</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">${partner.address}</p>
                        </div>
                        <label class="col-sm-2 control-label">Telephone</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">${partner.telephone}</p>
                        </div>
                        <label class="col-sm-2 control-label">Email</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">${partner.email}</p>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </article>

    <article class="container-fluid">
        <div class="panel panel-default">
            <div class="panel-heading clearfix">
                <h4 class="col-md-2">Events for partner</h4>
            </div>
            <div class="panel-body">
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th class="col-xs-1">Tickets</th>
                        <th class="col-xs-1">Price</th>
                        <th class="col-xs-2">Date</th>
                        <th class="col-xs-1">Action</th>
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
                                <a class="btn btn-info" data-dismiss="modal" aria-label="Close"
                                   href=<c:url value='/events/${event.id}'/>>Select</a>
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
