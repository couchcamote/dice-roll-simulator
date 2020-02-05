package com.alexiesracca.sandbox.dto;

public class DiceRollGroupByPieceSide{

    int piece;
    int side;
    Long rollCount;
    Long simulationCount;

    public DiceRollGroupByPieceSide(int piece, int side, Long rollCount, Long simulationCount) {
        this.piece = piece;
        this.side = side;
        this.rollCount = rollCount;
        this.simulationCount = simulationCount;
    }

    public DiceRollGroupByPieceSide() {

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

    public Long getRollCount() {
        return rollCount;
    }

    public void setRollCount(Long rollCount) {
        this.rollCount = rollCount;
    }

    public Long getSimulationCount() {
        return simulationCount;
    }

    public void setSimulationCount(Long simulationCount) {
        this.simulationCount = simulationCount;
    }

    
}