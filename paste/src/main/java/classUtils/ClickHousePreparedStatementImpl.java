package classUtils;

import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @program: paste
 * @description: 对象之间的操作
 * @author: MagnetoWang
 * @create: 2018-07-28 20:11
 **/
public class ClickHousePreparedStatementImpl {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private final SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    List<String> binds;
    public void setObject(int parameterIndex, Object x) throws SQLException {
        if (x == null) {
            this.setNull(parameterIndex, 1111);
        } else if (x instanceof Byte) {
            this.setInt(parameterIndex, ((Byte)x).intValue());
        } else if (x instanceof String) {
            this.setString(parameterIndex, (String)x);
        } else if (x instanceof BigDecimal) {
            this.setBigDecimal(parameterIndex, (BigDecimal)x);
        } else if (x instanceof Short) {
            this.setShort(parameterIndex, (Short)x);
        } else if (x instanceof Integer) {
            this.setInt(parameterIndex, (Integer)x);
        } else if (x instanceof Long) {
            this.setLong(parameterIndex, (Long)x);
        } else if (x instanceof Float) {
            this.setFloat(parameterIndex, (Float)x);
        } else if (x instanceof Double) {
            this.setDouble(parameterIndex, (Double)x);
        } else if (x instanceof byte[]) {
            this.setBytes(parameterIndex, (byte[])((byte[])x));
        } else if (x instanceof Date) {
            this.setDate(parameterIndex, (Date)x);
        } else if (x instanceof Time) {
            this.setTime(parameterIndex, (Time)x);
        } else if (x instanceof Timestamp) {
            this.setTimestamp(parameterIndex, (Timestamp)x);
        } else if (x instanceof Boolean) {
            this.setBoolean(parameterIndex, (Boolean)x);
        } else if (x instanceof InputStream) {
            this.setBinaryStream(parameterIndex, (InputStream)x, -1);
        } else if (x instanceof Blob) {
            this.setBlob(parameterIndex, (Blob)x);
        } else if (x instanceof Clob) {
            this.setClob(parameterIndex, (Clob)x);
        } else {
            if (!(x instanceof BigInteger)) {
                throw new SQLDataException("Can't bind object of class " + x.getClass().getCanonicalName());
            }

            this.setString(parameterIndex, x.toString());
        }

    }
    public void setBlob(int parameterIndex, Blob x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    public void setClob(int parameterIndex, Clob x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    public void setBinaryStream(int parameterIndex, InputStream x, int length) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    private void setBind(int parameterIndex, String bind) {
        this.binds.set(parameterIndex - 1, bind);
    }

    public void setNull(int parameterIndex, int sqlType) throws SQLException {
        this.setBind(parameterIndex, "NULL");
    }

    public void setBoolean(int parameterIndex, boolean x) throws SQLException {
        this.setBind(parameterIndex, x ? "1" : "0");
    }

    public void setByte(int parameterIndex, byte x) throws SQLException {
        this.setBind(parameterIndex, Byte.toString(x));
    }

    public void setShort(int parameterIndex, short x) throws SQLException {
        this.setBind(parameterIndex, Short.toString(x));
    }

    public void setInt(int parameterIndex, int x) throws SQLException {
        this.setBind(parameterIndex, Integer.toString(x));
    }

    public void setLong(int parameterIndex, long x) throws SQLException {
        this.setBind(parameterIndex, Long.toString(x));
    }

    public void setFloat(int parameterIndex, float x) throws SQLException {
        this.setBind(parameterIndex, Float.toString(x));
    }

    public void setDouble(int parameterIndex, double x) throws SQLException {
        this.setBind(parameterIndex, Double.toString(x));
    }

    public void setBigDecimal(int parameterIndex, BigDecimal x) throws SQLException {
        this.setBind(parameterIndex, x.toPlainString());
    }

    public void setString(int parameterIndex, String x) throws SQLException {
        this.setBind(parameterIndex, x);
    }

    public void setBytes(int parameterIndex, byte[] x) throws SQLException {
        this.setBind(parameterIndex, new String(x));
    }

    public void setDate(int parameterIndex, Date x) throws SQLException {
        this.setBind(parameterIndex, "toDate('" + this.dateFormat.format(x) + "')");
    }

    public void setTime(int parameterIndex, Time x) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    public void setTimestamp(int parameterIndex, Timestamp x) throws SQLException {
        this.setBind(parameterIndex, "toDateTime('" + this.dateTimeFormat.format(x) + "')");
    }

    public void setAsciiStream(int parameterIndex, InputStream x, int length) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }
}
