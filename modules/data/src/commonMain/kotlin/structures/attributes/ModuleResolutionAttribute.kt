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
import org.gjt.jclasslib.structures.paddedHex

/**
 * Describes a ModuleResolution attribute structure.
 */
class ModuleResolutionAttribute(classFile: ClassFile) : AttributeInfo(classFile) {

    /**
     * Module resolution flag.
     */
    var resolution: Int = 0

    /**
     * The module resolution as a hex string.
     */
    val formattedResolution: String
        get() = resolution.paddedHex(4)

    /**
     * The verbose description of the module resolution.
     */
    val resolutionVerbose: String
        get() = formatFlagsVerbose(ModuleResolutionType.entries.toSet(), resolution, separator = ", ")


    override fun readData(input: DataInput) {
        resolution = input.readUnsignedShort()
    }

    override fun writeData(output: DataOutput) {
        output.writeShort(resolution)
    }

    override fun getAttributeLength(): Int =  2

    override val debugInfo: String
        get() = ""

    companion object {
        /**
         * Name of the attribute as in the corresponding constant pool entry.
         */
        const val ATTRIBUTE_NAME = "ModuleResolution"
    }
}