package daos;

import dtos.CityInfoDTO;
import dtos.WeatherInfoDTO;
import entities.CityInfo;
import entities.WeatherInfo;
import enums.HibernateConfigState;
import jakarta.persistence.EntityManagerFactory;
import persistence.HibernateConfig;

public class CityInfoDAO {
    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig(HibernateConfigState.NORMAL, "activity");

    public static CityInfo convertToCityInfo(CityInfoDTO cityInfoDTO) {
        CityInfo cityInfo = CityInfo.builder()
                .name(cityInfoDTO.getName())
                .buildingCode(cityInfoDTO.getProperties().getBuildingCode())
                .population(cityInfoDTO.getProperties().getPopulation())
                .visualCenter(cityInfoDTO.getVisualCenter())
                .build();
        return cityInfo;
    }
}
