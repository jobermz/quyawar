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

import pe.edu.upc.quyawar.core.model.entity.TipoCatalogo;
import pe.edu.upc.quyawar.core.service.TipoCatalogoService;

/**
 * Clase Controller que da soporte para las solicitudes de manteniento de Tipo Catalogo
 * 
 * @author Jober Mena
 * 
 */

@RestController
public class TipoCatalogoRestController {
	
	@Autowired
	private TipoCatalogoService tipoCatalogoService;
	
	@RequestMapping(value = "/tipoCatalogo/", method = RequestMethod.GET)
	public ResponseEntity<List<TipoCatalogo>> listAllTipoCatalogos() throws Exception {
		List<TipoCatalogo> tipoCatalogos = tipoCatalogoService.buscar(new TipoCatalogo(), null);
		if (tipoCatalogos.isEmpty()) {
			return new ResponseEntity<List<TipoCatalogo>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<TipoCatalogo>>(tipoCatalogos, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/tipoCatalogo/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoCatalogo> getTipoCatalogo(@PathVariable("id") Integer id) throws Exception {
		System.out.println("Fetching TipoCatalogo with id " + id);
		TipoCatalogo tipoCatalogo = tipoCatalogoService.buscarById(new TipoCatalogo(id));
		if (tipoCatalogo == null) {
			System.out.println("TipoCatalogo with id " + id + " not found");
			return new ResponseEntity<TipoCatalogo>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<TipoCatalogo>(tipoCatalogo, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/tipoCatalogo/", method = RequestMethod.POST)
	public ResponseEntity<Void> createTipoCatalogo(@RequestBody TipoCatalogo tipoCatalogo, UriComponentsBuilder ucBuilder) throws Exception {
		///System.out.println("Creating TipoCatalogo " + tipoCatalogo.getStrNombre());
		if (tipoCatalogoService.buscarById(tipoCatalogo) != null) {
			//System.out.println("A TipoCatalogo with name " + tipoCatalogo.getStrNombre() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		tipoCatalogoService.guardar(tipoCatalogo);
		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(ucBuilder.path("/tipoCatalogo/{id}").buildAndExpand(tipoCatalogo.getSrlIdCatalogo()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/tipoCatalogo/{id}", method = RequestMethod.PUT)
	public ResponseEntity<TipoCatalogo> updateTipoCatalogo(@PathVariable("id") Integer id, @RequestBody TipoCatalogo tipoCatalogo) throws Exception {
		System.out.println("Updating TipoCatalogo " + id);

		TipoCatalogo currentTipoCatalogo = tipoCatalogoService.buscarById(new TipoCatalogo(id));

		if (currentTipoCatalogo == null) {
			System.out.println("TipoCatalogo with id " + id + " not found");
			return new ResponseEntity<TipoCatalogo>(HttpStatus.NOT_FOUND);
		}

		tipoCatalogoService.guardar(tipoCatalogo);
		return new ResponseEntity<TipoCatalogo>(currentTipoCatalogo, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/tipoCatalogo/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<TipoCatalogo> deleteTipoCatalogo(@PathVariable("id") Integer id) throws Exception {
		System.out.println("Fetching & Deleting TipoCatalogo with id " + id);

		TipoCatalogo tipoCatalogo = tipoCatalogoService.buscarById(new TipoCatalogo(id));
		if (tipoCatalogo == null) {
			System.out.println("Unable to delete. TipoCatalogo with id " + id + " not found");
			return new ResponseEntity<TipoCatalogo>(HttpStatus.NOT_FOUND);
		}

		tipoCatalogoService.eliminar(new TipoCatalogo(id));
		return new ResponseEntity<TipoCatalogo>(HttpStatus.NO_CONTENT);
	}
	
}