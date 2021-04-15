package com.github.chantsune.gradle.plugin.license.exceptions

import com.github.chantsune.gradle.plugin.license.models.LibraryInfo

class NotEnoughInformationException(private val libraryInfo: LibraryInfo, message: String? = null) :
    RuntimeException("${libraryInfo.name}:${message ?: "no message"}")
