/*
    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU General Public
    License as published by the Free Software Foundation; either
    version 2 of the license or (at your option) any later version.
*/

package org.gjt.jclasslib.structures.attributes

import org.gjt.jclasslib.io.DataInput
import org.gjt.jclasslib.io.DataOutput
import org.gjt.jclasslib.structures.AttributeInfo
import org.gjt.jclasslib.structures.ClassFile

/**
 * Describes a Synthetic attribute structure.
 */
class SyntheticAttribute(classFile: ClassFile) : AttributeInfo(classFile) {

    override fun readData(input: DataInput) {
    }

    override fun writeData(output: DataOutput) {
    }

    override fun getAttributeLength(): Int = 0

    override val debugInfo: String
        get() = ""

    companion object {
        /**
         * Name of the attribute as in the corresponding constant pool entry.
         */
        const val ATTRIBUTE_NAME = "Synthetic"
    }

}
