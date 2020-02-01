package com.alexiesracca.sandbox.repository;

import java.util.List;

import com.alexiesracca.sandbox.entity.DiceRoll;
import com.alexiesracca.sandbox.entity.DiceRollGroupByTotal;
import com.alexiesracca.sandbox.entity.DiceRollSimulation;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DiceRollRepository extends CrudRepository<DiceRoll, Long>{

    public List<DiceRoll> findAll();

    

    //All
    @Query("select new com.alexiesracca.sandbox.entity.DiceRollGroupByTotal "
    + " ( dc.total as total, "
    + " count(dc) as count ) "
    + " from DiceRoll dc "
    + " group by dc.total order by dc.total")
    public List<DiceRollGroupByTotal> groupByTotal();

    //By Simulation
    @Query("select new com.alexiesracca.sandbox.entity.DiceRollGroupByTotal "
    + " ( dc.total as total, "
    + " count(dc) as count ) "
    + " from DiceRoll dc "
    + " where dc.diceRollSimulation = :simulation "
    + " group by dc.total order by dc.total")
    public List<DiceRollGroupByTotal> groupByTotalBySimulation(@Param("simulation") DiceRollSimulation simulationId);


   
}