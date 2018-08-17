package stringUtils;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
/**
 * @program: paste
 * @description: 生成系统信息
 * @create: 2018-08-17 15:29
 **/
public class SystemInfo {
    private static SystemInfo currentSystem = null;
    private InetAddress localHost = null;

    private SystemInfo() {
        try {
            localHost = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static SystemInfo getInstance() {
        if (currentSystem == null) {
            currentSystem = new SystemInfo();
        }
        return currentSystem;
    }

    public String getIP() {
        return localHost.getHostAddress();
    }

    public String getHostName() {
        return localHost.getHostName();
    }

    public String getMac() {
        NetworkInterface byInetAddress;
        try {
            byInetAddress = NetworkInterface.getByInetAddress(localHost);
            byte[] hardwareAddress = byInetAddress.getHardwareAddress();
            return getMacFromBytes(hardwareAddress);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getMacFromBytes(byte[] bytes) {
        StringBuffer mac = new StringBuffer();
        byte currentByte;
        boolean first = false;

        for (byte b : bytes) {
            if (first) {
                mac.append("-");
            }
            currentByte = (byte) ((b & 240) >> 4);
            mac.append(Integer.toHexString(currentByte));
            currentByte = (byte) (b & 15);
            mac.append(Integer.toHexString(currentByte));
            first = true;
        }
        return mac.toString().toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println(SystemInfo.getInstance().getIP());
        System.out.println(SystemInfo.getInstance().getHostName());
        System.out.println(SystemInfo.getInstance().getMac());
    }

}
