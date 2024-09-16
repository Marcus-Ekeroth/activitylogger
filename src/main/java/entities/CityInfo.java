package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import dtos.CityInfoDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
public class CityInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private int buildingCode;
    @Column
    private Integer population;
    @ElementCollection
    private List<Double> visualCenter;
    /*@Column
    private int code;
    @Column
    private String municipalityName;*/
    @OneToMany(mappedBy = "cityInfo")
    private List<ActivityEnt> activities;
}



