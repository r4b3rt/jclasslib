/*
 This library is free software; you can redistribute it and/or
 modify it under the terms of the GNU General Public
 License as published by the Free Software Foundation; either
 version 2 of the license or (at your option) any later version.
 */

package org.gjt.jclasslib.structures.attributes.targettype

import org.gjt.jclasslib.io.DataInput
import org.gjt.jclasslib.io.DataOutput

/**
 * Target info for a TypeAnnotation structure with a parameter index and a bound index.
 */
class TypeParameterBoundTargetInfo : TargetInfo() {

    /**
     * The index of the parameter.
     */
    var typeParameterIndex: Int = 0

    /**
     * The bound index.
     */
    var boundIndex: Int = 0

    override fun readData(input: DataInput) {
        typeParameterIndex = input.readUnsignedByte()
        boundIndex = input.readUnsignedByte()
    }

    override fun writeData(output: DataOutput) {
        output.writeByte(typeParameterIndex)
        output.writeByte(boundIndex)
    }

    override val length: Int
        get() = 2

    override val verbose: String
        get() = "parameter index $typeParameterIndex, bound index $boundIndex"

    override val debugInfo: String
        get() = "with $verbose"
}
