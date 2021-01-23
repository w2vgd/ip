import java.time.format.DateTimeFormatter;

public class Formatter {
    // Input format e.g. 23/1/2021 1933
    public static final DateTimeFormatter INPUT_DATE_FORMATTER = DateTimeFormatter.ofPattern("d/M/y HHmm");

    // Output format e.g. Jan 23 2021, 7:33PM
    public static final DateTimeFormatter OUTPUT_DATE_FORMATTER = DateTimeFormatter.ofPattern("MMM d y, h:mma");
}