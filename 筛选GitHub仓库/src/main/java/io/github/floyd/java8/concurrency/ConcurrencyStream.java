package io.github.floyd.java8.concurrency;

public class ConcurrencyStream {

    private static final Logger logger = LoggerFactory.getLogger(ConcurrencyStream.class);

    public static void main(String[] args) {
        int max             = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; ++i) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        long t0 = System.nanoTime();
        List<String> sortedList = values.stream().sorted().collect(Collectors.toList());
        logger.debug("排序后列表大小{}", sortedList.size());
        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        logger.debug("排序花费时间{}", sortedList.size());
    }
}
