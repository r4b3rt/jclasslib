/*
 This library is free software; you can redistribute it and/or
 modify it under the terms of the GNU General Public
 License as published by the Free Software Foundation; either
 version 2 of the license or (at your option) any later version.
 */

package org.gjt.jclasslib.structures

/**
 * Base class for companion objects that facilitates fast bytecode to enum instance lookups.
 * @property enumConstants The enum constants
 * @property name A name for the enum for use in error messages
 */
abstract class Lookup<T>(enumConstants: List<T>, val name: String) where T : Enum<T>, T : ClassFileEnum {

    private val lookup = arrayOfNulls<Any?>(enumConstants.maxByOrNull { it.tag }!!.tag + 1)

    init {
        for (constant in enumConstants) {
            lookup[constant.tag] = constant
        }
    }

    /**
     * Get the enum instance for the specified bytecode tag.
     * @throws InvalidByteCodeException if the bytecode tag is not found
     */
    fun getFromTag(tag: Int): T {
        if (tag < lookup.size && tag >= 0) {
            val constant = lookup[tag]
            if (constant != null) {
                @Suppress("UNCHECKED_CAST")
                return constant as T
            }
        }
        throw InvalidByteCodeException("Invalid $name: $tag")
    }
}