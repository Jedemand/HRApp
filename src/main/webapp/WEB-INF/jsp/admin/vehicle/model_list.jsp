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
                        <th>Id</th>
                        <th>Model</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="vehicleModel" items="${modelList}">
                                <tr>
                                    <td>${vehicleModel.id}</td>
                                    <td>${vehicleModel.vehicleModelName}</td>
                                    <td><a href="/admin/vehicle/edit/model/${vehicleModel.id}">Edit</a> </td>
                                    <td><a href="/admin/vehicle/delete/model/${vehicleModel.id}">Delete</a> </td>
                                </tr>

                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<%@include file="../../Includes/footer.jsp"%>