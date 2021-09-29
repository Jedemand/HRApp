<%@include file="../../Includes/header.jsp"%>
<%@include file="../../Includes/navbar.jsp"%>
<%@include file="../../Includes/subnav_admin.jsp"%>

<script>
    console.log()
</script>


<div class="wrapper">

    <%--sidebar--%>
    <div class="d-flex justify-content-center">
        <%@include file="vehicle_sidebar.jsp"%>
        <div id="main-wrapper" class="col-sm-10">
            <div class="col-sm-8">

                <c:set var="idx" value="0" scope="page"/>
                <form:form action="/admin/vehicle/update/make" modelAttribute="vehicleMake" class="form-horizontal" method="post">
                    <form:hidden path="id"></form:hidden>
                    <form:hidden path="version"></form:hidden>
                    <div class="row">
                        <div class="form-group">
                            <div class="col-sm-4">
                                <label for="inputVehicleMakeName" id="title" class="d-flex justify-content-center">Make</label>
                                <form:input path="vehicleMakeName" type="text" id="inputVehicleMakeName" cssClass="form-control"></form:input>
                            </div>
                        </div>
                    </div>
                    <div>
                        <c:forEach items="${vehicleMake.modelList}" var="model">
                            <form:hidden path="modelList[${idx}].id" />
                            <form:hidden path="modelList[${idx}].version"/>
                            <form:hidden path="modelList[${idx}].vehicleList"/>
                            <div class="row">
                                <div class="form-group">
                                    <div class="col-lg-4">
                                        <div class="input-group">
                                            <div>
                                                <label for="${idx}" id="title" class="d-flex justify-content-center">Model</label>
                                                <form:input path="modelList[${idx}].vehicleModelName" id="${idx}" cssClass="form-control"/>
                                            </div>
                                        </div>
                                   </div>
                                </div>
                            </div>
                            <c:set var="idx" value="${idx + 1}" scope="page"/>
                        </c:forEach>
                    </div>

                    <div class="row">
                        <div class="form-group">
                            <div class="col-sm-4">
                                <label for="inputNewModel" id="title" class="d-flex justify-content-center">Add New Model</label>
                                <input type="text" class="form-control" name="inputNewModel"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <button class="btn btn-primary">Update</button>
                    </div>

                </form:form>

            </div>


        </div>

    </div>
</div>


<%@include file="../../Includes/footer.jsp"%>