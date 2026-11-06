package frame;

import java.awt.TextField;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import javax.swing.JButton;

public class Btnadapter implements TextListener {

    private final TextField tf;
    private final JButton btnInput;
    private String lastValidText = "";

    public Btnadapter(TextField tf, JButton btnInput) {
        this.tf = tf;
        this.btnInput = btnInput;
    }

    @Override
    public void textValueChanged(TextEvent e) {
        String currentText = tf.getText();

        // 1. 4자리 이상 입력 시 이전의 유효했던 텍스트로 복원
        if (currentText.length() > 3) {
            tf.setText(lastValidText);
            return;
        }

        // 2. 입력값이 숫자로만 이루어져 있는지 정규식으로 검증 (CWE-20 조치)
        // 숫자가 아닌 문자가 포함되어 있다면 유효하지 않은 입력으로 처리
        boolean isNumeric = currentText.matches("^[0-9]*$");

        if (!isNumeric) {
            // 숫자가 아닌 문자가 입력된 경우 이전 유효 값으로 원상복구
            tf.setText(lastValidText);
            currentText = lastValidText;
        } else {
            lastValidText = currentText;
        }

        // 3. 정확히 "숫자 3자리"일 때만 버튼 활성화
        if (currentText.length() == 3 && isNumeric) {
            btnInput.setEnabled(true);
        } else {
            btnInput.setEnabled(false);
        }
    }
}
