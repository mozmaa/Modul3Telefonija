package test.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.model.Tarifa;
import test.service.TarifaService;
import test.support.TarifaToTarifaDTO;
import test.web.dto.TarifaDTO;


@RestController
@RequestMapping(value = "/api/tarife", produces = MediaType.APPLICATION_JSON_VALUE)
public class TarifaController {
	
	@Autowired
	private TarifaService tarifaService;
	
	@Autowired
	private TarifaToTarifaDTO toDTO;

	@GetMapping()
	public ResponseEntity<List<TarifaDTO>> getAll(){
		List<Tarifa> tarife = tarifaService.findAll();
		return new ResponseEntity<> (toDTO.convert(tarife), HttpStatus.OK);
	}
}
