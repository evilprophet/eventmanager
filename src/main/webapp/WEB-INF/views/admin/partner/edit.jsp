<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<rapid:override name="pageTitle">Partner - ${partner.name}</rapid:override>
<rapid:override name="content">
    <article class="container-fluid">
        <div class="panel panel-default">
            <div class="panel-heading clearfix">
                <h4 class="col-md-1">Details</h4>
                <a class="btn btn-default btn-lg pull-right" data-dismiss="modal" aria-label="Close"
                   href=<c:url value='/admin/partners'/>>Back</a>
            </div>
            <div class="panel-body">
                <form:form method="POST" modelAttribute="partner" class="form-horizontal">
                    <form:input type="hidden" path="id" id="id"/>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Id</label>
                        <div class="col-sm-5">
                            <p class="form-control-static">${partner.id}</p>
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
                        <label class="col-sm-2 control-label">Website</label>
                        <div class="col-sm-5">
                            <form:input type="text" path="website" id="website" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="website" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Address</label>
                        <div class="col-sm-5">
                            <form:input type="text" path="address" id="address" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="address" class="help-inline"/>
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
                        <label class="col-sm-2 control-label">Email</label>
                        <div class="col-sm-5">
                            <form:input type="text" path="email" id="email" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="email" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                    <input type="submit" value="Update" class="btn btn-primary btn-lg"/>
                </form:form>
            </div>
        </div>
    </article>
</rapid:override>

<%@ include file="../base.jsp" %>
