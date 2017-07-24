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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import pe.edu.upc.quyawar.core.model.entity.Ubigeo;
import pe.edu.upc.quyawar.core.service.UbigeoService;

/**
 * Clase Controller que da soporte para las solicitudes de manteniento de Ubigeo
 * 
 * @author Jober Mena
 * 
 */

@RestController
public class UbigeoRestController {
	
	@Autowired
	private UbigeoService ubigeoService;
	
	@RequestMapping(value = "/ubigeo/", method = RequestMethod.GET)
	public ResponseEntity<List<Ubigeo>> listAllUbigeos(@RequestParam(required=false) Integer intIdDepartamento, @RequestParam(required=false) Integer intIdProvincia, @RequestParam(required=false) Integer intIdDistrito) throws Exception {
		Ubigeo ubigeoBuscar = new Ubigeo();
		if(intIdDepartamento != null) {
			ubigeoBuscar.setIntIdDepartamento(intIdDepartamento);
		}
		if(intIdProvincia != null) {
			ubigeoBuscar.setIntIdProvincia(intIdProvincia);
		}
		if(intIdDistrito != null) {
			ubigeoBuscar.setIntIdDistrito(intIdDistrito);
		}
		List<Ubigeo> ubigeos = ubigeoService.buscar(ubigeoBuscar, null);
		if (ubigeos.isEmpty()) {
			return new ResponseEntity<List<Ubigeo>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Ubigeo>>(ubigeos, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/ubigeo/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ubigeo> getUbigeo(@PathVariable("id") Integer id) throws Exception {
		System.out.println("Fetching Ubigeo with id " + id);
		Ubigeo ubigeo = ubigeoService.buscarById(new Ubigeo(id));
		if (ubigeo == null) {
			System.out.println("Ubigeo with id " + id + " not found");
			return new ResponseEntity<Ubigeo>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Ubigeo>(ubigeo, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/ubigeo/", method = RequestMethod.POST)
	public ResponseEntity<Void> createUbigeo(@RequestBody Ubigeo ubigeo, UriComponentsBuilder ucBuilder) throws Exception {
		///System.out.println("Creating Ubigeo " + ubigeo.getStrNombre());
		if (ubigeoService.buscarById(ubigeo) != null) {
			//System.out.println("A Ubigeo with name " + ubigeo.getStrNombre() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		ubigeoService.guardar(ubigeo);
		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(ucBuilder.path("/ubigeo/{id}").buildAndExpand(ubigeo.getSrlIdUbigeo()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/ubigeo/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Ubigeo> updateUbigeo(@PathVariable("id") Integer id, @RequestBody Ubigeo ubigeo) throws Exception {
		System.out.println("Updating Ubigeo " + id);

		Ubigeo currentUbigeo = ubigeoService.buscarById(new Ubigeo(id));

		if (currentUbigeo == null) {
			System.out.println("Ubigeo with id " + id + " not found");
			return new ResponseEntity<Ubigeo>(HttpStatus.NOT_FOUND);
		}

		ubigeoService.guardar(ubigeo);
		return new ResponseEntity<Ubigeo>(currentUbigeo, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/ubigeo/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Ubigeo> deleteUbigeo(@PathVariable("id") Integer id) throws Exception {
		System.out.println("Fetching & Deleting Ubigeo with id " + id);

		Ubigeo ubigeo = ubigeoService.buscarById(new Ubigeo(id));
		if (ubigeo == null) {
			System.out.println("Unable to delete. Ubigeo with id " + id + " not found");
			return new ResponseEntity<Ubigeo>(HttpStatus.NOT_FOUND);
		}

		ubigeoService.eliminar(new Ubigeo(id));
		return new ResponseEntity<Ubigeo>(HttpStatus.NO_CONTENT);
	}
	
}