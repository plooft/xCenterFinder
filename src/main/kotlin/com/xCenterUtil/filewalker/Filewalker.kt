package com.xCenterUtil.filewalker

import java.io.File

class Filewalker {
    //Companion object is used for class functions as far as I can see it
    companion object Walker{//, Texas Ranger
        val pathToStart = "c://"
        //function walkPWDForXCenters()
        //checks all folders in current working directory and returns all that have Center in the name
        //this will need to check in every folder in current location, then check folder names in there
        fun retrieveFileListOfCurrentPath() : List<File>{
            //TODO: exception handling for file reading
            var curFolder = File(pathToStart)
            /*        var curFolder : File
                    try{
                        curFolder = File(pathToStart)
                    }catch (npe : NullPointerException){
                        println(npe.stackTrace)
                    }*/

            if(!curFolder.isDirectory){
                print("${curFolder.absoluteFile} is not a directory!")
            }
            println("Printing all files in: ${curFolder.absoluteFile}")

            //walks all files/folders and their contents based off the path
/*            var curFileTreeWalk = curFolder.walk()
            curFileTreeWalk.forEach {
                println(it.name)
            }*/
            println("PATH: ${curFolder.absoluteFile}")
            println("SIZE: ${curFolder.listFiles().forEach { println("Current: ${it.name}") }}")

            //return a list of Files in current folder
//            return curFileTreeWalk.toList()
            return curFolder.walk().toList()
        }
    }
}