package org.litespring.service.asm;

import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.FieldVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by qingge on 2019/4/24.
 */
public class ClassModifier extends ClassVisitor {
    private String owner;
    private boolean isInterface;

    public ClassModifier(ClassVisitor cv) {
        super(Opcodes.ASM5, cv);
    }

    @Override
    public void visit(int version, int access, String name, String signature,
                      String superName, String[] interfaces) {
        cv.visit(version, access, name, signature, superName, interfaces);
        owner = name;
        isInterface = (access & Opcodes.ACC_INTERFACE) != 0;
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc,
                                     String signature, String[] exceptions) {
        MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
        if (!name.equals("<init>") && !isInterface && mv != null) {
            mv = new AddTimeMethodVisitor(mv);
        }
        return mv;
    }

    @Override
    public void visitEnd() {
        if (!isInterface) {
            FieldVisitor fv = cv.visitField(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC,
                    "timer", "J", null, null);
            if (fv != null) {
                fv.visitEnd();
            }
        }
        cv.visitEnd();
    }

    class AddTimeMethodVisitor extends MethodVisitor {
        public AddTimeMethodVisitor(MethodVisitor mv) {
            super(Opcodes.ASM5, mv);
        }

        // Starts the visit of the method's code, if any(i.e. non abstract method)
        @Override
        public void visitCode() {
            mv.visitCode();
            // Visits a field instruction
            mv.visitFieldInsn(Opcodes.GETSTATIC, owner, "timer", "J");
            // Visits a method instruction
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System",
                    "currentTimeMillis", "()J", isInterface);
            // Visits a zero operand instruction
            mv.visitInsn(Opcodes.LSUB);
            mv.visitFieldInsn(Opcodes.PUTSTATIC, owner, "timer", "J");
        }

        @Override
        public void visitInsn(int opcode) {
            if ((opcode >= Opcodes.IRETURN && opcode <= Opcodes.RETURN)
                    || opcode == Opcodes.ATHROW) {
                mv.visitFieldInsn(Opcodes.GETSTATIC, owner, "timer", "J");
                mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System",
                        "currentTimeMillis", "()J", isInterface);
                mv.visitInsn(Opcodes.LADD);
                mv.visitFieldInsn(Opcodes.PUTSTATIC, owner, "timer", "J");
            }
            mv.visitInsn(opcode);
        }

        @Override
        public void visitMaxs(int maxStack, int maxLocal) {
            mv.visitMaxs(maxStack + 4, maxLocal);
        }
    }

    public static void main(String[] args) {
        try {
            ClassReader cr = new ClassReader("org/litespring/service/asm/ClassModifierExample");
            // ClassWriter extends ClassVisitor
            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
            ClassVisitor classAdapter = new ClassModifier(cw);
            // 使给定的访问者访问Java类的ClassReader
            cr.accept(classAdapter, ClassReader.SKIP_DEBUG);
            byte[] data = cw.toByteArray();
            File file = new File("ClassModifierExample.class");
            FileOutputStream out = new FileOutputStream(file);
            out.write(data);
            out.close();
            System.out.println("success!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
