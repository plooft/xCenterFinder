package com.xCenterUtil.filewalker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.io.File

@SpringBootApplication
class FilewalkerApplication

fun main(args: Array<String>) {
	runApplication<FilewalkerApplication>(*args)
	var filePathResultList = mutableListOf<String>()

	//grab all files in the current folder
	println("pre retrieveFileListOfCurrentPath")
	val filesInCurrentPath = Filewalker.retrieveFileListOfCurrentPath()
	println("post retrieveFileListOfCurrentPath")

	println("pre retrieveFileListOfCurrentPath")
	filesInCurrentPath.forEach {
		var result = Filewalker.checkFolderForxCenters(it)
		result.forEach{
			filePathResultList.add(it)
		}
//		println("${result.size} xCenters found for path ${Filewalker.currentPath}")
	}
	println("post retrieveFileListOfCurrentPath")

	println("Paths with xCenters:")
	filePathResultList.forEach{
		println("\t${it}")
	}
}
