package test.service;

import java.util.List;

import test.model.Tarifa;

public interface TarifaService {

	Tarifa findOneById(Long tarifaId);

	List<Tarifa> findAll();

}
