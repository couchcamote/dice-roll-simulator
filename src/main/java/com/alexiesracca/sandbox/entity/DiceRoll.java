package com.alexiesracca.sandbox.entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class DiceRoll{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;	

    @Column
    private String pieceSide;

    @Column
    private int piece;

    @Column
    private int side;

    @Column
    private int total;

    @Column
    String combinationString;

    @Transient
    String[] combinationArray;

    @ManyToOne(
        fetch = FetchType.LAZY
    )
    @JoinColumn(name = "dice_roll_simulation_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private DiceRollSimulation diceRollSimulation;

    public DiceRoll(int piece, int side){
        this.piece = piece;
        this.side = side;
        this.pieceSide = piece+"-"+side;
    }

    public DiceRoll(){}

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DiceRollSimulation )) return false;
        return id != null && id.equals(((DiceRoll) o).getId());
    }
 
    @Override
    public int hashCode() {
        return 31;
    }

    public String getPieceSide() {
        return piece+"-"+side;
    }

    public void setPieceSide(String pieceSide) {
        this.pieceSide = pieceSide;
    }

    public int getPiece() {
        return piece;
    }

    public void setPiece(int piece) {
        this.piece = piece;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String[] getCombinationArray() {
        combinationArray = this.getCombinationString().split(",");
        return combinationArray;
    }

    public void setCombinationArray(String[] combinationArray) {
        Arrays.sort(combinationArray);
        this.combinationString = String.join(",", combinationArray);
        this.combinationArray = combinationArray;
    }

    public String getCombinationString() {
        return combinationString;
    }

    public void setCombinationString(String combinationString) {
        this.combinationString = combinationString;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DiceRollSimulation getDiceRollSimulation() {
        return diceRollSimulation;
    }

    public void setDiceRollSimulation(DiceRollSimulation diceRollSimulation) {
        this.diceRollSimulation = diceRollSimulation;
    }

}