package services;

import daos.ActivityDAO;
import dtos.ActivityDTO;
import entities.ActivityEnt;

public class ActivityService {
    private static ActivityDAO activityDAO = new ActivityDAO();

    public static void addActivity(ActivityDTO activityDTO) {
       ActivityEnt activity = ActivityDAO.convertToActivity(activityDTO);
        activityDAO.createActivity(activity);
    }
}
