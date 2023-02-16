// package frc.robot.subsystems;

// import edu.wpi.first.wpilibj.AddressableLED;
// import edu.wpi.first.wpilibj.AddressableLEDBuffer;
// import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import edu.wpi.first.wpilibj.Timer;

// public class LEDS extends SubsystemBase{
//     // PWM port 9
//     // Must be a PWM header, not MXP or DIO
//     AddressableLED led = new AddressableLED(9);

//     // Reuse buffer
//     // Default to a length of 60, start empty output
//     // Length is expensive to set, so only set it once, then just update data
//     AddressableLEDBuffer ledBuffer = new AddressableLEDBuffer(60);

//     // Set the data

//     public LEDS(){
//         led.setLength(ledBuffer.getLength());
//         led.setData(ledBuffer);
//     }

//     public void pink()    {
//         for (var i = 0; i < ledBuffer.getLength(); i++) {
//             // Sets the specified LED to the RGB values for red
//             ledBuffer.setRGB(i, 205, 1, 135);
//          }
         
//          led.setData(ledBuffer);
//     }

//     public void blue()    {
//         for (var i = 0; i < ledBuffer.getLength(); i++) {
//             // Sets the specified LED to the RGB values for red
//             ledBuffer.setRGB(i, 0, 0, 255);
//          }
         
//          led.setData(ledBuffer);
//     }

//     public void red()    {
//         for (var i = 0; i < ledBuffer.getLength(); i++) {
//             // Sets the specified LED to the RGB values for red
//             ledBuffer.setRGB(i, 255, 0, 0);
//          }
         
//          led.setData(ledBuffer);
//     }

//     public void pinkBlink(Timer time){
//         if (time.get() % 2 == 0){
//             for (var i = 0; i < ledBuffer.getLength(); i+=2) {
//                 // Sets the specified LED to the RGB values for red
//                 ledBuffer.setRGB(i, 205, 1, 135);
//              }
             
//              led.setData(ledBuffer);
//         }
//         else{
//             for (var i = 1; i < ledBuffer.getLength(); i+=2) {
//                 // Sets the specified LED to the RGB values for red
//                 ledBuffer.setRGB(i, 205, 1, 135);
//              }
             
//              led.setData(ledBuffer);
//         }
//     }

//     public void redBlink(Timer time){
//         if (time.get() % 2 == 0){
//             for (var i = 0; i < ledBuffer.getLength(); i+=2) {
//                 // Sets the specified LED to the RGB values for red
//                 ledBuffer.setRGB(i, 255, 0, 0);
//              }
             
//              led.setData(ledBuffer);
//         }
//         else{
//             for (var i = 1; i < ledBuffer.getLength(); i+=2) {
//                 // Sets the specified LED to the RGB values for red
//                 ledBuffer.setRGB(i, 255, 0, 0);
//              }
             
//              led.setData(ledBuffer);
//         }
//     }

//     public void blueBlink(Timer time){
//         if (time.get() % 2 == 0){
//             for (var i = 0; i < ledBuffer.getLength(); i+=2) {
//                 // Sets the specified LED to the RGB values for red
//                 ledBuffer.setRGB(i, 0, 0, 255);
//              }
             
//              led.setData(ledBuffer);
//         }
//         else{
//             for (var i = 1; i < ledBuffer.getLength(); i+=2) {
//                 // Sets the specified LED to the RGB values for red
//                 ledBuffer.setRGB(i, 0, 0, 255);
//              }
             
//              led.setData(ledBuffer);
//         }
//     }

//     public void pinkRed(){
//         for (var i = 0; i < ledBuffer.getLength(); i+=10) {
//             // Sets the specified LED to the RGB values for red
//             ledBuffer.setRGB(i, 205, 1, 135);
//             ledBuffer.setRGB(i+1, 205, 1, 135);
//             ledBuffer.setRGB(i+2, 205, 1, 135);
//             ledBuffer.setRGB(i+3, 205, 1, 135);
//             ledBuffer.setRGB(i+4, 0, 0, 0);
//             ledBuffer.setRGB(i+5, 255, 0, 0);
//             ledBuffer.setRGB(i+6, 255, 0, 0);
//             ledBuffer.setRGB(i+7, 255, 0, 0);
//             ledBuffer.setRGB(i+8, 255, 0, 0);
//             ledBuffer.setRGB(i+9, 0, 0, 0);
//          }
         
//          led.setData(ledBuffer);
//     }

//     public void pinkBlue(){
//         for (var i = 0; i < ledBuffer.getLength(); i+=10) {
//             // Sets the specified LED to the RGB values for red
//             ledBuffer.setRGB(i, 205, 1, 135);
//             ledBuffer.setRGB(i+1, 205, 1, 135);
//             ledBuffer.setRGB(i+2, 205, 1, 135);
//             ledBuffer.setRGB(i+3, 205, 1, 135);
//             ledBuffer.setRGB(i+4, 0, 0, 0);
//             ledBuffer.setRGB(i+5, 0, 0, 255);
//             ledBuffer.setRGB(i+6, 0, 0, 255);
//             ledBuffer.setRGB(i+7, 0, 0, 255);
//             ledBuffer.setRGB(i+8, 0, 0, 255);
//             ledBuffer.setRGB(i+9, 0, 0, 0);
//          }
         
//          led.setData(ledBuffer);
//     }
// }
