<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<rapid:override name="pageTitle">New reservation</rapid:override>
<rapid:override name="content">
    <article class="container-fluid">
        <div class="panel panel-default">
            <div class="panel-heading clearfix">
                <h4 class="col-md-2">Create Reservation</h4>
                <a class="btn btn-default btn-lg pull-right" data-dismiss="modal" aria-label="Close"
                   href=<c:url value='${referrer}'/>>Back</a>
            </div>
            <div class="panel-body">
                <form:form method="POST" modelAttribute="reservation" class="form-horizontal">
                    <form:input type="hidden" path="id" id="id"/>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Event</label>
                        <div class="col-sm-5">
                            <form:select path="event" items="${events}" itemValue="id" itemLabel="name"
                                         class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="event" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Ticket price</label>
                        <div class="col-sm-5">
                            <p id="ticketPrice" class="form-control-static"></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">First Name</label>
                        <div class="col-sm-5">
                            <form:input type="text" path="firstName" id="firstName" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="firstName" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Last Name</label>
                        <div class="col-sm-5">
                            <form:input type="text" path="lastName" id="lastName" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="lastName" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Email</label>
                        <div class="col-sm-5">
                            <form:input type="text" path="email" id="email" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="email" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Telephone</label>
                        <div class="col-sm-5">
                            <form:input type="text" path="telephone" id="telephone" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="telephone" class="help-inline"/>
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
                        <label class="col-sm-2 control-label">Price</label>
                        <div class="col-sm-5">
                            <form:input type="text" path="finalPrice" id="finalPrice" class="form-control input-sm" readonly="true"/>
                            <div class="has-error">
                                <form:errors path="finalPrice" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                    <input type="submit" value="Add" class="btn btn-primary btn-lg"/>
                </form:form>
            </div>
        </div>
    </article>
</rapid:override>
<rapid:override name="script">
    <script type="text/javascript">
        var eventPriceMap = {
        <c:forEach items="${eventPriceMap}" var="item" varStatus="loop">${item.key}: ${item.value} ${not loop.last ? ',' : ''}</c:forEach>
        }
        $(function () {
            $('#ticketPrice').html(eventPriceMap[$('#event').val()]);
        });
        $('#amount, #event').bind('change paste keyup', function () {
            $('#finalPrice').val($('#amount').val()*$('#ticketPrice').html());
        });
        $('#event').bind('change keyup', function () {
            $('#ticketPrice').html(eventPriceMap[$('#event').val()]);
        });

    </script>
</rapid:override>

<%@ include file="../base.jsp" %>
