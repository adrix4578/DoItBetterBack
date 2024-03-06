package com.apiRest.ApiRest.controller;

import com.apiRest.ApiRest.RoutineService;
import com.apiRest.ApiRest.UserService;
import com.apiRest.ApiRest.model.Routine;
import com.apiRest.ApiRest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/routine")
public class RoutineController {
    @Autowired
    private RoutineService routineService;
    @Autowired
    private UserService userService;

    @PostMapping
    public Routine createRoutine(  @RequestBody Map<String,Object> body  ){

        User tempUser = userService.getUserById(Long.parseLong(body.get("user_Id").toString()) );
        Routine routine =  new Routine(tempUser,
                body.get("name").toString(),
                Boolean.parseBoolean(body.get("published").toString()));

       return routineService.createRoutine(routine);
    }


    @GetMapping
    public List<Routine> getAllRoutines(){
        return routineService.getRoutines();
    }

    @GetMapping("{id}")
    public Routine searchRoutineByID(@PathVariable("id") Long id){
        return routineService.getRoutineById(id);
    }



    @DeleteMapping("{id}")
    public void deleteRoutineByID(@PathVariable("id") Long id){
        routineService.deleteRoutine(id);
    }

}
