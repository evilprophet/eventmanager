<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<rapid:override name="content">
    <article class="container-fluid">
        <div class="panel panel-default">
            <div class="panel-heading clearfix">
                <a class="btn btn-link btn-sm pull-right" data-dismiss="modal" aria-label="Close"
                   href=<c:url value='/admin'/>>Login</a>
            </div>
            <div class="panel-body">
                <h1 class="text-center">Welcome in EventManager</h1>
                <div class="text-center">
                    <a class="btn btn-primary btn-lg" data-dismiss="modal" aria-label="Close"
                       href=<c:url value='/partners'/>>Show partners</a>
                    <a class="btn btn-default btn-lg" data-dismiss="modal" aria-label="Close"
                       href=<c:url value='/events'/>>Show events</a>
                    <a class="btn btn-primary btn-lg" data-dismiss="modal" aria-label="Close"
                       href=<c:url value='/reservations/new'/>>New reservation</a>
                </div>
            </div>
        </div>
    </article>
    <c:if test="${not empty uuid}">
        <div id="registrationSuccess" class="modal fade" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">EventManager registration</h4>
                    </div>
                    <div class="modal-body">
                        <p>Thanks for registration on event ${eventName}</p>
                        <p>To confirm it please click link: <a href="<c:url value='/reservations/${uuid}'/>">Click!</a></p>
                    </div>
                    <div class="modal-footer">
                        This message should be sent via email but email service isn't implemented
                    </div>
                </div>
            </div>
        </div>
    </c:if>
</rapid:override>
<rapid:override name="script">
    <c:if test="${not empty uuid}">
        <script type="text/javascript">
            $(function () {
                $('#registrationSuccess').modal('show');
            });
        </script>
    </c:if>
</rapid:override>

<%@ include file="../base.jsp" %>
