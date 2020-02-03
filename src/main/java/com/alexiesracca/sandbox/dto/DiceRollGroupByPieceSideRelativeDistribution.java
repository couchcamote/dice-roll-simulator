package com.alexiesracca.sandbox.dto;

public class DiceRollGroupByPieceSideRelativeDistribution extends GenericDto{

    int piece;
    int side;
    int total;    
    float distribution;
    long count;

    public DiceRollGroupByPieceSideRelativeDistribution(int piece, int side, int total, long count,  float distribution) {
        this.piece = piece;
        this.side = side;
        this.total = total;
        this.count = count;
        this.distribution = distribution;
    }

    public DiceRollGroupByPieceSideRelativeDistribution() { }

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

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

    
}