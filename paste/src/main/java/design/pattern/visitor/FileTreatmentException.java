package design.pattern.visitor;

/**
 * @program: paste
 * @description: 文件异常类
 * @author: MagnetoWang
 * @create: 2018-07-23 12:03
 **/
public class FileTreatmentException extends RuntimeException {
    public FileTreatmentException() {
    }
    public FileTreatmentException(String msg) {
        super(msg);
    }
}
