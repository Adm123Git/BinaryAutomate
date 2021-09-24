package ru.adm123.binaryAutomate.automate;

import ru.adm123.binaryAutomate.error.OutOfRange;
import ru.adm123.binaryAutomate.error.StateNotAvailable;
import ru.adm123.binaryAutomate.liveLow.CeilStateLow;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import java.util.function.IntFunction;

/**
 * @author Dmitry Ushakov on 23.09.21
 */
public class Automate {

    private final int ceilCount;
    private final int ceilStateCount;
    private final CeilStateLow ceilStateLow;
    private final int[] ceils;

    public Automate(int ceilStateCount,
                    int ceilCount,
                    CeilStateLow ceilStateLow) throws OutOfRange {
        if (ceilCount < 2) {
            throw new OutOfRange("Automate line length must be >= 2");
        }
        this.ceils = new int[ceilCount];
        this.ceilStateCount = ceilStateCount;
        this.ceilCount = ceilCount;
        this.ceilStateLow = ceilStateLow;
    }

    public void initCeilStates(int[] ceilStates) throws StateNotAvailable {
        if (Math.min(ceilStates.length, ceilCount) - 1 >= 0)
            System.arraycopy(ceilStates, 0, ceils, 0, Math.min(ceilStates.length, ceilCount) - 1);
        nextTick();
    }

    public void nextTick() throws StateNotAvailable {
        int[] oldCeilArray = new int[ceilCount];
        System.arraycopy(ceils, 0, oldCeilArray, 0, ceilCount);
        for (int i = 0; i < ceilCount; i++) {
            int envCeilState = oldCeilArray[i]
                    + oldCeilArray[i == 0 ? ceilCount - 1 : i - 1]
                    + oldCeilArray[i == ceilCount - 1 ? 0 : i + 1];
            ceils[i] = ceilStateLow.getCeilNewState(envCeilState, ceilStateCount);
        }
        print();
    }

    private void print() {
        for (int ceilState : ceils) {
            ceilStateLow.printCeil(ceilState);
        }
        System.out.println();
        sleep(50);
    }

    private void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException ignored) {
        }
    }

}
