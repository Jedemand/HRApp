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
                        <th>Make</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="vehicleMake" items="${makeList}">
                                <tr>
                                    <td>${vehicleMake.id}</td>
                                    <td>${vehicleMake.vehicleMakeName}</td>
                                    <td><a href="/admin/vehicle/edit/make/${vehicleMake.id}">Edit</a> </td>
                                    <td><a href="/admin/vehicle/delete/make/${vehicleMake.id}">Delete</a> </td>
                                </tr>

                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<%@include file="../../Includes/footer.jsp"%>