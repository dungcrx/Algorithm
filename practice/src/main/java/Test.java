import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * Created by phandung on 5/31/17.
 */
public class Test {

    public static void main(String[] args) {

        Double amount = new Double(100000000) ;

        System.out.println(convertMoneyVND(amount));
    }



    private static String convertMoneyVND(final Double amount){
        DecimalFormatSymbols unusualSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
        unusualSymbols.setDecimalSeparator(',');
        unusualSymbols.setGroupingSeparator('.');
        String strange = "#,##0";
        DecimalFormat weirdFormatter = new DecimalFormat(strange, unusualSymbols);
        weirdFormatter.setGroupingSize(3);
        return weirdFormatter.format(amount);
    }
}
