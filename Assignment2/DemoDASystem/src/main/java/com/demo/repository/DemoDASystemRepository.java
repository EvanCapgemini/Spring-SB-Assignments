package com.demo.repository;

import com.demo.model.TraineeDTO;

public interface DemoDASystemRepository {
    Integer addNewTrainee(TraineeDTO trainee);
    TraineeDTO getAllocationDetails(Integer traineeId);
}
