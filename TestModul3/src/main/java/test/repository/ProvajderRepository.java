package test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.model.Provajder;

@Repository
public interface ProvajderRepository extends JpaRepository<Provajder, Long> {

	Provajder findOneById(Long provajderId);

}
