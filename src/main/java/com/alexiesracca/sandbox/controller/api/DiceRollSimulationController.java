package com.alexiesracca.sandbox.controller.api;

import com.alexiesracca.sandbox.dto.DiceRollGroupByPieceSide;
import com.alexiesracca.sandbox.dto.DiceRollGroupByPieceSideRelativeDistribution;
import com.alexiesracca.sandbox.dto.DiceRollGroupByTotal;
import com.alexiesracca.sandbox.dto.Response;
import com.alexiesracca.sandbox.dto.Response.Status;
import com.alexiesracca.sandbox.entity.DiceRoll;
import com.alexiesracca.sandbox.entity.DiceRollSimulation;
import com.alexiesracca.sandbox.repository.DiceRollRepository;
import com.alexiesracca.sandbox.repository.DiceRollSimulationRepository;
import com.alexiesracca.sandbox.service.DiceRollSimulationService;
import com.alexiesracca.sandbox.service.EntityService;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * @author alexies
 * @since 2020
 */

@RestController
@CrossOrigin(origins = { "http://localhost:4200" }, maxAge = 3000)
@RequestMapping("/api")
public class DiceRollSimulationController {

    @Autowired
    DiceRollSimulationRepository simulationRepository;

    @Autowired
    DiceRollRepository rollRepository;

    @Autowired
    DiceRollSimulationService simulationService;
    
    @GetMapping(value = "/simulate")
    public Response runSimulation(
            @RequestParam("piece") int piece,
            @RequestParam("side") int side,
            @RequestParam("roll") int roll
            ){

        //Validation
        if(piece < 1){
            return new Response(Response.Status.FAILURE, "Minimum piece is 1");
        }
        if(roll < 1){
            return new Response(Response.Status.FAILURE, "Minimum roll is 1");
        }           
        if(side < 4){
            return new Response(Response.Status.FAILURE, "Minimum side is 4");
        } 

        DiceRollSimulation simulation = new DiceRollSimulation(piece, side, roll);
        try{
            List <DiceRoll> rolls = DiceRollSimulationService.roll(roll, piece, side);
            simulation.addRolls(rolls);
            EntityService.updateEntity(simulation);
            DiceRollSimulation persistedSimulation = simulationRepository.save(simulation);
        }catch(Exception e){
            return new Response(Response.Status.FAILURE, e.getMessage());
        }

        List<DiceRollGroupByTotal> list = rollRepository.groupByTotalBySimulation(simulation);
        return new Response(Response.Status.SUCCESS, "Success", list);
    }

    @GetMapping(value = "/piece-side")
    public Response retrieveAllPieceSide(){
        List<DiceRollGroupByPieceSide> list = rollRepository.groupByPieceSide();
        return new Response(Response.Status.SUCCESS, "Success", list);
    }


    @GetMapping(value = "/piece-side-relative-dist")
    public Response retrieveAllPieceSideRelativeDistribution(
            @RequestParam("piece") int piece,
            @RequestParam("side") int side
            ){
       //Validation
       if(piece < 1){
        return new Response(Response.Status.FAILURE, "Minimum piece is 1");
        }   
        if(side < 4){
            return new Response(Response.Status.FAILURE, "Minimum side is 4");
        }                 
        List<DiceRollGroupByPieceSideRelativeDistribution> list = rollRepository.relativeDistributionByPieceSide(piece, side);
        if(list == null || list.size() == 0) {
        	DiceRollGroupByPieceSideRelativeDistribution d = new DiceRollGroupByPieceSideRelativeDistribution(piece, side, 0, 0, 0);
        	list = new ArrayList<DiceRollGroupByPieceSideRelativeDistribution>();
        	list.add(d);
        }
        return new Response(Response.Status.SUCCESS, "Success", list);               
    }






    /************************************************* */
    @GetMapping(value = "/retieveAllTotalCount")
    public Response retrieveAll(){
        List<DiceRollGroupByTotal> list = rollRepository.groupByTotal();
        return new Response(Status.SUCCESS, "Success", list); 
    }

    @GetMapping(value = "/retieveTotalCountBySimulation")
    public Response retrieveBySimulation(@RequestParam("simulationId") Long id
            ){
       //Validation
       if(id < 1){
        return new Response(Response.Status.FAILURE, "Invalid ID");
         }

        DiceRollSimulation simulation = simulationRepository.findById(id).orElse(null);
        if(simulation == null) {
            return new Response(Status.FAILURE, "No Simulation Found"); 
        }

        List<DiceRollGroupByTotal> list = rollRepository.groupByTotalBySimulation(simulation);
        return new Response(Status.SUCCESS, "Success", list); 
    }
  

}