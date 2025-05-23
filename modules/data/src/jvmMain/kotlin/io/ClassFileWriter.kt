/*
 This library is free software; you can redistribute it and/or
 modify it under the terms of the GNU General Public
 License as published by the Free Software Foundation; either
 version 2 of the license, or (at your option) any later version.
 */

package org.gjt.jclasslib.io

import org.gjt.jclasslib.structures.ClassFile
import org.gjt.jclasslib.structures.InvalidByteCodeException
import java.io.File
import java.io.IOException
import java.nio.file.Path

/**
 * Converts class file structure ClassFile as defined in
 * org.gjt.jclasslib.structures to class files.
 */
object ClassFileWriter {

    /**
     * Converts a ClassFile structure to a class file.
     * @param file the file to which to write the ClassFile structure
     * @param classFile the ClassFile structure to be written
     */
    @Throws(InvalidByteCodeException::class, IOException::class)
    @JvmStatic
    fun writeToFile(file: File, classFile: ClassFile) {
        classFile.writeToPath(kotlinx.io.files.Path(file.path))
    }

    /**
     * Converts a ClassFile structure to a class file.
     * @param path the file to which to write the ClassFile structure
     * @param classFile the ClassFile structure to be written
     */
    @Throws(InvalidByteCodeException::class, IOException::class)
    @JvmStatic
    fun writeToFile(path: Path, classFile: ClassFile) {
        classFile.writeToPath(kotlinx.io.files.Path(path.toString()))
    }

    /**
     * Converts a ClassFile structure to a byte array.
     * @param classFile the class file
     */
    @Throws(InvalidByteCodeException::class, IOException::class)
    @JvmStatic
    fun writeToByteArray(classFile: ClassFile): ByteArray = classFile.writeToByteArray()

}
