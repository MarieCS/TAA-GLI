package sample.data.jpa.service;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import sample.data.jpa.domain.PreferencePratique;

@Transactional
public interface PreferencePratiqueDao extends CrudRepository<PreferencePratique, Long> {

	@Query("select p from PreferencePratique p where p.id in (select p2.id from Personne p2 where p2.id = :userId)")
	public Collection<PreferencePratique> getPreferencePratiqueByUserId(@Param("userId") long userId);

}
