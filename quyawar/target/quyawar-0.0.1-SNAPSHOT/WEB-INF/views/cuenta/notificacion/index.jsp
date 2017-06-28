<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style type="text/css">
    tr.notificacion {
        cursor: pointer;
    }

    tr.sinleer {
        font-weight: bold;
        color: cadetblue;
    }

    .notificacion_asunto {
        font-weight: bold;
        color: cadetblue;
    }
</style>

<div id="mensajes"></div>
<div class="row hidden">
    <div class="col-xs-12">
        <div class="panel panel-default">
            <div class="panel-body">
                <div class="row">
                    <label class="control-label col-xs-1">CUT</label>
                    <div class="col-xs-5">
                        <input type="text" class="form-control input-sm" />
                    </div>
                    <label class="control-label col-xs-1">Asunto</label>
                    <div class="col-xs-5">
                        <input type="text" class="form-control input-sm" />
                    </div>
                </div>
                <br />
                <div class="row">
                    <label class="control-label col-xs-1">Tipo</label>
                    <div class="col-xs-5">
                        <input type="text" class="form-control input-sm" />
                    </div>
                    <label class="control-label col-xs-1">Fecha</label>
                    <div class="col-xs-5">
                        <input type="text" class="form-control input-sm" />
                    </div>
                </div>
                <br />
                <div class="row">
                    <div class="pull-right" style="margin-right: 10px;">
                        <div class="btn-group">
                            <button class="btn btn-success"><i class="fa fa-search"></i> Buscar</button>
                            <button class="btn btn-danger"><i class="fa fa-eraser"></i> Cancelar</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
<div class="row">
    <div class="col-xs-12">
        <div class="box box-success">
            <div class="box-header hidden">
                <h3 class="box-title">Hover Data Table</h3>
            </div>

            <div class="box-body"> 
           		<div id="divSinDatos" >
           			<div class="callout callout-default">
		               <h4>No cuenta con Notificaciones emitidas.</h4>
		             </div>
           		</div>
				<div id="divConDatos" class="table-responsive">
                    <table id="tbNotificacion" class="table table-striped table-bordered table-hover" 
                    	data-pagesize="20" data-page="1" data-totalrows="0" data-function="ListarTablaNotificacion" data-paginator="Paginacion">
                        <thead>
                            <tr>
                                <th style="width: 50px">#</th>
                                <th style="width: 150px">Fecha</th>
                                <th>Asunto</th>
                            </tr>
                        </thead>
                       	<tbody>
<%--                        		<c:set var="nro" value="1" /> --%>
<%--                        		<c:forEach items="${lista}" var="notif"> --%>
<%--                        			<c:set var="sinleer" value="${notif.isBolLeido() ? '' : 'sinleer'}" /> --%>
<%--                        			<c:out value="" /> --%>
<%--                        			<tr class="notificacion <c:out value="${sinleer}" />" data-id="<c:out value="${notif.getSrlIdNotificacion()}" />" > --%>
<%--                                 	<td><c:out value="${nro}" /></td> --%>
<%-- 	                                <td><c:out value="${notif.getDteFecNotificacion()}" /></td> --%>
<!-- 	                                <td> -->
<!-- 	                                    <i class="fa fa-envelope"></i> -->
<%-- 	                                    <c:out value="${notif.getVarAsunto()}" /> --%>
<!-- 	                                </td> -->
<!-- 	                            </tr>    -->
<%-- 	                            <c:set var="nro" value="${nro + 1}" />                    		 --%>
<%--                        		</c:forEach> --%>
                       	</tbody>
                    </table>
                    <div id="Paginacion"></div>
            	</div>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="modal-ventana">
    <div id="ventana-container">
        
    </div>
</div>

<script>
    $(document).ready(function () {
		
    	ListarTablaNotificacion('tbNotificacion', 1);
    	
        $(document).on('click', '#tbNotificacion tbody tr', function (e) {
        	verNotificacion($(this));
        });
    });
    
    function ListarTablaNotificacion (table, page) {
        table = $('#' + table);
        //var model = {'id' : equipoId, 'page' : page, 'pagesize': table.data('pagesize')};
        $.ajax({
            url : ves.string.format('/ves_extranet/cuenta/notificacion/listar/{0}/1', $('#hidIdSolicitante').val()),
            type : "GET",
            data : {},
            dataType: "json",
            beforeSend : function (data) {
                ves.wait.append('mensajes');
            },
            complete: function (data) {
                ves.wait.remove('mensajes');
            },
            success: function (data) {
                table.data('page', page);
                table.data('totalrows', data.totalRows);
                if(data.totalRows > 0) {
                	$('#divConDatos').show();                	
                	$('#divSinDatos').hide();
                	GenerarTablaNotificacion(table, data.lista);
                } else {
                	$('#divConDatos').hide();                	
                	$('#divSinDatos').show();
                }
                
            },
            error: function (data) {
                console.log("error");
            }
        });
    };

    var GenerarTablaNotificacion = function(table, lista) {
        var tabla = table.children('tbody');
        tabla.children('tr').remove();
        var rows = '';
        if (lista.length > 0) {
            var numero = (table.data('pagesize') * table.data('page')) - table.data('pagesize');
            $.each(lista, function(i, r) {
                rows += ves.string.format('<tr class="notificacion {3}" data-id="{4}"><td>{0}</td><td>{1}</td><td><i class="fa fa-envelope"></i> {2}</td></tr>',
                        ++numero, r.dteFecNotificacion, r.varAsunto, r.bolLeido ? '' : 'sinleer', r.srlIdNotificacion);
            });
            tabla.append(rows);
            ves.pagination.update(table);
        }
    };
    
    var verNotificacion = function (tr) {
    	$.ajax({
            type: "GET",
            url: "/ves_extranet/cuenta/notificacion/ver/" + tr.data('id'),
            data: {},
            cache: false,
            beforeSend: function () {
                ves.wait.modal('ventana-container');
                $('#modal-ventana').modal('show');
            },
            complete: function () { },
            success: function (data) {
                $('#ventana-container').html(data);
                if (tr.hasClass('sinleer')) tr.removeClass('sinleer');
            },
            error: function (result) {
                $('#modal-ventana').modal('hide');
                //sga.error.show('mensajes', result.responseText);
            }
        });
    };
    
    var printNotificacion = function() {
    	 var divName = 'modal-ventana';
	     var printContents = document.getElementById(divName).innerHTML;
	     //var originalContents = document.body.innerHTML;
		
	     var wPrint = window.open('', '_blank');
	     wPrint.document.body.innerHTML = printContents;
	     wPrint.print();

	     //document.body.innerHTML = originalContents;
	};
</script>