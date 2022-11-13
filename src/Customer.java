import java.util.Enumeration;
import java.util.Vector;

/**
 * класс, представляющий клиента магазина
 */
public class Customer {
    private String _name;
    private Vector<Rental> _rentals = new Vector<>();

    public Customer (String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName () {
        return _name;
    }
    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentals = _rentals.elements();
        String result = "Учет аренды для " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            //определить сумму для каждой строки
            frequentRenterPoints += each.getFrequentRenterPoints();
            //показать результаты для этой аренды
            result += "\t" + each.getMovie().getTitle()+ "\t" +
                    String.valueOf(each.getCharge()) + "\n";
            totalAmount += each.getCharge();
        }
        //добавить нижний колонтитул
        result += "Сумма задолженности составляет " +
                String.valueOf(totalAmount) + "\n";
        result += "Вы заработали " + String.valueOf(frequentRenterPoints) +
                " очков за активность";
        return result;
    }

}
