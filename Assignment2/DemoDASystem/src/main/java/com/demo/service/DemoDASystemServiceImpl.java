package com.demo.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.exception.DemoDASystemException;
import com.demo.model.TraineeDTO;
import com.demo.repository.DemoDASystemRepository;
import com.demo.validator.Validator;

@Service("demoDASystemService")
public class DemoDASystemServiceImpl implements DemoDASystemService {

    private static final Log LOGGER = LogFactory.getLog(DemoDASystemServiceImpl.class);

    @Autowired
    private DemoDASystemRepository demoDASystemRepository;

    @Override
    public Integer addNewTrainee(TraineeDTO trainee) throws DemoDASystemException {
        try {
            Validator.validate(trainee); // validate trainee details
            return demoDASystemRepository.addNewTrainee(trainee);
        } catch (DemoDASystemException e) {
            //LOGGER.error("Validation/Service error in addNewTrainee", e);
        	LOGGER.error(e.getMessage());
            throw e; // re-throw as specified
        } catch (Exception e) {
            //LOGGER.error("Unexpected error in addNewTrainee", e);
        	LOGGER.error("Unexpected error: "+e.getMessage());
            throw e;
        }
    }

    @Override
    public TraineeDTO getAllocationDetails(Integer traineeId) throws DemoDASystemException {
        try {
            TraineeDTO dto = demoDASystemRepository.getAllocationDetails(traineeId);
            if (dto == null) {
                throw new DemoDASystemException("Service.NO_DETAILS_FOUND");
            }
            return dto;
        } catch (DemoDASystemException e) {
            LOGGER.error("Service error in getAllocationDetails", e);
            throw e;
        } catch (Exception e) {
            LOGGER.error("Unexpected error in getAllocationDetails", e);
            throw e;
        }
    }
}
