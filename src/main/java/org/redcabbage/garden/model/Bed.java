package org.redcabbage.garden.model;

import javax.persistence.*;

@Entity
public class Bed {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public GardenLocation getFrontOrBack() {
        return frontOrBack;
    }

    public void setFrontOrBack(GardenLocation frontOrBack) {
        this.frontOrBack = frontOrBack;
    }

    @Override
    public String toString() {
        return String.format("{'id': '%s', 'name': '%s', 'GardenLocation': '%s'}", id, name, frontOrBack);
    }

    private int id;
    private String name;
    private GardenLocation frontOrBack;

    public enum GardenLocation {
        front,
        back
    }
}
