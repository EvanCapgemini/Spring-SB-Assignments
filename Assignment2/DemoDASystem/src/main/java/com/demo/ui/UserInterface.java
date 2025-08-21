package com.demo.ui;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.config.SpringConfig;
import com.demo.exception.DemoDASystemException;
import com.demo.model.TraineeDTO;
import com.demo.service.DemoDASystemService;

public class UserInterface {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext ctx =
                 new AnnotationConfigApplicationContext(SpringConfig.class)) {

            DemoDASystemService service =
                ctx.getBean("demoDASystemService", DemoDASystemService.class);

            // 1) Valid add
            try {
                TraineeDTO t = new TraineeDTO(1008, "Robin", "9040555861");
                Integer id = service.addNewTrainee(t);
                System.out.println("Trainee added successfully with id: " + id);
            } catch (DemoDASystemException e) {
                System.out.println(e.getMessage());
            }

            // 2) Invalid add (bad phone) [Commented by me]
//            try {
//                TraineeDTO t = new TraineeDTO(1008, "Robin", "555861");
//                service.addNewTrainee(t);
//            } catch (DemoDASystemException e) {
//                System.out.println(e.getMessage()); // "Invalid trainee details"
//            }

            // 3) Valid allocation lookup
            try {
                System.out.println(service.getAllocationDetails(1001));
            } catch (DemoDASystemException e) {
                System.out.println(e.getMessage());
            }

            // 4) Invalid allocation lookup [Commented by me]
//            try {
//                System.out.println(service.getAllocationDetails(1002));
//            } catch (DemoDASystemException e) {
//                System.out.println(e.getMessage()); // "Service.NO_DETAILS_FOUND"
//            }
        }
    }
}
