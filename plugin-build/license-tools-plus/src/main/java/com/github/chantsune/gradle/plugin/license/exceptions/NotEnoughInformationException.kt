package com.github.chantsune.gradle.plugin.license.exceptions

import com.github.chantsune.gradle.plugin.license.models.LibraryInfo

class NotEnoughInformationException(val libraryInfo: LibraryInfo) : RuntimeException()
