package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("Long Wire Magnetic Field");
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis(0,0.08,0.01);
        xAxis.setLabel("Distance from Wire's Center(m)");
        yAxis.setLabel("Tesla / 100000");

        final LineChart<Number,Number> lineChart =
                new LineChart<Number,Number>(xAxis,yAxis);
        lineChart.setTitle("Magnetic Field of Wire");
        XYChart.Series series = new XYChart.Series();
        series.setName("Physics-II");

        Wire wr = new Wire(10,0,0,3);
        int k = 0;
        for(double i = 0.1; i <= 20; i++, k++){
            series.getData().add(new XYChart.Data(i, wr.magBField(i,0)));
            System.out.printf("At the point %.1f this wire creates " +
                    "%.5f/100000 Tesla Magnetic Field\n",i,wr.magBField(i,0));
        }

        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}




