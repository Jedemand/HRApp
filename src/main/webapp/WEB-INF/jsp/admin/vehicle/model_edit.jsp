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

    <%--sidebar--%>
    <div class="d-flex justify-content-center">
        <%@include file="vehicle_sidebar.jsp"%>
        <div id="main-wrapper" class="col-sm-8">
            <div class="col-sm-8">

                <form:form action="/admin/vehicle/update/model" modelAttribute="vehicleModel" class="form-horizontal" method="post">
                    <c:set var="idx2" value="0" scope="page"/>
                    <form:hidden path="id"></form:hidden>
                    <form:hidden path="version"></form:hidden>
                    <div class="row">
                        <div class="form-group">
                           <div class="col-lg-10">
                               <label for="inputVehicleModelName" id="title" class="d-flex justify-content-start">Vehicle Model</label>
                               <form:input path="vehicleModelName" type="text" id="inputVehicleModelName" cssClass="form-control"></form:input>
                            </div>
                        </div>
                    </div>
                    <div>
                           <c:forEach items="${vehicleModel.vehicleList}" var="vehicle">
                            <form:hidden path="vehicleList[${idx2}].id" />
                            <form:hidden path="vehicleList[${idx2}].version"/>
                            <div class="row">
                                <div class="form-group">
                                    <div class="col-lg-10">
                                        <label for="${idx2}"  id="title" class="d-flex justify-content-center">Vehicle</label>
                                        <div>
                                            <label for="inputVehicle" class="col-lg-2"></label>
                                            <form:input path="vehicleList[${idx2}].year" type="int" class="form-control" id="inputVehicle" placeholder="Year"/>
                                            <form:input path="vehicleList[${idx2}].licensePlate" type="text" class="form-control" id="inputModel" placeholder="License Plate"/>
                                            <form:input path="vehicleList[${idx2}].VIN" type="text" class="form-control" id="inputModel" placeholder="VIN#"/>
                                            <form:input path="vehicleList[${idx2}].color" type="text" class="form-control" id="inputModel" placeholder="Color"/>
                                            <form:input path="vehicleList[${idx2}].purchasePrice" type="int" class="form-control" id="inputModel" placeholder="Price"/>
                                        </div>
                                   </div>
                                </div>
                            </div>
                       <c:set var="idx2" value="${idx2 + 1}" scope="page"/>
                        </c:forEach>

                    </div>
                    <div class="row">
                        <div class="form-group">
                            <div class="col-lg-10">
                                <label id="title" class="d-flex justify-content-center"> New Vehicle</label>
                                <div>
                                    <label for="inputYear" class="col-lg-10 control-label"></label>
                                    <input type="String" class="form-control" name="inputYear" placeholder="Year"/>

                                    <label for="inputPlate" class="col-lg-2 control-label"></label>
                                    <input  type="text" class="form-control" name="inputPlate" placeholder="License Plate"/>

                                    <label for="inputVIN" class="col-lg-2 control-label"></label>
                                    <input  type="text" class="form-control" name="inputVIN" placeholder="VIN#"/>

                                    <label for="inputColor" class="col-lg-2 control-label"></label>
                                    <input  type="text" class="form-control" name="inputColor" placeholder="Color"/>

                                    <label for="inputPrice" class="col-lg-2 control-label"></label>
                                    <input  type="String" class="form-control" name="inputPrice" placeholder="Price"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <button class="btn btn-primary col-lg-10">Update</button>
                    </div>
                </form:form>
            </div>
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
                    <p class="mb-0">Warning! Please enter only whole numbers without symbols for Year and Price <a href="#" class="alert-link"></a>.</p>
                </div>
            </div>
            <div class="${dangerAlert == null ? 'hidden' : dangerAlert}" id="dangerAlert">
                <div class="alert alert-dismissible alert-danger">
                    <button type="button" class="btn-close" data-bs-dismiss="alert">&times;</button>
                    <strong>Oh snap!</strong> <a href="#" class="alert-link">Change a few things up and try submitting again.</a>
                </div>
            </div>
        </div>
</div>



<%@include file="../../Includes/footer.jsp"%>