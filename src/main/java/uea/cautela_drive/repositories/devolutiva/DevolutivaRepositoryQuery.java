package uea.cautela_drive.repositories.devolutiva;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import uea.cautela_drive.dto.ResumoDevolutivaDto;
import uea.cautela_drive.repositories.filters.DevolutivaFilter;

public interface DevolutivaRepositoryQuery {
	public Page<ResumoDevolutivaDto> filtrar(DevolutivaFilter devolutivaFilter, Pageable pageable);
}
