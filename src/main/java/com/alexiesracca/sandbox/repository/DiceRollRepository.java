package com.alexiesracca.sandbox.repository;

import com.alexiesracca.sandbox.dto.DiceRollGroupByPieceSide;
import com.alexiesracca.sandbox.dto.DiceRollGroupByPieceSideRelativeDistribution;
import com.alexiesracca.sandbox.dto.DiceRollGroupByTotal;
import com.alexiesracca.sandbox.entity.DiceRoll;
import com.alexiesracca.sandbox.entity.DiceRollSimulation;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface DiceRollRepository extends CrudRepository<DiceRoll, Long>{

    @Override
    public List<DiceRoll> findAll();

    

    //All
    @Query("select new com.alexiesracca.sandbox.dto.DiceRollGroupByTotal "
    + " ( dc.total as total, "
    + " count(dc) as count ) "
    + " from DiceRoll dc "
    + " group by dc.total order by dc.total")
    public List<DiceRollGroupByTotal> groupByTotal();

    //By Simulation
    @Query("select new com.alexiesracca.sandbox.dto.DiceRollGroupByTotal "
    + " ( dc.total as total, "
    + " count(dc) as count ) "
    + " from DiceRoll dc "
    + " where dc.diceRollSimulation = :simulation "
    + " group by dc.total order by dc.total")
    public List<DiceRollGroupByTotal> groupByTotalBySimulation(@Param("simulation") DiceRollSimulation simulationId);

   //By PieceSide
       //(int piece, int side, Long rollCount, Long simulationCount) 
       //SELECT piece, side, count(*), count  (distinct dice_roll_simulation_id) FROM DICE_ROLL group by piece, side 
       @Query("select new com.alexiesracca.sandbox.dto.DiceRollGroupByPieceSide "
       + " ( "
       + "   dc.piece as piece "
       + " , dc.side as side "
       + " , count(dc) as rollCount "
       + " , count(distinct dice_roll_simulation_id) as simulationCount "
       + " ) "
       + " from DiceRoll dc "
       + " group by dc.piece, dc.side")
       public List<DiceRollGroupByPieceSide> groupByPieceSide();


    //By PieceSide - Relative Distribution
    //select piece, side, cast (count(*) as float) / cast((select count(*) from  dice_roll) as float) from dice_roll where piece = 3 and side = 6 group by total
       @Query("select new com.alexiesracca.sandbox.dto.DiceRollGroupByPieceSideRelativeDistribution "
       + " ( "
       + "   dc.piece as piece "
       + " , dc.side as side "
       + " , dc.total as total "
       + " , count(*) as count "
       + " , cast (count(*) as float) * 100 / cast((select count(*) from  DiceRoll dc2 where dc2.piece = :piece and dc2.side = :side) as float)  "
       + " ) "
       + " from DiceRoll dc "
       + " where dc.piece = :piece "
       + " and dc.side = :side "
       + " group by dc.total ")
       public List<DiceRollGroupByPieceSideRelativeDistribution> relativeDistributionByPieceSide(
        @Param("piece") int piece, @Param("side") int side
       );
       
   


   
}