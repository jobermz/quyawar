<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

   <div class="modal-dialog">
      <div class="modal-content">
          <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
              </button>
              <h4 class="modal-title notificacion_asunto">${notificacion.getVarAsunto()}</h4>
          </div>
          <div class="modal-body">
              <span class="mailbox-read-time pull-right">${notificacion.getDteFecNotificacion()}</span>
              ${notificacion.getTxtContenido()}
          </div>
          <div class="modal-footer hidden">
              
          </div>
          <div class="modal-footer">
          	  <button id="btnImprimir" type="button" class="btn btn-default btn-sm" ><i class="fa fa-print"></i> Imprimir</button>
              <button type="button" class="btn btn-danger btn-sm" data-dismiss="modal"><i class="fa fa-arrow-left"></i> Volver</button>
          </div>
      </div>
  </div>
  <script>
  	$(document).ready(function (){
  		
  		$('#btnImprimir').click(function (e) {
  			printNotificacion();
  		});
  		
  	});
  </script>