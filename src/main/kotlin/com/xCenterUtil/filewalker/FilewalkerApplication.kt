package com.xCenterUtil.filewalker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FilewalkerApplication

fun main(args: Array<String>) {
	runApplication<FilewalkerApplication>(*args)
	println("pre call")
	Filewalker.retrieveFileListOfCurrentPath()
	println("post call")
}
