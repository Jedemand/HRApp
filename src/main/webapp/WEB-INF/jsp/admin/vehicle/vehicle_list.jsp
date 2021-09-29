<%@include file="../../Includes/header.jsp"%>
<%@include file="../../Includes/navbar.jsp"%>
<%@include file="../../Includes/subnav_admin.jsp"%>


<div class="wrapper">
    <div class="d-flex justify-content-center">
        <%@include file="vehicle_sidebar.jsp"%>
        <div id="main-wrapper" class="col-sm-10">
            <div class="col-sm-12">
                <%--LIST OF EXISTING Vehicles--%>
                <table class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Year</th>
                        <th>License Plate</th>
                        <th>VIN#</th>
                        <th>Color</th>
                        <%--<th>Purchased</th>--%>
                        <th>Price</th>
                        <th>Model</th>
                        <th>Make</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="vehicleMake" items="${makeList}">
                        <c:forEach var="vehicleModel" items="${vehicleMake.getModelList()}">
                            <c:forEach var="vehicle" items="${vehicleModel.getVehicleList()}">
                                <tr>
                                    <td>${vehicle.id}</td>
                                    <td>${vehicle.year}</td>
                                    <td>${vehicle.licensePlate}</td>
                                    <td>${vehicle.VIN}</td>
                                    <td>${vehicle.color}</td>
                                    <%--<td>${vehicle.purchased}</td>--%>
                                    <td>${vehicle.purchasePrice}</td>
                                    <td>${vehicleModel.vehicleModelName}</td>
                                    <td>${vehicleMake.vehicleMakeName}</td>
                                    <td><a href="/admin/vehicle/edit/${vehicle.id}">Edit</a> </td>
                                    <td><a href="/admin/vehicle/delete/${vehicle.id}">Delete</a> </td>
                                </tr>
                            </c:forEach>
                        </c:forEach>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<%@include file="../../Includes/footer.jsp"%>