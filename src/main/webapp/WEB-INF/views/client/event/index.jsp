<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<rapid:override name="pageTitle">Partners</rapid:override>
<rapid:override name="content">
    <article class="container-fluid">
        <div class="panel panel-default">
            <div class="panel-heading clearfix">
                Partners
            </div>
            <div class="panel-body">
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Tickets</th>
                        <th>Price</th>
                        <th>Date</th>
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
                                <a class="btn btn-default" data-dismiss="modal" aria-label="Close"
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
