package HW1;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Test;
import org.junit.Assert;
import java.lang.reflect.Modifier;
import java.lang.reflect.Field;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.ThreadLocalRandom;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

/**
 * A set of local test cases for Homework 9.
 *
 * <p>Purdue University -- CS18000 -- Spring 2020 -- Polymorphism -- Homework</p>
 *
 * @author Purdue CS
 * @version 03/23/2020
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public final class SolidLocalTest {
    private static final double DELTA = 1E-10;

    @Test(timeout = 1_000)
    public void archimedeanSolidClassDeclarationTest() {
        Class<?> clazz = ArchimedeanSolid.class;
        int modifiers = clazz.getModifiers();
        Class<?> superclass = clazz.getSuperclass();
        Class<?>[] superinterfaces = clazz.getInterfaces();

        Assert.assertTrue("Ensure that `ArchimedeanSolid` is `public`!", Modifier.isPublic(modifiers));

        Assert.assertTrue("Ensure that `ArchimedeanSolid` is `abstract`!", Modifier.isAbstract(modifiers));

        Assert.assertEquals("Ensure that `ArchimedeanSolid` extends `Object`!", Object.class, superclass);

        Assert.assertEquals("Ensure that `ArchimedeanSolid` implements no interfaces!", 0, superinterfaces.length);
    } //archimedeanSolidClassDeclarationTest

    @Test(timeout = 1_000)
    public void cuboctahedronClassDeclarationTest() {
        Class<?> clazz = Cuboctahedron.class;
        int modifiers = clazz.getModifiers();
        Class<?> superclass = clazz.getSuperclass();
        Class<?>[] superinterfaces = clazz.getInterfaces();

        Assert.assertTrue("Ensure that `Cuboctahedron` is `public`!", Modifier.isPublic(modifiers));

        Assert.assertFalse("Ensure that `Cuboctahedron` is NOT `abstract`!", Modifier.isAbstract(modifiers));

        Assert.assertEquals("Ensure that `Cuboctahedron` extends `ArchimedeanSolid`!",
                ArchimedeanSolid.class, superclass);

        Assert.assertEquals("Ensure that `Cuboctahedron` implements no interfaces!", 0, superinterfaces.length);
    } //cuboctahedronClassDeclarationTest

    @Test(timeout = 1_000)
    public void icosidodecahedronClassDeclarationTest() {
        Class<?> clazz = Icosidodecahedron.class;
        int modifiers = clazz.getModifiers();
        Class<?> superclass = clazz.getSuperclass();
        Class<?>[] superinterfaces = clazz.getInterfaces();

        Assert.assertTrue("Ensure that `Icosidodecahedron` is `public`!", Modifier.isPublic(modifiers));

        Assert.assertFalse("Ensure that `Icosidodecahedron` is NOT `abstract`!", Modifier.isAbstract(modifiers));

        Assert.assertEquals("Ensure that `Icosidodecahedron` extends `ArchimedeanSolid`!",
                ArchimedeanSolid.class, superclass);

        Assert.assertEquals("Ensure that `Icosidodecahedron` implements no interfaces!", 0, superinterfaces.length);
    } //icosidodecahedronClassDeclarationTest

    @Test(timeout = 1_000)
    public void archimedeanSolidEdgeLengthFieldDeclarationTest() {
        Class<?> clazz = ArchimedeanSolid.class;
        Field edgeLengthField;
        int modifiers;

        try {
            edgeLengthField = clazz.getDeclaredField("edgeLength");
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that `ArchimedeanSolid` declares a field named" +
                    " `edgeLength` that is `private` and of type `double`!");

            return;
        } //end try catch

        modifiers = edgeLengthField.getModifiers();

        Assert.assertTrue("Ensure that `ArchimedeanSolid`'s `edgeLength` field is `private`!",
                Modifier.isPrivate(modifiers));

        Assert.assertEquals("Ensure that `ArchimedeanSolid`'s `edgeLength` field is of type `double`!",
                double.class, edgeLengthField.getType());
    } //archimedeanSolidEdgeLengthFieldDeclarationTest

    @Test(timeout = 1_000)
    public void cuboctahedronEqualsImplementationTest() {
        Class<?> clazz = Cuboctahedron.class;
        Constructor<?> constructor;
        Method equalsMethod;
        Field edgeLengthField;
        Class<?> superclass = clazz.getSuperclass();
        double edgeLengthArgument;
        Cuboctahedron cuboctahedron;
        boolean returnValue;
        double fieldValue;

        try {
            constructor = clazz.getDeclaredConstructor(double.class);
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that `Cuboctahedron` declares a constructor that is `public`" +
                    ", has one parameter of type `double`, and is NOT declared to throw any exceptions!");

            return;
        } //end try catch

        try {
            equalsMethod = clazz.getDeclaredMethod("equals", Object.class);
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that `Cuboctahedron` declares a method named" +
                    " `equals` that is `public`, has a return type of `boolean`," +
                    " has one parameter of type `Object`, and is NOT declared to throw any exceptions!");

            return;
        } //end try catch

        try {
            edgeLengthField = superclass.getDeclaredField("edgeLength");
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that `ArchimedeanSolid` declares a field named" +
                    " `edgeLength` that is `private` and of type `double`!");

            return;
        } //end try catch

        constructor.setAccessible(true);

        equalsMethod.setAccessible(true);

        edgeLengthField.setAccessible(true);

        edgeLengthArgument = ThreadLocalRandom.current()
                .nextInt(1, Integer.MAX_VALUE);

        try {
            cuboctahedron = (Cuboctahedron) constructor.newInstance(edgeLengthArgument);

            returnValue = (Boolean) equalsMethod.invoke(cuboctahedron, new Object[] {null});

            fieldValue = edgeLengthField.getDouble(cuboctahedron);

            Assert.assertFalse("Ensure that `Cuboctahedron`'s `equals` method returns" +
                    " `false` if the specified object is `null`!", returnValue);

            Assert.assertEquals("Ensure that `Cuboctahedron`'s `equals` method does NOT modify the" +
                            " `edgeLength` field of `this` cuboctahedron!", edgeLengthArgument,
                    fieldValue, DELTA);
        } catch (InvocationTargetException e) {
            e.getCause().printStackTrace();

            Assert.fail();
        } catch (Exception e) {
            e.printStackTrace();

            Assert.fail();
        } //end try catch
    } //cuboctahedronEqualsImplementationTest


    @Test(timeout = 1_000)
    public void icosidodecahedronEqualsImplementationTest() {
        Class<?> clazz = Icosidodecahedron.class;
        Constructor<?> constructor;
        Method equalsMethod;
        Field edgeLengthField;
        Class<?> superclass = clazz.getSuperclass();
        double edgeLengthArgument;
        double otherEdgeLengthArgument;
        Icosidodecahedron icosidodecahedron;
        Icosidodecahedron otherIcosidodecahedron;
        boolean returnValue;
        double fieldValue;
        double otherFieldValue;

        try {
            constructor = clazz.getDeclaredConstructor(double.class);
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that `Icosidodecahedron` declares a constructor that is `public`" +
                    ", has one parameter of type `double`, and is NOT declared to throw any exceptions!");

            return;
        } //end try catch

        try {
            equalsMethod = clazz.getDeclaredMethod("equals", Object.class);
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that `Icosidodecahedron` declares a method named `equals` that is `public`," +
                    " has a return type of `boolean`, has one parameter of type `Object`, and is NOT" +
                    " declared to throw any exceptions!");

            return;
        } //end try catch

        try {
            edgeLengthField = superclass.getDeclaredField("edgeLength");
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that `ArchimedeanSolid` declares a field named" +
                    " `edgeLength` that is `private` and of type `double`!");

            return;
        } //end try catch

        constructor.setAccessible(true);

        equalsMethod.setAccessible(true);

        edgeLengthField.setAccessible(true);

        edgeLengthArgument = ThreadLocalRandom.current()
                .nextInt(1, Integer.MAX_VALUE);

        do {
            otherEdgeLengthArgument = ThreadLocalRandom.current()
                    .nextInt(1, Integer.MAX_VALUE);
        } while (Double.compare(otherEdgeLengthArgument, edgeLengthArgument) == 0);

        try {
            icosidodecahedron = (Icosidodecahedron) constructor.newInstance(edgeLengthArgument);

            otherIcosidodecahedron = (Icosidodecahedron) constructor.newInstance(otherEdgeLengthArgument);

            returnValue = (Boolean) equalsMethod.invoke(icosidodecahedron, otherIcosidodecahedron);

            fieldValue = edgeLengthField.getDouble(icosidodecahedron);

            otherFieldValue = edgeLengthField.getDouble(otherIcosidodecahedron);

            Assert.assertFalse("Ensure that `Icosidodecahedron`'s `equals` method returns `false` if `this`" +
                            " icosidodecahedron is NOT equal to the specified icosidodecahedron!",
                    returnValue);

            Assert.assertEquals("Ensure that `Icosidodecahedron`'s `equals` method does NOT modify the " +
                            "`edgeLength` field of `this` icosidodecahedron!", edgeLengthArgument,
                    fieldValue, DELTA);

            Assert.assertEquals("Ensure that `Icosidodecahedron`'s `equals` method does NOT modify the " +
                            "`edgeLength` field of the specified icosidodecahedron!",
                    otherEdgeLengthArgument, otherFieldValue, DELTA);
        } catch (InvocationTargetException e) {
            e.getCause().printStackTrace();

            Assert.fail();
        } catch (Exception e) {
            e.printStackTrace();

            Assert.fail();
        } //end try catch
    } //icosidodecahedronEqualsImplementationTest

}
