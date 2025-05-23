/*
    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU General Public
    License as published by the Free Software Foundation; either
    version 2 of the license or (at your option) any later version.
*/

package org.gjt.jclasslib.structures.constants

import org.gjt.jclasslib.io.DataInput
import org.gjt.jclasslib.io.DataOutput
import org.gjt.jclasslib.structures.AbstractConstant
import org.gjt.jclasslib.structures.ClassFile
import org.gjt.jclasslib.structures.ConstantType

/**
 * Describes a CONSTANT_String_info constant pool data structure.
 */
class ConstantStringInfo(classFile: ClassFile) : AbstractConstant(classFile) {

    /**
     * Index of the constant pool entry containing the
     * string of this entry.
     */
    var stringIndex: Int = 0

    /**
     * Returns the ConstantUtf8Info constant pool entry that contains the actual string.
     */
    val utf8Constant: ConstantUtf8Info
        get() = classFile.getConstantPoolUtf8Entry(stringIndex)

    override val constantType: ConstantType
        get() = ConstantType.STRING

    override val verbose: String
        get() = utf8Constant.string

    override fun readData(input: DataInput) {
        stringIndex = input.readUnsignedShort()
    }

    override fun writeData(output: DataOutput) {
        output.writeByte(ConstantType.STRING.tag)
        output.writeShort(stringIndex)
    }

    override val debugInfo: String
        get() = "with stringIndex $stringIndex"

    override fun equals(other: Any?): Boolean {
        if (other !is ConstantStringInfo) {
            return false
        }
        return super.equals(other) && other.stringIndex == stringIndex
    }

    override fun hashCode(): Int = super.hashCode() xor stringIndex

}
