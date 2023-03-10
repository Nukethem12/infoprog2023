package pognaplo.frontend;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.TimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;
import pognaplo.exceptions.LeirasLengthException;
import pognaplo.exceptions.RosszIdoException;
import pognaplo.control.Bejegyzes;
import pognaplo.control.Controller;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class AddWindow extends JFrame
{
    private JPanel panel1;
    private JTextField esemenyTextField;
    private JLabel dateandformat;
    private JButton submitButton;
    private TimePicker zaroidopontPicker;
    private TimePicker kezdoidopontPicker;
    private DatePicker datepicker;

    public AddWindow()
    {
        $$$setupUI$$$();

        setIconImage(Controller.ICON.getImage());
        setSize(300, 450);
        setResizable(false);
        setContentPane(panel1);


        submitButton.addActionListener(e ->
        {
            try
            {
                FileWriter fw = new FileWriter(Controller.getFilepath(), true);
                LocalDate dt = datepicker.getDate();
                LocalTime kezdoidopont = kezdoidopontPicker.getTime();
                LocalTime zaroidopont = zaroidopontPicker.getTime();
                String esemeny = esemenyTextField.getText();


                if (zaroidopont.isBefore(kezdoidopont)) throw new RosszIdoException("");
                if (esemeny.length() > 250) throw new LeirasLengthException("");
                if (dt == null) throw new NullPointerException("");

                Bejegyzes b = new Bejegyzes(dt,
                        kezdoidopont,
                        zaroidopont,
                        esemeny);
                if (Controller.isUnique(b))
                {

                    fw.write(dt.format(DateTimeFormatter.ofPattern("dd-MM-uuuu")) + "," + kezdoidopont + "," + zaroidopont + ',' + esemeny + "\n");
                    fw.close();
                    dispose();
                }

            } catch (IOException ex)
            {
                throw new RuntimeException(ex);
            } catch (DateTimeException ex)
            {
                JOptionPane.showMessageDialog(null, "Hiba t??rt??nt a beolvasasnal", "Rossz bemenet", JOptionPane.ERROR_MESSAGE);
            } catch (NullPointerException ignored)
            {
                JOptionPane.showMessageDialog(null, "Hiba t??rtent a d??tum megad??s??n??l", "Hiba t??rtent", JOptionPane.ERROR_MESSAGE);
            } catch (LeirasLengthException ignored)
            {
                JOptionPane.showMessageDialog(null, "A leir??s t??ll hossz?? (T??bb mint 250 karakter)", "T??ll hossz?? leir??s", JOptionPane.ERROR_MESSAGE);
            } catch (RosszIdoException ignored)
            {
                JOptionPane.showMessageDialog(null, "A z??r?? id??pont nem lehet a kezd?? id??pont el??tt", "Rossz bemenet", JOptionPane.ERROR_MESSAGE);
            }
        });
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

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
        createUIComponents();
        panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(9, 1, new Insets(5, 5, 5, 5), -1, -1));
        final JLabel label1 = new JLabel();
        label1.setText("D??tum:");
        panel1.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        dateandformat = new JLabel();
        dateandformat.setText("kezd?? id??pont");
        panel1.add(dateandformat, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("z??r?? id??pont");
        panel1.add(label2, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        esemenyTextField = new JTextField();
        esemenyTextField.setText("");
        panel1.add(esemenyTextField, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("esem??ny");
        panel1.add(label3, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        submitButton = new JButton();
        submitButton.setText("Hozz??ad??s");
        submitButton.setMnemonic('H');
        submitButton.setDisplayedMnemonicIndex(0);
        panel1.add(submitButton, new com.intellij.uiDesigner.core.GridConstraints(8, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        panel1.add(datepicker, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel1.add(kezdoidopontPicker, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel1.add(zaroidopontPicker, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$()
    {
        return panel1;
    }

    private void createUIComponents()
    {
        TimePickerSettings timeSettings = new TimePickerSettings();
        datepicker = new DatePicker();
        timeSettings.use24HourClockFormat();
        timeSettings.setDisplaySpinnerButtons(true);
        timeSettings.generatePotentialMenuTimes(TimePickerSettings.TimeIncrement.TenMinutes, null, null);
        timeSettings.setInitialTimeToNow();
        datepicker.setLocale(new Locale("HU", "sk"));
        kezdoidopontPicker = new TimePicker(timeSettings);
        zaroidopontPicker = new TimePicker(timeSettings);
    }
}
