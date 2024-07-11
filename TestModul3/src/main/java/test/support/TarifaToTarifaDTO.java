package test.support;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import test.model.Pretplata;
import test.model.Tarifa;
import test.web.dto.TarifaDTO;

@Component
public class TarifaToTarifaDTO implements Converter<Tarifa, TarifaDTO> {

	@Override
	public TarifaDTO convert(Tarifa tarifa) {
		TarifaDTO dto = new TarifaDTO();
		dto.setId(tarifa.getId());
		dto.setNaziv(tarifa.getNaziv());
		dto.setOpis(tarifa.getOpis());
		dto.setCena(tarifa.getCena());
		LinkedHashMap<Long, String> pretplatakMap = new LinkedHashMap<>();
		for (Pretplata pretplata: tarifa.getPretplate()) {
			pretplatakMap.put(pretplata.getId(), pretplata.getPretplatnicikiBroj());
        }
        dto.setPretplate(pretplatakMap);
		return dto;
	}
	
	public List<TarifaDTO> convert(List<Tarifa> tarife){
	    List<TarifaDTO> tarifaDTOs = new ArrayList<>();
	
	    for(Tarifa tarifa: tarife) {
	    	tarifaDTOs.add(convert(tarifa));
	    }
	
	    return tarifaDTOs;
	}

}
