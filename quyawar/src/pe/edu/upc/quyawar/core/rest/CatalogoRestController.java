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

import pe.edu.upc.quyawar.core.model.entity.Catalogo;
import pe.edu.upc.quyawar.core.model.entity.TipoCatalogo;
import pe.edu.upc.quyawar.core.service.CatalogoService;

/**
 * Clase Controller que da soporte para las solicitudes de manteniento de Catalogo
 * 
 * @author Jober Mena
 * 
 */

@RestController
public class CatalogoRestController {
	
	@Autowired
	private CatalogoService catalogoService;
	
	@RequestMapping(value = "/catalogo/", method = RequestMethod.GET)
	public ResponseEntity<List<Catalogo>> listAllCatalogos(@RequestParam(required=false) Integer idTipoCatalogo) throws Exception {
		Catalogo catalogoBuscar = new Catalogo();
		if(idTipoCatalogo != null) {
			catalogoBuscar.setIdTipoCatalogo(new TipoCatalogo(idTipoCatalogo));
		}
		List<Catalogo> catalogos = catalogoService.buscar(catalogoBuscar, null);
		if (catalogos.isEmpty()) {
			return new ResponseEntity<List<Catalogo>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Catalogo>>(catalogos, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/catalogo/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Catalogo> getCatalogo(@PathVariable("id") Integer id) throws Exception {
		System.out.println("Fetching Catalogo with id " + id);
		Catalogo catalogo = catalogoService.buscarById(new Catalogo(id));
		if (catalogo == null) {
			System.out.println("Catalogo with id " + id + " not found");
			return new ResponseEntity<Catalogo>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Catalogo>(catalogo, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/catalogo/", method = RequestMethod.POST)
	public ResponseEntity<Void> createCatalogo(@RequestBody Catalogo catalogo, UriComponentsBuilder ucBuilder) throws Exception {
		///System.out.println("Creating Catalogo " + catalogo.getStrNombre());
		if (catalogoService.buscarById(catalogo) != null) {
			//System.out.println("A Catalogo with name " + catalogo.getStrNombre() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		catalogoService.guardar(catalogo);
		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(ucBuilder.path("/catalogo/{id}").buildAndExpand(catalogo.getSrlIdCatalogo()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/catalogo/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Catalogo> updateCatalogo(@PathVariable("id") Integer id, @RequestBody Catalogo catalogo) throws Exception {
		System.out.println("Updating Catalogo " + id);

		Catalogo currentCatalogo = catalogoService.buscarById(new Catalogo(id));

		if (currentCatalogo == null) {
			System.out.println("Catalogo with id " + id + " not found");
			return new ResponseEntity<Catalogo>(HttpStatus.NOT_FOUND);
		}

		catalogoService.guardar(catalogo);
		return new ResponseEntity<Catalogo>(currentCatalogo, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/catalogo/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Catalogo> deleteCatalogo(@PathVariable("id") Integer id) throws Exception {
		System.out.println("Fetching & Deleting Catalogo with id " + id);

		Catalogo catalogo = catalogoService.buscarById(new Catalogo(id));
		if (catalogo == null) {
			System.out.println("Unable to delete. Catalogo with id " + id + " not found");
			return new ResponseEntity<Catalogo>(HttpStatus.NOT_FOUND);
		}

		catalogoService.eliminar(new Catalogo(id));
		return new ResponseEntity<Catalogo>(HttpStatus.NO_CONTENT);
	}
	
}