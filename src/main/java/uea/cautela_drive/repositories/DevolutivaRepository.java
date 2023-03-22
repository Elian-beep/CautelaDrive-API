package uea.cautela_drive.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uea.cautela_drive.models.Devolutiva;
import uea.cautela_drive.repositories.devolutiva.DevolutivaRepositoryQuery;

public interface DevolutivaRepository extends JpaRepository<Devolutiva, Long>, DevolutivaRepositoryQuery{

}
