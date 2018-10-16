import javax.swing.*;
import java.awt.*;

public class ListJavaFonts {
    public static void main(String[] args) {
        String fonts[] =
                GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        for (String font : fonts) {
            System.out.println(font);
        }

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JLabel testLabel = new JLabel("<html><b>Bold</b> or <i>italic</i> <font color='red'>red</font> text sample<br/><br/>" +
                "Пример <b>жирного</b> или <i>курсивного</i> <font color='red'>красного</font> текста</html>", SwingConstants.CENTER);
        testLabel.setPreferredSize(new Dimension(600, 300));
        JList<String> fontsList = new JList<>(fonts);
        fontsList.addListSelectionListener(e -> {
            if (!fontsList.isSelectionEmpty()) {
                testLabel.setFont(new Font(fontsList.getSelectedValue(), Font.PLAIN, 18));
            }
        });
        panel.add(new JScrollPane(fontsList), BorderLayout.CENTER);
        panel.add(testLabel, BorderLayout.EAST);
        JOptionPane.showMessageDialog(null, panel);
    }
}
