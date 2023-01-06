package pognaplo.frontend;

import pognaplo.kek.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

public class WelcomePage extends JFrame
{
    private JPanel panel1;
    private JTextField textField1;

    private JLabel title;
    private JLabel instructMsg;
    private JButton submitButton;
    private JButton chooseButton;


    /**
     * Definiál egy WelcomPage objektumot.
     * A WelcomPage bekeri a felhasznalotol a naplo.txt helyet a rendszeren belul.
     */
    public WelcomePage()
    {

        setTitle(Controller.TITLE);
        setIconImage(Controller.ICON.getImage());
        setResizable(false);
        setSize(450, 300);
        setContentPane(panel1);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        // Akkor aktíválódik, ha a felhasználó megnyomja a "Submit" gombot.
        submitButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // bekeri a "textfield1"-tol a szöveget, ami ebben az esetben az út a naplo.txt-hez,
                // és megnyitja a főablakot.
                MainWindow mw = new MainWindow(textField1.getText());
                setVisible(false);
            }
        });
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        // Akkor aktíválódik, ha a felhasználó megnyomja a "textfield1"-en belul az Enter gombot.
        textField1.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                {
                    MainWindow mw = new MainWindow(textField1.getText());
                    setVisible(false);
                }
            }
        });

        // Alternativa az elozo ketto opciohoz, ahol a felhasznalo egyenesen kikeresi a naplo.txt helyet a rendszeren
        chooseButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JFileChooser jFC = new JFileChooser();
                jFC.setCurrentDirectory(new File("."));

                if (jFC.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
                {
                    Controller.setFilepath(jFC.getSelectedFile().getAbsolutePath());
                    textField1.setText(jFC.getSelectedFile().getAbsolutePath());
                }
            }
        });
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$()
    {
        panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(7, 2, new Insets(5, 5, 5, 5), -1, -1));
        title = new JLabel();
        title.setText("Infoprog 2023");
        panel1.add(title, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textField1 = new JTextField();
        textField1.setHorizontalAlignment(0);
        panel1.add(textField1, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        panel1.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        instructMsg = new JLabel();
        instructMsg.setText("Kérem adja meg a naplo.txt fájl abszolut helyét");
        panel1.add(instructMsg, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        submitButton = new JButton();
        submitButton.setText("submit");
        panel1.add(submitButton, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        panel1.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Készítette: Tankó Ádám");
        panel1.add(label1, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        chooseButton = new JButton();
        chooseButton.setText("choose");
        panel1.add(chooseButton, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(20, -1), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$()
    {
        return panel1;
    }

}
