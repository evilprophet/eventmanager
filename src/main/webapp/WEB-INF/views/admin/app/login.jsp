<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<rapid:override name="content">
    <article class="container-fluid">
        <div class="panel panel-default">
            <div class="panel-heading clearfix">
                <h4 class="col-md-1">Please login</h4>
                <a class="btn btn-default btn-lg pull-right" data-dismiss="modal" aria-label="Close"
                   href=<c:url value='/'/>>Back</a>
            </div>
            <div class="panel-body">
                <form th:action="@{/login}" method="post" class="form-horizontal">
                    <fieldset>
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="username">Username</label>
                            <div class="col-sm-5">
                                <input class="form-control input-sm" type="text" id="username" name="username"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="password">Password</label>
                            <div class="col-sm-5">
                                <input class="form-control input-sm" type="password" id="password" name="password"/>
                            </div>
                        </div>
                        <p class="text-muted">Username: admin, Password: nimda</p>
                        <div class="form-actions">
                            <input type="submit" value="Log in" class="btn btn-default btn-lg"/>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </article>
</rapid:override>

<%@ include file="../../client/base.jsp" %>
