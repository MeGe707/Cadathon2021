package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class intakeSubsystem extends SubsystemBase {
  /** Creates a new IntakeSubsystem. */

  private final PWMVictorSPX motor1 = new PWMVictorSPX(Constants.RoboRIOPWMPorts.intakeMotor1);
  private final PWMVictorSPX motor2 = new PWMVictorSPX(Constants.RoboRIOPWMPorts.intakeMotor2);

  private final SpeedControllerGroup motors = new SpeedControllerGroup(motor1, motor2);

    
  private static intakeSubsystem INSTANCE = new intakeSubsystem();

  public static intakeSubsystem getInstance() {
    if (INSTANCE == null){
        synchronized (intakeSubsystem.class) {
            if (INSTANCE == null){
                INSTANCE = new intakeSubsystem();
            }
        }
    }
    return INSTANCE;
}

public void motorOpenClose(double speed){
  motors.set(speed);
}

public void motorStop(){
    motors.set(0);
}

  public intakeSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}