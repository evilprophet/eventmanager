<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head><title><rapid:block name="pageTitle">EventManager</rapid:block></title>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/css/bootstrap.min.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/css/bootstrap-theme.min.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/css/jquery.datetimepicker.min.css' />" rel="stylesheet"/>
</head>
<body>
<article class="container-fluid">
    <c:if test="${not empty msg}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            <strong>${msg}</strong>
        </div>
    </c:if>
    <div class="panel panel-default">
        <div class="panel-heading clearfix">
            <h5>Admin Panel</h5>
        </div>
        <div class="panel-body">
            <ul class="nav nav-pills">
                <li role="presentation"><a href="<c:url value='/admin/partners'/>">Partners</a></li>
                <li role="presentation"><a href="<c:url value='/admin/events'/>">Events</a></li>
                <li role="presentation"><a href="<c:url value='/admin/reservations'/>">Reservations</a></li>
            </ul>
        </div>
    </div>
</article>
<rapid:block name="content">

</rapid:block>
</body>
<script src="<c:url value='/static/js/jquery-3.1.1.min.js' />"></script>
<script src="<c:url value='/static/js/bootstrap.min.js' />"></script>
<script src="<c:url value='/static/js/jquery.datetimepicker.full.min.js' />"></script>
<rapid:block name="script">

</rapid:block>
</html>