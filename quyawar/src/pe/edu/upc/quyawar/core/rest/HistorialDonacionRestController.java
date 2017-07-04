package pe.edu.upc.quyawar.core.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import pe.edu.upc.quyawar.core.model.entity.HistorialDonacion;
import pe.edu.upc.quyawar.core.service.HistorialDonacionService;

/**
 * Clase Controller que da soporte para las solicitudes de manteniento de Historial Donacion
 * 
 * @author Jober Mena
 * 
 */

@RestController
public class HistorialDonacionRestController {
	
	@Autowired
	private HistorialDonacionService historialDonacionService;
	
	@RequestMapping(value = "/historialDonacion/", method = RequestMethod.GET)
	public ResponseEntity<List<HistorialDonacion>> listAllHistorialDonacions() throws Exception {
		List<HistorialDonacion> historialDonacions = historialDonacionService.buscar(new HistorialDonacion(), null);
		if (historialDonacions.isEmpty()) {
			return new ResponseEntity<List<HistorialDonacion>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<HistorialDonacion>>(historialDonacions, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/historialDonacion/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HistorialDonacion> getHistorialDonacion(@PathVariable("id") Integer id) throws Exception {
		System.out.println("Fetching HistorialDonacion with id " + id);
		HistorialDonacion historialDonacion = historialDonacionService.buscarById(new HistorialDonacion(id));
		if (historialDonacion == null) {
			System.out.println("HistorialDonacion with id " + id + " not found");
			return new ResponseEntity<HistorialDonacion>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<HistorialDonacion>(historialDonacion, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/historialDonacion/", method = RequestMethod.POST)
	public ResponseEntity<Void> createHistorialDonacion(@RequestBody HistorialDonacion historialDonacion, UriComponentsBuilder ucBuilder) throws Exception {
		///System.out.println("Creating HistorialDonacion " + historialDonacion.getStrNombre());
		if (historialDonacionService.buscarById(historialDonacion) != null) {
			//System.out.println("A HistorialDonacion with name " + historialDonacion.getStrNombre() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		historialDonacionService.guardar(historialDonacion);
		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(ucBuilder.path("/historialDonacion/{id}").buildAndExpand(historialDonacion.getSrlIdHistorialdonacion()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/historialDonacion/{id}", method = RequestMethod.PUT)
	public ResponseEntity<HistorialDonacion> updateHistorialDonacion(@PathVariable("id") Integer id, @RequestBody HistorialDonacion historialDonacion) throws Exception {
		System.out.println("Updating HistorialDonacion " + id);

		HistorialDonacion currentHistorialDonacion = historialDonacionService.buscarById(new HistorialDonacion(id));

		if (currentHistorialDonacion == null) {
			System.out.println("HistorialDonacion with id " + id + " not found");
			return new ResponseEntity<HistorialDonacion>(HttpStatus.NOT_FOUND);
		}

		historialDonacionService.guardar(historialDonacion);
		return new ResponseEntity<HistorialDonacion>(currentHistorialDonacion, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/historialDonacion/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<HistorialDonacion> deleteHistorialDonacion(@PathVariable("id") Integer id) throws Exception {
		System.out.println("Fetching & Deleting HistorialDonacion with id " + id);

		HistorialDonacion historialDonacion = historialDonacionService.buscarById(new HistorialDonacion(id));
		if (historialDonacion == null) {
			System.out.println("Unable to delete. HistorialDonacion with id " + id + " not found");
			return new ResponseEntity<HistorialDonacion>(HttpStatus.NOT_FOUND);
		}

		historialDonacionService.eliminar(new HistorialDonacion(id));
		return new ResponseEntity<HistorialDonacion>(HttpStatus.NO_CONTENT);
	}
	
}