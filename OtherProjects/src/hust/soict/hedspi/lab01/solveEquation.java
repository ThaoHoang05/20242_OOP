package hust.soict.hedspi.lab01;

import javax.swing.JOptionPane;
public class solveEquation{
    public static void main(String[] args){
        String typeE;
        typeE = JOptionPane.showInputDialog(null,"Please enter type of equation:\n1.Linear Equation\n2.Linear System with 2 variable.\n3.Quadratic Equation", JOptionPane.INFORMATION_MESSAGE);  
        int type = Integer.parseInt(typeE);
        if(type == 1){
            String stra, strb, strc;
            stra = JOptionPane.showInputDialog(null, "Please input a:",JOptionPane.INFORMATION_MESSAGE);
            strb = JOptionPane.showInputDialog(null, "Please input b:",JOptionPane.INFORMATION_MESSAGE);
            strc = JOptionPane.showInputDialog(null, "Please input c:",JOptionPane.INFORMATION_MESSAGE);
            double a = Double.parseDouble(stra);
            double b = Double.parseDouble(strb);
            double c = Double.parseDouble(strc);
            if(a == 0){
                if(b == c){
                    JOptionPane.showMessageDialog(null,"Infinite values");
                
                }else{
                    JOptionPane.showMessageDialog(null,"No values");
                }
            }else{
                double x = (c-b)/a;
                String strAnswer = "x = " + x;
                JOptionPane.showMessageDialog(null,strAnswer);
            }
        }
        else if(type == 2){
            String stra1, strb1, strc1, stra2, strb2, strc2;
            stra1 = JOptionPane.showInputDialog(null, "Please input a1:",JOptionPane.INFORMATION_MESSAGE);
            strb1 = JOptionPane.showInputDialog(null, "Please input b1:",JOptionPane.INFORMATION_MESSAGE);
            strc1 = JOptionPane.showInputDialog(null, "Please input c1:",JOptionPane.INFORMATION_MESSAGE);
            stra2 = JOptionPane.showInputDialog(null, "Please input a2:",JOptionPane.INFORMATION_MESSAGE);
            strb2 = JOptionPane.showInputDialog(null, "Please input b2:",JOptionPane.INFORMATION_MESSAGE);
            strc2 = JOptionPane.showInputDialog(null, "Please input c2:",JOptionPane.INFORMATION_MESSAGE);
            double a1 = Double.parseDouble(stra1);
            double b1 = Double.parseDouble(strb1);
            double c1 = Double.parseDouble(strc1);
            double a2 = Double.parseDouble(stra2);
            double b2 = Double.parseDouble(strb2);
            double c2 = Double.parseDouble(strc2);
            double D = a1*b2 - a2*b1;
            double Dx = c1*b2 - c2*b1;
            double Dy = a1*c2 - a2*c1;
            if(D == 0){
                if(Dx == Dy && Dy == 0){
                    JOptionPane.showMessageDialog(null,"Infinite values");
                }else{
                    JOptionPane.showMessageDialog(null,"No values");
                }
            }else{
                double x = Dx/D;
                double y = Dy/D;
                String strAnswer = "x = " + x + " and y = " + y;
                JOptionPane.showMessageDialog(null,strAnswer);
            }
        }else if(type == 3){
            String stra, strb, strc;
            stra = JOptionPane.showInputDialog(null, "Please input a:",JOptionPane.INFORMATION_MESSAGE);
            strb = JOptionPane.showInputDialog(null, "Please input b:",JOptionPane.INFORMATION_MESSAGE);
            strc = JOptionPane.showInputDialog(null, "Please input c:",JOptionPane.INFORMATION_MESSAGE);
            double a = Double.parseDouble(stra);
            double b = Double.parseDouble(strb);
            double c = Double.parseDouble(strc);
            double delta = b*b - 4*a*c;
            if(delta < 0){
                JOptionPane.showMessageDialog(null,"No values");
            }else if(delta == 0){
                double x = -b/(2*a);
                String strAnswer = "x = " + x;
                JOptionPane.showMessageDialog(null,strAnswer);
            }else{
                double x1 = (-b + Math.sqrt(delta))/(2*a);
                double x2 = (-b - Math.sqrt(delta))/(2*a);
                String strAnswer = "x1 = " + x1 + " and x2 = " + x2;
                JOptionPane.showMessageDialog(null,strAnswer);
            }
        }else{
            String strError = "Wrong type of equation";
            JOptionPane.showMessageDialog(null,strError);
        } 
    }
}