package frc.robot.subsystems;

import java.util.ArrayList;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Data extends SubsystemBase {

    static ArrayList<Double> numbers = new ArrayList<Double> (){
        {
            add(74.0);  //   upperDistance 
            add(53.25);  //   middleDistance
            add(0.0);  //   restPosition
            add(1.0);  //   upperDegree
            add(1.0);  //   middleDegree 
            add(0.0);  //   restDegree 
        }
    };

    static ArrayList<String> list = new ArrayList<String> (){
        {
            add("upperDistance"); 
            add("lowerDistance"); 
            add("restDistance"); 
            add("upperDegree");
            add("lowerDegree");
            add("restDegree"); 
        }
    };
    

    public static Double n(String str){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).equals(str)){
                return numbers.get(i);
            }
        }
        return 0.0;
    }
}
