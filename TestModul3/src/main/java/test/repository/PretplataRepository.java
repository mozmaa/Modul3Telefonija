package test.repository;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import test.model.Pretplata;

@Repository
public interface PretplataRepository extends JpaRepository<Pretplata, Long> {

	Pretplata findOneById(Long id);

	@Query("SELECT p FROM Pretplata p WHERE "+
			"(p.datumPocetka BETWEEN :localDatumPocetkaOd AND :localDatumPocetkaDo) AND " +
			"(:tarifaId IS NULL OR p.tarifa.id = :tarifaId)")
	Page<Pretplata> search(
			@Param("localDatumPocetkaOd") LocalDateTime localDatumPocetkaOd, 
			@Param("localDatumPocetkaDo") LocalDateTime localDatumPocetkaDo,
			@Param("tarifaId") Long tarifaId, Pageable pageable);

}
