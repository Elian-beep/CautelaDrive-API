package uea.cautela_drive.repositories.devolutiva;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import uea.cautela_drive.dto.ResumoDevolutivaDto;
import uea.cautela_drive.models.Devolutiva;
import uea.cautela_drive.repositories.filters.DevolutivaFilter;

public class DevolutivaRepositoryQueryImpl implements DevolutivaRepositoryQuery {
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<ResumoDevolutivaDto> filtrar(DevolutivaFilter devolutivaFilter, Pageable pageable) {
		// TODO Auto-generated method stub
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ResumoDevolutivaDto> criteria = builder.createQuery(ResumoDevolutivaDto.class);
		Root<Devolutiva> root = criteria.from(Devolutiva.class); // SELECT * FROM LANCAMENTO dentro de root
		criteria.select(builder.construct(ResumoDevolutivaDto.class,
				root.get("id"),
				root.get("situacao"),
				root.get("dataDevolutiva"),
				root.get("motorista").get("nome")
			));
		Predicate[] predicates = criarRestricoes(devolutivaFilter, builder, root);
		if (predicates.length > 0) {
			criteria.where(predicates);
		}

		// List<ResumoDevolutivaDto> returnList =
		// manager.createQuery(criteria).getResultList();
		TypedQuery<ResumoDevolutivaDto> query = manager.createQuery(criteria);

		adicionarRestricoesDePaginacao(query, pageable);

		return new PageImpl<>(query.getResultList(), pageable, total(devolutivaFilter));
	}

	private Long total(DevolutivaFilter devolutivaFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Devolutiva> root = criteria.from(Devolutiva.class);

		Predicate[] predicates = criarRestricoes(devolutivaFilter, builder, root);
		if (predicates.length > 0) {
			criteria.where(predicates);
		}

		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<ResumoDevolutivaDto> query, Pageable pageable) {
		int paginaAtual = 1, totalRegistroPagina = pageable.getPageSize(),
				primeiroRegistroPagina = (paginaAtual - 1) * totalRegistroPagina;
		query.setFirstResult(primeiroRegistroPagina);
		query.setMaxResults(totalRegistroPagina);
	}

	private Predicate[] criarRestricoes(DevolutivaFilter devolutivaFilter, CriteriaBuilder builder,
			Root<Devolutiva> root) {
		List<Predicate> predicates = new ArrayList<>();
		

		if (devolutivaFilter.getDataDevolutivaDe() != null) {
			predicates.add(
					builder.greaterThanOrEqualTo(root.get("dataDevolutiva"), devolutivaFilter.getDataDevolutivaDe()));
		}

		if (devolutivaFilter.getDataDevolutivaAte() != null) {
			predicates.add(
					builder.lessThanOrEqualTo(root.get("dataDevolutiva"), devolutivaFilter.getDataDevolutivaAte()));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}
}
