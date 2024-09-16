package daos;

import dtos.WeatherInfoDTO;
import entities.WeatherInfo;
import enums.HibernateConfigState;
import jakarta.persistence.EntityManagerFactory;
import persistence.HibernateConfig;

public class WeatherInfoDAO {
    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig(HibernateConfigState.NORMAL, "activity");

    public static WeatherInfo convertToWeatherInfo(WeatherInfoDTO weatherInfoDTO) {
         WeatherInfo weatherInfo = WeatherInfo.builder()
                .locationName(weatherInfoDTO.getLocationName())
                .temperature(weatherInfoDTO.getCurrentData().getTemperature())
                .skyText(weatherInfoDTO.getCurrentData().getSkyText())
                .humidity(weatherInfoDTO.getCurrentData().getHumidity())
                .windText(weatherInfoDTO.getCurrentData().getWindText())
                .build();
         return weatherInfo;
    }
}
