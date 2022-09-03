package com.work.springbootstandalone.models;

import java.util.ArrayList;
import java.util.List;

public class Household {

    private List<Occupant> occupants;

    public Household() {
        this.occupants = new ArrayList<Occupant>();
    }

    public Household(List<Occupant> occupants) {
        this.occupants = occupants;
    }

    public List<Occupant> getOccupants() {
        return occupants;
    }
    public void setOccupants(List<Occupant> occupants) {
        this.occupants = occupants;
    }
}
