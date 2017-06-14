import javax.swing.*;
import java.awt.*;


public class Client {

    public static void main(String[] args) {
        CurrentWeather currentWeather = new CurrentWeather();

        JFrame myWindow = new JFrame("What weather is today?");
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JTextField cityField = new JTextField();
        cityField.setHorizontalAlignment(JLabel.CENTER);
        JButton button = new JButton("Get now!");
        JLabel tempLabel = new JLabel();
        tempLabel.setVerticalAlignment(JLabel.CENTER);
        tempLabel.setHorizontalAlignment(JLabel.CENTER);
        button.addActionListener(e -> {
            String city = cityField.getText();
            String temp = currentWeather.getToClient(city);
            temp =  (!temp.equals("Error!") )? temp + " " : temp;
            tempLabel.setText(temp);

        });

        JPanel contents = new JPanel(new GridLayout(3,0));
        contents.add(cityField);
        contents.add(button);
        contents.add(tempLabel);
        myWindow.add(contents);
        myWindow.setSize(500, 300);
        myWindow.setVisible(true);

    }
}
