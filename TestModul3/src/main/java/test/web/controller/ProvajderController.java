package test.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.model.Provajder;
import test.service.ProvajderService;
import test.support.ProvajderToProvajderDTO;
import test.web.dto.ProvajderDTO;


@RestController
@RequestMapping(value = "/api/provajderi", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProvajderController {

	@Autowired
	private ProvajderService provajderService;
	
	@Autowired //konverter
	private ProvajderToProvajderDTO toDTO;
	
	@GetMapping()
	public ResponseEntity<List<ProvajderDTO>> getAll(){
		List<Provajder> tarife = provajderService.findAll();
		return new ResponseEntity<> (toDTO.convert(tarife), HttpStatus.OK);
	}
}
