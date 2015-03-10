<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>즐거운 장비 현황list</title>

    <script src="http://jashkenas.github.io/underscore/underscore-min.js"></script>
	<script src="http://code.jquery.com/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
	<script src="http://path/to/your/copy/of/jquery.blockUI.js"></script>
	<link 	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"
          	rel="stylesheet" type="text/css" />

<script>
$("button[name=listRender]").click(function () {

    data = [];

    $.post("./selectGearList", function (data) {
			console.log("sdfgdgdgfdgfdfgd");
        $("table[name=table01] tbody tr").remove();

        _.each(data, function (obj) {

            var checkbox = "<input type='checkbox' name='chkInfo' class='mycheck' value='" + obj.id + "'/>";

            var $tr = $("<tr name='" + obj.id + "'>"
            + "<td>" + checkbox + "</td>"
            + "<td>" + obj.id + "</td>"
            + "<td>" + obj.name + "</td>"
            + "<td>" + obj.snno + "</td>"
            + "<td>" + obj.rental + "</td>"
            + "<td>" + obj.day + "</td>"
            + "<td>" + obj.tel + "</td>"
            + "</tr>");

            $tr.appendTo("table[name=table01] tbody");
        }, "json");
    });
});    


</script>    

</head>


<body>

<div class="modal fade" id="modal_pop">
    <div class="modal-dialog">
        <div class="modal-content">
        <!-- header-->
            <div class="modal-header">
                <div class="modal-body">
<div class="form-horizontal" role="form" name="inputArea" style="background-color: beige">
<!--<div name="inputArea" class="well">-->
    <div class="form-group">
        <label class="col-md-6 control-label">저장값 입력</label>
    </div>

    <div class="form-group">
        <label class="col-lg-3 control-label">ID</label>
        <div class="col-lg-6">
            <input type="text" class="form-control" name="id" placeholder="id">
        </div>
    </div>

    <div class="form-group">
        <label class="col-lg-3 control-label">이름</label>
        <div class="col-lg-6">
        <input type="text" class="form-control" name="name" placeholder="name">
        </div>
    </div>

    <div class="form-group">
        <label class="col-lg-3 control-label">제품시리얼</label>
        <div class="col-lg-6">
        <input type="text" class="form-control" name="snno" placeholder="snno">
        </div>
    </div>

    <div class="form-group">
        <label class="col-lg-3 control-label">렌탈여부</label>
        <div class="col-lg-6">
        <input type="text" class="form-control" name="rental" placeholder="rental">
        </div>
    </div>

    <div class="form-group">
        <label class="col-lg-3 control-label">렌탈일</label>
        <div class="col-lg-6">
        <input type="text" class="form-control" name="day" placeholder="day">
        </div>
    </div>

    <div class="form-group">
        <label class="col-lg-3 control-label">전화번호</label>
        <div class="col-lg-6">
        <input type="text" class="form-control" name="tel" placeholder="tel">
        </div>
    </div>

    <p>
    <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
    <button class="btn btn-default btn-primary btn-success" name="save"> <i class="glyphicon glyphicon-floppy-saved"></i>저장</button>

    </p>

</div>
                </div>
            </div>
        </div>
    </div>
</div>

<!--<form class="form-horizontal" role="form" name="listArea">-->
<div name ="listArea" class="well">

    <p><button class="btn btn-default btn-primary btn-info" name="listRender"><i class="glyphicon glyphicon-search"></i>조회</button>
        <button class="btn btn-default btn-primary btn-danger" name="del"><i class="glyphicon glyphicon-floppy-remove"></i>삭제</button>
        <button class="btn btn-default btn-primary btn btn-warning" name="redact" class="openmodal"><i class="glyphicon glyphicon-floppy-save"></i>수정</button>
        <button class="btn btn-default btn-primary btn btn-success" name="save" data-target="#modal_pop" data-toggle="modal"><i class="glyphicon glyphicon-floppy-open"></i>저장</button>
    </p>

    <table name="table01" class="table table-bordered table-condensed table-hover table-striped ">
        <thead>
        <th class="success"><input type="checkbox" name="all" id="all_box" value="전체선택"/></th>
        <th class="success">ID</th>
        <th class="success">이름</th>
        <th class="success">제품시리얼</th>
        <th class="success">렌탈여부</th>
        <th class="success">렌탈일</th>
        <th class="success" >전화번호</th>
        </thead>
        <tbody>

        </tbody>
    </table>


</div>

</body>
</html>