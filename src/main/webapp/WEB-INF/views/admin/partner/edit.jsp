<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
</rapid:override>

<%@ include file="../base.jsp" %>
