

package frc.robot.subsystems;

import java.beans.Encoder;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import jdk.javadoc.internal.doclets.formats.html.PackageWriterImpl;
import edu.wpi.first.wpilibj.Encoder;


public class elevatorSubsystem extends SubsystemBase {
       

    //elevator motors
    private final PWMVictorSPX left_front_elevator_motor  = new PWMVictorSPX(Constants.RoboRIOPWMPorts.elevator_motor_1);
    private final PWMVictorSPX left_back_elevator_motor   = new PWMVictorSPX(Constants.RoboRIOPWMPorts.elevator_motor_2);
    private final PWMVictorSPX right_front_elevator_motor = new PWMVictorSPX(Constants.RoboRIOPWMPorts.elevator_motor_3);
    private final PWMVictorSPX right_back_elevator_motor  = new PWMVictorSPX(Constants.RoboRIOPWMPorts.elevator_motor_4);

    private final SpeedControllerGroup elevator_motors = new SpeedControllerGroup(left_front_elevator_motor, left_back_elevator_motor, right_front_elevator_motor, right_back_elevator_motor);
   

    //encoder
    private final Encoder elevator_encoder = new Encoder(Constants.RoboRIOAnalogPorts.elevator_encoder);



    private static elevatorSubsystem INSTANCE = new elevatorSubsystem();

    public static elevatorSubsystem getInstance() {
      if (INSTANCE == null){
          synchronized (elevatorSubsystem.class) {
              if (INSTANCE == null){
                  INSTANCE = new elevatorSubsystem();
              }
          }
      }
      return INSTANCE;
  }

    
    //ENCODER METHODS

      //Encoder Distance Methods
    public double encoder_drop_distance(){
        elevator_encoder.setDistancePerPulse(Constants.RobotFeatures.elevator_encoder_drop_PerTour/Constants.RobotFeatures.encoderPPR);
        return elevator_encoder.getDistance();

    }

    public double encoder_raise_distance(){
        elevator_encoder.setDistancePerPulse(Constants.RobotFeatures.elevator_encoder_raise_PerTour/Constants.RobotFeatures.encoderPPR);
        return elevator_encoder.getDistance();

    }

    
      //Encoder Reset Method
    public void elevator_encoder_reset_method(){
        elevator_encoder.reset();
    }





 
    //ELEVATOR METHODS
  
       //Elevator Upgrade Method
    public void elevator_up(double elevator_speed){
        elevator_encoder_reset_method();
        
        if(elevator_speed > 0){
             elevator_motors.set(elevator_speed);
            
        }
        else{
            elevator_motors.set(0.0);
        }    
    }
      
    
        //Elevator Lowering Method
    public void elevator_down(double elevator_speed2){
        elevator_encoder_reset_method();
        
        if(elevator_speed2 < 0){
           elevator_motors.set(elevator_speed2);
        }

        else{
            elevator_motors.set(0.0);
        }
    }
    
    
        //Elevator Stop Method
    public void elevator_stop(){
        elevator_motors.set(0.0);
    }


  public elevatorSubsystem() {}

}
