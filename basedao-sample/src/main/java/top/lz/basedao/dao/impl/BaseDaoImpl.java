package top.lz.basedao.dao.impl;

import top.lz.basedao.dao.BaseDao;
import top.lz.basedao.context.DataContext;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("unchecked")
public abstract class BaseDaoImpl<T> implements BaseDao<T> {
    private final Class<T> clazz;
    private final List<T> list;

    public BaseDaoImpl() {
        // this.getClass() 代表当前运行对象的Class对象
        Class<?> cClass = this.getClass();
        // cClass.getGenericSuperclass() 得到当前对象的父类（参数化类型） 如BaseDao<Book,?,?>
        Type type = cClass.getGenericSuperclass();
        // 向下转型为参数化类型对象
        ParameterizedType pt = (ParameterizedType) type;
        // 得到参数化类型（泛型类型列表）, 如<Book,?,?>
        Type[] types = pt.getActualTypeArguments();
        // 去除泛型类型列表中想要的类型，并强制转为具体的Class
        clazz = (Class<T>) types[0];
        list = (List<T>) DataContext.getData();
    }

    /**
     * 添加
     *
     * @param t
     */
    @Override
    public void add(T t) {
        list.add(t);
    }

    /**
     * 删除
     *
     * @param t
     */
    @Override
    public void delete(T t) {
        list.remove(t);
    }

    /**
     * 更新
     *
     * @param t
     * @param id
     */
    @Override
    public void update(T t, Long id) {
        Field field = null;
        try {
            field = clazz.getDeclaredField("id");
        } catch (NoSuchFieldException e) {
            System.err.println(e.getMessage());
        }
        Objects.requireNonNull(field).setAccessible(true);
        // 查找数据集中和id值和入参相同的对象
        for (int i = 0; i < list.size(); i ++) {
            T next = list.get(i);
            try {
                // 得到该对象的id值
                Object o = field.get(next);
                // 如果id值相等，找到了需要更新的对象
                if (id.equals(o)) {
                    // 将入参t放入该位置，实现更新
                    list.add(i, t);
                    break;
                }
            } catch (IllegalAccessException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    @Override
    public T get(Long id) {
        List<T> res = findByField(list, "id", id, clazz);
        return Objects.requireNonNull(res).get(0);
    }

    @Override
    public List<T> findByField(String fieldName, Object value) {
        List<T> res = findByField(list, fieldName, value, clazz);
        return res;
    }

    @Override
    public List<T> findAll() {
        return list;
    }

    private static <T> List<T> findByField(List<T> list, String field, Object value, Class<T> clazz) {
        List<T> res = new ArrayList<>();
        try {
            // 通过反射指定的属性,比如说id，book中的id什么的
            Field classField = clazz.getDeclaredField(field);
            // 设置属性为可访问
            classField.setAccessible(true);
            for (T t : list) {
                // 遍历list，获取到对应属性的值
                Object o = classField.get(t);
                if (value.equals(o) || value.toString().equals(o.toString())) {
                    // 如果相等
                    res.add(t);
                }
            }
        } catch (NoSuchFieldException e) {
            // 如果不存在
            return null;
        } catch (IllegalAccessException e) {
            System.err.println(e.getMessage());
        }
        return res;
    }
}
