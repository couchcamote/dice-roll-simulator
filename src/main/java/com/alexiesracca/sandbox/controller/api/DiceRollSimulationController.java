package com.alexiesracca.sandbox.controller.api;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.alexiesracca.sandbox.dto.DiceRollGroupByPieceSide;
import com.alexiesracca.sandbox.dto.DiceRollGroupByPieceSideRelativeDistribution;
import com.alexiesracca.sandbox.dto.DiceRollGroupByTotal;
import com.alexiesracca.sandbox.entity.DiceRollSimulation;
import com.alexiesracca.sandbox.service.DiceRollSimulationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    DiceRollSimulationService simulationService;

    @GetMapping(value = "/simulate")
    public ResponseEntity<List<DiceRollGroupByTotal>> runSimulation(
        @Valid @Min(value = 1, message = "Piece should be atleast 1") @RequestParam("piece") int piece,
        @Valid @Min(value = 4, message = "Side should be atleast 4") @RequestParam("side") int side,
        @Valid @Min(value = 1, message = "Roll should be atleast 1") @RequestParam("roll") int roll) {

        DiceRollSimulation simulation = simulationService.simulateRolls(roll, piece, side);
        List<DiceRollGroupByTotal> list = simulationService.retrieveTotalBySimulation(simulation);
        return new ResponseEntity<List<DiceRollGroupByTotal>>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/piece-side")
    public ResponseEntity<List<DiceRollGroupByPieceSide>> retrieveAllPieceSide() {
        List<DiceRollGroupByPieceSide> list = simulationService.retrieveAllPieceSide();
        return new ResponseEntity<List<DiceRollGroupByPieceSide>>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/piece-side-relative-dist")
    public ResponseEntity<List<DiceRollGroupByPieceSideRelativeDistribution>> retrieveAllPieceSideRelativeDistribution(
            @Min(value = 1, message = "Piece should be atleast 1") @RequestParam("piece") int piece,
            @Min(value = 4, message = "Side should be atleast 4") @RequestParam("side") int side) {

        List<DiceRollGroupByPieceSideRelativeDistribution> list = simulationService
                .retrieveAllPieceSideRelativeDistribution(piece, side);
        return new ResponseEntity<List<DiceRollGroupByPieceSideRelativeDistribution>>(list, HttpStatus.OK);

    }

}