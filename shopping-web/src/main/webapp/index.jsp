<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <script src="skin/js/jquery-1.12.0.min.js"></script>
</head>
<body>
<label>快递号：</label><input id="kdNo" type="text">&nbsp;<input type="button" value="查询" onclick="find()">
<div>
    <table id="list"></table>
</div>
<script type="text/javascript">
    function find() {
        $.ajax({
            type: "GET",
            url: '/findNo.do',
            data: {
                No: $("#kdNo").val()
            },
            dataType: 'json',
            success: function (data) {
                if (data.code == 200) {
                    var html ="";
                    for(var o in data.list){
                        var my = data.list[o];
                        html+="<tr><td>"+my.AcceptTime+"</td><td>"+my.AcceptStation+"</td><tr>";
                    }
                    $("#list").html(html);
                } else {

                }
            },
            error: function (e) {
            }
        });
    }
</script>
</body>
</html>
