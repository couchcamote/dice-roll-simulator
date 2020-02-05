package com.alexiesracca.sandbox.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;


@Entity
public class DiceRollSimulation extends GenericEntity {

    @Min(value = 1, message = "Piece should be atleast 1")
    @Column
    int piece;

    @Min(value = 4, message = "Side should be atleast 4")
    @Column
    int side;

    @Min(value = 1, message = "Roll should be atleast 1")
    @Column
    int roll;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "dice_roll_simulation_id")
    List<DiceRoll> diceRolls = new ArrayList<DiceRoll>();

    public DiceRollSimulation(int piece, int side, int roll) {
        this.piece = piece;
        this.side = side;
        this.roll = roll;
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

    public List<DiceRoll> getDiceRolls() {
        return diceRolls;
    }

    public void setDiceRolls(List<DiceRoll> diceRolls) {
        this.diceRolls = diceRolls;
    }

}