package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextArea;

public class Controller {
    @FXML
    private Button k1;
    @FXML
    private Button k2;
    @FXML
    private Button mix;
    @FXML
    private Button mixedcolor;
    @FXML
    private TextArea text;
    @FXML
    private ColorPicker color1picker;
    @FXML
    private ColorPicker color2picker;

    private RGBController rgbController = new RGBController();
    private RGB color1 = new RGB();
    private RGB color2 = new RGB();
    private RGB colorMix = new RGB();
    private int r1 = 0,r2 = 0;
    private int g1 = 0,g2 = 0;
    private int b1 = 0,b2 = 0;
    private String sColor1 = "";
    private String sColor2 = "";
    @FXML
    private void onActionCallback(ActionEvent e){
        if(e.getSource() == k1 || e.getSource() == k2){
            if(e.getSource() == k1) sColor1 = color1picker.getValue().toString();
            else sColor1 = color2picker.getValue().toString();
            r1 = Integer.parseInt(sColor1.substring(2,4),16);
            g1 = Integer.parseInt(sColor1.substring(4,6),16);
            b1 = Integer.parseInt(sColor1.substring(6,8),16);
            rgbController.init(color1,r1,g1,b1);
            text.setText(rgbController.showColor(color1));
        }

        if(e.getSource() == mix){
            sColor1 = color1picker.getValue().toString();
            sColor2 = color2picker.getValue().toString();
            r1 = Integer.parseInt(sColor1.substring(2,4),16);
            g1 = Integer.parseInt(sColor1.substring(4,6),16);
            b1 = Integer.parseInt(sColor1.substring(6,8),16);
            r2 = Integer.parseInt(sColor2.substring(2,4),16);
            g2 = Integer.parseInt(sColor2.substring(4,6),16);
            b2 = Integer.parseInt(sColor2.substring(6,8),16);
            rgbController.init(color1,r1,g1,b1);
            rgbController.init(color2,r2,g2,b2);
            rgbController.mixColors(color1,color2,colorMix);
            text.setText(rgbController.showColor(colorMix));
            mixedcolor.setStyle(String.format("-fx-background-color: #%02X%02X%02X;",colorMix.getR_value(),colorMix.getG_value(),colorMix.getB_value()));
        }
    }

}
