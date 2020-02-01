package com.alexiesracca.sandbox.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class DiceRollSimulation extends GenericEntity {

    @Column
    int piece;

    @Column
    int side;

    @Column
    int roll;

    @Column
    String pieceSide;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "dice_roll_simulation_id")
    List<DiceRoll> diceRolls = new ArrayList<DiceRoll>();

    public DiceRollSimulation(int piece, int side, int roll) {
        this.piece = piece;
        this.side = side;
        this.roll = roll;
        this.pieceSide = piece+"-"+side;
    }

    public DiceRollSimulation(){}

    public void addRolls(List<DiceRoll> diceRolls){
        for(DiceRoll diceRoll : diceRolls){
            diceRoll.setDiceRollSimulation(this);
        }
        this.diceRolls.addAll(diceRolls);
    }

    
    public void addRoll(DiceRoll diceRoll){
        diceRoll.setDiceRollSimulation(this);
        this.diceRolls.add(diceRoll);
    }

    public void removeRoll(DiceRoll diceRoll){
        diceRoll.setDiceRollSimulation(null);
        this.diceRolls.remove(diceRoll);
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

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getPieceSide() {
        return piece+"-"+side;
    }

    public void setPieceSide(String pieceSide) {
        this.pieceSide = pieceSide;
    }

    public List<DiceRoll> getDiceRolls() {
        return diceRolls;
    }

    public void setDiceRolls(List<DiceRoll> diceRolls) {
        this.diceRolls = diceRolls;
    }

}