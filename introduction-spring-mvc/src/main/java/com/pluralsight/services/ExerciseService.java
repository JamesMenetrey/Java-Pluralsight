package com.pluralsight.services;

import com.pluralsight.models.Activity;

import java.util.List;

public interface ExerciseService {
    List<Activity> findAllActivities();
}
