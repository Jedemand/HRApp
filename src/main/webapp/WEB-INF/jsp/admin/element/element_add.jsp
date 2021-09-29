<%@include file="../../Includes/header.jsp"%>
<%@include file="../../Includes/navbar.jsp"%>
<%@include file="../../Includes/subnav_admin.jsp"%>

<script>
    $(document).ready(function(){

        $("#successAlert").delay(8000).fadeOut(2000);
        $("#warningAlert").delay(8000).fadeOut(2000);
        $("#dangerAlert").delay(8000).fadeOut(2000);
    })
</script>
<div class="wrapper">

    <%--sidebar--%>
    <div class="d-flex justify-content-center">
        <%@include file="element_sidebar.jsp"%>



        <div id="main-wrapper" class="col-sm-10">
            <div class="col-sm-8">
                <form:form cssClass="form-horizontal" modelAttribute="elementVO" action="/admin/element/add" method="post">
                    <fieldset>
                        <legend>Element Management</legend>
                        <div class="form-group">
                            <label for="inputNewElementType" class="col-lg-2 control-label">Element Type</label>
                            <div class="col-lg-10">
                                <form:input path="newElementType" type="text" class="form-control" id="inputNewElementType" placeholder="Element Type"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="inputNewElements" class="col-lg-2 control-label">Elements</label>
                            <div class="col-lg-10">
                                <form:textarea path="newElements" type="text" class="form-control" rows="3" id="inputNewElements"/>
                                <span class="help">Enter each new Element on a new line</span>
                            </div>
                        </div>

                        <div class="formgroup">
                            <div class="col-lg-10 col-lg-offset-2">
                                <form:button action="reset" type="reset" value="cancel" class="btn btn-default">Cancel</form:button>
                                <form:button action="submit" value="save" class="btn btn-primary">Save</form:button>
                            </div>
                        </div>

                    </fieldset>
                </form:form>
            </div>
            <div class="col-sm-4">
                <%--ALERTS--%>
                <div class="${successAlert == null ? 'hidden' : successAlert}" id="successAlert">
                    <div class="alert alert-dismissible alert-success">
                        <button type="button" class="btn-close" data-bs-dismiss="alert">&times;</button>
                        <strong>Element Added</strong> You successfully read <a href="#" class="alert-link">this important alert message</a>.
                    </div>
                </div>
                <div class="${warningAlert == null ? 'hidden' : warningAlert}" id="warningAlert">
                    <div class="alert alert-dismissible alert-warning">
                        <button type="button" class="btn-close" data-bs-dismiss="alert">&times;</button>
                        <h4>Warning!</h4>
                        <p class="mb-0">Warning! All fields must be filled. please enter an Element Type and associated Elements <a href="#" class="alert-link">vel scelerisque nisl consectetur et</a>.</p>
                    </div>
                </div>
                <div class="${dangerAlert == null ? 'hidden' : dangerAlert}" id="dangerAlert">
                    <div class="alert alert-dismissible alert-danger">
                        <button type="button" class="btn-close" data-bs-dismiss="alert">&times;</button>
                        <strong>Oh snap!</strong> <a href="#" class="alert-link">Change a few things up</a> and try submitting again.
                    </div>
                </div>
            </div>
        </div>

    </div>


</div>

<%@include file="../../Includes/footer.jsp"%>