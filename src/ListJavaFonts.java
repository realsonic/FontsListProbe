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
        String sampleHtmlStr = "<html><b>Bold</b> or <i>italic</i> <span style=\"color: red; \">red</span> text sample<br/><br/>" +
                "Пример <b>жирного</b> или <i>курсивного</i> <span style=\"color: red; \">красного</span> текста</html>";
        JLabel testLabel = new JLabel(sampleHtmlStr, SwingConstants.CENTER);
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
