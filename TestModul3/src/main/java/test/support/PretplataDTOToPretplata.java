package test.support;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import test.model.Pretplata;
import test.service.PretplataService;
import test.service.ProvajderService;
import test.service.TarifaService;
import test.web.dto.PretplataDTO;

@Component
public class PretplataDTOToPretplata implements Converter<PretplataDTO, Pretplata> {
	
	@Autowired
	private PretplataService pretplataService;
	
	@Autowired
	private TarifaService tarifaService;
	
	@Autowired
	private ProvajderService provajderService;

	@Override
	public Pretplata convert(PretplataDTO dto) {
		Pretplata pretplata;

        if(dto.getId() == null){
        	pretplata = new Pretplata();
        }else{
        	pretplata = pretplataService.findOneById(dto.getId());
        }

        if(pretplata != null){
        	pretplata.setImeKorisnika(dto.getImeKorisnika());
        	pretplata.setPretplatnicikiBroj(dto.getPretplatnicikiBroj());
        	pretplata.setDatumPocetka(getLocalDateTime(dto.getDatumPocetka()));
        	pretplata.setTrajanjeUgovora(dto.getTrajanjeUgovora());
        	pretplata.setTarifa(tarifaService.findOneById(dto.getTarifaId()));
        	pretplata.setProvajder(provajderService.findOneById(dto.getProvajderId()));
        }
        
        return pretplata;
	}
	
	private LocalDateTime getLocalDateTime(String datumIVreme) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate datum = LocalDate.parse(datumIVreme.replace('T', ' ').substring(0, 10), formatter);
        LocalTime vreme = LocalTime.parse(datumIVreme.substring(11), DateTimeFormatter.ofPattern("HH:mm"));
        return LocalDateTime.of(datum, vreme);
    }

}
