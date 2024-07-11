package test.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import test.model.Pretplata;
import test.web.dto.PretplataDTO;

@Component
public class PretplataToPretplataDTO implements Converter<Pretplata, PretplataDTO> {

	@Override
	public PretplataDTO convert(Pretplata pretplata) {
		PretplataDTO dto = new PretplataDTO();
		dto.setId(pretplata.getId());
		dto.setImeKorisnika(pretplata.getImeKorisnika());
		dto.setDatumPocetka(pretplata.getDatumPocetka().toString().replace("T", " "));
		dto.setTrajanjeUgovora(pretplata.getTrajanjeUgovora());
		dto.setPretplatnicikiBroj(pretplata.getPretplatnicikiBroj());
		dto.setTarifaId(pretplata.getTarifa().getId());
		dto.setTarifaIme(pretplata.getTarifa().getNaziv());
		dto.setCena(pretplata.getTarifa().getCena());
		dto.setProvajderId(pretplata.getProvajder().getId());
		dto.setProvajderIme(pretplata.getProvajder().getNaziv());
		return dto;
	}
	
	public List<PretplataDTO> convert(List<Pretplata> pretplate){
        List<PretplataDTO> pretplataDTOs = new ArrayList<>();

        for(Pretplata pretplata: pretplate) {
        	pretplataDTOs.add(convert(pretplata));
        }

        return pretplataDTOs;
    }
}
