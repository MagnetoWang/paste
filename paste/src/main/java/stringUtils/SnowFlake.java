package stringUtils;



/**
 * @program: paste
 * @description: 生成唯一ID
 * @create: 2018-08-17 15:35
 **/
public class SnowFlake {

    /**
     * 起始的时间戳
     */
    private final static long START_STMP = 1514736000000L;

    /**
     * 每一部分占用的位数
     */
    private final static long SEQUENCE_BIT = 12; //序列号占用的位数
    private final static long MACHINE_BIT = 8;  //机器标识占用的位数
    private final static long DATACENTER_BIT = 2;//数据中心占用的位数
//    private final static long SERVICE_BIT = 3;//数据中心占用的位数

    /**
     * 每一部分的最大值
     */
    private final static long MAX_DATACENTER_NUM = -1L ^ (-1L << DATACENTER_BIT);
    private final static long MAX_MACHINE_NUM = -1L ^ (-1L << MACHINE_BIT);
    private final static long MAX_SEQUENCE = -1L ^ (-1L << SEQUENCE_BIT);
//    private final static long MAX_SERVICE = -1L ^ (-1L << SERVICE_BIT);

    /**
     * 每一部分向左的位移
     */
    private final static long MACHINE_LEFT = SEQUENCE_BIT;
    private final static long DATACENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
    private final static long TIMESTMP_LEFT = DATACENTER_LEFT + DATACENTER_BIT;
//    private final static long SERVICE_LEFT = TIMESTMP_LEFT + SERVICE_BIT;

//    @Value("${id.generate.datacenter}")
    private long datacenterId;  //数据中心
    private long machineId;    //机器标识
    private long sequence = 0L; //序列号
    private long lastStmp = -1L;//上一次时间戳

    public void init(long datacenterId, long machineId) {
        if (datacenterId > MAX_DATACENTER_NUM || datacenterId < 0) {
            throw new IllegalArgumentException("datacenterId can't be greater than MAX_DATACENTER_NUM or less than 0");
        }
        if (machineId > MAX_MACHINE_NUM || machineId < 0) {
            throw new IllegalArgumentException("machineId can't be greater than MAX_MACHINE_NUM or less than 0");
        }
        this.datacenterId = datacenterId;
        this.machineId = machineId;
    }

    public void init() {
        String ip = SystemInfo.getInstance().getIP();
        long machineId = Long.valueOf(ip.substring(ip.lastIndexOf(".") + 1));
        init(datacenterId, machineId);
    }


    /**
     * 产生下一个ID
     *
     * @return
     */
    public synchronized long nextId() {
//        if (serviceId > MAX_SERVICE || serviceId <= 0) {
//            return -1;
//        }

        long currStmp = getNewstmp();
        if (currStmp < lastStmp) {
            throw new RuntimeException("Clock moved backwards.  Refusing to generate id");
        }

        if (currStmp == lastStmp) {
            //相同毫秒内，序列号自增
            sequence = (sequence + 1) & MAX_SEQUENCE;
            //同一毫秒的序列数已经达到最大
            if (sequence == 0L) {
                currStmp = getNextMill();
            }
        } else {
            //不同毫秒内，序列号置为0
            sequence = 0L;
        }

        lastStmp = currStmp;

        return (currStmp - START_STMP) << TIMESTMP_LEFT //时间戳部分
                | datacenterId << DATACENTER_LEFT      //数据中心部分
                | machineId << MACHINE_LEFT            //机器标识部分
                | sequence;                            //序列号部分

//        long id = (currStmp - START_STMP) << TIMESTMP_LEFT   //时间戳部分
//                | datacenterId << DATACENTER_LEFT           //数据中心部分
//                | machineId << MACHINE_LEFT                 //机器标识部分
//                | sequence;
//
//        long newid = serviceId * (long) Math.pow(10, (long) (Math.log10(id) + 1L)) + id;
//
//        return newid;

    }

    private long getNextMill() {
        long mill = getNewstmp();
        while (mill <= lastStmp) {
            mill = getNewstmp();
        }
        return mill;
    }

    private long getNewstmp() {
        return System.currentTimeMillis();
    }

    public long getDatacenterId() {
        return datacenterId;
    }

    public long getMachineId() {
        return machineId;
    }
}

