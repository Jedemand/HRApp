<%@include file="../../Includes/header.jsp"%>
<%@include file="../../Includes/navbar.jsp"%>
<%@include file="../../Includes/subnav_admin.jsp"%>

<script>
    $(document).ready(function(){
        //attach and on click
        $('#removeVehicle').click(function(){
            //log name of button and contents of associated textbox
            console.log(this.name);
            //clear the values
            $('#'+ this.year).val(0)
            $('#'+ this.licensePlate).val('')
            $('#'+ this.VIN).val('')
            $('#'+ this.color).val('')
            $('#'+ this.purchasePrice).val(0)
            //submit form
            $('#vehicleMake').submit();
        });
    });
</script>

<div class="wrapper">

    <%--sidebar--%>
    <div class="d-flex justify-content-center">
        <%@include file="vehicle_sidebar.jsp"%>
        <div id="main-wrapper" class="col-sm-10">
            <div class="col-sm-8">

                <form:form action="/admin/vehicle/update/model" modelAttribute="vehicleModel" class="form-horizontal" method="post">
                    <c:set var="idx2" value="0" scope="page"/>
                    <form:hidden path="id"></form:hidden>
                    <form:hidden path="version"></form:hidden>
                    <div class="row">
                        <div class="form-group">
                           <div class="col-lg-8">
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
                                    <div class="col-lg-8">
                                        <label for="${idx2}"  id="title" class="d-flex justify-content-center">Vehicle</label>
                                        <div>
                                            <label for="inputVehicle" class="col-lg-2"></label>
                                            <form:input path="vehicleList[${idx2}].year" type="int" class="form-control" id="inputVehicle" placeholder="Year"/>
                                            <form:input path="vehicleList[${idx2}].licensePlate" type="text" class="form-control" id="inputModel" placeholder="License Plate"/>
                                            <form:input path="vehicleList[${idx2}].VIN" type="text" class="form-control" id="inputModel" placeholder="VIN#"/>
                                            <form:input path="vehicleList[${idx2}].color" type="text" class="form-control" id="inputModel" placeholder="Color"/>
                                            <form:input path="vehicleList[${idx2}].purchasePrice" type="int" class="form-control" id="inputModel" placeholder="Price"/>
                                        </div>
                                        <span class="input-group-btn">
                                          <button name="${idx2}" class="btn btn-default remove_button" type="button" id="removeVehicle">Remove</button>
                                      </span>
                                    </div>
                                </div>
                            </div>
                       <c:set var="idx2" value="${idx2 + 1}" scope="page"/>
                        </c:forEach>
                        <div class="row">
                            <button class="btn btn-primary col-lg-7">Update</button>
                        </div>
                    </div>









                </form:form>

            </div>


        </div>

    </div>
</div>


<%@include file="../../Includes/footer.jsp"%>