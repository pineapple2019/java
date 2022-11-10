//import javax.swing.*;
//import java.awt.*;
//
//public class test {
//
//    public static void main(String[] args) {
//
//    }
//
//    private JPanel createPanel(){
//        JPanel panel = new JPanel();
//
//        GridBagLayout gbl = new GridBagLayout();
//        GridBagConstraints gbs = new GridBagConstraints();
//        panel.setLayout(gbl);
//
//        panel.add(bt7);panel.add(bt8);panel.add(bt9);panel.add(btp);
//        panel.add(bt4);panel.add(bt5);panel.add(bt6);
//        panel.add(bt1);panel.add(bt2);panel.add(bt9);panel.add(btp);
//        panel.add(bt1);panel.add(bt2);panel.add(bt3);panel.add(btm);
//        panel.add(bt0);panel.add(btdot);
//        panel.add(btsignleft);panel.add(btsignright);panel.add(bte);panel.add(btmp);
//        panel.add(btclear);panel.add(bt);				panel.add(btd);
//        panel.add(textField);
//
//        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
//        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
//        gbs.gridx=0;gbs.gridy=0;
//        gbl.setConstraints(bt7, gbs);
//        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
//        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
//        gbs.gridx=1;gbs.gridy=0;
//        gbl.setConstraints(bt8, gbs);
//        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
//        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
//        gbs.gridx=2;gbs.gridy=0;
//        gbl.setConstraints(bt9, gbs);
//
//        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=2;
//        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
//        gbs.gridx=3;gbs.gridy=0;
//        gbl.setConstraints(btp, gbs);
//
//        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
//        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
//        gbs.gridx=0;gbs.gridy=1;
//        gbl.setConstraints(bt4, gbs);
//        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
//        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
//        gbs.gridx=1;gbs.gridy=1;
//        gbl.setConstraints(bt5, gbs);
//        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
//        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
//        gbs.gridx=2;gbs.gridy=1;
//        gbl.setConstraints(bt6, gbs);
//
//        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
//        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
//        gbs.gridx=0;gbs.gridy=2;
//        gbl.setConstraints(bt1, gbs);
//        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
//        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
//        gbs.gridx=1;gbs.gridy=2;
//        gbl.setConstraints(bt2, gbs);
//        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
//        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
//        gbs.gridx=2;gbs.gridy=2;
//        gbl.setConstraints(bt3, gbs);
//
//        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=2;
//        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
//        gbs.gridx=3;gbs.gridy=2;
//        gbl.setConstraints(btm, gbs);
//
//        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=2;gbs.gridheight=1;
//        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
//        gbs.gridx=0;gbs.gridy=3;
//        gbl.setConstraints(bt0, gbs);
//        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
//        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
//        gbs.gridx=2;gbs.gridy=3;
//        gbl.setConstraints(btdot, gbs);
//
//        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
//        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
//        gbs.gridx=0;gbs.gridy=4;
//        gbl.setConstraints(btsignleft, gbs);
//        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
//        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
//        gbs.gridx=1;gbs.gridy=4;
//        gbl.setConstraints(btsignright, gbs);
//        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=2;
//        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
//        gbs.gridx=2;gbs.gridy=4;
//        gbl.setConstraints(bte, gbs);
//        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
//        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
//        gbs.gridx=3;gbs.gridy=4;
//        gbl.setConstraints(btmp, gbs);
//        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
//        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
//        gbs.gridx=0;gbs.gridy=5;
//        gbl.setConstraints(btclear, gbs);
//        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
//        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
//        gbs.gridx=1;gbs.gridy=5;
//        gbl.setConstraints(bt, gbs);
//        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
//        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
//        gbs.gridx=3;gbs.gridy=5;
//        gbl.setConstraints(btd, gbs);
//
//        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=4;gbs.gridheight=3;
//        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
//        gbs.gridx=0;gbs.gridy=6;
//        gbl.setConstraints(textField, gbs);
//
//        return panel;
//    }
//}
