package test.support;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import test.model.Pretplata;
import test.model.Provajder;
import test.web.dto.ProvajderDTO;

@Component
public class ProvajderToProvajderDTO implements Converter<Provajder, ProvajderDTO> {

	@Override
	public ProvajderDTO convert(Provajder provajder) {
		ProvajderDTO dto = new ProvajderDTO();
		dto.setId(provajder.getId());
		dto.setNaziv(provajder.getNaziv());
		dto.setAdresa(provajder.getAdresa());
		LinkedHashMap<Long, String> pretplatakMap = new LinkedHashMap<>();
		for (Pretplata pretplata: provajder.getPretplate()) {
			pretplatakMap.put(pretplata.getId(), pretplata.getPretplatnicikiBroj());
        }
        dto.setPretplate(pretplatakMap);
		return dto;
	}
	
	public List<ProvajderDTO> convert(List<Provajder> provajderi){
	    List<ProvajderDTO> provajderDTOs = new ArrayList<>();
	
	    for(Provajder provajder: provajderi) {
	    	provajderDTOs.add(convert(provajder));
	    }
	
	    return provajderDTOs;
	}

}
