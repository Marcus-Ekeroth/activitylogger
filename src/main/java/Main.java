import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import daos.ActivityDAO;
import dtos.ActivityDTO;
import dtos.CityInfoDTO;
import dtos.WeatherInfoDTO;
import enums.Activity;
import services.ActivityService;
import services.CityService;
import services.WeatherService;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        WeatherInfoDTO weatherInfo = WeatherService.fetchWeatherDataByLocationName("Hillerød");
        CityInfoDTO cityInfo = CityService.getCityInfo("Hillerød");
        WeatherInfoDTO weatherInfo2 = WeatherService.fetchWeatherDataByLocationName("Søborg");
        CityInfoDTO cityInfo2 = CityService.getCityInfo("Søborg");
        WeatherInfoDTO weatherInfo3 = WeatherService.fetchWeatherDataByLocationName("Helsingør");
        CityInfoDTO cityInfo3 = CityService.getCityInfo("Helsingør");

        ActivityDTO activityDTO = ActivityDTO
                .builder()
                .exerciseType(Activity.RUNNING)
                .cityInfo(cityInfo)
                .distance(6.5)
                .exerciseDate(LocalDate.now())
                .duration(30.0)
                .timeOfDay(LocalTime.of(15, 45))
                .comment("Lovely downhill stroll")
                .cityInfo(cityInfo)
                .weatherInfo(weatherInfo)
                .build();

        ActivityDTO activityDTO2 = ActivityDTO
                .builder()
                .exerciseType(Activity.RUNNING)
                .cityInfo(cityInfo)
                .distance(6.5)
                .exerciseDate(LocalDate.now())
                .duration(30.0)
                .timeOfDay(LocalTime.of(17, 45))
                .comment("Sprint")
                .cityInfo(cityInfo2)
                .weatherInfo(weatherInfo2)
                .build();
        ActivityDTO activityDTO3 = ActivityDTO
                .builder()
                .exerciseType(Activity.RUNNING)
                .cityInfo(cityInfo)
                .distance(6.5)
                .exerciseDate(LocalDate.now())
                .duration(30.0)
                .timeOfDay(LocalTime.of(12, 30))
                .comment("Casual walk")
                .cityInfo(cityInfo3)
                .weatherInfo(weatherInfo3)
                .build();
       // System.out.println(activityDTO);

        //System.out.println(activityDTO.getCityInfo().getVisualCenter());

        ActivityService.addActivity(activityDTO);
        ActivityService.addActivity(activityDTO2);
        ActivityService.addActivity(activityDTO3);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        System.out.println(objectMapper.writeValueAsString(activityDTO));
        System.out.println(objectMapper.writeValueAsString(activityDTO2));
        System.out.println(objectMapper.writeValueAsString(activityDTO3));
    }
}