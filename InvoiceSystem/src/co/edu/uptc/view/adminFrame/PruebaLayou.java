package co.edu.uptc.view.adminFrame;

import javax.swing.*;
import java.awt.*;

public class PruebaLayou extends JPanel {
    JLabel[] labels = new JLabel[5];
    JTextField[] textFields = new JTextField[5];

    public PruebaLayou() {
        initComponets();
    }

    private void initComponets() {
        for (int i = 0; i < 5; i++) {
            labels[i] = new JLabel("Label " + (i + 1));
            textFields[i] = new JTextField(10);
        }

        JButton button = new JButton("Botón");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();

        GroupLayout.Group yLabelGroup = layout.createParallelGroup(GroupLayout.Alignment.TRAILING);
        GroupLayout.Group yTextFieldGroup = layout.createParallelGroup();

        for (int i = 0; i < 5; i++) {
            yLabelGroup.addComponent(labels[i]);
            yTextFieldGroup.addComponent(textFields[i]);
        }
        hGroup.addComponent(button);
        hGroup.addGroup(yLabelGroup);
        hGroup.addGroup(yTextFieldGroup);

        layout.setHorizontalGroup(hGroup);

        // Create a sequential group for the vertical axis.
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();

        for (int i = 0; i < 5; i++) {
            //vGroup.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                   vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(labels[i])
                            .addComponent(textFields[i]));
        }
        //vGroup.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED);
        vGroup.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);
        vGroup.addComponent(button);

        layout.setVerticalGroup(vGroup);
    }
}
