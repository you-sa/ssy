package top.lz.basedao.context;

/**
 * 使用ThreadLocal封装传递全局存储数据
 */
public class DataContext implements AutoCloseable{
    public static final ThreadLocal<Object> CTX = new ThreadLocal<>();

    public static void setData(Object data) {
        CTX.set(data);
    }

    public static Object getData() {
        return CTX.get();
    }

    @Override
    public void close() {
        CTX.remove();
    }
}
