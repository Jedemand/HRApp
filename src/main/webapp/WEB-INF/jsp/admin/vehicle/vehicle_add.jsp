<%@include file="../../Includes/header.jsp"%>
<%@include file="../../Includes/navbar.jsp"%>
<%@include file="../../Includes/subnav_admin.jsp"%>


<script>
    $(document).ready(function(){

        $("#successAlert").delay(6000).fadeOut(2000);
        $("#warningAlert").delay(6000).fadeOut(2000);
        $("#dangerAlert").delay(6000).fadeOut(2000);
    })
</script>
<div class="wrapper">
    <div class="d-flex justify-content-center">
        <%@include file="vehicle_sidebar.jsp"%>
            <div id="main-wrapper" class="col-sm-10">
                <div class="col-sm-8">
                    <form:form cssClass="form-horizontal" modelAttribute="vehicleVO" action="/admin/vehicle/add" method="post">
                        <legend>Add a Vehicle</legend>
                            <div class="form-group">
                                <div class="col-lg-10">
                                    <label for="inputVehicleMakeName" id="title" class="d-flex justify-content-center">Vehicle Make</label>
                                    <form:input path="newVehicleMakeName" type="text" class="form-control" id="inputVehicleMakeName" placeholder="Vehicle Make" required="required"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-10">
                                    <label for="inputModel" id="title" class="d-flex justify-content-center">Vehicle Model</label>
                                    <form:input path="newVehicleModelName" type="text" class="form-control" id="inputModel" placeholder="Vehicle Model" required="required"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-10">
                                    <label for="inputVehicle" id="title" class="d-flex justify-content-center">Vehicle Information</label>
                                    <form:input path="newYear" type="int" class="form-control" id="inputVehicle" placeholder="Year"/>
                                    <form:input path="newLicensePlate" type="text" class="form-control" id="inputModel" placeholder="License Plate"/>
                                    <form:input path="newVIN" type="text" class="form-control" id="inputModel" placeholder="VIN#"/>
                                    <form:input path="newColor" type="text" class="form-control" id="inputModel" placeholder="Color"/>
                                    <form:input path="newPurchasePrice" type="int" class="form-control" id="inputModel" placeholder="Price"/>
                                </div>
                            </div>
                            <div class="formgroup">
                                <div class="d-flex justify-content-center">
                                    <form:button action="reset" type="reset" value="cancel" class="btn btn-default">Cancel</form:button>
                                    <form:button action="submit" value="save" class="btn btn-primary">Save</form:button>
                                </div>
                            </div>
                    </form:form>
                </div>
                <div class="col-sm-4">
                    <%--ALERTS--%>
                    <div class="${successAlert == null ? 'hidden' : successAlert}" id="successAlert">
                        <div class="alert alert-dismissible alert-success">
                            <button type="button" class="btn-close" data-bs-dismiss="alert">&times;</button>
                            <strong>Element Added</strong>
                            <p>You've added a new vehicle.</p>
                        </div>
                    </div>
                    <div class="${warningAlert == null ? 'hidden' : warningAlert}" id="warningAlert">
                        <div class="alert alert-dismissible alert-warning">
                            <button type="button" class="btn-close" data-bs-dismiss="alert">&times;</button>
                            <h4>Warning!</h4>
                            <p class="mb-0">Warning! All fields must be filled. please enter a Make, Model, and all Vehicle parameters.  <a href="#" class="alert-link"></a>.</p>
                        </div>
                    </div>
                    <div class="${dangerAlert == null ? 'hidden' : dangerAlert}" id="dangerAlert">
                        <div class="alert alert-dismissible alert-danger">
                            <button type="button" class="btn-close" data-bs-dismiss="alert">&times;</button>
                            <strong>Oh snap!</strong> <a href="#" class="alert-link">Year and Price must be whole numbers without symbols.</a>
                        </div>
                    </div>
                </div>
            </div>
    </div>
</div>

<%@include file="../../Includes/footer.jsp"%>