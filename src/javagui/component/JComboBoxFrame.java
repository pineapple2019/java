package component;


import java.awt.event.*;

import javax.swing.*;

public class JComboBoxFrame extends JFrame

{
    private JComboBox cb = new JComboBox();

    public JComboBoxFrame()

    {
        cb.addItem("1");

        cb.addItem("2");

        cb.addItem("3");

        cb.addItemListener(new ItemListener()

        {
            public void itemStateChanged(ItemEvent event)

            {
                switch (event.getStateChange())

                {
                    case ItemEvent.SELECTED:



                        System.out.println("ѡ��" + event.getItem());

                        break;

                    case ItemEvent.DESELECTED:

                        System.out.println("ȡ��ѡ��" + event.getItem());

                        break;

                }

            }

        });

        add(cb);

    }

    public static void main(String[] args)

    {
        JFrame frame = new JComboBoxFrame();

        frame.pack();

        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}