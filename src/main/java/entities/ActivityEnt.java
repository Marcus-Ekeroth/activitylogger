package entities;

import dtos.CityInfoDTO;
import dtos.WeatherInfoDTO;
import enums.Activity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@ToString
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
@Table(name = "activityent")
public class ActivityEnt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private LocalDate exerciseDate;
    @Column
    private Activity exerciseType;
    @Column
    private LocalTime timeOfDay;
    @Column
    private double duration;  // In hours, for example
    @Column
    private double distance;  // In kilometers or miles
    @Column
    private String comment;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cityInfo_name")
    private CityInfo cityInfo;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "weatherInfo_locationName")
    private WeatherInfo weatherInfo;

}