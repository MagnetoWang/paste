package threadUtils;

import org.slf4j.LoggerFactory;
import stringUtils.Constants;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.*;
import java.util.Queue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.logging.Logger;

/**
 * @program: paste
 * @description: 数据库的连接池。单例模式
 * @author: MagnetoWang
 * @create: 2018-07-30 20:59
 **/
public class ConnectionPool implements DataSource {
    private  static org.slf4j.Logger logger=LoggerFactory.getLogger(ConnectionPool.class);
    private  volatile static ConnectionPool clickHouseThreadPool=null;
    // 链表 --- 实现 栈结构 、队列 结构
    private  static Queue<Connection> dataSources=new LinkedTransferQueue<>();
    private  static String clickHouseDriver;
    private  static String address;
    private static Statement singleStatement=null;
    private static PreparedStatement preparedStatements=null;

    private ConnectionPool(){
        Constants constants=new Constants();
        clickHouseDriver=constants.CLICKHOUSE_DRIVER;
        address=constants.CLICKHOUSE_ADDRESS1;
        try {
            Class.forName(clickHouseDriver);
            for (int i = 0; i < 100; i++){
                try {
                    Connection connection = DriverManager.getConnection(address);
                    dataSources.add(connection);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
    public static ConnectionPool getInstance(){
        if(clickHouseThreadPool==null){
            synchronized (ConnectionPool.class){
                //双重检查！！
                if(clickHouseThreadPool == null){
                    clickHouseThreadPool=new ConnectionPool();
                }
            }
        }
        return clickHouseThreadPool;
    }

    @Override
    public Connection getConnection() throws SQLException {
        // 取出连接池中一个连接
        final Connection conn = dataSources.remove(); // 删除第一个连接返回
        logger.info("取出一个连接剩余 " + dataSources.size() + "个连接！");
        // 将目标Connection对象进行增强
        Connection connProxy = (Connection) Proxy.newProxyInstance(conn
                        .getClass().getClassLoader(), conn.getClass().getInterfaces(),
                new InvocationHandler() {
                    // 执行代理对象任何方法 都将执行 invoke
                    @Override
                    public Object invoke(Object proxy, Method method,
                                         Object[] args) throws Throwable {
                        if (method.getName().equals("close")) {
                            // 需要加强的方法
                            // 不将连接真正关闭，将连接放回连接池
                            releaseConnection(conn);
                            return null;
                        } else {
                            // 不需要加强的方法
                            return method.invoke(conn, args); // 调用真实对象方法
                        }
                    }
                });
        return connProxy;
    }

    // 将连接放回连接池
    public void releaseConnection(Connection conn) {
        dataSources.add(conn);
        logger.info("将连接 放回到连接池中 数量:" + dataSources.size());
    }

    /**
     * 线程池回收线程
     * @param conn
     */
    public void close(Connection conn){
        releaseConnection(conn);
    }

    public boolean isEmpty(){
        return dataSources.isEmpty();
    }


    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
    public static Statement getSingleStatement() {
        return singleStatement;
    }

    public static void setSingleStatement(Statement singleStatement) {
        ConnectionPool.singleStatement = singleStatement;
    }

    public static PreparedStatement getPreparedStatements() {
        return preparedStatements;
    }

    public static void setPreparedStatements(PreparedStatement preparedStatements) {
        ConnectionPool.preparedStatements = preparedStatements;
    }


}
