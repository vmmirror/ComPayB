package compaysb;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ComPays implements Initializable {
    public Label lblTotal;
    public GridPane gridData;

    private ArrayList<TextField> editRate;
    private ArrayList<TextField> editMeter;
    private ArrayList<Label> lblSubTotal;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        editRate=new ArrayList<>();     // Создание массивов компонент
        editMeter=new ArrayList<>();
        lblSubTotal=new ArrayList<>();

        TextField edit;
        Label lbl;
        for(int i=0;i<6;i++) {
            edit=new TextField("0");
            gridData.setValignment(edit, VPos.CENTER);
            editRate.add(edit);
            gridData.add(edit,1,i+1);
            edit=new TextField("0");
            if (i==3) edit.setEditable(false);
            editMeter.add(edit);
            gridData.setValignment(edit, VPos.CENTER);
            gridData.add(edit,2,i+1);
            lbl=new Label("?");
            lblSubTotal.add(lbl);
            gridData.add(lbl,3,i+1);
            gridData.setValignment(lbl,VPos.CENTER);
            gridData.setHalignment(lbl,HPos.RIGHT);
        }
    }

    public void CalcClick(ActionEvent ignoredActionEvent) {
        ArrayList<Double> payCalc=new ArrayList<>();
        Double r;
        r=calcDrainage(editMeter.get(1).getText(),editMeter.get(2).getText());
        editMeter.get(3).setText(r.toString());
        for(int i=0;i<6;i++) {
            r=calcLine(editRate.get(i).getText(),editMeter.get(i).getText());
            payCalc.add(r);
            lblSubTotal.get(i).setText(String.format("%10.2f р.",r));
        }

        r=calcTotal(payCalc);
        lblTotal.setText("----");
        if (r.isNaN()) {
            Alert alert = new Alert(Alert.AlertType.ERROR,"Проверьте правильность ввода");
            alert.setTitle("Ошибка");
            alert.setHeaderText(null);
            alert.showAndWait();
        } else lblTotal.setText(String.format("%10.2f р.",r));
    }

    public Double calcLine(String a,String b) {
        Double res=Double.NaN;
        double da,db;
        try {
            res=Double.valueOf(a)*Double.valueOf(b);
        } catch(Exception e) {}

        return res;
    }

    public Double calcDrainage(String a,String b) {
        Double res=Double.NaN;
        double da,db;
        try {
            res=Double.valueOf(a)+Double.valueOf(b);
        } catch(Exception e) {}

        return res;
    }

    public Double calcTotal(ArrayList<Double> arr) {
        Double res=0.0;
        for(Double d : arr) res+=d;

        return res;
    }
}