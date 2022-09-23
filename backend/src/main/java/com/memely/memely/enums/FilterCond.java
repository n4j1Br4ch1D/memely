package com.memely.memely.enums;

public enum FilterCond {
    AND,
    OR;
	
    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
