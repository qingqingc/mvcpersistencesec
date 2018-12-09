<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show all resources</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.12.3.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/plugin/jquery-ui.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/plugin/pqgrid.min.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/js/plugin/jquery-ui.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/plugin/pqgrid.min.css" />
    
    
    <script type="text/javascript">
        $(function() {
        	
        	var ajaxObj = {
                    dataType: "JSON",
                    beforeSend: function () {
                        this.pqGrid("showLoading");
                    },
                    complete: function () {
                        this.pqGrid("hideLoading");
                    },
                    error: function () {
                        this.pqGrid("rollback");
                    }
                };
        	
        	function update(rowIndx, $grid) {
                if (!$grid.pqGrid("saveEditCell")) {
                    return false;
                }

                var rowData = $grid.pqGrid("getRowData", { rowIndx: rowIndx });
                console.log(rowData[1]);
                var isValid = $grid.pqGrid("isValid", { rowData: rowData }).valid;
                if (!isValid) {
                    return false;
                }
                var isDirty = true;//$grid.pqGrid("isDirty");
                if (isDirty) {
                    var recIndx = $grid.pqGrid("option", "dataModel.recIndx");

                    $grid.pqGrid("removeClass", { rowIndx: rowIndx, cls: 'pq-row-edit' });

                    var url;
                    if (rowData[recIndx] == null) {
                        //url to add records.
                        /* url = "${pageContext.request.contextPath}/auth/role/findAllRoles"; */
                    	url = "${pageContext.request.contextPath}/auth/role/updateResource";
                    }
                    else {
                        //url to  update records.
                        url = "${pageContext.request.contextPath}/auth/role/updateResource";
                    }
                    $.ajax($.extend({}, ajaxObj, {
                        context: $grid,
                        url: url,
                        type: "POST",  
                        data: {"rowData": rowData},
                        success: function (response) {
                            /* var recIndx = $grid.pqGrid("option", "dataModel.recIndx");
                            if (rowData[recIndx] == null) {
                                rowData[recIndx] = response.recId;
                            } */
                            $grid.pqGrid("removeClass", { rowIndx: rowIndx, cls: 'pq-row-edit' });
                            $grid.pqGrid("commit");
                        }
                    }));
                }
                else {
                    $grid.pqGrid("quitEditMode");
                    $grid.pqGrid("removeClass", { rowIndx: rowIndx, cls: 'pq-row-edit' });
                    $grid.pqGrid("refreshRow", { rowIndx: rowIndx });
                }
            }
        	
            function isEditing($grid) {
                var rows = $grid.pqGrid("getRowsByClass", { cls: 'pq-row-edit' });
                if (rows.length > 0) {
                    //focus on editor if any 
                    $grid.find(".pq-editor-focus").focus();
                    return true;
                }
                return false;
            }
            
            function editRow(rowIndx, $grid) {
                $grid.pqGrid("addClass", { rowIndx: rowIndx, cls: 'pq-row-edit' });
                $grid.pqGrid("editFirstCellInRow", { rowIndx: rowIndx });

                //change edit button to update button and delete to cancel.
                var $tr = $grid.pqGrid("getRow", { rowIndx: rowIndx }),
                    $btn = $tr.find("button.edit_btn");
                $btn.button("option", { label: "Update", "icons": { primary: "ui-icon-check"} })
                    .unbind("click")
                    .click(function (evt) {
                        evt.preventDefault();
                        return update(rowIndx, $grid);
                    });
                $btn.next().button("option", { label: "Cancel", "icons": { primary: "ui-icon-cancel"} })
                    .unbind("click")
                    .click(function (evt) {
                        $grid.pqGrid("quitEditMode");
                        $grid.pqGrid("removeClass", { rowIndx: rowIndx, cls: 'pq-row-edit' });
                        $grid.pqGrid("refreshRow", { rowIndx: rowIndx });
                        $grid.pqGrid("rollback");
                    });
            }
            
            function deleteRow(rowIndx, $grid) {
                $grid.pqGrid("addClass", { rowIndx: rowIndx, cls: 'pq-row-delete' });
                var rowData = $grid.pqGrid("getRowData", { rowIndx: rowIndx });
                var ans = window.confirm("Are you sure to delete row No " + (rowIndx + 1) + "?");

                if (ans) {
                    $grid.pqGrid("deleteRow", { rowIndx: rowIndx, effect: true });

                    var rowId = $grid.pqGrid("getRecId", { rowIndx: rowIndx });
                    $.ajax($.extend({}, ajaxObj, {
                        context: $grid,
                        url: "${pageContext.request.contextPath}/auth/role/deleteResource",
                        data: {"rowData": rowData},
                        success: function () {
                            $grid.pqGrid("commit");
                            $grid.pqGrid("refreshDataAndView");
                        },
                        error: function () {
                            //debugger;
                            $grid.pqGrid("removeClass", { rowData: rowData, cls: 'pq-row-delete' });
                            $grid.pqGrid("rollback");
                        }
                    }));
                }
                else {
                    $grid.pqGrid("removeClass", { rowIndx: rowIndx, cls: 'pq-row-delete' });
                }
            }
            
            var tbl = $("table.test");
            var obj = $.paramquery.tableToArray(tbl);
            var newObj = {width:1000, height:400, title:"Grid For test", flexWidth:false};
            newObj.dataModel = {data: obj.data,recIndx: obj.data[1].title};
            newObj.colModel = obj.colModel;
            newObj.pageModel = {rPP:5, type:"local"};
            newObj.editModel = {
                saveKey: $.ui.keyCode.ENTER
            },
            newObj.editable = function (ui) {
                var $grid = $(this);
                var rowIndx = ui.rowIndx;
                if ($grid.pqGrid("hasClass", { rowIndx: rowIndx, cls: 'pq-row-edit' }) == true) {
                    return true;
                }
                else {
                    return false;
                }
            };
            newObj.refresh = function() {
            	var $grid = $(this);
                if (!$grid) {
                    return;
                }
                //delete button
                $grid.find("button.delete_btn").button({ icons: { primary: 'ui-icon-close'} })
                .unbind("click")
                .bind("click", function (evt) {
                    if (isEditing($grid)) {
                        return false;
                    }
                    var $tr = $(this).closest("tr"),
                        rowIndx = $grid.pqGrid("getRowIndx", { $tr: $tr }).rowIndx;
                    deleteRow(rowIndx, $grid);
                });
                //edit button
                $grid.find("button.edit_btn").button({ icons: { primary: 'ui-icon-pencil'} })
                .unbind("click")
                .bind("click", function (evt) {
                    if (isEditing($grid)) {
                        return false;
                    }
                    var $tr = $(this).closest("tr"),
                        rowIndx = $grid.pqGrid("getRowIndx", { $tr: $tr }).rowIndx;
                    editRow(rowIndx, $grid);
                    return false;
                });
                
                $grid.find("button.viewDetail_btn").button({ icons: { primary: 'ui-icon-pencil'} })
                .unbind("click")
                .bind("click", function (evt) {           
                    var $tr = $(this).closest("tr"),
                        rowIndx = $grid.pqGrid("getRowIndx", { $tr: $tr }).rowIndx;
                    alert(rowIndx);
                    return false;
                });                

                //rows which were in edit mode before refresh, put them in edit mode again.
                var rows = $grid.pqGrid("getRowsByClass", { cls: 'pq-row-edit' });
                if (rows.length > 0) {
                    var rowIndx = rows[0].rowIndx;
                    editRow(rowIndx, $grid);
                }
            };
            $("#grid_table").pqGrid(newObj);
            tbl.css("display", "none");       
            var t = true;
        });
</script>
</head>
<body>
    Show all resources:
    <div id="grid_table"></div>
        <table class="test">
            <tbody>
	            <tr valign="middle">
	                 <th>index</th>
	                 <th>id</th>
	                 <th>name</th>
	                 <th>operation</th>
	            </tr>
	            <c:forEach items="${resources}" var="sta" varStatus="status">
	                <tr>
	                     <td>${status.index }</td>
	                     <td>${sta.id }</td>
	                     <td>${sta.name }</td>
	                     <td>
	                        <button type='button' class='edit_btn'>Edit</button>\
                            <button type='button' class='delete_btn'>Delete</button>
                            \<button type='button' class='viewDetail_btn'>View Detail</button>
                         </td>	                                       
	                </tr>
	            </c:forEach>
	         </tbody>
        </table>
</body>
</html>