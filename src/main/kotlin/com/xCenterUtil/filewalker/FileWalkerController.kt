package com.xCenterUtil.filewalker

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

class FileWalkerController {
}

data class Message(val id: String?, val text: String)

@RestController
class MessageResource{
    var idCounter : Int = 0;

    @GetMapping("/")
    fun getXCenterPaths() : List<Message> {
        var filePathResultList = mutableListOf<Message>()

        //grab all files in the current folder
        println("pre retrieveFileListOfCurrentPath")
        val filesInCurrentPath = Filewalker.retrieveFileListOfCurrentPath()
        println("post retrieveFileListOfCurrentPath")

        println("pre retrieveFileListOfCurrentPath")
        filesInCurrentPath.forEach {
            var result = Filewalker.checkFolderForxCenters(it)
            result.forEach{
                val currentPathMessage = Message(idCounter++.toString(), it)
                filePathResultList.add(currentPathMessage)
            }
        }
        println("post retrieveFileListOfCurrentPath")

        return filePathResultList;
    }
}