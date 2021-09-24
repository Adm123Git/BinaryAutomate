package ru.adm123.binaryAutomate;

import ru.adm123.binaryAutomate.automate.Automate;
import ru.adm123.binaryAutomate.error.OutOfRange;
import ru.adm123.binaryAutomate.error.StateNotAvailable;
import ru.adm123.binaryAutomate.liveLow.LowBinary;

/**
 * @author Dmitry Ushakov on 23.09.21
 */
public class Main {


    public static void main(String[] args) throws OutOfRange, StateNotAvailable {
        Automate automate = new Automate(5, 50, new LowBinary());
        automate.initCeilStates(getInitArray());
        for (int i = 0; i < 10; i++) {
            automate.nextTick();
        }
    }

    private static int[] getInitArray() {
        int[] arr = new int[51];
        arr[25] = 1;
        return arr;
    }

}
