package com.xCenterUtil.filewalker

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

class FileWalkerController {
}

data class Message(val id: String?, val text: String)

@RestController
class MessageResource{
    var idCounter : Int = 0;

    //trying to get this working with a map
/*    @GetMapping("/")
    fun getXCenterPaths() : MutableMap<String, Message> {
//        var filePathResultList = mutableListOf<Message>()
        var resultMap = mutableMapOf<String, Message>()

        //grab all files in the current folder
        println("pre retrieveFileListOfCurrentPath")
        val filesInCurrentPath = Filewalker.retrieveFileListOfCurrentPath()
        println("post retrieveFileListOfCurrentPath")

        println("pre retrieveFileListOfCurrentPath")
        filesInCurrentPath.forEach {
            var result = Filewalker.checkFolderForxCenters(it)
            result.forEach{
                val currentPathMessage = Message(idCounter++.toString(), it)
//                filePathResultList.add(currentPathMessage)
                print("Adding \'${it}\' to the map")
                resultMap[idCounter++.toString()] = currentPathMessage
            }
        }
        println("post retrieveFileListOfCurrentPath")

        return resultMap;
    }*/

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

    @GetMapping("/{id}")
    fun getXCenterPathById(@PathVariable id : Int) : Message {
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
        ;
        println("post retrieveFileListOfCurrentPath")

        println("Returning message with ID = ${id} and content: ${filePathResultList.get(id).text}")

        return filePathResultList.get(id)
    }
}