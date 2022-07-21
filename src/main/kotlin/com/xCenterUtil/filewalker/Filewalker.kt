package com.xCenterUtil.filewalker

import java.io.File

class Filewalker {
    //Companion object is used for class functions as far as I can see it
    companion object Walker{//, Texas Ranger
        val pathToStart = "c://"
        var currentPath = pathToStart;
        //function walkPWDForXCenters()
        //checks all folders in current working directory and returns all that have Center in the name
        //this will need to check in every folder in current location, then check folder names in there
        fun retrieveFileListOfCurrentPath() : Array<File>{
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
            curFolder.listFiles().forEach { println("Current: ${it.name}") }

            //return a list of Files in current folder
            return curFolder.listFiles()
        }

        //not sure if this should return the files themselves or just an array of paths as Strings
        fun checkFolderForxCenters(currentFolder : File) : MutableList<String> {
            //list to store xCenter paths as strings
            val xCenterList = mutableListOf<String>()

            //all files in current folder
            val currentFolderContents = currentFolder.listFiles()

            println("Currently checking following path for xCenters: \'${currentFolder.absolutePath}\'")

            if(currentFolderContents != null){
                //iterate through current folders child files and see if any of them have "Center" in their name
                currentFolderContents.forEach {
                    var fileName = it.name
                    if(fileName.contains("Center") || fileName.contains("cc")
                        || fileName.contains("pc") || fileName.contains("cm")){
                        println("\txCenter found at: ${fileName}")
                        xCenterList.add(it.absolutePath)
                    }
                }
            }
            else{
                println("Skipping ${currentFolder.path}")
            }
            return xCenterList
        }
    }
}