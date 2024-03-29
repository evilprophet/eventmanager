<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<rapid:override name="content">
    <article class="container-fluid">
        <div class="panel panel-default">
            <div class="panel-heading clearfix">
            </div>
            <div class="panel-body">
                <h1 class="text-center">Welcome in EventManager Admin</h1>
                <div class="text-center">
                    <a class="btn btn-primary btn-lg" data-dismiss="modal" aria-label="Close"
                       href=<c:url value='/admin/partners'/>>Show partners</a>
                    <a class="btn btn-default btn-lg" data-dismiss="modal" aria-label="Close"
                       href=<c:url value='/admin/events'/>>Show events</a>
                    <a class="btn btn-primary btn-lg" data-dismiss="modal" aria-label="Close"
                       href=<c:url value='/admin/reservations'/>>Show reservations</a>
                </div>
            </div>
        </div>
    </article>
</rapid:override>

<%@ include file="../base.jsp" %>
