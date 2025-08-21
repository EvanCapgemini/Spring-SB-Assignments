package com.demo.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.demo.model.DesktopDTO;
import com.demo.model.TraineeDTO;

@Repository("demoDASystemRepository") // required qualifier
public class DemoDASystemRepositoryImpl implements DemoDASystemRepository {

    // Simulated in-memory DB to match sample outputs
    private static final Map<Integer, TraineeDTO> DB = new HashMap<>();
    static {
        TraineeDTO t = new TraineeDTO(1001, "Adam", "9658014355");
        t.setDesktop(new DesktopDTO("MYSGEC111111D", "Acer"));
        DB.put(1001, t);
    }

    @Override
    public Integer addNewTrainee(TraineeDTO trainee) {
        DB.put(trainee.getId(), trainee);
        return trainee.getId();
    }

    @Override
    public TraineeDTO getAllocationDetails(Integer traineeId) {
        return DB.get(traineeId);
    }
}
