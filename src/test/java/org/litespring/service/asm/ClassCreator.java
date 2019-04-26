package org.litespring.service.asm;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;

/**
 * Created by qingge on 2019/4/24.
 */
public class ClassCreator {

    static class MyClassLoader extends ClassLoader {
        public Class defineClass(String name, byte[] b) {
            return defineClass(name, b, 0, b.length);
        }
    }

    public static void main(String[] args) throws IOException {
        ClassWriter cw = new ClassWriter(0);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC + Opcodes.ACC_ABSTRACT + Opcodes.ACC_INTERFACE, "ASM", null, "java/lang/Object", new String[]{"java/lang/Runnable"});
        cw.visitField(Opcodes.ACC_PUBLIC + Opcodes.ACC_FINAL + Opcodes.ACC_STATIC, "number", "I", null, new Integer(-1)).visitEnd();
        cw.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_ABSTRACT, "test", "(Ljava/lang/Object;)I", null, null).visitEnd();
        cw.visitEnd();
        byte[] data = cw.toByteArray();
        File file = new File("ASM.class");
        FileOutputStream out = new FileOutputStream(file);
        out.write(data);
        out.close();
        MyClassLoader myClassLoader = new MyClassLoader();
        Class c = myClassLoader.defineClass("ASM", data);
        System.out.println(c.getName());
        Field f[] = c.getFields();
        for (int i = 0; i < f.length; i++) {
            System.out.println(f[i].toString());
        }
    }
}