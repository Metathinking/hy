import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) Fuli.java 2017/05/31 22:53
 */
public class Fuli {

    public static void main(String[] args) {
        double initValue = 10000;
        int years = 30;
        double add=0.1;
        double result=initValue;
        for (int i = 1; i <= years; i++) {
            result=result*(1+add);
            DecimalFormat decimalFormat = new DecimalFormat(".##");
            System.out.println("第"+i+"年，本金增长为："+decimalFormat.format(result) +"元");
        }
    }
}