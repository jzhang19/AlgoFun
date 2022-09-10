package com.work.springbootstandalone.models;

import java.util.ArrayList;
import java.util.List;

public class Household {
    private Address address;
    private List<Occupant> occupants;

    public Household(Address address, List<Occupant> occupants) {
        this.address = address;
        this.occupants = occupants;
    }

    public List<Occupant> getOccupants() {
        return occupants;
    }
    public void setOccupants(List<Occupant> occupants) {
        this.occupants = occupants;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    
}
