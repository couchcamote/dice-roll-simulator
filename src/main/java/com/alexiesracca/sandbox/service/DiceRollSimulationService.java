package com.alexiesracca.sandbox.service;

import java.util.ArrayList;
import java.util.List;

import com.alexiesracca.sandbox.dto.DiceRollGroupByPieceSide;
import com.alexiesracca.sandbox.dto.DiceRollGroupByPieceSideRelativeDistribution;
import com.alexiesracca.sandbox.dto.DiceRollGroupByTotal;
import com.alexiesracca.sandbox.entity.DiceRoll;
import com.alexiesracca.sandbox.entity.DiceRollSimulation;
import com.alexiesracca.sandbox.helper.DiceRollHelper;
import com.alexiesracca.sandbox.repository.DiceRollRepository;
import com.alexiesracca.sandbox.repository.DiceRollSimulationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiceRollSimulationService {

    @Autowired
    DiceRollSimulationRepository simulationRepository;

    @Autowired
    DiceRollRepository rollRepository;

    public DiceRollSimulation simulateRolls(int roll, int piece, int side) {
        DiceRollSimulation simulation = new DiceRollSimulation(piece, side, roll);
        List<DiceRoll> rolls = DiceRollHelper.roll(roll, piece, side);
        simulation.addRolls(rolls);
        EntityService.updateEntity(simulation);
        DiceRollSimulation persistedSimulation = simulationRepository.save(simulation);
        return persistedSimulation;
    }

    public List<DiceRollGroupByTotal> retrieveTotalBySimulation(DiceRollSimulation simulation) {
        return rollRepository.groupByTotalBySimulation(simulation);
    }

    public List<DiceRollGroupByPieceSide> retrieveAllPieceSide() {
        List<DiceRollGroupByPieceSide> list = rollRepository.groupByPieceSide();
        return list;
    }

    public List<DiceRollGroupByPieceSideRelativeDistribution> retrieveAllPieceSideRelativeDistribution(int piece,
            int side) {
        List<DiceRollGroupByPieceSideRelativeDistribution> list = rollRepository.relativeDistributionByPieceSide(piece,
                side);
        if (list == null || list.size() == 0) {
            DiceRollGroupByPieceSideRelativeDistribution d = new DiceRollGroupByPieceSideRelativeDistribution(piece,
                    side, 0, 0, 0);
            list = new ArrayList<DiceRollGroupByPieceSideRelativeDistribution>();
            list.add(d);
        }
        return list;
    }

}