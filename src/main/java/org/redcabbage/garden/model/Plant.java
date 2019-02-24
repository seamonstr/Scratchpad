package org.redcabbage.garden.model;

import javax.persistence.*;

@Entity
public class Plant {
    private int id;
    private int height;
    private Bed bed;
    private Species species;

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="bed_id")
    public Bed getBed() {
        return bed;
    }

    public void setBed(Bed bed) {
        this.bed = bed;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="species_id")
    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }
}
