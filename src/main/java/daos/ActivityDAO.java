package daos;

import entities.WeatherInfo;
import enums.HibernateConfigState;
import persistence.HibernateConfig;
import dtos.ActivityDTO;
import entities.ActivityEnt;
import enums.Activity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

public class ActivityDAO {
    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig(HibernateConfigState.NORMAL, "activity");

    public void createActivity(ActivityEnt activity) {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(activity);
            em.getTransaction().commit();
        }
    }

    public static ActivityEnt convertToActivity(ActivityDTO activityDTO) {
        ActivityEnt activity =
                ActivityEnt.builder()
                .exerciseDate(activityDTO.getExerciseDate())
                .exerciseType(activityDTO.getExerciseType())
                .timeOfDay(activityDTO.getTimeOfDay())
                .duration(activityDTO.getDuration())
                .distance(activityDTO.getDistance())
                .comment(activityDTO.getComment())
                .cityInfo(CityInfoDAO.convertToCityInfo(activityDTO.getCityInfo()))
                .weatherInfo(WeatherInfoDAO.convertToWeatherInfo(activityDTO.getWeatherInfo()))
                .build();
        return activity;
    }

    public static void getAllActivities() {
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig(HibernateConfigState.NORMAL, "activity");
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<ActivityEnt> query = em.createQuery("SELECT a FROM ActivityEnt a", ActivityEnt.class);

        }
    }
}
