import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<String> stringClass = String.class;
        Map<String, Integer> mapObject = new HashMap<>();
        Class<?> hashMapClass = mapObject.getClass();
        //Class<?> squareClass = Class.forName("exercises.MainSquare");
        //printClassInfo(squareClass, hashMapClass, squareClass);

        var circleObject = new Drawable(){
            @Override
            public int getNumberOfCorners() {
                return 0;
            }
        };

        printClassInfo(Collection.class, boolean.class, int [][].class, Color.class, circleObject.getClass());
    }
    private static void printClassInfo(Class<?> ... classes){
        for (Class<?> clazz : classes){
            System.out.println(String.format("class name: :%s, class package name : %s",
                    clazz.getSimpleName(),
                    clazz.getPackageName()));
            Class<?> [] implementedInterfaces = clazz.getInterfaces();

            for (Class<?> implementedInterface: implementedInterfaces){
                System.out.println(String.format("class %s implements: %s",
                        clazz.getSimpleName(),
                        implementedInterface.getSimpleName()));
            }
            System.out.println("is array: " +clazz.isArray());
            System.out.println("is primitive: " + clazz.isPrimitive());
            System.out.println("is enum: " + clazz.isEnum());
            System.out.println("is interface: " + clazz.isInterface());
            System.out.println("is anonymous: " + clazz.isAnonymousClass());



            System.out.println();
            System.out.println();
        }
    }

    private static class Square implements Drawable{

        @Override
        public int getNumberOfCorners() {
            return 4;
        }
    }

    private static interface Drawable{
        int getNumberOfCorners();
    }

    private enum Color {
        BLUE,
        RED,
        GREEN
    }

}

/**
 * 출력 결과
 * class name: :Collection, class package name : java.util
 * class Collection implements: Iterable
 * is array: false
 * is primitive: false
 * is enum: false
 * is interface: true
 * is anonymous: false
 *
 *
 * class name: :boolean, class package name : java.lang
 * is array: false
 * is primitive: true
 * is enum: false
 * is interface: false
 * is anonymous: false
 *
 *
 * class name: :int[][], class package name : java.lang
 * class int[][] implements: Cloneable
 * class int[][] implements: Serializable
 * is array: true
 * is primitive: false
 * is enum: false
 * is interface: false
 * is anonymous: false
 *
 *
 * class name: :Color, class package name :
 * is array: false
 * is primitive: false
 * is enum: true
 * is interface: false
 * is anonymous: false
 *
 *
 * class name: :, class package name :
 * class  implements: Drawable
 * is array: false
 * is primitive: false
 * is enum: false
 * is interface: false
 * is anonymous: true
 *
 * **/