package slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Demo {
    static Logger logger = LoggerFactory.getLogger(Demo.class);

    public static void main(String[] args) {

        logger.info("www.javajh.com");

        System.out.println("end");

    }
}
