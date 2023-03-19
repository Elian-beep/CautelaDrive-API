package uea.cautela_drive.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uea.cautela_drive.models.Motorista;

@Repository
public interface MotoristaRepository extends JpaRepository<Motorista, Long>{
}