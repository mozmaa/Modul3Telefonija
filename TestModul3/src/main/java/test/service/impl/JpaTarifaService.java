package test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.model.Tarifa;
import test.repository.TarifaRepository;
import test.service.TarifaService;

@Service
public class JpaTarifaService implements TarifaService {

	@Autowired
	private TarifaRepository tarifaRepository;
	
	@Override
	public Tarifa findOneById(Long tarifaId) {
		return tarifaRepository.findOneById(tarifaId);
	}

	@Override
	public List<Tarifa> findAll() {
		return tarifaRepository.findAll();
	}

}
