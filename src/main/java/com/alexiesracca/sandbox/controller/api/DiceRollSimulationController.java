package com.alexiesracca.sandbox.controller.api;

import com.alexiesracca.sandbox.dto.DiceRollGroupByPieceSide;
import com.alexiesracca.sandbox.dto.DiceRollGroupByPieceSideRelativeDistribution;
import com.alexiesracca.sandbox.dto.DiceRollGroupByTotal;
import com.alexiesracca.sandbox.entity.DiceRoll;
import com.alexiesracca.sandbox.entity.DiceRollSimulation;
import com.alexiesracca.sandbox.repository.DiceRollRepository;
import com.alexiesracca.sandbox.repository.DiceRollSimulationRepository;
import com.alexiesracca.sandbox.service.DiceRollSimulationService;
import com.alexiesracca.sandbox.service.EntityService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * @author alexies
 * @since 2020
 */

@RestController
public class DiceRollSimulationController {

    @Autowired
    DiceRollSimulationRepository simulationRepository;

    @Autowired
    DiceRollRepository rollRepository;

    @Autowired
    DiceRollSimulationService simulationService;
    
    @GetMapping(value = "/api/simulate")
    public List<DiceRollGroupByTotal> runSimulation(
            @RequestParam("piece") int piece,
            @RequestParam("side") int side,
            @RequestParam("roll") int roll
            ){
        DiceRollSimulation simulation = new DiceRollSimulation(piece, side, roll);
        List <DiceRoll> rolls = DiceRollSimulationService.roll(roll, piece, side);
        simulation.addRolls(rolls);
        EntityService.updateEntity(simulation);
        DiceRollSimulation persistedSimulation = simulationRepository.save(simulation);
        return rollRepository.groupByTotalBySimulation(simulation);
    }

    @GetMapping(value = "/api/piece-side")
    public List<DiceRollGroupByPieceSide> retrieveAllPieceSide(){
        return rollRepository.groupByPieceSide();
    }


    @GetMapping(value = "/api/piece-side-relative-dist")
    public List<DiceRollGroupByPieceSideRelativeDistribution> retrieveAllPieceSideRelativeDistribution(
            @RequestParam("piece") int piece,
            @RequestParam("side") int side
            ){
        return rollRepository.relativeDistributionByPieceSide(piece, side);
    }






    /************************************************* */
    @GetMapping(value = "/api/retieveAllTotalCount")
    public List<DiceRollGroupByTotal> retrieveAll(){
        return rollRepository.groupByTotal();
    }

    @GetMapping(value = "/api/retieveTotalCountBySimulation")
    public List<DiceRollGroupByTotal> retrieveBySimulation(@RequestParam("simulationId") Long id
            ){
        DiceRollSimulation simulation = simulationRepository.findById(id).orElse(null);
        if(simulation == null) return new ArrayList();
        return rollRepository.groupByTotalBySimulation(simulation);
    }
  

}