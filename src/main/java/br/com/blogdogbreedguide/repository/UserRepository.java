package br.com.blogdogbreedguide.repository;

import br.com.blogdogbreedguide.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
