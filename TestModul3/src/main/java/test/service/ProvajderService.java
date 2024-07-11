package test.service;

import java.util.List;

import test.model.Provajder;

public interface ProvajderService {

	Provajder findOneById(Long provajderId);

	List<Provajder> findAll();

}
