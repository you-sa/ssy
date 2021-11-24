package file;

public class EnumTest {
    public static void main(String[] args) {
        testSwitch(Weekday.FRIDAY);
    }

    static void testSwitch(Weekday week) {
        switch (week) {
            case MONDAY:
            case SUNDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
            case SATURDAY:
                System.out.println(week.getValue());
                break;
            default:
                System.out.println("输入有误");
                break;
        }
    }
}
