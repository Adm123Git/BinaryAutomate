package ru.adm123.binaryAutomate.liveLow;

import ru.adm123.binaryAutomate.error.StateNotAvailable;

import java.util.Arrays;
import java.util.List;

/**
 * @author Dmitry Ushakov on 23.09.21
 */
public class LowBinary implements CeilStateLow {

    private final List<Integer> envStatesFor1 = Arrays.asList(1, 5, 10);

    @Override
    public int getCeilNewState(int ceilEnvironmentState,
                               int ceilStateCount) throws StateNotAvailable {
        if (ceilEnvironmentState > (ceilStateCount - 1) * 3) {
            throw new StateNotAvailable("ceil environment state " + ceilEnvironmentState + " > " + (ceilStateCount - 1) * 3);
        }
        return envStatesFor1.contains(ceilEnvironmentState) ? 1 : 0;
    }

    @Override
    public void printCeil(int ceilState) {
        if (ceilState == 0) {
            System.out.print(" ");
        } else {
            System.out.print("\u25A0");
        }
    }

}
