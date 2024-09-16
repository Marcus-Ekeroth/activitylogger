package entities;

import com.fasterxml.jackson.annotation.JsonSetter;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class WeatherInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String locationName;
    @Column
    private double temperature;
    @Column
    private String skyText;
    @Column
    private int humidity;
    @Column
    private String windText;
    @OneToMany(mappedBy = "weatherInfo")
    private List<ActivityEnt> activities;

}
