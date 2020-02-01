package com.alexiesracca.sandbox.repository;

import java.util.List;
import java.util.Optional;

import com.alexiesracca.sandbox.entity.DiceRollSimulation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author alexies
 *
 */
@Repository
public interface DiceRollSimulationRepository extends CrudRepository<DiceRollSimulation, Long> {

    public List<DiceRollSimulation> findAll();

    public Optional<DiceRollSimulation> findById(Long id);

    public DiceRollSimulation save(DiceRollRepository diceRollSimulation);

}