package Factory2;

import Factory2.Computer;

public class ComputerFactory {
    public static Computer getComputer(ComputerAbstractFactory factory){
        return factory.createComputer();
    }
}