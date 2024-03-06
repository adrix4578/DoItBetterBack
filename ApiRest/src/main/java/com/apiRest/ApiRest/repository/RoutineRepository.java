package com.apiRest.ApiRest.repository;

import com.apiRest.ApiRest.model.Routine;
import com.apiRest.ApiRest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoutineRepository extends JpaRepository<Routine,Long> {

    public List<Routine> findAllByOwnerUser (User user);

}
