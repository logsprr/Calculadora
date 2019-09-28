
package componentes;

import ExceptionErro.ExceptionErro;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Gabriel
 */
public class ComponenteIMC extends JFrame implements ActionListener{
    private static final JTextField valor1 = new JTextField("Peso") ;
    private static final JTextField valor2 = new JTextField("Altura");
    private static final JButton btnCalcula = new JButton("Calcular IMC");
    
    public static void main (String args[]){
            
        ComponenteIMC frame = new ComponenteIMC();
        Container cont = frame.getContentPane();
        cont.setLayout(new FlowLayout());
        frame.setSize(900,200);
        frame.setLocation(1024/3,768/2); 
        valor1.setColumns(10);
        valor2.setColumns(10);
        cont.add(btnCalcula);
        cont.add(valor1);
        cont.add(valor2);
        btnCalcula.addActionListener(frame);
        frame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){        
        if(e.getSource()==btnCalcula){
        double resultado = 0;
            try {
                resultado = this.imc(Double.parseDouble(valor1.getText()),
                        Double.parseDouble(valor2.getText()));
                this.mostraResultado(resultado);
            } catch (ExceptionErro ex) {
                System.out.println("ERRO NA APLICAÇÃO");
            }
        }
    }
    public double imc(double x, double y) throws ExceptionErro{
        if(x <= 0 || y <= 0 ){
            throw new ExceptionErro();
        }
        return (x/(y*y));
    }
    public void mostraResultado(double x){
        if(x < 16){
            JOptionPane.showMessageDialog(null, "Seu IMC é:" + x + "\nMagreza grave");
        }
        else if(x > 16 && x < 17){
            JOptionPane.showMessageDialog(null, "Seu IMC é:"+ x + "\nMagreza moderada");
        }
        else if(x > 17 && x < 18.5){
            JOptionPane.showMessageDialog(null, "Seu IMC é:"+ x + "\nMagreza leve");
        }
        else if(x > 18.5 && x < 25){
            JOptionPane.showMessageDialog(null, "Seu IMC é:"+ x + "\nSaudavel");
        }
        else if(x > 25 && x < 30){
            JOptionPane.showMessageDialog(null, "Seu IMC é:"+ x + "\nSobrepeso");
        }
        else if(x > 30 && x < 35){
            JOptionPane.showMessageDialog(null, "Seu IMC é:"+ x + "\nObesidade Grau 1");
        }
        else if(x > 35 && x < 40){
            JOptionPane.showMessageDialog(null, "Seu IMC é:"+ x + "\nObresidade Grau 2 (severa)");
        }
        else if(x > 16 && x < 17){
            JOptionPane.showMessageDialog(null, "Seu IMC é:"+ x + "\nObesidade Grau 3 (mórbida");
        }
    }
}
