package pe.edu.upc.quyawar.core.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upc.quyawar.core.model.entity.Donante;
import pe.edu.upc.quyawar.core.service.DonanteService;

@RestController
@RequestMapping("/rest/donante")
public class DonanteRestController {
	@Autowired
	private DonanteService donanteService;

	@RequestMapping(method = RequestMethod.GET, value = "/editar/{intIdDonante}")
	public Donante detalle(@PathVariable Integer intIdDonante) throws Exception {
		try {
			return donanteService.buscarById(new Donante(intIdDonante));
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/grabar")
	public boolean grabar(@RequestBody Donante donante) throws Exception {
		try {
			donanteService.guardar(donante);
			return true;
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

}
