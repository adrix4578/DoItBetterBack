package com.apiRest.ApiRest;

import com.apiRest.ApiRest.model.Routine;
import com.apiRest.ApiRest.model.User;
import com.apiRest.ApiRest.repository.RoutineRepository;
import com.apiRest.ApiRest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RoutineService {
    @Autowired
    private RoutineRepository routineRepository;


    public Routine createRoutine(Routine routine){

        return routineRepository.save(routine);
    }

    public Routine getRoutineById(Long id){
        Optional<Routine> optionalRoutine = routineRepository.findById(id);

        return  optionalRoutine.get();
    }

    public  List<Routine> getRoutineByUserId(User user){
        return routineRepository.findAllByOwnerUser(user);
    }


    public List<Routine> getRoutines(){
        return routineRepository.findAll();
    }

    public void deleteRoutine(Long id){
        routineRepository.deleteById(id);
    }


}
