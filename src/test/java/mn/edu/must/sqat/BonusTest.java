package mn.edu.must.sqat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    @DisplayName("B3: empty attendance meets a zero threshold")
    void emptyAttendanceMeetsZeroThreshold() {
        assertEquals(5, DataFlowTargets.bonus(new int[0], 0));
    }

    @Test
    @DisplayName("B4: all days absent and below the attendance threshold")
    void allAbsentBelowThreshold() {
        assertEquals(0, DataFlowTargets.bonus(new int[]{0}, 1));
    }

    @Test
    @DisplayName("B5: meets attendance threshold with a six-day streak")
    void meetsThresholdWithLongStreak() {
        int[] attendance = {1, 1, 1, 1, 1, 1};

        assertEquals(8, DataFlowTargets.bonus(attendance, 6));
    }

    @Test
    @DisplayName("B6: rejects null attendance")
    void rejectsNullAttendance() {
        assertThrows(IllegalArgumentException.class, () -> DataFlowTargets.bonus(null, 0));
    }

    @Test
    @DisplayName("B7: rejects a negative threshold")
    void rejectsNegativeThreshold() {
        assertThrows(IllegalArgumentException.class, () -> DataFlowTargets.bonus(new int[0], -1));
    }

    @Test
    @DisplayName("B8: longest streak remains below five after an absence")
    void countsLongestStreakAfterAnAbsence() {
        int[] attendance = {1, 1, 1, 0, 1, 1, 1, 1};

        assertEquals(5, DataFlowTargets.bonus(attendance, 7));
    }
}
