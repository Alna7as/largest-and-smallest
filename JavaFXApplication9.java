package javafxapplication9;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class JavaFXApplication9 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // ===== عناصر الإدخال =====
        TextField num1Field = createStyledTextField("أدخل الرقم الأول");
        TextField num2Field = createStyledTextField("أدخل الرقم الثاني");
        TextField num3Field = createStyledTextField("أدخل الرقم الثالث");

        // ===== زر الحساب =====
        Button calculateBtn = new Button("احسب الأكبر والأصغر");
        calculateBtn.setFont(Font.font("Arial", 14));
        calculateBtn.setStyle("-fx-background-color: #ffffffcc; -fx-text-fill: #003366; -fx-font-weight: bold; -fx-background-radius: 10;");
        calculateBtn.setOnMouseEntered(e -> calculateBtn.setStyle("-fx-background-color: #b2ebf2; -fx-text-fill: #003366; -fx-font-weight: bold; -fx-background-radius: 10;"));
        calculateBtn.setOnMouseExited(e -> calculateBtn.setStyle("-fx-background-color: #ffffffcc; -fx-text-fill: #003366; -fx-font-weight: bold; -fx-background-radius: 10;"));

        // ===== مكان عرض النتائج =====
        Label resultLabel = new Label();
        resultLabel.setFont(Font.font("Arial", 16));

        VBox resultBox = new VBox(resultLabel);
        resultBox.setPadding(new Insets(15));
        resultBox.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255, 0.6), new CornerRadii(10), Insets.EMPTY)));
        resultBox.setEffect(new DropShadow());
        resultBox.setVisible(false);

        // ===== الزر عندما يُضغط =====
        calculateBtn.setOnAction(e -> {
            try {
                int num1 = Integer.parseInt(num1Field.getText());
                int num2 = Integer.parseInt(num2Field.getText());
                int num3 = Integer.parseInt(num3Field.getText());

                int largest = Math.max(num1, Math.max(num2, num3));
                int smallest = Math.min(num1, Math.min(num2, num3));

                resultLabel.setText("✅ أكبر رقم هو: " + largest + "\n🔻 أصغر رقم هو: " + smallest);
                resultLabel.setTextFill(Color.DARKGREEN);
                resultBox.setVisible(true);
            } catch (NumberFormatException ex) {
                resultLabel.setText("❌ من فضلك أدخل أرقام صحيحة فقط!");
                resultLabel.setTextFill(Color.RED);
                resultBox.setVisible(true);
            }
        });

        // ===== الحاوية الرئيسية =====
        VBox root = new VBox(15, num1Field, num2Field, num3Field, calculateBtn, resultBox);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));

        // خلفية بتدرج لوني مع شفافية
        root.setStyle("-fx-background-color: linear-gradient(to bottom right, rgba(169, 169, 169, 0.5), rgba(192, 192, 192, 0.7));");

        Scene scene = new Scene(root, 450, 400);

        primaryStage.setTitle("🌊 تحديد الأكبر والأصغر");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    // دالة لتنسيق مربعات الإدخال
    private TextField createStyledTextField(String prompt) {
        TextField tf = new TextField();
        tf.setPromptText(prompt);
        tf.setMaxWidth(250);
        tf.setFont(Font.font("Arial", 14));
        tf.setStyle("-fx-background-radius: 10; -fx-background-color: #ffffffcc; -fx-padding: 10;");
        return tf;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
