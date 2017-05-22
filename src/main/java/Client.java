import javax.swing.*;
import java.awt.*;


public class Client {

    public static void main(String[] args) {
        CurentWeather curentWeather = new CurentWeather();

        JFrame myWindow = new JFrame("What weather is today?");
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font helvetica = new Font("Helvetica", Font.BOLD, 40);

        JTextField cityField = new JTextField();
        cityField.setFont(helvetica);
        JLabel tempLabel = new JLabel();

        tempLabel.setFont(helvetica);

        JButton button = new JButton("Get now!");

        button.setFont(helvetica);


        button.addActionListener(e -> {
            String city = cityField.getText();
            String temp = curentWeather.getToClient(city);
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
