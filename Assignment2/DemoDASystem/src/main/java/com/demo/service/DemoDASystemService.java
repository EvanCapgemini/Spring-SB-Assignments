package com.demo.service;

import com.demo.exception.DemoDASystemException;
import com.demo.model.TraineeDTO;

public interface DemoDASystemService {
    Integer addNewTrainee(TraineeDTO trainee) throws DemoDASystemException;
    TraineeDTO getAllocationDetails(Integer traineeId) throws DemoDASystemException;
}
