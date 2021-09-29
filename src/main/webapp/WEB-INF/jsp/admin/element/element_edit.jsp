<%@include file="../../Includes/header.jsp"%>
<%@include file="../../Includes/navbar.jsp"%>
<%@include file="../../Includes/subnav_admin.jsp"%>

<script>
    $(document).ready(function(){
        //attach and on click
        $('.remove_button').click(function(){
            //log name of button and contents of associated textbox
            console.log(this.name);
            console.log($('#'+ this.name).val());
            //clear the values
            $('#'+ this.name).val('')
            //submit form
            $('#elementType').submit();
        });
    });
</script>

<div class="wrapper">

    <%--sidebar--%>
    <div class="d-flex justify-content-center">
        <%@include file="element_sidebar.jsp"%>
        <div id="main-wrapper" class="col-sm-10">
            <div class="col-sm-8">
                <c:set var="idx" value="0" scope="page"/>
                <form:form action="/admin/element/update" modelAttribute="elementType" class="form-horizontal" method="post">
                    <form:hidden path="id"></form:hidden>
                    <form:hidden path="version"></form:hidden>

                    <div class="row">
                        <div class="form-group">
                            <label for="inputElementTypeName" class="col-sm-2 control-label">Element Type</label>
                            <div class="col-sm-8">
                                <form:input path="elementTypeName" type="text" id="inputElementTypeName" cssClass="form-control"></form:input>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-8">
                            <hr>
                        </div>
                    </div>

                    <c:forEach items="${elementType.elementList}" var="element">
                        <form:hidden path="elementList[${idx}].id" />
                        <form:hidden path="elementList[${idx}].version"/>
                        <div class="row">
                            <div class="form-group">
                                <label for="${idx}" class="col-sm-3 control-label">Element</label>
                                <div class="col-sm-7">
                                    <div class="input-group">
                                        <form:input path="elementList[${idx}].elementName" id="${idx}" cssClass="form-control"/>
                                            <span class="input-group-btn">
                                                <button name="${idx}" class="btn btn-default remove_button" type="button">Remove</button>
                                            </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <c:set var="idx" value="${idx + 1}" scope="page"/>
                    </c:forEach>

                    <div class="row">
                        <div class="form-group">
                            <label for="inputNewElement" class="col-sm-3 control-label">Add New Element</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="inputNewElement"/>
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