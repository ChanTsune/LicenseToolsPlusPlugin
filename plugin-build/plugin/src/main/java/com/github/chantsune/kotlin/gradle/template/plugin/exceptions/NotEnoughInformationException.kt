package com.github.chantsune.kotlin.gradle.template.plugin.exceptions

import com.github.chantsune.kotlin.gradle.template.plugin.models.LibraryInfo

class NotEnoughInformationException(val libraryInfo: LibraryInfo): RuntimeException()