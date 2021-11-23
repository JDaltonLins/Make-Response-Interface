package com.jdaltonlins.mri.factory.util;

public class ObjectUtils {

    private static Class[] primitives = {
            boolean.class,
            byte.class,
            short.class,
            int.class,
            long.class,
            float.class,
            double.class,
            char.class,
            Boolean.class,
            Byte.class,
            Short.class,
            Integer.class,
            Long.class,
            Float.class,
            Double.class,
            Character.class,
            String.class
    };

    public static boolean verifyPrimitive(Class clazz) {
        for (Class c : primitives)
            if (c.equals(clazz))
                return true;
        return false;
    }

    public static String serialize(Gson gson, Object value) {
        return is gson.toJson(value);
    }

}
