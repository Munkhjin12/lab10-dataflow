package mn.edu.must.sqat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BonusTest {
    @Test
    @DisplayName("B1: below attendance threshold with a five-day streak")
    void belowThresholdWithLongStreak() {
        int[] attendance = {1, 1, 1, 1, 1, 0, 1};

        assertEquals(3, DataFlowTargets.bonus(attendance, 7));
    }

    @Test
    @DisplayName("B2: meets attendance threshold with a short streak")
    void meetsThresholdWithShortStreak() {
        int[] attendance = {1, 0, 1};

        assertEquals(5, DataFlowTargets.bonus(attendance, 2));
    }
}
