package com.alexiesracca.sandbox.dto;

public class DiceRollGroupByPieceSideRelativeDistribution extends GenericDto{

    int piece;
    int side;
    float distribution;

    public DiceRollGroupByPieceSideRelativeDistribution(int piece, int side, float distribution) {
        this.piece = piece;
        this.side = side;
        this.distribution = distribution;
    }

    public DiceRollGroupByPieceSideRelativeDistribution() {

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

    public float getDistribution() {
        return distribution;
    }

    public void setDistribution(float distribution) {
        this.distribution = distribution;
    }

    
}