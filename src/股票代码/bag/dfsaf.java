package bag;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.util.Enumeration;

//布局
class GBS{
    GridBagConstraints gbs = new GridBagConstraints();
    public GBS(int gw,int gh,int wx,int wy,int gx,int gy) {
        this.gbs.fill=GridBagConstraints.BOTH;
        this.gbs.gridwidth=gw;
        this.gbs.gridheight=gh;
        this.gbs.insets=new Insets(1, 1, 1, 1);
        this.gbs.weightx=wx;
        this.gbs.weighty=wy;
        this.gbs.gridx=gx;
        this.gbs.gridy=gy;
    }
    public GridBagConstraints getGbs(){
        return gbs;
    }
}
//计算
class Expression{
    private double NumA;
    private double NumB;
    private String operator;

    public Expression(double numA, double numB, String operator) {
        NumA = numA;
        NumB = numB;
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }
    public double add(){
        return NumA+NumB;
    }
    public double subtract(){
        return NumA-NumB;
    }
    public double multiply(){
        return NumA*NumB;
    }
    public double divide(){
        return NumA/NumB;
    }
}

