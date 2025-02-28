/*
    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU General Public
    License as published by the Free Software Foundation; either
    version 2 of the license or (at your option) any later version.
*/
package org.gjt.jclasslib.structures.attributes

import org.gjt.jclasslib.structures.ClassFile

/**
 * Describes a RuntimeInvisibleAnnotations attribute structure.
 */
class RuntimeInvisibleAnnotationsAttribute(classFile: ClassFile) : RuntimeAnnotationsAttribute(classFile) {

    companion object {
        /**
         * Name of the attribute as in the corresponding constant pool entry.
         */
        const val ATTRIBUTE_NAME = "RuntimeInvisibleAnnotations"
    }
}
