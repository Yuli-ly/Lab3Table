import javax.swing.table.AbstractTableModel;
import java.math.*;

public class GornerTableModel extends AbstractTableModel {
    private Double[] coefficients;
    private Double from;
    private Double to;
    private Double step;

    public GornerTableModel(Double from, Double to, Double step, Double[] coefficients) {
        this.from = from;
        this.to = to;
        this.step = step;
        this.coefficients = coefficients;
    }

    public Double getFrom() {
        return from;
    }

    public Double getTo() {
        return to;
    }

    public Double getStep() {
        return step;
    }

    public int getColumnCount() {
        return 3;
    }

    public int getRowCount() {

        return new Double(Math.ceil((to - from) / step)).intValue() + 1;
    }

    public Object getValueAt(int row, int col) {
        Double result = 0.0, result1 = 0.0;
        Double x = from + step * row;
        if (col == 0) {
            return x;
        } else if (col == 1) {
            for (int i = 0; i < coefficients.length - 1; i++) {
                double temp = coefficients[i] + result;
                result = temp * x;
            }
            result += coefficients[coefficients.length - 1];
        }

        else if (col == 2){
            for (int i = 0; i < coefficients.length - 1; i++) {
                double temp = coefficients[i] + result1;
                result1 = temp * x;
            }
            result1 += coefficients[coefficients.length - 1];
            if(result1 % 1 <= 0.1)
                return 1;
            else
                return 0;
        }
        return result;
    }
    public String getColumnName(int col) {
        switch (col) {
            case 0:
                return "Значение X";
            case 1:
                return "Значение многочлена";
            default:
                return "Число близко к целому?";
        }
    }
    public Class<?> getColumnClass(int col) {
// И в 1-ом и во 2-ом столбце находятся значения типа Double
        return Double.class;
    }
}




