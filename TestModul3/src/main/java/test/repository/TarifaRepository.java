package test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.model.Tarifa;

@Repository
public interface TarifaRepository extends JpaRepository<Tarifa, Long> {

	Tarifa findOneById(Long tarifaId);

}
