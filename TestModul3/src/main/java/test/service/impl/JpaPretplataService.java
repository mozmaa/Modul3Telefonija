package test.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import test.model.Pretplata;
import test.repository.PretplataRepository;
import test.service.PretplataService;

@Service
public class JpaPretplataService implements PretplataService {

	@Autowired
	private PretplataRepository pretplataRepository;
	
	@Override
	public Pretplata findOneById(Long id) {
		return pretplataRepository.findOneById(id);
	}

	@Override
	public Page<Pretplata> find(String datumPocetkaOd, String datumPocetkaDo, Long tarifaId, int pageNo) {
		LocalDateTime LocalDatumPocetkaOd;
		LocalDateTime LocalDatumPocetkaDo;
		
		if(datumPocetkaOd == null) {
			LocalDatumPocetkaOd = getLocalDateTime("1000-01-01T00:00");
		}else {
			LocalDatumPocetkaOd = getLocalDateTime(datumPocetkaOd);
		}
		
		if(datumPocetkaDo == null) {
			LocalDatumPocetkaDo = getLocalDateTime("9999-01-01T00:00");
		}else {
			LocalDatumPocetkaDo = getLocalDateTime(datumPocetkaDo);
		}
		
		return pretplataRepository.search(LocalDatumPocetkaOd, LocalDatumPocetkaDo, tarifaId, PageRequest.of(pageNo, 2));
	}
	
	private LocalDateTime getLocalDateTime(String datumIVreme) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate datum = LocalDate.parse(datumIVreme.replace('T', ' ').substring(0, 10), formatter);
        LocalTime vreme = LocalTime.parse(datumIVreme.substring(11), DateTimeFormatter.ofPattern("HH:mm"));
        return LocalDateTime.of(datum, vreme);
    }

	@Override
	public Pretplata save(Pretplata pretplata) {
		return pretplataRepository.save(pretplata);
	}

	@Override
	public Pretplata delete(Long id) {
		Pretplata pretplata= pretplataRepository.findOneById(id);
        if(pretplata != null){
    		
        	pretplata.getTarifa().getPretplate().remove(pretplata);
        	pretplata.setTarifa(null);
        	pretplata.getProvajder().getPretplate().remove(pretplata);
        	pretplata.setProvajder(null);
        	pretplata= pretplataRepository.save(pretplata);
        	pretplataRepository.delete(pretplata);
            return pretplata;
        }
        return null;
	}

}
