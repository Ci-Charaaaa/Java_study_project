package com.runtu.oop.IoC;

import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {}          // 自定义注入注解

public class MiniIoC {

    public MiniIoC() {}


    public static <T> T create(Class<T> clazz) throws Exception {
        T instance = clazz.getDeclaredConstructor().newInstance();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                Class<?> fieldType = field.getType();
                Object dependency = fieldType.getDeclaredConstructor().newInstance();
                field.setAccessible(true);       // 关键：绕过 private
                field.set(instance, dependency); // 注入
            }
        }
        return instance;
    }

    public static void main(String[] args) throws Exception {
        // 使用
        UserService svc = MiniIoC.create(UserService.class);
        System.out.println(svc.getDao() != null);   // 应该输出 true
    }

}

class UserDao { }

class UserService {
    @Inject
    private UserDao userDao;   // private 字段，外部无法直接赋值

    public UserDao getDao(){
        return this.userDao;
    }

}


