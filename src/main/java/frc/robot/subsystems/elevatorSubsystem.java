

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class elevatorSubsystem extends SubsystemBase {

    private final PWMVictorSPX left_elevator = new PWMVictorSPX(Constants.RoboRIOPWMPorts.elevator_motor_1);
    private final PWMVictorSPX right_elevator = new PWMVictorSPX(Constants.RoboRIOPWMPorts.elevator_motor_2);

    private final SpeedControllerGroup elevator_motors = new SpeedControllerGroup(left_elevator, right_elevator);

    public static boolean is_elevator_open = false;
    public static boolean is_elevator_up   = false; 

    private static drivetrainSubsystem INSTANCE = new drivetrainSubsystem();

    public static drivetrainSubsystem getInstance() {
      if (INSTANCE == null){
          synchronized (drivetrainSubsystem.class) {
              if (INSTANCE == null){
                  INSTANCE = new drivetrainSubsystem();
              }
          }
      }
      return INSTANCE;
  }

    public void elevator_motors_open_close(double speed){
        elevator_motors.set(speed);
    }

    public void elevator_motors_stop(){
        elevator_motors.set(0);
    }

  public elevatorSubsystem() {}

}
