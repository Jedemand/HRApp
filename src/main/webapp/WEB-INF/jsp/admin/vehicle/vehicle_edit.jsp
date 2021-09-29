<%@include file="../../Includes/header.jsp"%>
<%@include file="../../Includes/navbar.jsp"%>
<%@include file="../../Includes/subnav_admin.jsp"%>

<div class="wrapper">

    <%--sidebar--%>
    <div class="d-flex justify-content-center">
        <%@include file="vehicle_sidebar.jsp"%>
        <div id="main-wrapper" class="col-sm-8">
            <div class="col-sm-8">
                <c:set var="idx" value="0" scope="page"/>
                <form:form action="/admin/vehicle/update" modelAttribute="vehicle" class="form-horizontal" method="post">
                    <form:hidden path="id"></form:hidden>
                    <form:hidden path="version"></form:hidden>
                    <div class="row">
                        <div class="form-group">
                           <div class="col-sm-8">
                                <label for="${idx2}" id="title" class="d-flex justify-content-center">Vehicle</label>
                               <div>
                                    <label for="inputVehicle" class="col-lg-2"></label>
                                        <form:input path="year" type="int" class="form-control" id="inputVehicle" placeholder="Year"/>
                                        <form:input path="licensePlate" type="text" class="form-control" id="inputVehicle" placeholder="License Plate"/>
                                        <form:input path="VIN" type="text" class="form-control" id="inputVehicle" placeholder="VIN#"/>
                                        <form:input path="color" type="text" class="form-control" id="inputVehicle" placeholder="Color"/>
                                        <form:input path="purchasePrice" type="int" class="form-control" id="inputVehicle" placeholder="Price"/>
                               </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <button class="btn btn-primary col-sm-8">Update</button>
                    </div>

                </form:form>

            </div>


        </div>

    </div>
</div>


<%@include file="../../Includes/footer.jsp"%>