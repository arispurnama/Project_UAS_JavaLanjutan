package com.neo.sihotel.repository;

import com.neo.sihotel.model.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Historyrepository extends JpaRepository<History, Integer> {
}
