package com.tanzu.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tanzu.app.domain.Hello;

public interface HelloRepository extends JpaRepository<Hello, Long> {

	@Query("select h from Hello h inner join fetch h.a inner join fetch h.b")
	List<Hello> findAllEagered();

}
