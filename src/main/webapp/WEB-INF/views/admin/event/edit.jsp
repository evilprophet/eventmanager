<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                <form:form method="POST" modelAttribute="event" class="form-horizontal">
                    <form:input type="hidden" path="id" id="id"/>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Id</label>
                        <div class="col-sm-5">
                            <p class="form-control-static">${event.id}</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Partner</label>
                        <div class="col-sm-5">
                            <form:select path="partner" items="${partners}" itemValue="id" itemLabel="name"
                                         class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="partner" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Name</label>
                        <div class="col-sm-5">
                            <form:input type="text" path="name" id="name" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="name" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Description</label>
                        <div class="col-sm-5">
                            <form:textarea path="description" id="description" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="description" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Tickets</label>
                        <div class="col-sm-5">
                            <form:input type="number" path="amount" id="amount" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="amount" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Free Tickets</label>
                        <div class="col-sm-5">
                            <form:input type="text" path="freeAmount" id="freeAmount" class="form-control input-sm"
                                        readonly="true"/>
                            <div class="has-error">
                                <form:errors path="freeAmount" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Price</label>
                        <div class="col-sm-5">
                            <div class="input-group">
                                <div class="input-group-addon">$</div>
                                <form:input type="text" path="price" id="price" class="form-control input-sm"/>
                            </div>
                            <div class="has-error">
                                <form:errors path="price" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Date</label>
                        <div class="col-sm-5">
                            <form:input type="text" path="eventDate" id="eventDate" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="eventDate" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Publishing Date</label>
                        <div class="col-sm-5">
                            <form:input type="text" path="publishedAt" id="publishedAt" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="publishedAt" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Closing Date</label>
                        <div class="col-sm-5">
                            <form:input type="text" path="closedAt" id="closedAt" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="closedAt" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                    <input type="submit" value="Update" class="btn btn-primary btn-lg"/>
                </form:form>
            </div>
        </div>
    </article>
</rapid:override>
<rapid:override name="script">
    <script type="text/javascript">
        var ticketsUsed;
        $(function () {
            ticketsUsed = $('#amount').val() - $('#freeAmount').val();
        });
        $('#eventDate, #publishedAt, #closedAt').datetimepicker({
            format:'Y-m-d H:i',
            startDate: new Date(),
            mask: true
        });
        $('#amount').bind('change paste keyup', function () {
            $('#freeAmount').val($('#amount').val() - ticketsUsed);
        });
    </script>
</rapid:override>

<%@ include file="../base.jsp" %>
