package test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.model.Provajder;
import test.repository.ProvajderRepository;
import test.service.ProvajderService;

@Service
public class JpaProvajderService implements ProvajderService {

	@Autowired
	private ProvajderRepository provajderRepository;
	
	@Override
	public Provajder findOneById(Long provajderId) {
		return provajderRepository.findOneById(provajderId);
	}

	@Override
	public List<Provajder> findAll() {
		return provajderRepository.findAll();
	}

}
