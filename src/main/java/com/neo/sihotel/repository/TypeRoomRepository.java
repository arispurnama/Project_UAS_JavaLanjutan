package com.neo.sihotel.repository;

import com.neo.sihotel.model.TypeRoom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface TypeRoomRepository extends CrudRepository<TypeRoom, Long> {
}
