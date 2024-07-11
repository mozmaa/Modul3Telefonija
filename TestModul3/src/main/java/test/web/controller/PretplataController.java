package test.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import test.model.Pretplata;
import test.service.PretplataService;
import test.support.PretplataDTOToPretplata;
import test.support.PretplataToPretplataDTO;
import test.web.dto.PretplataDTO;

@RestController
@RequestMapping(value = "/api/pretplate", produces = MediaType.APPLICATION_JSON_VALUE)
public class PretplataController {

	@Autowired
	private PretplataService pretplataService;
	
	@Autowired
	private PretplataDTOToPretplata toPretplata;
	
	@Autowired
	private PretplataToPretplataDTO toDTO;
	
	@PreAuthorize("permitAll()")
	@GetMapping
    public ResponseEntity<List<PretplataDTO>> getAll(
            @RequestParam(required=false) String datumPocetkaOd,
            @RequestParam(required=false) String datumPocetkaDo,
            @RequestParam(required=false) Long tarifaId,
            @RequestParam(value = "pageNo", defaultValue = "0") int pageNo){

        Page<Pretplata> page = pretplataService.find(datumPocetkaOd, datumPocetkaDo, tarifaId, pageNo);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Total-Pages", Integer.toString(page.getTotalPages()));

        return new ResponseEntity<>(toDTO.convert(page.getContent()),headers, HttpStatus.OK);
    }
	
	 @GetMapping("/{id}")
	 public ResponseEntity<PretplataDTO> getOne(@PathVariable Long id){
		 Pretplata pretplata = pretplataService.findOneById(id);

	     if(pretplata != null) {
	         return new ResponseEntity<>(toDTO.convert(pretplata), HttpStatus.OK);
	     }else {
	         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	     }
	 }
	 
	 @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<PretplataDTO> create(@Valid @RequestBody PretplataDTO pretplataDTO){
		 Pretplata pretplata = toPretplata.convert(pretplataDTO);

	        if(pretplata.getTarifa() == null || pretplata.getProvajder() == null) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
	        Pretplata savedPretplata = pretplataService.save(pretplata);
	        
	        
	        return new ResponseEntity<>(toDTO.convert(savedPretplata), HttpStatus.CREATED);
	    }
	 
	 @PutMapping(value= "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<PretplataDTO> update(@PathVariable Long id, @Valid @RequestBody PretplataDTO pretplataDTO){

	        if(!id.equals(pretplataDTO.getId())) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }

	        Pretplata pretplata = toPretplata.convert(pretplataDTO);

	        if(pretplata.getTarifa() == null || pretplata.getProvajder() == null) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
	        
	        Pretplata savedPretplata = pretplataService.save(pretplata);

	        return new ResponseEntity<>(toDTO.convert(savedPretplata),HttpStatus.OK);
	    }
	 
	 @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Long id){
		 Pretplata deletedPretplata = pretplataService.delete(id);

	        if(deletedPretplata != null) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
}
