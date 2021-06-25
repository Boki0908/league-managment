package com.bf1el.common;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

//custom repo pravimo da bismo na nivou aplikacije implementirali JPARepository odnosno Hibernate
// svaki nas posebni repository ce automatski implementirati ovaj CustomRepository sto
// ce nam omoguciti da koristimo Hibernate u potpunosti
// T = tip koji dolazi , ID je id koji se salje u JPA Repository
@NoRepositoryBean
public interface CustomRepository<T,ID extends Serializable> extends JpaRepository<T,ID> {
	
	void refresh(T t);
	void detach(T t);
	void clear();
}
