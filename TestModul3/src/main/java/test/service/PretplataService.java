package test.service;

import org.springframework.data.domain.Page;

import test.model.Pretplata;

public interface PretplataService {

	Pretplata findOneById(Long id);

	Page<Pretplata> find(String datumPocetkaOd, String datumPocetkaDo, Long tarifaId, int pageNo);

	Pretplata save(Pretplata pretplata);

	Pretplata delete(Long id);

}
